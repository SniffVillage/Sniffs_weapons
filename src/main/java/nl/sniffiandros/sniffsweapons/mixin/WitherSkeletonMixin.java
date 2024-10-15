package nl.sniffiandros.sniffsweapons.mixin;

import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.monster.piglin.AbstractPiglin;
import net.minecraft.world.entity.monster.piglin.Piglin;
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

@Mixin(WitherSkeleton.class)
public abstract class WitherSkeletonMixin extends AbstractSkeleton {


    protected WitherSkeletonMixin(EntityType<? extends AbstractSkeleton> p_32133_, Level p_32134_) {
        super(p_32133_, p_32134_);
    }

    @Inject(at = @At("HEAD"), method = "populateDefaultEquipmentSlots", cancellable = true)
    public void customEquipment(RandomSource random, DifficultyInstance difficulty, CallbackInfo ci) {
        boolean is_landsknecht = random.nextFloat() >= 0.95F;

        if (is_landsknecht) {

            ItemStack hat = new ItemStack(ItemReg.TELLERBARRET.get());

            if (hat.getItem() instanceof DyeableArmorItem dyeableArmorItem) {
                dyeableArmorItem.setColor(hat,  0xD45721);
            }

            this.setItemSlot(EquipmentSlot.HEAD, hat);
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ItemReg.STONE_GREAT_AXE.get()));
            ci.cancel();
            return;
        }

        if (random.nextFloat() >= 0.75F) {
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ItemReg.STONE_GREAT_SWORD.get()));
            ci.cancel();
        }
    }
}
