package me.ichun.mods.betterthanllamas.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.animal.Rabbit;
import net.minecraft.world.entity.animal.horse.Llama;

public class LlamaFancyModel<T extends Llama> extends EntityModel<T>
{
    //hat
    public ModelPart hatRim;
    public ModelPart hatTop;

    //bowtie
    public ModelPart bowtie5;
    public ModelPart bowtie3;
    public ModelPart bowtie4;
    public ModelPart bowtie1;
    public ModelPart bowtie2;

    //monocle
    public ModelPart monocle;
    public ModelPart monocle2;
    public ModelPart monocle3;
    public ModelPart monocle4;
    public ModelPart monocle5;
    public ModelPart monocle6;
    public ModelPart monocle7;
    public ModelPart monocle8;
    public ModelPart monocle1;
    public ModelPart monocleChain1;
    public ModelPart monocleChain2;
    public ModelPart monocleChain3;
    public ModelPart monocleChain4;

    //suit
    public ModelPart bodyTux;
    public ModelPart frontLegRightTux;
    public ModelPart bodyTuxTail1;
    public ModelPart bodyTuxTail2;
    public ModelPart frontLegLeftTux;

    //pipe
    public ModelPart pipe4;
    public ModelPart pipe2;
    public ModelPart pipe3;
    public ModelPart pipe;

    //fez
    public ModelPart fez1;
    public ModelPart fez2;
    public ModelPart fez3;

    //mous
    public ModelPart mous1;
    public ModelPart mousL1;
    public ModelPart mousR1;
    public ModelPart mousL2;
    public ModelPart mousL3;
    public ModelPart mousR2;
    public ModelPart mousR3;


    public LlamaFancyModel()
    {
        ModelPart root = createModel().bakeRoot();

        hatRim = root.getChild("hat_rim");
        hatTop = root.getChild("hat_top");

        bowtie5 = root.getChild("bowtie5");
        bowtie3 = root.getChild("bowtie3");
        bowtie4 = root.getChild("bowtie4");
        bowtie1 = root.getChild("bowtie1");
        bowtie2 = root.getChild("bowtie2");

        monocle = root.getChild("monocle");
        monocle2 = root.getChild("monocle2");
        monocle3 = root.getChild("monocle3");
        monocle4 = root.getChild("monocle4");
        monocle5 = root.getChild("monocle5");
        monocle6 = root.getChild("monocle6");
        monocle7 = root.getChild("monocle7");
        monocle8 = root.getChild("monocle8");
        monocle1 = root.getChild("monocle1");

        monocleChain1 = root.getChild("monocleChain1");
        monocleChain2 = root.getChild("monocleChain2");
        monocleChain3 = root.getChild("monocleChain3");
        monocleChain4 = root.getChild("monocleChain4");

        bodyTux = root.getChild("bodyTux");
        frontLegRightTux = root.getChild("frontLegRightTux");
        bodyTuxTail1 = root.getChild("bodyTuxTail1");
        bodyTuxTail2 = root.getChild("bodyTuxTail2");
        frontLegLeftTux = root.getChild("frontLegLeftTux");

        pipe4 = root.getChild("pipe4");
        pipe2 = root.getChild("pipe2");
        pipe3 = root.getChild("pipe3");
        pipe = root.getChild("pipe");

        fez1 = root.getChild("fez1");
        fez2 = fez1.getChild("fez2");
        fez3 = fez2.getChild("fez3");

        mous1 = root.getChild("mous1");
        mousL1 = mous1.getChild("mousL1");
        mousR1 = mous1.getChild("mousR1");

        mousL2 = mousL1.getChild("mousL2");
        mousR2 = mousR1.getChild("mousR2");

        mousL3 = mousL2.getChild("mousL3");
        mousR3 = mousR2.getChild("mousR3");
    }

    public static LayerDefinition createModel()
    {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();

        //multiply the box dims/offset by the scale to have a model renderer that can be scaled. Do not use CubeDeformation
        root.addOrReplaceChild("hat_rim", CubeListBuilder.create().texOffs(1, 34).addBox(-4.5F, -0.5F, -4.5F, 9, 1, 9, new CubeDeformation(-1.35F, 0.025F, -1.35F)), PartPose.offset(0F, 11.5F, -3.68F));
        root.addOrReplaceChild("hat_top", CubeListBuilder.create().texOffs(1, 47).addBox(-3.5F, -4.5F, -3.5F, 7, 9, 7, new CubeDeformation(-1.4F, -1.8F, -1.4F)), PartPose.offset(0F, 8.5F, -3.68F));

        root.addOrReplaceChild("bowtie5", CubeListBuilder.create().texOffs(36, 36).addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, new CubeDeformation(-0.125F, -0.125F, -0.125F)), PartPose.offset(0F, 17F, -3F));
        root.addOrReplaceChild("bowtie3", CubeListBuilder.create().texOffs(36, 36).addBox(-0.5F, -1F, -0.5F, 1, 2, 1, new CubeDeformation(-0.125F, -0.25F, -0.125F)), PartPose.offset(0.75F, 17F, -3F));
        root.addOrReplaceChild("bowtie4", CubeListBuilder.create().texOffs(36, 36).addBox(-0.5F, -1.5F, -0.5F, 1, 3, 1, new CubeDeformation(-0.125F, -0.375F, -0.125F)), PartPose.offset(1.5F, 17F, -3F));
        root.addOrReplaceChild("bowtie1", CubeListBuilder.create().texOffs(36, 36).addBox(-0.5F, -1F, -0.5F, 1, 2, 1, new CubeDeformation(-0.125F, -0.25F, -0.125F)), PartPose.offset(-0.75F, 17F, -3F));
        root.addOrReplaceChild("bowtie2", CubeListBuilder.create().texOffs(36, 36).addBox(-0.5F, -1.5F, -0.5F, 1, 3, 1, new CubeDeformation(-0.125F, -0.375F, -0.125F)), PartPose.offset(-1.5F, 17F, -3F));

        root.addOrReplaceChild("monocle", CubeListBuilder.create().texOffs(0, 35).addBox(-1.5F, -0.5F, -0.5F, 3, 1, 1, new CubeDeformation(-1.05F, -0.35F, -0.35F)), PartPose.offset(1F, 12F, -6.4F));
        root.addOrReplaceChild("monocle2", CubeListBuilder.create().texOffs(0, 35).addBox(-1.5F, -0.5F, -0.5F, 3, 1, 1, new CubeDeformation(-1.05F, -0.35F, -0.35F)), PartPose.offset(1F, 14.1F, -6.4F));
        root.addOrReplaceChild("monocle3", CubeListBuilder.create().texOffs(0, 35).addBox(-0.5F, -2F, -0.5F, 1, 4, 1, new CubeDeformation(-0.35F, -1.4F, -0.35F)), PartPose.offset(0.1F, 13.05F, -6.4F));
        root.addOrReplaceChild("monocle4", CubeListBuilder.create().texOffs(0, 35).addBox(-0.5F, -2F, -0.5F, 1, 4, 1, new CubeDeformation(-0.35F, -1.4F, -0.35F)), PartPose.offset(1.9F, 13.05F, -6.4F));
        root.addOrReplaceChild("monocle5", CubeListBuilder.create().texOffs(0, 35).addBox(-0.5F, -0.5F, -0.5F, 1 ,1 ,1, new CubeDeformation(-0.35F, -0.35F, -0.35F)), PartPose.offset(0.4F, 12.3F, -6.4F));
        root.addOrReplaceChild("monocle6", CubeListBuilder.create().texOffs(0, 35).addBox(-0.5F, -0.5F, -0.5F, 1 ,1 ,1, new CubeDeformation(-0.35F, -0.35F, -0.35F)), PartPose.offset(0.4F, 13.8F, -6.4F));
        root.addOrReplaceChild("monocle7", CubeListBuilder.create().texOffs(0, 35).addBox(-0.5F, -0.5F, -0.5F, 1 ,1 ,1, new CubeDeformation(-0.35F, -0.35F, -0.35F)), PartPose.offset(1.6F, 12.3F, -6.4F));
        root.addOrReplaceChild("monocle8", CubeListBuilder.create().texOffs(0, 35).addBox(-0.5F, -0.5F, -0.5F, 1 ,1 ,1, new CubeDeformation(-0.35F, -0.35F, -0.35F)), PartPose.offset(1.6F, 13.8F, -6.4F));
        root.addOrReplaceChild("monocle1", CubeListBuilder.create().texOffs(44, 34).addBox(-3.5F, -4F, 0F, 7, 8, 0, new CubeDeformation(-2.45F, -2.8F, 0F)), PartPose.offset(1F, 13.05F, -6.4F));

        root.addOrReplaceChild("monocleChain1", CubeListBuilder.create().texOffs(0, 35).addBox(-2F, -0.5F, -0.5F, 4, 1, 1, new CubeDeformation(-1.4F, -0.35F, -0.35F)), PartPose.offsetAndRotation(2.25F, 13.6F, -6.3F, 0F, -0.0799003F, 0.8822937F));
        root.addOrReplaceChild("monocleChain2", CubeListBuilder.create().texOffs(8, 32).addBox(-0.16666666666F * 0.3F, -0.5F * 0.3F, -0.5F * 0.3F, 7 * 0.3F, 1 * 0.3F, 1 * 0.3F), PartPose.offsetAndRotation(2.6F, 14F, -6.3F, -1.5263477F, -0.8136065F, 1.5096725F));
        root.addOrReplaceChild("monocleChain3", CubeListBuilder.create().texOffs(8, 32).addBox(-0.16666666666F * 0.3F, -0.5F * 0.3F, -0.5F * 0.3F, 7 * 0.3F, 1 * 0.3F, 1 * 0.3F), PartPose.offsetAndRotation(2.683918F, 15.3712F, -4.846462F, -1.5867012F, -0.8144203F, 1.5926617F));
        root.addOrReplaceChild("monocleChain4", CubeListBuilder.create().texOffs(8, 32).addBox(-0.16666666666F * 0.3F, -0.5F * 0.3F, -0.5F * 0.3F, 7 * 0.3F, 1 * 0.3F, 1 * 0.3F), PartPose.offsetAndRotation(2.65391F, 16.74345F, -3.391807F, -2.501873F, -0.6680762F, 2.6430418F));

        root.addOrReplaceChild("bodyTux", CubeListBuilder.create().texOffs(32, 49).addBox(-3F, -2.02380952381F, -9.7619047619F, 6, 5, 10, new CubeDeformation(0.15F, 0.125F, 0.25F)), PartPose.offsetAndRotation(0F, 19F, 8F, -0.3490658F, 0F, 0F));
        root.addOrReplaceChild("frontLegRightTux", CubeListBuilder.create().texOffs(50, 22).addBox(-1F, -0.16666666666F, -1F, 2, 7, 2, new CubeDeformation(0.05F, 0.175F, 0.05F)), PartPose.offsetAndRotation(-3F, 17F, -0.9999999F, -0.1919862F, 0F, 0F));
        root.addOrReplaceChild("bodyTuxTail1", CubeListBuilder.create().texOffs(28, 53).addBox(-1.5F, 0.5F, -0.5F, 3, 0, 5), PartPose.offsetAndRotation(1.6F, 17.10369F, 9.222291F, -1.1550761F, 0.0783855F, -0.1755566F));
        root.addOrReplaceChild("bodyTuxTail2", CubeListBuilder.create().texOffs(28, 48).addBox(-1.5F, 0.5F, -0.5F, 3, 0, 5), PartPose.offsetAndRotation(-1.6F, 17.10369F, 9.222291F, -1.1550189F, -0.0783511F, 0.1755257F));
        root.addOrReplaceChild("frontLegLeftTux", CubeListBuilder.create().texOffs(50, 13).addBox(-1F, -0.16666666666F, -1F, 2, 7, 2, new CubeDeformation(0.05F, 0.175F, 0.05F)), PartPose.offsetAndRotation(3F, 17F, -0.9999999F, -0.1919862F, 0F, 0F));

        root.addOrReplaceChild("pipe4", CubeListBuilder.create().texOffs(22, 46).addBox(-0.5F, -0.5F, -2F, 1, 1, 4, new CubeDeformation(-0.335F, -0.335F, -1.34F)), PartPose.offsetAndRotation(-0.5F, 15.26F, -6.5F, 0.3689549F, 0.3528234F, 0.0869134F));
        root.addOrReplaceChild("pipe2", CubeListBuilder.create().texOffs(52, 44).addBox(-0.5F, -0.5F, -1.5F, 1, 1, 3, new CubeDeformation(-0.335F, -0.335F, -1.005F)), PartPose.offsetAndRotation(-0.863904F, 15.73034F, -7.373644F, 0.6067749F, 0.3528234F, 0.0869134F));
        root.addOrReplaceChild("pipe3", CubeListBuilder.create().texOffs(52, 44).addBox(-0.5F, -1F, -1.5F, 1, 2, 3, new CubeDeformation(-0.335F, -0.67F, -1.005F)), PartPose.offsetAndRotation(-1.09568F, 16.31841F, -7.862072F, 0.8521354F, 0.3528233F, 0.0869134F));
        root.addOrReplaceChild("pipe", CubeListBuilder.create().texOffs(41, 42).addBox(-1.5F, -2F, -1.5F, 3, 4, 3, new CubeDeformation(-1.005F, -1.34F, -1.005F)), PartPose.offsetAndRotation(-1.326135F, 16.51624F, -8.438918F, 0.2627141F, 0.3528234F, 0.0869134F));

        PartDefinition fez1 = root.addOrReplaceChild("fez1", CubeListBuilder.create().texOffs(11, 0).addBox(-2.0F, -3.0F, -2.0F, 4, 4, 4), PartPose.offset(0.0F, -10.0F, -9.0F));
        PartDefinition fez2 = fez1.addOrReplaceChild("fez2", CubeListBuilder.create().texOffs(23, 0).addBox(-0.5F, 0.0F, 0.0F, 1, 1, 3), PartPose.offsetAndRotation(0.0F, -3.8F, 0.0F, -0.17453292519943295F, 0.7330382858376184F, 0.0F));
        fez2.addOrReplaceChild("fez3", CubeListBuilder.create().texOffs(27, 0).addBox(-0.5F, 0.0F, 0.0F, 1, 1, 4), PartPose.offsetAndRotation(0.0F, 0.0F, 3.0F, -1.2292353921796064F, 0.0F, 0.0F));

        PartDefinition mous1 = root.addOrReplaceChild("mous1", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2, 1, 1), PartPose.offset(0.0F, -5.5F, -17.0F));
        PartDefinition mousL1 = mous1.addOrReplaceChild("mousL1", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 1, 1, 1), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7740535232594852F));
        PartDefinition mousR1 = mous1.addOrReplaceChild("mousR1", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 1, 1, 1), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7740535232594852F));

        PartDefinition mousL2 = mousL1.addOrReplaceChild("mousL2", CubeListBuilder.create().addBox(-0.7F, -0.3F, 0.0F, 2, 1, 1), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7740535232594852F));
        PartDefinition mousR2 = mousR1.addOrReplaceChild("mousR2", CubeListBuilder.create().addBox(-1.3F, -0.3F, 0.0F, 2, 1, 1), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7740535232594852F));

        mousL2.addOrReplaceChild("mousL3", CubeListBuilder.create().addBox(-0.5F, -0.1F, 0.0F, 1, 1, 1), PartPose.offsetAndRotation(1.0F, -0.3F, 0.0F, 0.0F, 0.0F, -0.8196066167365371F));
        mousR2.addOrReplaceChild("mousR3", CubeListBuilder.create().addBox(-0.5F, -0.1F, 0.0F, 1, 1, 1), PartPose.offsetAndRotation(-1.0F, -0.3F, 0.0F, 0.0F, 0.0F, 0.8196066167365371F));

        return LayerDefinition.create(mesh, 64, 64);
    }

    @Override
    public void setupAnim(T t, float v, float v1, float v2, float v3, float v4)
    {
    }

    @Override
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) //this method is never called, normally.
    {
        renderHeadParts(true, true, true, false, matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        renderHeadParts(true, true, true, true, matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
    }

    public void renderHeadParts(boolean renderHat, boolean renderMonocle, boolean renderPipe, boolean color, PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha)
    {
        if(!color)
        {
            if(renderHat)
            {
                hatTop.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                hatRim.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
            }
            if(renderMonocle)
            {
                monocle.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                monocle2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                monocle3.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                monocle4.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                monocle5.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                monocle6.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                monocle7.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                monocle8.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                monocle1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);

                monocleChain1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                monocleChain2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                monocleChain3.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                monocleChain4.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
            }
            if(renderPipe)
            {
                pipe4.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                pipe2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                pipe3.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                pipe.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
            }
        }
        else if(renderHat)
        {
            hatTop.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        }
    }

    public void renderBody(Rabbit rabbit, boolean color, float ageInTicks, PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha)
    {
        if(!color)
        {
            float f = ageInTicks - (float)rabbit.tickCount;
            float jumpRotation = Mth.sin(rabbit.getJumpCompletion(f) * (float)Math.PI);

            frontLegRightTux.xRot = (jumpRotation * -40.0F - 11.0F) * 0.017453292F;
            frontLegLeftTux.xRot = (jumpRotation * -40.0F - 11.0F) * 0.017453292F;
            bodyTuxTail1.xRot = (-1.108972F + jumpRotation * 0.8F);
            bodyTuxTail2.xRot = (-1.108972F + jumpRotation * 0.8F);

            frontLegRightTux.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
            frontLegLeftTux.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
            bodyTuxTail1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
            bodyTuxTail2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
            bodyTux.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        }
        else
        {
            bowtie5.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
            bowtie3.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
            bowtie4.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
            bowtie1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
            bowtie2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);

            bodyTux.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        }
    }

    public void renderLlama(boolean color, boolean renderHat, boolean renderMonocle, boolean renderPipe, boolean renderBowtie, boolean renderFez, boolean renderMous, PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha)
    {
        float scale = 1.35F;

        if(!color)
        {
            if(renderHat)
            {
                matrixStackIn.pushPose();
                matrixStackIn.translate(0F, -1.55F, -0.25F );
                matrixStackIn.scale(scale, scale, scale);
                hatTop.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                hatRim.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                matrixStackIn.popPose();
            }
            if(renderMonocle)
            {
                matrixStackIn.pushPose();
                matrixStackIn.translate(0.041F, -1.55F, -0.22F);
                matrixStackIn.scale(scale, scale, scale);
                monocle.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                monocle2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                monocle3.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                monocle4.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                monocle5.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                monocle6.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                monocle7.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                monocle8.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                monocle1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);

                monocleChain1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                monocleChain2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                monocleChain3.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                monocleChain4.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                matrixStackIn.popPose();
            }
            if(renderPipe)
            {
                matrixStackIn.pushPose();
                matrixStackIn.translate(0F, -1.50F, -0.5F);
                matrixStackIn.scale(scale, scale, scale);
                pipe4.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                pipe2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                pipe3.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                pipe.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                matrixStackIn.popPose();
            }
            if(renderFez)
            {
                fez1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
            }
            if(renderMous)
            {
                mous1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
            }
        }
        else
        {
            if(renderHat)
            {
                matrixStackIn.pushPose();
                matrixStackIn.translate(0F, -1.55F, -0.25F);
                matrixStackIn.scale(scale, scale, scale);
                hatTop.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                matrixStackIn.popPose();
            }
            if(renderBowtie)
            {
                matrixStackIn.pushPose();
                matrixStackIn.translate(0F, -1.5F, -0.525F);
                matrixStackIn.scale(scale, scale, scale);
                bowtie5.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                bowtie3.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                bowtie4.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                bowtie1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                bowtie2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                matrixStackIn.popPose();
            }
        }
    }
}