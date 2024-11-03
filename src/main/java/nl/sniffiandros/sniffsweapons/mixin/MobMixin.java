package nl.sniffiandros.sniffsweapons.mixin;

import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.DyeableArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import nl.sniffiandros.sniffsweapons.misc.Utils;
import nl.sniffiandros.sniffsweapons.reg.ItemReg;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;

@Mixin(Mob.class)
public abstract class MobMixin extends LivingEntity {

    @Shadow public abstract void setItemSlot(EquipmentSlot p_21416_, ItemStack p_21417_);

    protected MobMixin(EntityType<? extends LivingEntity> p_21683_, Level p_21684_) {
        super(p_21683_, p_21684_);
    }

    @Inject(at = @At("HEAD"), method = "populateDefaultEquipmentSlots", cancellable = true)
    private void customEquipment(RandomSource random, DifficultyInstance difficultyInstance, CallbackInfo ci) {
        if (random.nextFloat() < 0.3F * difficultyInstance.getSpecialMultiplier() && !this.isBaby()) {
            boolean isWarrior = random.nextFloat() <= .5;

            if (isWarrior) {
                List<ItemStack> Helmets = new ArrayList<>();
                Helmets.add(0, new ItemStack(ItemReg.IRON_HELM.get()));
                Helmets.add(1, new ItemStack(ItemReg.IRON_HORNED_HELM.get()));
                Helmets.add(2, new ItemStack(ItemReg.IRON_KABUTO.get()));

                List<ItemStack> Chestplates = new ArrayList<>();
                Chestplates.add(0, new ItemStack(ItemReg.IRON_SURCOAT.get()));
                Chestplates.add(1, new ItemStack(ItemReg.PLATED_IRON_CHESTPLATE.get()));
                Chestplates.add(2, new ItemStack(ItemReg.IRON_DO.get()));

                int set = random.nextInt(3);

                ItemStack helm = Helmets.get(set);
                ItemStack chestplate = Chestplates.get(set);

                if (helm.getItem() instanceof DyeableArmorItem dyeableArmorItem) {
                    dyeableArmorItem.setColor(helm, set == 2 ? Integer.decode(Utils.generateRandomColorCode(this.getRandom())): 0xB02E26);
                }
                if (chestplate.getItem() instanceof DyeableArmorItem dyeableArmorItem) {
                    dyeableArmorItem.setColor(chestplate,  0xB02E26);
                }


                this.setItemSlot(EquipmentSlot.HEAD, helm);
                this.setItemSlot(EquipmentSlot.CHEST, chestplate);
                this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Items.IRON_LEGGINGS));
                this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Items.IRON_BOOTS));
                ci.cancel();
            }


        }
    }
}
