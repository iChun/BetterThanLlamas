package me.ichun.mods.betterthanllamas.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import me.ichun.mods.betterthanllamas.client.model.LlamaFancyModel;
import me.ichun.mods.betterthanllamas.common.BetterThanLlamas;
import net.minecraft.client.model.LlamaModel;
import net.minecraft.client.model.RabbitModel;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.LlamaRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Rabbit;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.animal.horse.Llama;
import net.minecraft.world.item.DyeColor;

import java.util.Calendar;
import java.util.Random;

public class LlamaFancyLayer extends RenderLayer<Llama, LlamaModel<Llama>>
{
    private final LlamaRenderer renderer;
    private Random rand;
    private LlamaFancyModel model;

    private static final ResourceLocation texFancy = new ResourceLocation("betterthanllamas","textures/model/fancy.png");
    private static final ResourceLocation texFancyColorizer = new ResourceLocation("betterthanllamas","textures/model/fancycolorizer.png");

    //Easter egg
    public final boolean isEasterEggDay;
    private RabbitModel modelRabbit;
    private Rabbit rabbitInstance;
    private static final ResourceLocation BROWN = new ResourceLocation("textures/entity/rabbit/brown.png");
    private static final ResourceLocation WHITE = new ResourceLocation("textures/entity/rabbit/white.png");
    private static final ResourceLocation BLACK = new ResourceLocation("textures/entity/rabbit/black.png");
    private static final ResourceLocation GOLD = new ResourceLocation("textures/entity/rabbit/gold.png");
    private static final ResourceLocation SALT = new ResourceLocation("textures/entity/rabbit/salt.png");
    private static final ResourceLocation WHITE_SPLOTCHED = new ResourceLocation("textures/entity/rabbit/white_splotched.png");
    private static final ResourceLocation TOAST = new ResourceLocation("textures/entity/rabbit/toast.png");
    private static final ResourceLocation CAERBANNOG = new ResourceLocation("textures/entity/rabbit/caerbannog.png");

    public LlamaFancyLayer(LlamaRenderer renderer)
    {
        super(renderer);
        this.renderer = renderer;
        this.rand = new Random();
        this.model = new LlamaFancyModel();

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());

        isEasterEggDay = calendar.get(Calendar.MONTH) == Calendar.APRIL && calendar.get(Calendar.DAY_OF_MONTH) == 1 ||
                calendar.get(Calendar.MONTH) == Calendar.DECEMBER && calendar.get(Calendar.DAY_OF_MONTH) == 9;
        if(isEasterEggDay)
        {
            modelRabbit = new RabbitModel(RabbitModel.createBodyLayer().bakeRoot());
            modelRabbit.young = false;
            processLlamaModelForEE(renderer.model);
        }
    }

    public static void processLlamaModelForEE(LlamaModel model)
    {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(33, 4).addBox(-4.0F, -9.0F, -6.0F, 8, 11, 6), PartPose.offset(0.0F, 7.0F, -6.0F));
        model.head = LayerDefinition.create(mesh, 128, 64).bakeRoot().getChild("head");
    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Llama llama, float limbSwing, float limbSwingAmount, float renderTick, float ageInTicks, float netHeadYaw, float headPitch)
    {
        if(!llama.isInvisible())
        {
            boolean iChunLlama = llama.hasCustomName() && "iChun".equals(llama.getName().getContents());
            if(iChunLlama)
            {
                rand.setSeed(Math.abs("iChun".hashCode() + (llama.getId() * 63268L) * 5642L));
            }
            else
            {
                rand.setSeed(Math.abs((llama.hasCustomName() ? llama.getName().getContents().hashCode() : llama.getUUID().hashCode()) * 5642L));
            }

            boolean renderHat, renderMonocle, renderPipe, renderBowtie, renderFez, renderMoustache;
            if(iChunLlama)
            {
                renderHat = rand.nextBoolean();
                renderMonocle = rand.nextBoolean();
                renderPipe = rand.nextBoolean();
                renderBowtie = rand.nextBoolean();
                renderFez = rand.nextBoolean();
                renderMoustache = rand.nextBoolean();
            }
            else
            {
                renderHat = rand.nextFloat() < BetterThanLlamas.config.hatChance.get() / 100F;
                renderMonocle = rand.nextFloat() < BetterThanLlamas.config.monocleChance.get() / 100F;
                renderPipe = rand.nextFloat() < BetterThanLlamas.config.pipeChance.get() / 100F;
                renderBowtie = rand.nextFloat() < BetterThanLlamas.config.bowtieChance.get() / 100F;
                renderFez = rand.nextFloat() < BetterThanLlamas.config.fezChance.get() / 100F;
                renderMoustache = rand.nextFloat() < BetterThanLlamas.config.moustacheChance.get() / 100F;
            }

            if(renderHat && renderFez)
            {
                renderHat = rand.nextBoolean();
                renderFez = !renderHat;
            }

            if(isEasterEggDay)
            {
                if(renderHat || renderMonocle || renderPipe || renderBowtie)
                {
                    float[] clr = new float[3];
                    if (iChunLlama)
                    {
                        int i = llama.tickCount / 25 + llama.getId();
                        int j = DyeColor.values().length;
                        int k = i % j;
                        int l = (i + 1) % j;
                        float f = ((float)(llama.tickCount % 25) + renderTick) / 25.0F;
                        float[] afloat1 = Sheep.getColorArray(DyeColor.byId(k));
                        float[] afloat2 = Sheep.getColorArray(DyeColor.byId(l));
                        clr[0] = afloat1[0] * (1.0F - f) + afloat2[0] * f;
                        clr[1] = afloat1[1] * (1.0F - f) + afloat2[1] * f;
                        clr[2] = afloat1[2] * (1.0F - f) + afloat2[2] * f;
                    }
                    else if (llama.getSwag() != null)
                    {
                        clr = Sheep.getColorArray(llama.getSwag());
                    }
                    else
                    {
                        rand.setSeed(Math.abs(llama.getId() * 1234L));
                        clr = Sheep.getColorArray(DyeColor.byId(rand.nextInt(16)));
                    }

                    //push for body renderBody
                    matrixStackIn.pushPose();

                    if(llama.isBaby())
                    {
                        matrixStackIn.scale(0.71428573F, 0.64935064F, 0.7936508F);
                        matrixStackIn.translate(0.0D, 1.3125D, (double)0.22F);
                    }

                    matrixStackIn.translate(0F, 7.0F / 16F, -6.0F / 16F);
                    matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(netHeadYaw));
                    matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(interpolateValues(llama.xRotO, llama.getXRot(), renderTick)));
                    matrixStackIn.translate(0F, -7.0F / 16F, 6.0F / 16F);

                    float scale = 0.0625F;

                    matrixStackIn.translate(0, -26F * scale, -10F * scale);

                    ResourceLocation bunnyTex;
                    if(llama.hasCustomName() && "Toast".equals(llama.getName().getContents()))
                    {
                        bunnyTex = TOAST;
                    }
                    else
                    {
                        bunnyTex = switch(rand.nextInt(7))
                                {
                                    default -> BROWN;
                                    case 1 -> WHITE;
                                    case 2 -> BLACK;
                                    case 3 -> WHITE_SPLOTCHED;
                                    case 4 -> GOLD;
                                    case 5 -> SALT;
                                    case 6 -> CAERBANNOG;
                                };
                    }

                    if (rabbitInstance == null || rabbitInstance.getLevel() != llama.getLevel())
                    {
                        rabbitInstance = new Rabbit(EntityType.RABBIT, llama.getLevel());
                    }

                    VertexConsumer ivertexbuilder = bufferIn.getBuffer(RenderType.entityTranslucent(bunnyTex));
                    int packedOverlay = LivingEntityRenderer.getOverlayCoords(llama, 0.0F);

                    modelRabbit.setupAnim(rabbitInstance, limbSwing, limbSwingAmount, ageInTicks, 0F, 0F);
                    modelRabbit.renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, packedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);

                    matrixStackIn.scale(0.6F, 0.6F, 0.6F);
                    matrixStackIn.translate(0.0F, 16.0F * scale, 0.0F);

                    if(renderHat || renderMonocle || renderPipe)
                    {
                        matrixStackIn.pushPose();

                        ivertexbuilder = bufferIn.getBuffer(RenderType.entityTranslucent(texFancy));
                        model.renderHeadParts(renderHat, renderMonocle, renderPipe, false, matrixStackIn, ivertexbuilder, packedLightIn, packedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);

                        if(renderHat)
                        {
                            ivertexbuilder = bufferIn.getBuffer(RenderType.entityTranslucent(texFancyColorizer));
                            model.renderHeadParts(renderHat, renderMonocle, renderPipe, true, matrixStackIn, ivertexbuilder, packedLightIn, packedOverlay, clr[0], clr[1], clr[2], 1.0F);
                        }
                        matrixStackIn.popPose();
                    }

                    if(renderBowtie)
                    {
                        ivertexbuilder = bufferIn.getBuffer(RenderType.entityTranslucent(texFancy));
                        model.renderBody(rabbitInstance, false, ageInTicks, matrixStackIn, ivertexbuilder, packedLightIn, packedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);

                        ivertexbuilder = bufferIn.getBuffer(RenderType.entityTranslucent(texFancyColorizer));
                        model.renderBody(rabbitInstance, true, ageInTicks, matrixStackIn, ivertexbuilder, packedLightIn, packedOverlay, clr[0], clr[1], clr[2], 1.0F);
                    }
                    matrixStackIn.popPose();
                }
            }
            else if(rand.nextFloat() < (BetterThanLlamas.config.fancyChance.get() / 100F))
            {
                if(renderHat || renderMonocle || renderPipe || renderBowtie || renderFez || renderMoustache)
                {
                    float[] clr = new float[3];
                    if (iChunLlama)
                    {
                        int i = llama.tickCount / 25 + llama.getId();
                        int j = DyeColor.values().length;
                        int k = i % j;
                        int l = (i + 1) % j;
                        float f = ((float)(llama.tickCount % 25) + renderTick) / 25.0F;
                        float[] afloat1 = Sheep.getColorArray(DyeColor.byId(k));
                        float[] afloat2 = Sheep.getColorArray(DyeColor.byId(l));
                        clr[0] = afloat1[0] * (1.0F - f) + afloat2[0] * f;
                        clr[1] = afloat1[1] * (1.0F - f) + afloat2[1] * f;
                        clr[2] = afloat1[2] * (1.0F - f) + afloat2[2] * f;
                    }
                    else
                    {
                        rand.setSeed(Math.abs(llama.getId() * 1234L));
                        clr = Sheep.getColorArray(DyeColor.byId(rand.nextInt(16)));
                    }

                    VertexConsumer ivertexbuilder = bufferIn.getBuffer(RenderType.entityTranslucent(texFancy));
                    int packedOverlay = LivingEntityRenderer.getOverlayCoords(llama, 0.0F);

                    matrixStackIn.pushPose();

                    if(llama.isBaby())
                    {
                        matrixStackIn.scale(0.71428573F, 0.64935064F, 0.7936508F);
                        matrixStackIn.translate(0.0D, 1.3125D, (double)0.22F);
                    }

                    matrixStackIn.translate(0F, 7.0F / 16F, -6.0F / 16F);
                    float pitch = interpolateValues(llama.xRotO, llama.getXRot(), renderTick);
                    matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(netHeadYaw));
                    matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(pitch));
                    matrixStackIn.translate(0F, -7.0F / 16F, 6.0F / 16F);

                    model.fez3.xRot = -1.2292353921796064F + (float)Math.toRadians(-Mth.clamp(pitch, -90F, 0));
                    model.renderLlama(false, renderHat, renderMonocle, renderPipe, renderBowtie, renderFez, renderMoustache, matrixStackIn, ivertexbuilder, packedLightIn, packedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);

                    if(renderHat || renderBowtie)
                    {
                        ivertexbuilder = bufferIn.getBuffer(RenderType.entityTranslucent(texFancyColorizer));
                        model.renderLlama(true, renderHat, renderMonocle, renderPipe, renderBowtie, renderFez, renderMoustache, matrixStackIn, ivertexbuilder, packedLightIn, packedOverlay, clr[0], clr[1], clr[2], 1.0F);
                    }
                    matrixStackIn.popPose();
                }
            }
        }
    }

    public static float interpolateValues(float prevVal, float nextVal, float partialTick)
    {
        return prevVal + partialTick * (nextVal - prevVal);
    }
}
