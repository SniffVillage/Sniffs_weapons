package nl.sniffiandros.sniffsweapons.item;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import nl.sniffiandros.sniffsweapons.client.model.SamuraiArmorModel;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class SamuraiArmorItem extends StylishArmorItem{
    public SamuraiArmorItem(ArmorMaterial material, Type type, int color, Properties properties) {
        super(material, type, "samurai", color, properties);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        super.initializeClient(consumer);
        consumer.accept(new IClientItemExtensions() {
            @Override
            @NotNull
            public HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
                return new SamuraiArmorModel<>(SamuraiArmorModel.createBodyLayer().bakeRoot(), itemStack, equipmentSlot);
            }
        });
    }
}
