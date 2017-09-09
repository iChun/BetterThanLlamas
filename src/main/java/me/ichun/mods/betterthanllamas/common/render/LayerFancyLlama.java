package me.ichun.mods.betterthanllamas.common.render;

import me.ichun.mods.betterthanllamas.common.BetterThanLlamas;
import me.ichun.mods.betterthanllamas.common.model.ModelFancy;
import net.minecraft.client.model.ModelLlama;
import net.minecraft.client.model.ModelRabbit;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLlama;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

import java.util.Calendar;
import java.util.Random;

public class LayerFancyLlama implements LayerRenderer<EntityLlama>
{
    public final RenderLlama renderer;
    public Random rand;

    private static final ResourceLocation texFancy = new ResourceLocation("betterthanllamas","textures/model/fancy.png");
    private static final ResourceLocation texFancyColorizer = new ResourceLocation("betterthanllamas","textures/model/fancycolorizer.png");


    private final boolean isAFDay;
    private ModelRabbit modelRabbit;
    private ModelFancy modelFancy;
    private EntityRabbit rabbitInstance;
    private static final ResourceLocation BROWN = new ResourceLocation("textures/entity/rabbit/brown.png");
    private static final ResourceLocation WHITE = new ResourceLocation("textures/entity/rabbit/white.png");
    private static final ResourceLocation BLACK = new ResourceLocation("textures/entity/rabbit/black.png");
    private static final ResourceLocation GOLD = new ResourceLocation("textures/entity/rabbit/gold.png");
    private static final ResourceLocation SALT = new ResourceLocation("textures/entity/rabbit/salt.png");
    private static final ResourceLocation WHITE_SPLOTCHED = new ResourceLocation("textures/entity/rabbit/white_splotched.png");
    private static final ResourceLocation CAERBANNOG = new ResourceLocation("textures/entity/rabbit/caerbannog.png");

    public LayerFancyLlama(RenderLlama renderer)
    {
        this.renderer = renderer;
        this.rand = new Random();
        this.modelFancy = new ModelFancy();

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());

        isAFDay = calendar.get(Calendar.MONTH) == Calendar.APRIL && calendar.get(Calendar.DAY_OF_MONTH) == 1;
        if(isAFDay)
        {
            modelRabbit = new ModelRabbit();
            modelRabbit.isChild = false;
            rabbitInstance = new EntityRabbit(null);
            if(renderer.mainModel instanceof ModelLlama)
            {
                ((ModelLlama)renderer.mainModel).head = new ModelRenderer(renderer.mainModel, 33, 4);
                ((ModelLlama)renderer.mainModel).head.addBox(-4.0F, -9.0F, -6.0F, 8, 11, 6, 0);
                ((ModelLlama)renderer.mainModel).head.setRotationPoint(0.0F, 7.0F, -6.0F);
            }
        }
    }

    @Override
    public void doRenderLayer(EntityLlama llama, float limbSwing, float limbSwingAmount, float renderTick, float ageInTicks, float netHeadYaw, float headPitch, float f5)
    {
        rand.setSeed(Math.abs(llama.getEntityId() * 5642L));
        if(!llama.isInvisible())
        {
            boolean renderHat = true;
            boolean renderMonocle = true;
            boolean renderPipe = true;
            boolean renderBowtie = true;
            boolean renderFez = true;
            boolean renderMoustache = true;

            if(BetterThanLlamas.randomizeParts == 1)
            {
                rand.setSeed(Math.abs(llama.getEntityId() * 8542L));
                renderHat = rand.nextBoolean();
                renderMonocle = rand.nextBoolean();
                renderPipe = rand.nextBoolean();
                renderBowtie = rand.nextBoolean();
                renderFez = rand.nextBoolean();
                renderMoustache = rand.nextBoolean();
            }

            if(renderHat && renderFez)
            {
                renderHat = rand.nextBoolean();
                renderFez = !renderHat;
            }

            for(String disabled : BetterThanLlamas.disabledParts)
            {
                if(disabled.equalsIgnoreCase("hat"))
                {
                    renderHat = false;
                }
                if(disabled.equalsIgnoreCase("monocle"))
                {
                    renderMonocle = false;
                }
                if(disabled.equalsIgnoreCase("pipe"))
                {
                    renderPipe = false;
                }
                if(disabled.equalsIgnoreCase("bowtie"))
                {
                    renderBowtie = false;
                }
                if(disabled.equalsIgnoreCase("fez"))
                {
                    renderFez = false;
                }
                if(disabled.equalsIgnoreCase("moustache"))
                {
                    renderMoustache = false;
                }
            }

            if(isAFDay)
            {
                if(renderHat || renderMonocle || renderPipe || renderBowtie)
                {
                    float[] clr = new float[3];
                    if (llama.hasCustomName() && "jeb_".equals(llama.getCustomNameTag()))
                    {
                        int i = llama.ticksExisted / 25 + llama.getEntityId();
                        int j = EnumDyeColor.values().length;
                        int k = i % j;
                        int l = (i + 1) % j;
                        float f = ((float)(llama.ticksExisted % 25) + renderTick) / 25.0F;
                        float[] afloat1 = EntitySheep.getDyeRgb(EnumDyeColor.byMetadata(k));
                        float[] afloat2 = EntitySheep.getDyeRgb(EnumDyeColor.byMetadata(l));
                        clr[0] = afloat1[0] * (1.0F - f) + afloat2[0] * f;
                        clr[1] = afloat1[1] * (1.0F - f) + afloat2[1] * f;
                        clr[2] = afloat1[2] * (1.0F - f) + afloat2[2] * f;
                    }
                    else
                    {
                        rand.setSeed(Math.abs(llama.getEntityId() * 1234L));
                        clr = EntitySheep.getDyeRgb(EnumDyeColor.byMetadata(rand.nextInt(16)));
                    }

                    GlStateManager.enableBlend();
                    GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);

                    //push for body renderBody
                    GlStateManager.pushMatrix();

                    if(llama.isChild())
                    {
                        GlStateManager.scale(0.71428573F, 0.64935064F, 0.7936508F);
                        GlStateManager.translate(0.0F, 21.0F * 0.0625F, 0.22F);
                    }

                    GlStateManager.translate(0F, 7.0F / 16F, -6.0F / 16F);
                    GlStateManager.rotate(netHeadYaw, 0.0F, 1.0F, 0.0F);
                    GlStateManager.rotate(interpolateValues(llama.prevRotationPitch, llama.rotationPitch, renderTick), 1.0F, 0.0F, 0.0F);
                    GlStateManager.translate(0F, -7.0F / 16F, 6.0F / 16F);

                    float scale = 0.0625F;

                    GlStateManager.translate(0, -26F * scale, -10F * scale);

                    ResourceLocation bunnyTex;
                    switch (rand.nextInt(7))
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

                    renderer.bindTexture(bunnyTex);
                    modelRabbit.render(rabbitInstance, limbSwing, limbSwingAmount, ageInTicks, 0F, 0F, f5);

                    GlStateManager.scale(0.6F, 0.6F, 0.6F);
                    GlStateManager.translate(0.0F, 16.0F * scale, 0.0F);

                    if(renderHat || renderMonocle || renderPipe)
                    {
                        GlStateManager.pushMatrix();

                        renderer.bindTexture(texFancy);
                        GlStateManager.color(1F, 1F, 1F);
                        modelFancy.renderHeadParts(renderHat, renderMonocle, renderPipe, false, 0.0625F);

                        if(renderHat)
                        {
                            renderer.bindTexture(texFancyColorizer);
                            GlStateManager.color(clr[0], clr[1], clr[2]);
                            modelFancy.renderHeadParts(renderHat, renderMonocle, renderPipe, true, 0.0625F);
                        }
                        GlStateManager.popMatrix();
                    }

                    if(renderBowtie)
                    {
                        renderer.bindTexture(texFancy);
                        GlStateManager.color(1F, 1F, 1F);
                        modelFancy.renderBody(rabbitInstance, false, ageInTicks, 0.0625F);

                        renderer.bindTexture(texFancyColorizer);
                        GlStateManager.color(clr[0], clr[1], clr[2]);
                        modelFancy.renderBody(rabbitInstance, true, ageInTicks, 0.0625F);
                    }
                    GlStateManager.popMatrix();

                    GlStateManager.disableBlend();
                }
            }
            else if(rand.nextFloat() < (BetterThanLlamas.fancyWeightage / 100F))
            {
                if(renderHat || renderMonocle || renderPipe || renderBowtie || renderFez || renderMoustache)
                {
                    float[] clr = new float[3];
                    if (llama.hasCustomName() && "jeb_".equals(llama.getCustomNameTag()))
                    {
                        int i = llama.ticksExisted / 25 + llama.getEntityId();
                        int j = EnumDyeColor.values().length;
                        int k = i % j;
                        int l = (i + 1) % j;
                        float f = ((float)(llama.ticksExisted % 25) + renderTick) / 25.0F;
                        float[] afloat1 = EntitySheep.getDyeRgb(EnumDyeColor.byMetadata(k));
                        float[] afloat2 = EntitySheep.getDyeRgb(EnumDyeColor.byMetadata(l));
                        clr[0] = afloat1[0] * (1.0F - f) + afloat2[0] * f;
                        clr[1] = afloat1[1] * (1.0F - f) + afloat2[1] * f;
                        clr[2] = afloat1[2] * (1.0F - f) + afloat2[2] * f;
                    }
                    else
                    {
                        rand.setSeed(Math.abs(llama.getEntityId() * 1234L));
                        clr = EntitySheep.getDyeRgb(EnumDyeColor.byMetadata(rand.nextInt(16)));
                    }
                    GlStateManager.enableBlend();
                    GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);

                    GlStateManager.pushMatrix();

                    if(llama.isChild())
                    {
                        GlStateManager.scale(0.71428573F, 0.64935064F, 0.7936508F);
                        GlStateManager.translate(0.0F, 21.0F * 0.0625F, 0.22F);
                    }

                    GlStateManager.translate(0F, 7.0F / 16F, -6.0F / 16F);
                    GlStateManager.rotate(netHeadYaw, 0.0F, 1.0F, 0.0F);
                    float pitch = interpolateValues(llama.prevRotationPitch, llama.rotationPitch, renderTick);
                    GlStateManager.rotate(pitch, 1.0F, 0.0F, 0.0F);
                    GlStateManager.translate(0F, -7.0F / 16F, 6.0F / 16F);

                    renderer.bindTexture(texFancy);
                    GlStateManager.color(1F, 1F, 1F);
                    modelFancy.fez3.rotateAngleX = -1.2292353921796064F + (float)Math.toRadians(-MathHelper.clamp(pitch, -90F, 0));
                    modelFancy.renderLlama(false, renderHat, renderMonocle, renderPipe, renderBowtie, renderFez, renderMoustache, 0.0625F);

                    if(renderHat || renderBowtie)
                    {
                        renderer.bindTexture(texFancyColorizer);
                        GlStateManager.color(clr[0], clr[1], clr[2]);
                        modelFancy.renderLlama(true, renderHat, renderMonocle, renderPipe, renderBowtie, renderFez, renderMoustache, 0.0625F);
                    }
                    GlStateManager.popMatrix();

                    GlStateManager.disableBlend();
                }
            }
        }
    }

    public static float interpolateValues(float prevVal, float nextVal, float partialTick)
    {
        return prevVal + partialTick * (nextVal - prevVal);
    }

    @Override
    public boolean shouldCombineTextures()
    {
        return true;
    }
}
