package nl.sniffiandros.sniffsweapons.mixin;

import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.monster.piglin.AbstractPiglin;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import nl.sniffiandros.sniffsweapons.misc.Utils;
import nl.sniffiandros.sniffsweapons.reg.ItemReg;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;

@Mixin(Piglin.class)
public abstract class PiglinMixin extends AbstractPiglin {


    @Shadow protected abstract void maybeWearArmor(EquipmentSlot p_219192_, ItemStack p_219193_, RandomSource p_219194_);

    public PiglinMixin(EntityType<? extends AbstractPiglin> p_34652_, Level p_34653_) {
        super(p_34652_, p_34653_);
    }
    @Inject(at = @At("HEAD"), method = "createSpawnWeapon", cancellable = true)
    private void customSpawnWeapon(CallbackInfoReturnable<ItemStack> cir) {
        cir.setReturnValue(this.getRandom().nextFloat() > 0.65 ?
                (new ItemStack(ItemReg.GOLDEN_GREAT_SWORD.get())) :
                (double)this.random.nextFloat() < 0.5D ? new ItemStack(Items.CROSSBOW) : new ItemStack(Items.GOLDEN_SWORD));
    }


    @Inject(at = @At("HEAD"), method = "populateDefaultEquipmentSlots")
    public void customEquipment(RandomSource random, DifficultyInstance difficulty, CallbackInfo ci) {
        if (this.isAdult()) {

            List<ItemStack> Helmets = new ArrayList<>();
            Helmets.add(0, new ItemStack(ItemReg.GOLDEN_HELM.get()));
            Helmets.add(1, new ItemStack(ItemReg.GOLDEN_HORNED_HELM.get()));
            Helmets.add(2, new ItemStack(ItemReg.GOLDEN_KABUTO.get()));

            List<ItemStack> Chestplates = new ArrayList<>();
            Chestplates.add(0, new ItemStack(ItemReg.GOLDEN_SURCOAT.get()));
            Chestplates.add(1, new ItemStack(ItemReg.PLATED_GOLDEN_CHESTPLATE.get()));
            Chestplates.add(2, new ItemStack(ItemReg.GOLDEN_DO.get()));

            int rHelm = random.nextInt(3);
            int rChestplate = random.nextInt(3);

            ItemStack helm = Helmets.get(rHelm);
            ItemStack chestplate = Chestplates.get(rChestplate);

            if (helm.getItem() instanceof DyeableArmorItem dyeableArmorItem) {
                dyeableArmorItem.setColor(helm, rHelm == 2 ? Integer.decode(Utils.generateRandomColorCode(this.getRandom())): 0xB02E26);
            }
            if (chestplate.getItem() instanceof DyeableArmorItem dyeableArmorItem) {
                dyeableArmorItem.setColor(chestplate,  0xB02E26);
            }


            this.maybeWearArmor(EquipmentSlot.HEAD, helm, random);
            this.maybeWearArmor(EquipmentSlot.CHEST, chestplate, random);
        }
    }
}
