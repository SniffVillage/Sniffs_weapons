package nl.sniffiandros.sniffsweapons.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.DyeableArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;


@OnlyIn(Dist.CLIENT)
public class HornedArmorModel<T extends LivingEntity> extends HumanoidModel<T> {
    private final ItemStack stack;
    public final ModelPart feathers;
    public final ModelPart feather_holder;
    private final ModelPart skirt;
    private final EquipmentSlot slot;

    public HornedArmorModel(ModelPart root, ItemStack stack, EquipmentSlot slot, LivingEntity entity) {
        super(root);
        this.stack = stack;
        this.feather_holder = root.getChild("feather_holder");
        this.feathers = feather_holder.getChild("feathers");
        this.skirt = root.getChild("skirt");
        this.slot = slot;
        this.setVisible(slot);
        this.animate((T) entity);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F);
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition feather_holder = partdefinition.addOrReplaceChild("feather_holder", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition feathers = feather_holder.addOrReplaceChild("feathers", CubeListBuilder.create(), PartPose.offset(0.0F, -11.0F, 0.0F));

        PartDefinition Feathers_Left_r1 = feathers.addOrReplaceChild("Feathers_Left_r1", CubeListBuilder.create().texOffs(0, 41).addBox(0.0F, -7.5F, -1.0F, 0.0F, 11.0F, 12.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(0.0F, -1.0F, -1.0F, 0.0F, 0.3491F, 0.0F));

        PartDefinition Feathers_Right_r1 = feathers.addOrReplaceChild("Feathers_Right_r1", CubeListBuilder.create().texOffs(0, 41).addBox(0.0F, -7.5F, -1.0F, 0.0F, 11.0F, 12.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(0.0F, -1.0F, -1.0F, 0.0F, -0.3491F, 0.0F));

        PartDefinition skirt = partdefinition.addOrReplaceChild("skirt", CubeListBuilder.create().texOffs(32, 50).addBox(-5.0F, 10.0F, -3.0F, 10.0F, 8.0F, 6.0F, new CubeDeformation(0.75F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition hat = head.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(1.0F))
                .texOffs(48, 6).addBox(4.0F, -12.0F, 0.0F, 8.0F, 9.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(48, 6).mirror().addBox(-12.0F, -12.0F, 0.0F, 8.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(32, 6).addBox(-2.0F, -11.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.3F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition visor = hat.addOrReplaceChild("visor", CubeListBuilder.create().texOffs(32, 0).addBox(-4.5F, -2.0F, -1.0F, 9.0F, 4.0F, 2.0F, new CubeDeformation(0.6F)), PartPose.offsetAndRotation(0.0F, -4.0F, -5.0F, -0.1309F, 0.0F, 0.0F));

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(1.01F))
                .texOffs(0, 32).addBox(-5.0F, 7.0F, -3.0F, 10.0F, 9.0F, 6.0F, new CubeDeformation(1.01F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(1.0F)), PartPose.offset(-5.0F, 2.0F, 0.0F));

        PartDefinition cap = right_arm.addOrReplaceChild("cap", CubeListBuilder.create().texOffs(32, 32).addBox(-6.0F, -2.0F, -3.5F, 6.0F, 2.0F, 7.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(1.0F, -2.0F, 0.0F, 0.0F, 0.0F, -0.2182F));

        PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(1.0F)).mirror(false), PartPose.offset(5.0F, 2.0F, 0.0F));

        PartDefinition cap2 = left_arm.addOrReplaceChild("cap2", CubeListBuilder.create().texOffs(32, 32).addBox(0.0F, -2.0F, -3.5F, 6.0F, 2.0F, 7.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-1.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.2182F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    public void animate(T entity) {
        float weatherf = entity.level().isRaining() ? 40.0F : 5.0F;
        float f = entity.tickCount * weatherf * ((float)Math.PI / 180F);
        this.feathers.xRot = (Mth.cos(f) / 8) * (float)Math.PI * 0.15F;
        this.feathers.yRot = (Mth.cos(f) / 4) * (float)Math.PI * 0.15F;
    }

    public void renderToBuffer(PoseStack poseStack, @NotNull VertexConsumer vertices, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        int decimal = ((DyeableArmorItem) this.stack.getItem()).getColor(stack);
        float r = (float) (decimal >> 16 & 0xFF) / 255.0f;
        float g = (float) (decimal >> 8 & 0xFF) / 255.0f;
        float b = (float) (decimal & 0xFF) / 255.0f;

        poseStack.pushPose();
        if (this.young) {
            if (this.slot == EquipmentSlot.HEAD) {
                poseStack.scale(0.75f, 0.75f, 0.75f);
                poseStack.translate(0, 1.0f, 0);
            } else {
                poseStack.scale(0.5f, 0.5f, 0.5f);
                poseStack.translate(0, 1.5f, 0);
            }
        }
        this.skirt.copyFrom(this.body);
        this.feather_holder.copyFrom(this.head);

        this.feather_holder.render(poseStack, vertices, packedLight, packedOverlay, r, g, b, 1.0f);
        this.skirt.render(poseStack, vertices, packedLight, packedOverlay, r, g, b, 1.0f);
        this.body.render(poseStack, vertices, packedLight, packedOverlay, red, green, blue, 1.0f);
        this.leftArm.render(poseStack, vertices, packedLight, packedOverlay, red, green, blue, 1.0f);
        this.rightArm.render(poseStack, vertices, packedLight, packedOverlay, red, green, blue, 1.0f);
        this.head.render(poseStack, vertices, packedLight, packedOverlay, red, green, blue, 1.0f);
        poseStack.popPose();
    }


    public void setVisible(EquipmentSlot slot) {
        this.setAllVisible(false);
        switch (slot) {
            case HEAD -> {
                this.skirt.visible = false;
                this.feather_holder.visible = true;
                this.head.visible = true;
            }
            case CHEST -> {
                this.feather_holder.visible = false;
                this.skirt.visible = true;
                this.body.visible = true;
            }

            default -> {}
        }
    }
}
