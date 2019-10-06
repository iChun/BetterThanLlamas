package me.ichun.mods.betterthanllamas.client.model;

import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.entity.passive.horse.LlamaEntity;
import net.minecraft.util.math.MathHelper;

public class LlamaFancyModel<T extends LlamaEntity>  extends EntityModel<T>
{
    //hat
    public RendererModel hatRim;
    public RendererModel hatTop;

    //bowtie
    public RendererModel bowtie5;
    public RendererModel bowtie3;
    public RendererModel bowtie4;
    public RendererModel bowtie1;
    public RendererModel bowtie2;

    //monocle
    public RendererModel monocle;
    public RendererModel monocle2;
    public RendererModel monocle3;
    public RendererModel monocle4;
    public RendererModel monocle5;
    public RendererModel monocle6;
    public RendererModel monocle7;
    public RendererModel monocle8;
    public RendererModel monocle1;
    public RendererModel monocleChain1;
    public RendererModel monocleChain2;
    public RendererModel monocleChain3;
    public RendererModel monocleChain4;

    //suit
    public RendererModel bodyTux;
    public RendererModel frontLegRightTux;
    public RendererModel bodyTuxTail1;
    public RendererModel bodyTuxTail2;
    public RendererModel frontLegLeftTux;

    //pipe
    public RendererModel pipe4;
    public RendererModel pipe2;
    public RendererModel pipe3;
    public RendererModel pipe;

    //fez
    public RendererModel fez1;
    public RendererModel fez2;
    public RendererModel fez3;

    //mous
    public RendererModel mous1;
    public RendererModel mousL1;
    public RendererModel mousR1;
    public RendererModel mousL2;
    public RendererModel mousL3;
    public RendererModel mousR2;
    public RendererModel mousR3;


    public LlamaFancyModel()
    {
        textureHeight = textureWidth = 64;

        hatRim = new RendererModelScalable( this, 1, 34, 0.7F, 1.05F, 0.7F );
        hatRim.addBox( -4.5F, -0.5F, -4.5F, 9, 1, 9);
        hatRim.setRotationPoint( 0F, 11.5F, -3.68F );

        hatTop = new RendererModelScalable( this, 1, 47, 0.6F );
        hatTop.addBox( -3.5F, -4.5F, -3.5F, 7, 9, 7);
        hatTop.setRotationPoint( 0F, 8.5F, -3.68F );

        bowtie5 = new RendererModelScalable( this, 36, 36, 0.75F );
        bowtie5.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 1);
        bowtie5.setRotationPoint( 0F, 17F, -3F );

        bowtie3 = new RendererModelScalable( this, 36, 36, 0.75F );
        bowtie3.addBox( -0.5F, -1F, -0.5F, 1, 2, 1);
        bowtie3.setRotationPoint( 0.75F, 17F, -3F );

        bowtie4 = new RendererModelScalable( this, 36, 36, 0.75F );
        bowtie4.addBox( -0.5F, -1.5F, -0.5F, 1, 3, 1);
        bowtie4.setRotationPoint( 1.5F, 17F, -3F );

        bowtie1 = new RendererModelScalable( this, 36, 36, 0.75F );
        bowtie1.addBox( -0.5F, -1F, -0.5F, 1, 2, 1);
        bowtie1.setRotationPoint( -0.75F, 17F, -3F );

        bowtie2 = new RendererModelScalable( this, 36, 36, 0.75F );
        bowtie2.addBox( -0.5F, -1.5F, -0.5F, 1, 3, 1);
        bowtie2.setRotationPoint( -1.5F, 17F, -3F );

        monocle = new RendererModelScalable( this, 0, 35, 0.3F );
        monocle.addBox( -1.5F, -0.5F, -0.5F, 3, 1, 1);
        monocle.setRotationPoint( 1F, 12F, -6.4F );

        monocle2 = new RendererModelScalable( this, 0, 35, 0.3F );
        monocle2.addBox( -1.5F, -0.5F, -0.5F, 3, 1, 1);
        monocle2.setRotationPoint( 1F, 14.1F, -6.4F );

        monocle3 = new RendererModelScalable( this, 0, 35, 0.3F );
        monocle3.addBox( -0.5F, -2F, -0.5F, 1, 4, 1);
        monocle3.setRotationPoint( 0.1F, 13.05F, -6.4F );

        monocle4 = new RendererModelScalable( this, 0, 35, 0.3F );
        monocle4.addBox( -0.5F, -2F, -0.5F, 1, 4, 1);
        monocle4.setRotationPoint( 1.9F, 13.05F, -6.4F );

        monocle5 = new RendererModelScalable( this, 0, 35, 0.3F );
        monocle5.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 1);
        monocle5.setRotationPoint( 0.4F, 12.3F, -6.4F );

        monocle6 = new RendererModelScalable( this, 0, 35, 0.3F );
        monocle6.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 1);
        monocle6.setRotationPoint( 0.4F, 13.8F, -6.4F );

        monocle7 = new RendererModelScalable( this, 0, 35, 0.3F );
        monocle7.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 1);
        monocle7.setRotationPoint( 1.6F, 12.3F, -6.4F );

        monocle8 = new RendererModelScalable( this, 0, 35, 0.3F );
        monocle8.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 1);
        monocle8.setRotationPoint( 1.6F, 13.8F, -6.4F );

        monocle1 = new RendererModelScalable( this, 44, 34, 0.3F );
        monocle1.addBox( -3.5F, -4F, 0F, 7, 8, 0);
        monocle1.setRotationPoint( 1F, 13.05F, -6.4F );

        monocleChain1 = new RendererModelScalable( this, 0, 35, 0.3F );
        monocleChain1.addBox( -2F, -0.5F, -0.5F, 4, 1, 1);
        monocleChain1.setRotationPoint( 2.25F, 13.6F, -6.3F );
        setRotateAngle(monocleChain1, 0.06167236F, -0.05083169F, 0.8807254F);

        monocleChain2 = new RendererModelScalable( this, 8, 32, 0.3F );
        monocleChain2.addBox( -0.16666666666F, -0.5F, -0.5F, 7, 1, 1);
        monocleChain2.setRotationPoint( 2.6F, 14F, -6.3F );
        setRotateAngle(monocleChain2, -0.02879648F, -1.540258F, 0.755817F);

        monocleChain3 = new RendererModelScalable( this, 8, 32, 0.3F );
        monocleChain3.addBox( -0.16666666666F, -0.5F, -0.5F, 7, 1, 1);
        monocleChain3.setRotationPoint( 2.683918F, 15.3712F, -4.846462F );
        setRotateAngle(monocleChain3, 0.01029625F, -1.581712F, 0.7562005F);

        monocleChain4 = new RendererModelScalable( this, 8, 32, 0.3F );
        monocleChain4.addBox( -0.16666666666F, -0.5F, -0.5F, 7, 1, 1);
        monocleChain4.setRotationPoint( 2.65391F, 16.74345F, -3.391807F );
        setRotateAngle(monocleChain4, 0.1892902F, -1.975307F, 0.2367755F);

        bodyTux = new RendererModelScalable( this, 32, 49, 1.05F );
        bodyTux.addBox( -3F, -2.02380952381F, -9.7619047619F, 6, 5, 10);
        bodyTux.setRotationPoint( 0F, 19F, 8F );
        setRotateAngle(bodyTux, -0.3490658F, 0F, 0F);

        frontLegRightTux = new RendererModelScalable( this, 50, 22, 1.05F );
        frontLegRightTux.addBox( -1F, -0.16666666666F, -1F, 2, 7, 2);
        frontLegRightTux.setRotationPoint( -3F, 17F, -0.9999999F );
        setRotateAngle(frontLegRightTux, -0.1919862F, 0F, 0F);

        bodyTuxTail1 = new RendererModelScalable( this, 28, 53, 1.0F );
        bodyTuxTail1.addBox( -1.5F, 0.5F, -0.5F, 3, 0, 5);
        bodyTuxTail1.setRotationPoint( 1.6F, 17.10369F, 9.222291F );
        setRotateAngle(bodyTuxTail1, -1.108972F, 0.4427959F, -0.4014674F);

        bodyTuxTail2 = new RendererModelScalable( this, 28, 48, 1.0F );
        bodyTuxTail2.addBox( -1.5F, 0.5F, -0.5F, 3, 0, 5);
        bodyTuxTail2.setRotationPoint( -1.6F, 17.10369F, 9.222291F );
        setRotateAngle(bodyTuxTail2, -1.108938F, -0.442661F, 0.4013657F);

        frontLegLeftTux = new RendererModelScalable( this, 50, 13, 1.05F );
        frontLegLeftTux.addBox( -1F, -0.16666666666F, -1F, 2, 7, 2);
        frontLegLeftTux.setRotationPoint( 3F, 17F, -0.9999999F );
        setRotateAngle(frontLegLeftTux, -0.1919862F, 0F, 0F);

        pipe4 = new RendererModelScalable( this, 22, 46, 0.33F );
        pipe4.addBox( -0.5F, -0.5F, -2F, 1, 1, 4);
        pipe4.setRotationPoint( -0.5F, 15.26F, -6.5F );
        setRotateAngle(pipe4, 0.3376844F, 0.382753F, 0.08644022F);

        pipe2 = new RendererModelScalable( this, 52, 44, 0.33F );
        pipe2.addBox( -0.5F, -0.5F, -1.5F, 1, 1, 3);
        pipe2.setRotationPoint( -0.863904F, 15.73034F, -7.373644F );
        setRotateAngle(pipe2, 0.5745154F, 0.4069837F, 0.09718834F);

        pipe3 = new RendererModelScalable( this, 52, 44, 0.33F );
        pipe3.addBox( -0.5F, -1F, -1.5F, 1, 2, 3);
        pipe3.setRotationPoint( -1.09568F, 16.31841F, -7.862072F );
        setRotateAngle(pipe3, 0.8184667F, 0.4414835F, 0.119488F);

        pipe = new RendererModelScalable( this, 41, 42, 0.33F );
        pipe.addBox( -1.5F, -2F, -1.5F, 3, 4, 3);
        pipe.setRotationPoint( -1.326135F, 16.51624F, -8.438918F );
        setRotateAngle(pipe, 0.2318274F, 0.3733464F, 0.08379398F);

        this.fez1 = new RendererModel(this, 11, 0);
        this.fez1.setRotationPoint(0.0F, -10.0F, -9.0F);
        this.fez1.addBox(-2.0F, -3.0F, -2.0F, 4, 4, 4, 0.0F);

        this.fez2 = new RendererModel(this, 23, 0);
        this.fez2.setRotationPoint(0.0F, -3.8F, 0.0F);
        this.fez2.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(fez2, -0.17453292519943295F, 0.7330382858376184F, 0.0F);

        this.fez3 = new RendererModel(this, 27, 0);
        this.fez3.setRotationPoint(0.0F, 0.0F, 3.0F);
        this.fez3.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 4, 0.0F);
        this.setRotateAngle(fez3, -1.2292353921796064F, 0.0F, 0.0F);

        this.fez1.addChild(this.fez2);
        this.fez2.addChild(this.fez3);

        this.mous1 = new RendererModel(this, 0, 0);
        this.mous1.setRotationPoint(0.0F, -5.5F, -17.0F);
        this.mous1.addBox(-1.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);

        this.mousL1 = new RendererModel(this, 0, 0);
        this.mousL1.setRotationPoint(1.0F, 0.0F, 0.0F);
        this.mousL1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(mousL1, 0.0F, 0.0F, 0.7740535232594852F);

        this.mousR1 = new RendererModel(this, 0, 0);
        this.mousR1.setRotationPoint(-1.0F, 0.0F, 0.0F);
        this.mousR1.addBox(-1.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(mousR1, 0.0F, 0.0F, -0.7740535232594852F);

        this.mousL2 = new RendererModel(this, 0, 0);
        this.mousL2.setRotationPoint(1.0F, 0.0F, 0.0F);
        this.mousL2.addBox(-0.7F, -0.3F, 0.0F, 2, 1, 1, 0.0F);
        this.setRotateAngle(mousL2, 0.0F, 0.0F, -0.7740535232594852F);

        this.mousR2 = new RendererModel(this, 0, 0);
        this.mousR2.setRotationPoint(-1.0F, 0.0F, 0.0F);
        this.mousR2.addBox(-1.3F, -0.3F, 0.0F, 2, 1, 1, 0.0F);
        this.setRotateAngle(mousR2, 0.0F, 0.0F, 0.7740535232594852F);

        this.mousL3 = new RendererModel(this, 0, 0);
        this.mousL3.setRotationPoint(1.0F, -0.3F, 0.0F);
        this.mousL3.addBox(-0.5F, -0.1F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(mousL3, 0.0F, 0.0F, -0.8196066167365371F);

        this.mousR3 = new RendererModel(this, 0, 0);
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
    public void render(LlamaEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) //this method is never called, normally.
    {
        renderHeadParts(true, true, true, false, scale);
        renderHeadParts(true, true, true, true, scale);
    }

    public void renderHeadParts(boolean renderHat, boolean renderMonocle, boolean renderPipe, boolean color, float f5)
    {
        if(!color)
        {
            if(renderHat)
            {
                hatTop.renderWithRotation(f5);
                hatRim.renderWithRotation(f5);
            }
            if(renderMonocle)
            {
                monocle.renderWithRotation(f5);
                monocle2.renderWithRotation(f5);
                monocle3.renderWithRotation(f5);
                monocle4.renderWithRotation(f5);
                monocle5.renderWithRotation(f5);
                monocle6.renderWithRotation(f5);
                monocle7.renderWithRotation(f5);
                monocle8.renderWithRotation(f5);
                monocle1.renderWithRotation(f5);

                monocleChain1.renderWithRotation(f5);
                monocleChain2.renderWithRotation(f5);
                monocleChain3.renderWithRotation(f5);
                monocleChain4.renderWithRotation(f5);
            }
            if(renderPipe)
            {
                pipe4.renderWithRotation(f5);
                pipe2.renderWithRotation(f5);
                pipe3.renderWithRotation(f5);
                pipe.renderWithRotation(f5);
            }
        }
        else if(renderHat)
        {
            hatTop.renderWithRotation(f5);
        }
    }

    public void renderBody(RabbitEntity rabbit, boolean color, float ageInTicks, float f5)
    {
        if(!color)
        {
            float f = ageInTicks - (float)rabbit.ticksExisted;
            float jumpRotation = MathHelper.sin(rabbit.getJumpCompletion(f) * (float)Math.PI);

            frontLegRightTux.rotateAngleX = (jumpRotation * -40.0F - 11.0F) * 0.017453292F;
            frontLegLeftTux.rotateAngleX = (jumpRotation * -40.0F - 11.0F) * 0.017453292F;
            bodyTuxTail1.rotateAngleX = (-1.108972F + jumpRotation * 0.8F);
            bodyTuxTail2.rotateAngleX = (-1.108972F + jumpRotation * 0.8F);

            frontLegRightTux.renderWithRotation(f5);
            frontLegLeftTux.renderWithRotation(f5);
            bodyTuxTail1.renderWithRotation(f5);
            bodyTuxTail2.renderWithRotation(f5);
            bodyTux.renderWithRotation(f5);
        }
        else
        {
            bowtie5.renderWithRotation(f5);
            bowtie3.renderWithRotation(f5);
            bowtie4.renderWithRotation(f5);
            bowtie1.renderWithRotation(f5);
            bowtie2.renderWithRotation(f5);

            bodyTux.renderWithRotation(f5);
        }
    }

    public void renderLlama(boolean color, boolean renderHat, boolean renderMonocle, boolean renderPipe, boolean renderBowtie, boolean renderFez, boolean renderMous, float f5)
    {
        float scale = 1.35F;

        if(!color)
        {
            if(renderHat)
            {
                GlStateManager.pushMatrix();
                GlStateManager.translatef(0F, -1.55F, -0.25F );
                GlStateManager.scalef(scale, scale, scale);
                hatTop.renderWithRotation(f5);
                hatRim.renderWithRotation(f5);
                GlStateManager.popMatrix();
            }
            if(renderMonocle)
            {
                GlStateManager.pushMatrix();
                GlStateManager.translatef(0.041F, -1.55F, -0.22F);
                GlStateManager.scalef(scale, scale, scale);
                monocle.renderWithRotation(f5);
                monocle2.renderWithRotation(f5);
                monocle3.renderWithRotation(f5);
                monocle4.renderWithRotation(f5);
                monocle5.renderWithRotation(f5);
                monocle6.renderWithRotation(f5);
                monocle7.renderWithRotation(f5);
                monocle8.renderWithRotation(f5);
                monocle1.renderWithRotation(f5);

                monocleChain1.renderWithRotation(f5);
                monocleChain2.renderWithRotation(f5);
                monocleChain3.renderWithRotation(f5);
                setRotateAngle(monocleChain4, 0.1892902F, -2.375307F, 0.2367755F);
                monocleChain4.renderWithRotation(f5);
                GlStateManager.popMatrix();
            }
            if(renderPipe)
            {
                GlStateManager.pushMatrix();
                GlStateManager.translatef(0F, -1.50F, -0.5F );
                GlStateManager.scalef(scale, scale, scale);
                pipe4.renderWithRotation(f5);
                pipe2.renderWithRotation(f5);
                pipe3.renderWithRotation(f5);
                pipe.renderWithRotation(f5);
                GlStateManager.popMatrix();
            }
            if(renderFez)
            {
                fez1.render(f5);
            }
            if(renderMous)
            {
                mous1.render(f5);
            }
        }
        else
        {
            if(renderHat)
            {
                GlStateManager.pushMatrix();
                GlStateManager.translatef(0F, -1.55F, -0.25F);
                GlStateManager.scalef(scale, scale, scale);
                hatTop.renderWithRotation(f5);
                GlStateManager.popMatrix();
            }
            if(renderBowtie)
            {
                GlStateManager.pushMatrix();
                GlStateManager.translatef(0F, -1.5F, -0.525F );
                GlStateManager.scalef(scale, scale, scale);
                bowtie5.renderWithRotation(f5);
                bowtie3.renderWithRotation(f5);
                bowtie4.renderWithRotation(f5);
                bowtie1.renderWithRotation(f5);
                bowtie2.renderWithRotation(f5);
                GlStateManager.popMatrix();
            }
        }
    }

    public void setRotateAngle(RendererModel RendererModel, float x, float y, float z)
    {
        RendererModel.rotateAngleX = x;
        RendererModel.rotateAngleY = y;
        RendererModel.rotateAngleZ = z;
    }

    public class RendererModelScalable extends RendererModel
    {
        private float scaleX;
        private float scaleY;
        private float scaleZ;

        public RendererModelScalable(Model model, int texOffX, int texOffY, float scale)
        {
            this(model, texOffX, texOffY, scale, scale, scale);
        }

        public RendererModelScalable(Model model, int texOffX, int texOffY, float scaleX, float scaleY, float scaleZ)
        {
            super(model, texOffX, texOffY);
            this.scaleX = scaleX;
            this.scaleY = scaleY;
            this.scaleZ = scaleZ;
        }

        @Override
        public void renderWithRotation(float scale)
        {
            if (!this.isHidden)
            {
                if (this.showModel)
                {
                    if (!this.compiled)
                    {
                        this.compileDisplayList(scale);
                    }

                    GlStateManager.pushMatrix();
                    GlStateManager.translatef(this.rotationPointX * scale, this.rotationPointY * scale, this.rotationPointZ * scale);

                    GlStateManager.scalef(scaleX, scaleY, scaleZ);

                    if (this.rotateAngleY != 0.0F)
                    {
                        GlStateManager.rotatef(this.rotateAngleY * (180F / (float)Math.PI), 0.0F, 1.0F, 0.0F);
                    }

                    if (this.rotateAngleX != 0.0F)
                    {
                        GlStateManager.rotatef(this.rotateAngleX * (180F / (float)Math.PI), 1.0F, 0.0F, 0.0F);
                    }

                    if (this.rotateAngleZ != 0.0F)
                    {
                        GlStateManager.rotatef(this.rotateAngleZ * (180F / (float)Math.PI), 0.0F, 0.0F, 1.0F);
                    }

                    GlStateManager.callList(this.displayList);
                    GlStateManager.popMatrix();
                }
            }
        }
    }
}