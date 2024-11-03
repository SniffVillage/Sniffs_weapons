package nl.sniffiandros.sniffsweapons.mixin;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.DamageEnchantment;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import nl.sniffiandros.sniffsweapons.item.GreatPickaxeItem;
import nl.sniffiandros.sniffsweapons.item.NaginataItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DamageEnchantment.class)
public abstract class DamageEnchantmentMixin extends Enchantment {
    protected DamageEnchantmentMixin(Rarity p_44676_, EnchantmentCategory p_44677_, EquipmentSlot[] p_44678_) {
        super(p_44676_, p_44677_, p_44678_);
    }

    @Inject(at = @At("HEAD"), method = "canEnchant", cancellable = true)
    private void canEnchant(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (stack.getItem() instanceof GreatPickaxeItem || stack.getItem() instanceof NaginataItem) {
            cir.setReturnValue(true);
        }
    }

}
