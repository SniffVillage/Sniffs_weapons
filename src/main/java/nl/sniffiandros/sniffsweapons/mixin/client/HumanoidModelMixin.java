package nl.sniffiandros.sniffsweapons.mixin.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.AgeableListModel;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.HeadedModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import nl.sniffiandros.sniffsweapons.Config;
import nl.sniffiandros.sniffsweapons.item.ISpecialItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HumanoidModel.class)
public abstract class HumanoidModelMixin <T extends LivingEntity> extends AgeableListModel<T> implements ArmedModel, HeadedModel {

    @Inject(at = @At("TAIL"), method = "setupAnim(Lnet/minecraft/world/entity/LivingEntity;FFFFF)V")
    private void animate(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, CallbackInfo ci) {
        float delta = Minecraft.getInstance().getDeltaFrameTime();
        ItemStack mainHandItem = entity.getMainHandItem();
        if (!mainHandItem.isEmpty() && mainHandItem.getItem() instanceof ISpecialItem specialItem && Config.ANIMATIONS.get()) {
            HumanoidModel<LivingEntity> self = (HumanoidModel<LivingEntity>) (Object) this;
            specialItem.getHoldingPose(self, ageInTicks, entity, mainHandItem, delta);
        }
    }
}
