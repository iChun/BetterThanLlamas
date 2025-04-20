package me.ichun.mods.betterthanllamas.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import me.ichun.mods.betterthanllamas.client.model.LlamaFancyModel;
import me.ichun.mods.betterthanllamas.common.BetterThanLlamas;
import net.minecraft.client.model.LlamaModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.LlamaRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.state.LlamaRenderState;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ARGB;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.animal.horse.Llama;
import net.minecraft.world.entity.animal.sheep.Sheep;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WoolCarpetBlock;

import java.util.Random;

public class LlamaFancyLayer extends RenderLayer<LlamaRenderState, LlamaModel>
{
    private static final ResourceLocation texFancy = ResourceLocation.fromNamespaceAndPath("betterthanllamas","textures/model/fancy.png");
    private static final ResourceLocation texFancyColorizer = ResourceLocation.fromNamespaceAndPath("betterthanllamas","textures/model/fancycolorizer.png");

    private Random rand = new Random();
    private LlamaFancyModel model = new LlamaFancyModel();

    public LlamaFancyLayer(LlamaRenderer renderer)
    {
        super(renderer);
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, LlamaRenderState renderState, float yRot, float xRot)
    {
        Llama llama = BetterThanLlamas.eventHandlerClient.llamaRendered.get();
        if(llama == null) return;

        if(!renderState.isInvisible)
        {
            boolean iChunLlama = renderState.customName != null && "iChun".equals(renderState.customName.getString());
            if(iChunLlama)
            {
                rand.setSeed(Math.abs("iChun".hashCode() + (llama.getId() * 63268L) * 5642L));
            }
            else
            {
                rand.setSeed(Math.abs((renderState.customName != null ? renderState.customName.getString().hashCode() : llama.getUUID().hashCode()) * 5642L));
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
                renderHat = rand.nextFloat() < BetterThanLlamas.config.hatChance / 100F;
                renderMonocle = rand.nextFloat() < BetterThanLlamas.config.monocleChance / 100F;
                renderPipe = rand.nextFloat() < BetterThanLlamas.config.pipeChance / 100F;
                renderBowtie = rand.nextFloat() < BetterThanLlamas.config.bowtieChance / 100F;
                renderFez = rand.nextFloat() < BetterThanLlamas.config.fezChance / 100F;
                renderMoustache = rand.nextFloat() < BetterThanLlamas.config.moustacheChance / 100F;
            }

            if(renderHat && renderFez)
            {
                renderHat = rand.nextBoolean();
                renderFez = !renderHat;
            }

            if(rand.nextFloat() < (BetterThanLlamas.config.fancyChance / 100F))
            {
                if(renderHat || renderMonocle || renderPipe || renderBowtie || renderFez || renderMoustache)
                {
                    int clr = getLlamaColouriserColour(llama, renderState, iChunLlama);

                    VertexConsumer ivertexbuilder = bufferSource.getBuffer(RenderType.entityTranslucent(texFancy));
                    int packedOverlay = LivingEntityRenderer.getOverlayCoords(renderState, 0.0F);

                    poseStack.pushPose();

                    if(llama.isBaby())
                    {
                        poseStack.scale(0.71428573F, 0.64935064F, 0.7936508F);
                        poseStack.translate(0.0D, 1.3125D, (double)0.22F);

                        //TODO the model desperately needs updating to match the actual Llama model and its rotation points once Tabula is available so this hack isn't needed
                        poseStack.translate(0F, 7.0F * 0.64935064F / 16F, -6.0F / 16F);
                        poseStack.mulPose(Axis.YP.rotationDegrees(renderState.yRot));
                        poseStack.mulPose(Axis.XP.rotationDegrees(renderState.xRot));
                        poseStack.translate(0F, -7.0F * 0.64935064F / 16F, 6.0F / 16F);
                    }
                    else
                    {
                        poseStack.translate(0F, 7.0F / 16F, -6.0F / 16F);
                        poseStack.mulPose(Axis.YP.rotationDegrees(renderState.yRot));
                        poseStack.mulPose(Axis.XP.rotationDegrees(renderState.xRot));
                        poseStack.translate(0F, -7.0F / 16F, 6.0F / 16F);
                    }

                    model.fez3.xRot = -1.2292353921796064F + (float)Math.toRadians(-Mth.clamp(renderState.xRot, -90F, 0));
                    model.renderLlama(false, renderHat, renderMonocle, renderPipe, renderBowtie, renderFez, renderMoustache, poseStack, ivertexbuilder, packedLight, packedOverlay, 0xffffffff);

                    if(renderHat || renderBowtie)
                    {
                        ivertexbuilder = bufferSource.getBuffer(RenderType.entityTranslucent(texFancyColorizer));
                        model.renderLlama(true, renderHat, renderMonocle, renderPipe, renderBowtie, renderFez, renderMoustache, poseStack, ivertexbuilder, packedLight, packedOverlay, clr);
                    }
                    poseStack.popPose();
                }
            }
        }
    }

    private int getLlamaColouriserColour(Llama llama, LlamaRenderState renderState, boolean iChunLlama)
    {
        if (iChunLlama)
        {
            int i = Mth.floor(renderState.ageInTicks) / 25 + llama.getId();
            int j = DyeColor.values().length;
            int k = i % j;
            int l = (i + 1) % j;
            float f = ((float)(Mth.floor(renderState.ageInTicks) % 25) + Mth.frac(renderState.ageInTicks)) / 25.0F;
            int clr1 = Sheep.getColor(DyeColor.byId(k));
            int clr2 = Sheep.getColor(DyeColor.byId(l));
            return ARGB.lerp(f, clr1, clr2);
        }
        else
        {
            ItemStack itemstack = renderState.bodyItem;
            Block block = Block.byItem(itemstack.getItem());
            if(block instanceof WoolCarpetBlock woolBlock)
            {
                return Sheep.getColor(woolBlock.getColor());
            }

            rand.setSeed(Math.abs(llama.getId() * 1234L));
            return Sheep.getColor(DyeColor.byId(rand.nextInt(16)));
        }
    }
}
