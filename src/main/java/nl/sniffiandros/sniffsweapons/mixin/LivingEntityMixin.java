package nl.sniffiandros.sniffsweapons.mixin;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import nl.sniffiandros.sniffsweapons.Config;
import nl.sniffiandros.sniffsweapons.item.GreatPickaxeItem;
import nl.sniffiandros.sniffsweapons.item.ISpecialItem;
import nl.sniffiandros.sniffsweapons.reg.SoundsReg;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    @Shadow public abstract ItemStack getUseItem();


    @Shadow public abstract ItemStack getMainHandItem();

    public LivingEntityMixin(EntityType<?> p_19870_, Level p_19871_) {
        super(p_19870_, p_19871_);
    }

    @Inject(at = @At("HEAD"), method = "blockUsingShield")
    private void onShieldBlock(LivingEntity target, CallbackInfo ci) {
        ItemStack stack = this.getUseItem();
        if (stack.getItem() instanceof GreatPickaxeItem) {
            if (stack.getTag() != null) {
                int hits = stack.getTag().getInt("hits_remaining");
                stack.getOrCreateTag().putInt("hits_remaining", Math.max(hits - 1,0));
            }

        }
    }

    @Inject(at = @At("HEAD"), method = "handleEntityEvent", cancellable = true)
    private void handleEntityEvent(byte b, CallbackInfo ci) {
        if (b == 29 && this.getUseItem().getItem() instanceof GreatPickaxeItem) {
            this.playSound(SoundsReg.GREAT_PICKAXE_BLOCK.get(), 1.0F, 0.8F + this.level().random.nextFloat() * 0.4F);
            ci.cancel();
        }
    }
}
