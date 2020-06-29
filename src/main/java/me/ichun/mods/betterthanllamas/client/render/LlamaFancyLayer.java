package me.ichun.mods.betterthanllamas.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import me.ichun.mods.betterthanllamas.client.model.LlamaFancyModel;
import me.ichun.mods.betterthanllamas.common.BetterThanLlamas;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.LlamaRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.LlamaModel;
import net.minecraft.client.renderer.entity.model.RabbitModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.passive.horse.LlamaEntity;
import net.minecraft.item.DyeColor;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;

import java.util.Calendar;
import java.util.Random;

public class LlamaFancyLayer extends LayerRenderer<LlamaEntity, LlamaModel<LlamaEntity>>
{
    private final LlamaRenderer renderer;
    private Random rand;
    private LlamaFancyModel model;

    private static final ResourceLocation texFancy = new ResourceLocation("betterthanllamas","textures/model/fancy.png");
    private static final ResourceLocation texFancyColorizer = new ResourceLocation("betterthanllamas","textures/model/fancycolorizer.png");

    //Easter egg
    public final boolean isEasterEggDay;
    private RabbitModel modelRabbit;
    private RabbitEntity rabbitInstance;
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
            modelRabbit = new RabbitModel();
            modelRabbit.isChild = false;
            rabbitInstance = new RabbitEntity(EntityType.RABBIT, null);
            processLlamaModelForEE(renderer.entityModel);
        }
    }

    public static void processLlamaModelForEE(LlamaModel model)
    {
        model.head = new ModelRenderer(model, 33, 4);
        model.head.addBox(-4.0F, -9.0F, -6.0F, 8, 11, 6, 0);
        model.head.setRotationPoint(0.0F, 7.0F, -6.0F);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, LlamaEntity llama, float limbSwing, float limbSwingAmount, float renderTick, float ageInTicks, float netHeadYaw, float headPitch)
    {
        if(!llama.isInvisible())
        {
            boolean iChunLlama = llama.hasCustomName() && "iChun".equals(llama.getName().getUnformattedComponentText());
            if(iChunLlama)
            {
                rand.setSeed(Math.abs("iChun".hashCode() + (llama.getEntityId() * 63268L) * 5642L));
            }
            else
            {
                rand.setSeed(Math.abs((llama.hasCustomName() ? llama.getName().getUnformattedComponentText().hashCode() : llama.getEntityId()) * 5642L));
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
                        int i = llama.ticksExisted / 25 + llama.getEntityId();
                        int j = DyeColor.values().length;
                        int k = i % j;
                        int l = (i + 1) % j;
                        float f = ((float)(llama.ticksExisted % 25) + renderTick) / 25.0F;
                        float[] afloat1 = SheepEntity.getDyeRgb(DyeColor.byId(k));
                        float[] afloat2 = SheepEntity.getDyeRgb(DyeColor.byId(l));
                        clr[0] = afloat1[0] * (1.0F - f) + afloat2[0] * f;
                        clr[1] = afloat1[1] * (1.0F - f) + afloat2[1] * f;
                        clr[2] = afloat1[2] * (1.0F - f) + afloat2[2] * f;
                    }
                    else if (llama.getColor() != null)
                    {
                        clr = SheepEntity.getDyeRgb(llama.getColor());
                    }
                    else
                    {
                        rand.setSeed(Math.abs(llama.getEntityId() * 1234L));
                        clr = SheepEntity.getDyeRgb(DyeColor.byId(rand.nextInt(16)));
                    }

                    //push for body renderBody
                    matrixStackIn.push();

                    if(llama.isChild())
                    {
                        matrixStackIn.scale(0.71428573F, 0.64935064F, 0.7936508F);
                        matrixStackIn.translate(0.0D, 1.3125D, (double)0.22F);
                    }

                    matrixStackIn.translate(0F, 7.0F / 16F, -6.0F / 16F);
                    matrixStackIn.rotate(Vector3f.YP.rotationDegrees(netHeadYaw));
                    matrixStackIn.rotate(Vector3f.XP.rotationDegrees(interpolateValues(llama.prevRotationPitch, llama.rotationPitch, renderTick)));
                    matrixStackIn.translate(0F, -7.0F / 16F, 6.0F / 16F);

                    float scale = 0.0625F;

                    matrixStackIn.translate(0, -26F * scale, -10F * scale);

                    ResourceLocation bunnyTex;
                    if(llama.hasCustomName() && "Toast".equals(llama.getName().getUnformattedComponentText()))
                    {
                        bunnyTex = TOAST;
                    }
                    else
                    {
                        switch(rand.nextInt(7))
                        {
                            case 0:
                            default:
                                bunnyTex = BROWN;
                                break;
                            case 1:
                                bunnyTex = WHITE;
                                break;
                            case 2:
                                bunnyTex = BLACK;
                                break;
                            case 3:
                                bunnyTex = WHITE_SPLOTCHED;
                                break;
                            case 4:
                                bunnyTex = GOLD;
                                break;
                            case 5:
                                bunnyTex = SALT;
                                break;
                            case 6:
                                bunnyTex = CAERBANNOG;
                                break;
                        }
                    }

                    IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEntityTranslucent(bunnyTex));
                    int packedOverlay = LivingRenderer.getPackedOverlay(llama, 0.0F);

                    modelRabbit.setRotationAngles(rabbitInstance, limbSwing, limbSwingAmount, ageInTicks, 0F, 0F);
                    modelRabbit.render(matrixStackIn, ivertexbuilder, packedLightIn, packedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);

                    matrixStackIn.scale(0.6F, 0.6F, 0.6F);
                    matrixStackIn.translate(0.0F, 16.0F * scale, 0.0F);

                    if(renderHat || renderMonocle || renderPipe)
                    {
                        matrixStackIn.push();

                        ivertexbuilder = bufferIn.getBuffer(RenderType.getEntityTranslucent(texFancy));
                        model.renderHeadParts(renderHat, renderMonocle, renderPipe, false, matrixStackIn, ivertexbuilder, packedLightIn, packedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);

                        if(renderHat)
                        {
                            ivertexbuilder = bufferIn.getBuffer(RenderType.getEntityTranslucent(texFancyColorizer));
                            model.renderHeadParts(renderHat, renderMonocle, renderPipe, true, matrixStackIn, ivertexbuilder, packedLightIn, packedOverlay, clr[0], clr[1], clr[2], 1.0F);
                        }
                        matrixStackIn.pop();
                    }

                    if(renderBowtie)
                    {
                        ivertexbuilder = bufferIn.getBuffer(RenderType.getEntityTranslucent(texFancy));
                        model.renderBody(rabbitInstance, false, ageInTicks, matrixStackIn, ivertexbuilder, packedLightIn, packedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);

                        ivertexbuilder = bufferIn.getBuffer(RenderType.getEntityTranslucent(texFancyColorizer));
                        model.renderBody(rabbitInstance, true, ageInTicks, matrixStackIn, ivertexbuilder, packedLightIn, packedOverlay, clr[0], clr[1], clr[2], 1.0F);
                    }
                    matrixStackIn.pop();
                }
            }
            else if(rand.nextFloat() < (BetterThanLlamas.config.fancyChance.get() / 100F))
            {
                if(renderHat || renderMonocle || renderPipe || renderBowtie || renderFez || renderMoustache)
                {
                    float[] clr = new float[3];
                    if (iChunLlama)
                    {
                        int i = llama.ticksExisted / 25 + llama.getEntityId();
                        int j = DyeColor.values().length;
                        int k = i % j;
                        int l = (i + 1) % j;
                        float f = ((float)(llama.ticksExisted % 25) + renderTick) / 25.0F;
                        float[] afloat1 = SheepEntity.getDyeRgb(DyeColor.byId(k));
                        float[] afloat2 = SheepEntity.getDyeRgb(DyeColor.byId(l));
                        clr[0] = afloat1[0] * (1.0F - f) + afloat2[0] * f;
                        clr[1] = afloat1[1] * (1.0F - f) + afloat2[1] * f;
                        clr[2] = afloat1[2] * (1.0F - f) + afloat2[2] * f;
                    }
                    else
                    {
                        rand.setSeed(Math.abs(llama.getEntityId() * 1234L));
                        clr = SheepEntity.getDyeRgb(DyeColor.byId(rand.nextInt(16)));
                    }

                    IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEntityTranslucent(texFancy));
                    int packedOverlay = LivingRenderer.getPackedOverlay(llama, 0.0F);

                    matrixStackIn.push();

                    if(llama.isChild())
                    {
                        matrixStackIn.scale(0.71428573F, 0.64935064F, 0.7936508F);
                        matrixStackIn.translate(0.0D, 1.3125D, (double)0.22F);
                    }

                    matrixStackIn.translate(0F, 7.0F / 16F, -6.0F / 16F);
                    float pitch = interpolateValues(llama.prevRotationPitch, llama.rotationPitch, renderTick);
                    matrixStackIn.rotate(Vector3f.YP.rotationDegrees(netHeadYaw));
                    matrixStackIn.rotate(Vector3f.XP.rotationDegrees(pitch));
                    matrixStackIn.translate(0F, -7.0F / 16F, 6.0F / 16F);

                    model.fez3.rotateAngleX = -1.2292353921796064F + (float)Math.toRadians(-MathHelper.clamp(pitch, -90F, 0));
                    model.renderLlama(false, renderHat, renderMonocle, renderPipe, renderBowtie, renderFez, renderMoustache, matrixStackIn, ivertexbuilder, packedLightIn, packedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);

                    if(renderHat || renderBowtie)
                    {
                        ivertexbuilder = bufferIn.getBuffer(RenderType.getEntityTranslucent(texFancyColorizer));
                        model.renderLlama(true, renderHat, renderMonocle, renderPipe, renderBowtie, renderFez, renderMoustache, matrixStackIn, ivertexbuilder, packedLightIn, packedOverlay, clr[0], clr[1], clr[2], 1.0F);
                    }
                    matrixStackIn.pop();
                }
            }
        }
    }

    public static float interpolateValues(float prevVal, float nextVal, float partialTick)
    {
        return prevVal + partialTick * (nextVal - prevVal);
    }
}
