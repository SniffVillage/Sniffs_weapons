package nl.sniffiandros.sniffsweapons.mixin.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import nl.sniffiandros.sniffsweapons.Config;
import nl.sniffiandros.sniffsweapons.item.ISpecialItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin implements ResourceManagerReloadListener {

    @Inject(at = @At("HEAD"), method = "renderStatic(Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/ItemDisplayContext;ZLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;Lnet/minecraft/world/level/Level;III)V")
    private void animate_item(LivingEntity entity, ItemStack stack, ItemDisplayContext displayContext, boolean left, PoseStack poseStack, MultiBufferSource multiBufferSource, Level level, int i1, int i2, int i3, CallbackInfo ci) {
       float delta = Minecraft.getInstance().getDeltaFrameTime();

        if (stack.getItem() instanceof ISpecialItem specialItem && Config.ANIMATIONS.get()) {
            if (entity != null) {
                specialItem.itemPoseStack(poseStack, displayContext, left, entity, stack, delta);
            }
       }
    }
}
