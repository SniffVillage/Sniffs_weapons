package nl.sniffiandros.sniffsweapons.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.DyeableArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import nl.sniffiandros.sniffsweapons.SniffsWeaponsMod;
import nl.sniffiandros.sniffsweapons.client.model.TellerbarretModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.UUID;
import java.util.function.Consumer;

public class TellerbarretItem extends DyeableArmorItem {
    private final int color;

    private final Multimap<Attribute, AttributeModifier> modifiers;
    protected static final UUID ARMOR_MODIFIER_UUID = UUID.fromString("bc2ff48a-9773-42dd-869c-52a31cda4d62");
    protected static final UUID TOUGHNESS_MODIFIER_UUID = UUID.fromString("0f70abc3-82f7-4063-ac25-97d8f75b559f");

    public TellerbarretItem(ArmorMaterial material, Type type, int color, Properties properties) {
        super(material, type, properties);
        this.color = color;
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ARMOR, new AttributeModifier(ARMOR_MODIFIER_UUID, "armor modifier", 2.5, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ARMOR, new AttributeModifier(TOUGHNESS_MODIFIER_UUID, "thoughness modifier", .5, AttributeModifier.Operation.ADDITION));

        this.modifiers = builder.build();
    }


    @Override
    public int getColor(ItemStack stack) {
        CompoundTag compoundtag = stack.getTagElement("display");
        return compoundtag != null && compoundtag.contains("color", 99) ? compoundtag.getInt("color") : this.color;
    }

    @Override
    @Nullable
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        String texture = "tellerbarret";
        String domain = SniffsWeaponsMod.MODID;

        boolean is_overlay = Objects.equals(type, "overlay");

        String s1 = String.format(java.util.Locale.ROOT, "%s:textures/models/armor/%s_%s.png", domain, texture, is_overlay ? "layer" : "color");


        return s1;
    }

    @Override
    public @NotNull Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot p_43274_) {
        return p_43274_ == EquipmentSlot.HEAD ? this.modifiers : super.getDefaultAttributeModifiers(p_43274_);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        super.initializeClient(consumer);
        consumer.accept(new IClientItemExtensions() {
            @Override
            @NotNull
            public HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
                return new TellerbarretModel<>(TellerbarretModel.createBodyLayer().bakeRoot(), itemStack, equipmentSlot, livingEntity);
            }
        });
    }


}
