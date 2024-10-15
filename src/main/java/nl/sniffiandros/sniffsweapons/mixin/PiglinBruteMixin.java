package nl.sniffiandros.sniffsweapons.mixin;

import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.monster.piglin.AbstractPiglin;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.monster.piglin.PiglinBrute;
import net.minecraft.world.item.DyeableArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import nl.sniffiandros.sniffsweapons.reg.ItemReg;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PiglinBrute.class)
public abstract class PiglinBruteMixin extends AbstractPiglin {

    public PiglinBruteMixin(EntityType<? extends AbstractPiglin> p_34652_, Level p_34653_) {
        super(p_34652_, p_34653_);
    }
    @Inject(at = @At("HEAD"), method = "populateDefaultEquipmentSlots", cancellable = true)
    private void customSpawnWeapon(RandomSource random, DifficultyInstance difficulty, CallbackInfo ci) {
        if (random.nextFloat() > 0.85) {
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ItemReg.GOLDEN_GREAT_AXE.get()));
            ci.cancel();
        }
    }
}
