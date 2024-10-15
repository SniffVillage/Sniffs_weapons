package nl.sniffiandros.sniffsweapons.item;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.DyeableArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import nl.sniffiandros.sniffsweapons.SniffsWeaponsMod;
import nl.sniffiandros.sniffsweapons.client.model.ClothedCuirassModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.function.Consumer;

public class ClothedCuirassItem extends DyeableArmorItem {
    private final int color;

    public ClothedCuirassItem(ArmorMaterial material, int color, Properties properties) {
        super(material, ArmorItem.Type.CHESTPLATE, properties);
        this.color = color;
    }


    @Override
    public int getColor(ItemStack stack) {
        CompoundTag compoundtag = stack.getTagElement("display");
        return compoundtag != null && compoundtag.contains("color", 99) ? compoundtag.getInt("color") : this.color;
    }

    @Override
    @Nullable
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        ArmorItem item = (ArmorItem) stack.getItem();

        boolean is_overlay = Objects.equals(type, "overlay");
        String texture = item.getMaterial().getName();
        String domain = SniffsWeaponsMod.MODID;

        int idx = texture.indexOf(':');
        if (idx != -1) {
            domain = texture.substring(0, idx);
            texture = texture.substring(idx + 1);
        }


        String s1 = String.format(java.util.Locale.ROOT, "%s:textures/models/armor/clothed_%s_cuirass_layer.png", domain,texture);
        String s2 = String.format(java.util.Locale.ROOT, "%s:textures/models/armor/clothed_cuirass_color.png", domain);

        return is_overlay ? s1 : s2;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        super.initializeClient(consumer);
        consumer.accept(new IClientItemExtensions() {
            @Override
            @NotNull
            public HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
                return new ClothedCuirassModel<>(ClothedCuirassModel.createBodyLayer().bakeRoot(), itemStack, equipmentSlot, livingEntity);
            }
        });
    }
}
