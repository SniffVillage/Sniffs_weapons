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
public class TellerbarretModel<T extends LivingEntity> extends HumanoidModel<T> {
    private final ItemStack stack;
    private final ModelPart feather_holder;
    private final ModelPart feathers;
    private final ModelPart hat;
    private final ModelPart cap;
    private final EquipmentSlot slot;

    public TellerbarretModel(ModelPart root, ItemStack stack, EquipmentSlot slot, LivingEntity entity) {
        super(root);
        this.stack = stack;
        this.feather_holder = root.getChild("feather_holder");
        this.feathers = this.feather_holder.getChild("feathers");
        this.hat = this.head.getChild("hat");
        this.cap = this.hat.getChild("cap");
        this.slot = slot;
        this.animate((T) entity);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F);
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition feather_holder = partdefinition.addOrReplaceChild("feather_holder", CubeListBuilder.create(), PartPose.offset(-1.0F, 1.0F, 2.0F));

        PartDefinition feathers = feather_holder.addOrReplaceChild("feathers", CubeListBuilder.create().texOffs(0, 23).addBox(0.0F, -12.5F, -3.0F, 0.0F, 15.0F, 15.0F, new CubeDeformation(0.001F)), PartPose.offset(0.0F, -12.0F, 0.0F));

        PartDefinition Feathers_Left_r1 = feathers.addOrReplaceChild("Feathers_Left_r1", CubeListBuilder.create().texOffs(0, 41).addBox(0.0F, -7.5F, -1.0F, 0.0F, 11.0F, 12.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(1.0F, -1.0F, 0.0F, 0.0F, 0.3491F, 0.0F));

        PartDefinition Feathers_Right_r1 = feathers.addOrReplaceChild("Feathers_Right_r1", CubeListBuilder.create().texOffs(0, 41).addBox(0.0F, -7.5F, -1.0F, 0.0F, 11.0F, 12.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(-1.0F, -1.0F, 0.0F, 0.0F, -0.3491F, 0.0F));

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition hat = head.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(0, 20).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cap = hat.addOrReplaceChild("cap", CubeListBuilder.create().texOffs(0, 0).addBox(-8.3F, -2.0F, -8.0F, 16.0F, 3.0F, 16.0F, new CubeDeformation(0.5F))
                .texOffs(24, 52).addBox(-5.3F, -4.5F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, -0.3054F, 0.0F, -0.1745F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    public void animate(T entity) {
        float weatherf = entity.level().isRaining() ? 40.0F : 5.0F;
        float f = entity.tickCount * weatherf * ((float)Math.PI / 180F);
        this.feathers.xRot = (Mth.cos(f) / 8) * (float)Math.PI * 0.15F;
        this.feathers.yRot = (Mth.cos(f) / 4) * (float)Math.PI * 0.15F;
    }

    public void renderToBuffer(PoseStack poseStack, @NotNull VertexConsumer vertices, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {

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
        this.feather_holder.copyFrom(this.head);

        this.feather_holder.render(poseStack, vertices, packedLight, packedOverlay, red, green, blue, 1.0f);
        this.head.render(poseStack, vertices, packedLight, packedOverlay, red, green, blue, 1.0f);
        poseStack.popPose();
    }
}
