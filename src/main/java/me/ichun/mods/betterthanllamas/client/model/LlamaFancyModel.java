package me.ichun.mods.betterthanllamas.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.entity.passive.horse.LlamaEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;

public class LlamaFancyModel<T extends LlamaEntity> extends EntityModel<T>
{
    //hat
    public ModelRenderer hatRim;
    public ModelRenderer hatTop;

    //bowtie
    public ModelRenderer bowtie5;
    public ModelRenderer bowtie3;
    public ModelRenderer bowtie4;
    public ModelRenderer bowtie1;
    public ModelRenderer bowtie2;

    //monocle
    public ModelRenderer monocle;
    public ModelRenderer monocle2;
    public ModelRenderer monocle3;
    public ModelRenderer monocle4;
    public ModelRenderer monocle5;
    public ModelRenderer monocle6;
    public ModelRenderer monocle7;
    public ModelRenderer monocle8;
    public ModelRenderer monocle1;
    public ModelRenderer monocleChain1;
    public ModelRenderer monocleChain2;
    public ModelRenderer monocleChain3;
    public ModelRenderer monocleChain4;

    //suit
    public ModelRenderer bodyTux;
    public ModelRenderer frontLegRightTux;
    public ModelRenderer bodyTuxTail1;
    public ModelRenderer bodyTuxTail2;
    public ModelRenderer frontLegLeftTux;

    //pipe
    public ModelRenderer pipe4;
    public ModelRenderer pipe2;
    public ModelRenderer pipe3;
    public ModelRenderer pipe;

    //fez
    public ModelRenderer fez1;
    public ModelRenderer fez2;
    public ModelRenderer fez3;

    //mous
    public ModelRenderer mous1;
    public ModelRenderer mousL1;
    public ModelRenderer mousR1;
    public ModelRenderer mousL2;
    public ModelRenderer mousL3;
    public ModelRenderer mousR2;
    public ModelRenderer mousR3;


    public LlamaFancyModel()
    {
        textureHeight = textureWidth = 64;

        hatRim = new ScalableModelRenderer( this, 1, 34, 0.7F, 1.05F, 0.7F );
        hatRim.addBox( -4.5F, -0.5F, -4.5F, 9, 1, 9);
        hatRim.setRotationPoint( 0F, 11.5F, -3.68F );

        hatTop = new ScalableModelRenderer( this, 1, 47, 0.6F );
        hatTop.addBox( -3.5F, -4.5F, -3.5F, 7, 9, 7);
        hatTop.setRotationPoint( 0F, 8.5F, -3.68F );

        bowtie5 = new ScalableModelRenderer( this, 36, 36, 0.75F );
        bowtie5.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 1);
        bowtie5.setRotationPoint( 0F, 17F, -3F );

        bowtie3 = new ScalableModelRenderer( this, 36, 36, 0.75F );
        bowtie3.addBox( -0.5F, -1F, -0.5F, 1, 2, 1);
        bowtie3.setRotationPoint( 0.75F, 17F, -3F );

        bowtie4 = new ScalableModelRenderer( this, 36, 36, 0.75F );
        bowtie4.addBox( -0.5F, -1.5F, -0.5F, 1, 3, 1);
        bowtie4.setRotationPoint( 1.5F, 17F, -3F );

        bowtie1 = new ScalableModelRenderer( this, 36, 36, 0.75F );
        bowtie1.addBox( -0.5F, -1F, -0.5F, 1, 2, 1);
        bowtie1.setRotationPoint( -0.75F, 17F, -3F );

        bowtie2 = new ScalableModelRenderer( this, 36, 36, 0.75F );
        bowtie2.addBox( -0.5F, -1.5F, -0.5F, 1, 3, 1);
        bowtie2.setRotationPoint( -1.5F, 17F, -3F );

        monocle = new ScalableModelRenderer( this, 0, 35, 0.3F );
        monocle.addBox( -1.5F, -0.5F, -0.5F, 3, 1, 1);
        monocle.setRotationPoint( 1F, 12F, -6.4F );

        monocle2 = new ScalableModelRenderer( this, 0, 35, 0.3F );
        monocle2.addBox( -1.5F, -0.5F, -0.5F, 3, 1, 1);
        monocle2.setRotationPoint( 1F, 14.1F, -6.4F );

        monocle3 = new ScalableModelRenderer( this, 0, 35, 0.3F );
        monocle3.addBox( -0.5F, -2F, -0.5F, 1, 4, 1);
        monocle3.setRotationPoint( 0.1F, 13.05F, -6.4F );

        monocle4 = new ScalableModelRenderer( this, 0, 35, 0.3F );
        monocle4.addBox( -0.5F, -2F, -0.5F, 1, 4, 1);
        monocle4.setRotationPoint( 1.9F, 13.05F, -6.4F );

        monocle5 = new ScalableModelRenderer( this, 0, 35, 0.3F );
        monocle5.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 1);
        monocle5.setRotationPoint( 0.4F, 12.3F, -6.4F );

        monocle6 = new ScalableModelRenderer( this, 0, 35, 0.3F );
        monocle6.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 1);
        monocle6.setRotationPoint( 0.4F, 13.8F, -6.4F );

        monocle7 = new ScalableModelRenderer( this, 0, 35, 0.3F );
        monocle7.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 1);
        monocle7.setRotationPoint( 1.6F, 12.3F, -6.4F );

        monocle8 = new ScalableModelRenderer( this, 0, 35, 0.3F );
        monocle8.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 1);
        monocle8.setRotationPoint( 1.6F, 13.8F, -6.4F );

        monocle1 = new ScalableModelRenderer( this, 44, 34, 0.3F );
        monocle1.addBox( -3.5F, -4F, 0F, 7, 8, 0);
        monocle1.setRotationPoint( 1F, 13.05F, -6.4F );

        monocleChain1 = new ScalableModelRenderer( this, 0, 35, 0.3F );
        monocleChain1.addBox( -2F, -0.5F, -0.5F, 4, 1, 1);
        monocleChain1.setRotationPoint( 2.25F, 13.6F, -6.3F );
        setRotateAngle(monocleChain1, 0.06167236F, -0.05083169F, 0.8807254F);

        monocleChain2 = new ScalableModelRenderer( this, 8, 32, 0.3F );
        monocleChain2.addBox( -0.16666666666F, -0.5F, -0.5F, 7, 1, 1);
        monocleChain2.setRotationPoint( 2.6F, 14F, -6.3F );
        setRotateAngle(monocleChain2, -0.02879648F, -1.540258F, 0.755817F);

        monocleChain3 = new ScalableModelRenderer( this, 8, 32, 0.3F );
        monocleChain3.addBox( -0.16666666666F, -0.5F, -0.5F, 7, 1, 1);
        monocleChain3.setRotationPoint( 2.683918F, 15.3712F, -4.846462F );
        setRotateAngle(monocleChain3, 0.01029625F, -1.581712F, 0.7562005F);

        monocleChain4 = new ScalableModelRenderer( this, 8, 32, 0.3F );
        monocleChain4.addBox( -0.16666666666F, -0.5F, -0.5F, 7, 1, 1);
        monocleChain4.setRotationPoint( 2.65391F, 16.74345F, -3.391807F );
        setRotateAngle(monocleChain4, 0.1892902F, -1.975307F, 0.2367755F);

        bodyTux = new ScalableModelRenderer( this, 32, 49, 1.05F );
        bodyTux.addBox( -3F, -2.02380952381F, -9.7619047619F, 6, 5, 10);
        bodyTux.setRotationPoint( 0F, 19F, 8F );
        setRotateAngle(bodyTux, -0.3490658F, 0F, 0F);

        frontLegRightTux = new ScalableModelRenderer( this, 50, 22, 1.05F );
        frontLegRightTux.addBox( -1F, -0.16666666666F, -1F, 2, 7, 2);
        frontLegRightTux.setRotationPoint( -3F, 17F, -0.9999999F );
        setRotateAngle(frontLegRightTux, -0.1919862F, 0F, 0F);

        bodyTuxTail1 = new ScalableModelRenderer( this, 28, 53, 1.0F );
        bodyTuxTail1.addBox( -1.5F, 0.5F, -0.5F, 3, 0, 5);
        bodyTuxTail1.setRotationPoint( 1.6F, 17.10369F, 9.222291F );
        setRotateAngle(bodyTuxTail1, -1.108972F, 0.4427959F, -0.4014674F);

        bodyTuxTail2 = new ScalableModelRenderer( this, 28, 48, 1.0F );
        bodyTuxTail2.addBox( -1.5F, 0.5F, -0.5F, 3, 0, 5);
        bodyTuxTail2.setRotationPoint( -1.6F, 17.10369F, 9.222291F );
        setRotateAngle(bodyTuxTail2, -1.108938F, -0.442661F, 0.4013657F);

        frontLegLeftTux = new ScalableModelRenderer( this, 50, 13, 1.05F );
        frontLegLeftTux.addBox( -1F, -0.16666666666F, -1F, 2, 7, 2);
        frontLegLeftTux.setRotationPoint( 3F, 17F, -0.9999999F );
        setRotateAngle(frontLegLeftTux, -0.1919862F, 0F, 0F);

        pipe4 = new ScalableModelRenderer( this, 22, 46, 0.33F );
        pipe4.addBox( -0.5F, -0.5F, -2F, 1, 1, 4);
        pipe4.setRotationPoint( -0.5F, 15.26F, -6.5F );
        setRotateAngle(pipe4, 0.3376844F, 0.382753F, 0.08644022F);

        pipe2 = new ScalableModelRenderer( this, 52, 44, 0.33F );
        pipe2.addBox( -0.5F, -0.5F, -1.5F, 1, 1, 3);
        pipe2.setRotationPoint( -0.863904F, 15.73034F, -7.373644F );
        setRotateAngle(pipe2, 0.5745154F, 0.4069837F, 0.09718834F);

        pipe3 = new ScalableModelRenderer( this, 52, 44, 0.33F );
        pipe3.addBox( -0.5F, -1F, -1.5F, 1, 2, 3);
        pipe3.setRotationPoint( -1.09568F, 16.31841F, -7.862072F );
        setRotateAngle(pipe3, 0.8184667F, 0.4414835F, 0.119488F);

        pipe = new ScalableModelRenderer( this, 41, 42, 0.33F );
        pipe.addBox( -1.5F, -2F, -1.5F, 3, 4, 3);
        pipe.setRotationPoint( -1.326135F, 16.51624F, -8.438918F );
        setRotateAngle(pipe, 0.2318274F, 0.3733464F, 0.08379398F);

        this.fez1 = new ModelRenderer(this, 11, 0);
        this.fez1.setRotationPoint(0.0F, -10.0F, -9.0F);
        this.fez1.addBox(-2.0F, -3.0F, -2.0F, 4, 4, 4, 0.0F);

        this.fez2 = new ModelRenderer(this, 23, 0);
        this.fez2.setRotationPoint(0.0F, -3.8F, 0.0F);
        this.fez2.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(fez2, -0.17453292519943295F, 0.7330382858376184F, 0.0F);

        this.fez3 = new ModelRenderer(this, 27, 0);
        this.fez3.setRotationPoint(0.0F, 0.0F, 3.0F);
        this.fez3.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 4, 0.0F);
        this.setRotateAngle(fez3, -1.2292353921796064F, 0.0F, 0.0F);

        this.fez1.addChild(this.fez2);
        this.fez2.addChild(this.fez3);

        this.mous1 = new ModelRenderer(this, 0, 0);
        this.mous1.setRotationPoint(0.0F, -5.5F, -17.0F);
        this.mous1.addBox(-1.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);

        this.mousL1 = new ModelRenderer(this, 0, 0);
        this.mousL1.setRotationPoint(1.0F, 0.0F, 0.0F);
        this.mousL1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(mousL1, 0.0F, 0.0F, 0.7740535232594852F);

        this.mousR1 = new ModelRenderer(this, 0, 0);
        this.mousR1.setRotationPoint(-1.0F, 0.0F, 0.0F);
        this.mousR1.addBox(-1.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(mousR1, 0.0F, 0.0F, -0.7740535232594852F);

        this.mousL2 = new ModelRenderer(this, 0, 0);
        this.mousL2.setRotationPoint(1.0F, 0.0F, 0.0F);
        this.mousL2.addBox(-0.7F, -0.3F, 0.0F, 2, 1, 1, 0.0F);
        this.setRotateAngle(mousL2, 0.0F, 0.0F, -0.7740535232594852F);

        this.mousR2 = new ModelRenderer(this, 0, 0);
        this.mousR2.setRotationPoint(-1.0F, 0.0F, 0.0F);
        this.mousR2.addBox(-1.3F, -0.3F, 0.0F, 2, 1, 1, 0.0F);
        this.setRotateAngle(mousR2, 0.0F, 0.0F, 0.7740535232594852F);

        this.mousL3 = new ModelRenderer(this, 0, 0);
        this.mousL3.setRotationPoint(1.0F, -0.3F, 0.0F);
        this.mousL3.addBox(-0.5F, -0.1F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(mousL3, 0.0F, 0.0F, -0.8196066167365371F);

        this.mousR3 = new ModelRenderer(this, 0, 0);
        this.mousR3.setRotationPoint(-1.0F, -0.3F, 0.0F);
        this.mousR3.addBox(-0.5F, -0.1F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(mousR3, 0.0F, 0.0F, 0.8196066167365371F);

        this.mous1.addChild(this.mousR1);
        this.mous1.addChild(this.mousL1);
        this.mousL1.addChild(this.mousL2);
        this.mousR1.addChild(this.mousR2);
        this.mousL2.addChild(this.mousL3);
        this.mousR2.addChild(this.mousR3);

    }

    @Override
    public void setRotationAngles(T t, float v, float v1, float v2, float v3, float v4)
    {
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) //this method is never called, normally.
    {
        renderHeadParts(true, true, true, false, matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        renderHeadParts(true, true, true, true, matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
    }

    public void renderHeadParts(boolean renderHat, boolean renderMonocle, boolean renderPipe, boolean color, MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha)
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

    public void renderBody(RabbitEntity rabbit, boolean color, float ageInTicks, MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha)
    {
        if(!color)
        {
            float f = ageInTicks - (float)rabbit.ticksExisted;
            float jumpRotation = MathHelper.sin(rabbit.getJumpCompletion(f) * (float)Math.PI);

            frontLegRightTux.rotateAngleX = (jumpRotation * -40.0F - 11.0F) * 0.017453292F;
            frontLegLeftTux.rotateAngleX = (jumpRotation * -40.0F - 11.0F) * 0.017453292F;
            bodyTuxTail1.rotateAngleX = (-1.108972F + jumpRotation * 0.8F);
            bodyTuxTail2.rotateAngleX = (-1.108972F + jumpRotation * 0.8F);

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

    public void renderLlama(boolean color, boolean renderHat, boolean renderMonocle, boolean renderPipe, boolean renderBowtie, boolean renderFez, boolean renderMous, MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha)
    {
        float scale = 1.35F;

        if(!color)
        {
            if(renderHat)
            {
                matrixStackIn.push();
                matrixStackIn.translate(0F, -1.55F, -0.25F );
                matrixStackIn.scale(scale, scale, scale);
                hatTop.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                hatRim.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                matrixStackIn.pop();
            }
            if(renderMonocle)
            {
                matrixStackIn.push();
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
                setRotateAngle(monocleChain4, 0.1892902F, -2.375307F, 0.2367755F);
                monocleChain4.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                matrixStackIn.pop();
            }
            if(renderPipe)
            {
                matrixStackIn.push();
                matrixStackIn.translate(0F, -1.50F, -0.5F);
                matrixStackIn.scale(scale, scale, scale);
                pipe4.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                pipe2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                pipe3.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                pipe.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                matrixStackIn.pop();
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
                matrixStackIn.push();
                matrixStackIn.translate(0F, -1.55F, -0.25F);
                matrixStackIn.scale(scale, scale, scale);
                hatTop.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                matrixStackIn.pop();
            }
            if(renderBowtie)
            {
                matrixStackIn.push();
                matrixStackIn.translate(0F, -1.5F, -0.525F);
                matrixStackIn.scale(scale, scale, scale);
                bowtie5.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                bowtie3.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                bowtie4.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                bowtie1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                bowtie2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                matrixStackIn.pop();
            }
        }
    }

    public void setRotateAngle(ModelRenderer RendererModel, float x, float y, float z)
    {
        RendererModel.rotateAngleX = x;
        RendererModel.rotateAngleY = y;
        RendererModel.rotateAngleZ = z;
    }

    public class ScalableModelRenderer extends ModelRenderer
    {
        private float scaleX;
        private float scaleY;
        private float scaleZ;

        public ScalableModelRenderer(Model model, int texOffX, int texOffY, float scale)
        {
            this(model, texOffX, texOffY, scale, scale, scale);
        }

        public ScalableModelRenderer(Model model, int texOffX, int texOffY, float scaleX, float scaleY, float scaleZ)
        {
            super(model, texOffX, texOffY);
            this.scaleX = scaleX;
            this.scaleY = scaleY;
            this.scaleZ = scaleZ;
        }

        @Override
        public void translateRotate(MatrixStack matrixStackIn) {
            matrixStackIn.translate((double)(this.rotationPointX / 16.0F), (double)(this.rotationPointY / 16.0F), (double)(this.rotationPointZ / 16.0F));
            matrixStackIn.scale(scaleX, scaleY, scaleZ);
            if (this.rotateAngleY != 0.0F) {
                matrixStackIn.rotate(Vector3f.YP.rotation(this.rotateAngleY));
            }

            if (this.rotateAngleX != 0.0F) {
                matrixStackIn.rotate(Vector3f.XP.rotation(this.rotateAngleX));
            }

            if (this.rotateAngleZ != 0.0F) {
                matrixStackIn.rotate(Vector3f.ZP.rotation(this.rotateAngleZ));
            }
        }
    }
}