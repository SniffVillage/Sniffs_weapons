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
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;


@OnlyIn(Dist.CLIENT)
public class ClothedCuirassModel<T extends LivingEntity> extends HumanoidModel<T> {
    private final ItemStack stack;
    private final EquipmentSlot slot;

    public ClothedCuirassModel(ModelPart root, ItemStack stack, EquipmentSlot slot, LivingEntity entity) {
        super(root);
        this.stack = stack;
        this.slot = slot;
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F);
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 54).addBox(-1.9F, 0.0F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.5F)), PartPose.offset(1.9F, 12.0F, 0.0F));

        PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 54).addBox(-3.1F, 0.0F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.5F)), PartPose.offset(-1.9F, 12.0F, 0.0F));

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition hat = head.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(1.01F))
                .texOffs(40, 51).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 9.0F, 4.0F, new CubeDeformation(1.3F))
                .texOffs(13, 32).addBox(-5.0F, 10.0F, -3.0F, 10.0F, 5.0F, 6.0F, new CubeDeformation(1.01F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition neck = body.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 5).addBox(-4.5F, -0.3F, -4.5F, 9.0F, 2.0F, 9.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(0.0F, -0.7F, 0.0F, 0.1309F, 0.0F, 0.0F));

        PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.8F))
                .texOffs(0, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(1.2F))
                .texOffs(44, 38).addBox(-3.9F, -3.0F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.8F)), PartPose.offset(-5.0F, 2.0F, 0.0F));

        PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.8F)).mirror(false)
                .texOffs(0, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(1.2F)).mirror(false)
                .texOffs(44, 38).mirror().addBox(-1.1F, -3.0F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.8F)).mirror(false), PartPose.offset(5.0F, 2.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    public void renderToBuffer(PoseStack poseStack, @NotNull VertexConsumer vertices, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {

        poseStack.pushPose();
        if (this.young) {
            poseStack.scale(0.5f, 0.5f, 0.5f);
            poseStack.translate(0, 1.5f, 0);
        }

        this.rightLeg.visible = true;
        this.leftLeg.visible = true;

        this.head.render(poseStack, vertices, packedLight, packedOverlay, red, green, blue, alpha);
        this.body.render(poseStack, vertices, packedLight, packedOverlay, red, green, blue, alpha);
        this.rightArm.render(poseStack, vertices, packedLight, packedOverlay, red, green, blue, alpha);
        this.leftArm.render(poseStack, vertices, packedLight, packedOverlay, red, green, blue, alpha);
        this.rightLeg.render(poseStack, vertices, packedLight, packedOverlay, red, green, blue, alpha);
        this.leftLeg.render(poseStack, vertices, packedLight, packedOverlay, red, green, blue, alpha);
        poseStack.popPose();
    }
}
