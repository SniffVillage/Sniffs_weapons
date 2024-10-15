package nl.sniffiandros.sniffsweapons.item;

import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.SmithingTemplateItem;
import nl.sniffiandros.sniffsweapons.SniffsWeaponsMod;

import java.util.List;

public class CustomSmithingTemplateItem extends SmithingTemplateItem {

    private static final ChatFormatting TITLE_FORMAT = ChatFormatting.GRAY;
    private static final ChatFormatting DESCRIPTION_FORMAT = ChatFormatting.BLUE;

    private static final Component HELM_ARMOR_TRIM_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(SniffsWeaponsMod.MODID,"smithing_template.armor_trim.applies_to_helm"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component HELM_ARMOR_TRIM_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(SniffsWeaponsMod.MODID,"smithing_template.armor_trim.ingredients_helm"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component HELM_ARMOR_TRIM_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(SniffsWeaponsMod.MODID, "smithing_template.armor_trim.base_slot_description_helm")));
    private static final Component HELM_ARMOR_TRIM_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(SniffsWeaponsMod.MODID, "smithing_template.armor_trim.additions_slot_description_helm")));

    private static final Component SURCOAT_ARMOR_TRIM_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(SniffsWeaponsMod.MODID,"smithing_template.armor_trim.applies_to_surcoat"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component SURCOAT_ARMOR_TRIM_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(SniffsWeaponsMod.MODID,"smithing_template.armor_trim.ingredients_surcoat"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component SURCOAT_ARMOR_TRIM_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(SniffsWeaponsMod.MODID, "smithing_template.armor_trim.base_slot_description_surcoat")));
    private static final Component SURCOAT_ARMOR_TRIM_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(SniffsWeaponsMod.MODID, "smithing_template.armor_trim.additions_slot_description_surcoat")));

    private static final Component HORNED_ARMOR_TRIM_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(SniffsWeaponsMod.MODID,"smithing_template.armor_trim.applies_to_horned"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component HORNED_ARMOR_TRIM_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(SniffsWeaponsMod.MODID,"smithing_template.armor_trim.ingredients_horned"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component HORNED_ARMOR_TRIM_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(SniffsWeaponsMod.MODID, "smithing_template.armor_trim.base_slot_description_horned")));
    private static final Component HORNED_ARMOR_TRIM_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(SniffsWeaponsMod.MODID, "smithing_template.armor_trim.additions_slot_description_horned")));

    private static final Component PLATED_ARMOR_TRIM_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(SniffsWeaponsMod.MODID,"smithing_template.armor_trim.applies_to_plated"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component PLATED_ARMOR_TRIM_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(SniffsWeaponsMod.MODID,"smithing_template.armor_trim.ingredients_plated"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component PLATED_ARMOR_TRIM_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(SniffsWeaponsMod.MODID, "smithing_template.armor_trim.base_slot_description_plated")));
    private static final Component PLATED_ARMOR_TRIM_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(SniffsWeaponsMod.MODID, "smithing_template.armor_trim.additions_slot_description_plated")));

    private static final Component SAMURAI_ARMOR_TRIM_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(SniffsWeaponsMod.MODID,"smithing_template.armor_trim.applies_to_samurai"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component SAMURAI_ARMOR_TRIM_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(SniffsWeaponsMod.MODID,"smithing_template.armor_trim.ingredients_samurai"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component SAMURAI_ARMOR_TRIM_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(SniffsWeaponsMod.MODID, "smithing_template.armor_trim.base_slot_description_samurai")));
    private static final Component SAMURAI_ARMOR_TRIM_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(SniffsWeaponsMod.MODID, "smithing_template.armor_trim.additions_slot_description_samurai")));

    private static final Component LANDSKNECHT_ARMOR_TRIM_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(SniffsWeaponsMod.MODID,"smithing_template.armor_trim.applies_to_landsknecht"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component LANDSKNECHT_ARMOR_TRIM_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(SniffsWeaponsMod.MODID,"smithing_template.armor_trim.ingredients_landsknecht"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component LANDSKNECHT_ARMOR_TRIM_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(SniffsWeaponsMod.MODID, "smithing_template.armor_trim.base_slot_description_landsknecht")));
    private static final Component LANDSKNECHT_ARMOR_TRIM_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(SniffsWeaponsMod.MODID, "smithing_template.armor_trim.additions_slot_description_landsknecht")));

    private static final ResourceLocation EMPTY_SLOT_HELMET = new ResourceLocation("item/empty_armor_slot_helmet");
    private static final ResourceLocation EMPTY_SLOT_CHESTPLATE = new ResourceLocation("item/empty_armor_slot_chestplate");
    private static final ResourceLocation EMPTY_SLOT_FEATHER = new ResourceLocation(SniffsWeaponsMod.MODID, "item/empty_slot_feather");
    private static final ResourceLocation EMPTY_SLOT_LEATHER = new ResourceLocation(SniffsWeaponsMod.MODID, "item/empty_slot_leather");
    private static final ResourceLocation EMPTY_SLOT_BONE = new ResourceLocation(SniffsWeaponsMod.MODID, "item/empty_slot_bone");
    private static final ResourceLocation EMPTY_SLOT_INGOT = new ResourceLocation("item/empty_slot_ingot");
    private static final ResourceLocation EMPTY_SLOT_NUGGET = new ResourceLocation(SniffsWeaponsMod.MODID,"item/empty_slot_nugget");
    private static final ResourceLocation EMPTY_SLOT_LINEN = new ResourceLocation(SniffsWeaponsMod.MODID, "item/empty_slot_linen");

    public CustomSmithingTemplateItem(Component p_266834_, Component p_267043_, Component p_267048_, Component p_267278_, Component p_267090_, List<ResourceLocation> p_266755_, List<ResourceLocation> p_267060_) {
        super(p_266834_, p_267043_, p_267048_, p_267278_, p_267090_, p_266755_, p_267060_);
    }

    public static SmithingTemplateItem createArmorHelmTemplate() {
        return new SmithingTemplateItem(
                HELM_ARMOR_TRIM_APPLIES_TO,
                HELM_ARMOR_TRIM_INGREDIENTS,
                Component.translatable("customization.sniffsweapons.helm").withStyle(TITLE_FORMAT),
                HELM_ARMOR_TRIM_BASE_SLOT_DESCRIPTION,
                HELM_ARMOR_TRIM_ADDITIONS_SLOT_DESCRIPTION,
                List.of(EMPTY_SLOT_HELMET),
                List.of(EMPTY_SLOT_FEATHER));
    }

    public static SmithingTemplateItem createArmorSurcoatTemplate() {
        return new SmithingTemplateItem(
                SURCOAT_ARMOR_TRIM_APPLIES_TO,
                SURCOAT_ARMOR_TRIM_INGREDIENTS,
                Component.translatable("customization.sniffsweapons.surcoat").withStyle(TITLE_FORMAT),
                SURCOAT_ARMOR_TRIM_BASE_SLOT_DESCRIPTION,
                SURCOAT_ARMOR_TRIM_ADDITIONS_SLOT_DESCRIPTION,
                List.of(EMPTY_SLOT_CHESTPLATE),
                List.of(EMPTY_SLOT_LEATHER));
    }

    public static SmithingTemplateItem createArmorHornedTemplate() {
        return new SmithingTemplateItem(
                HORNED_ARMOR_TRIM_APPLIES_TO,
                HORNED_ARMOR_TRIM_INGREDIENTS,
                Component.translatable("customization.sniffsweapons.horned").withStyle(TITLE_FORMAT),
                HORNED_ARMOR_TRIM_BASE_SLOT_DESCRIPTION,
                HORNED_ARMOR_TRIM_ADDITIONS_SLOT_DESCRIPTION,
                List.of(EMPTY_SLOT_HELMET),
                List.of(EMPTY_SLOT_BONE));
    }

    public static SmithingTemplateItem createArmorPlatedTemplate() {
        return new SmithingTemplateItem(
                PLATED_ARMOR_TRIM_APPLIES_TO,
                PLATED_ARMOR_TRIM_INGREDIENTS,
                Component.translatable("customization.sniffsweapons.plated").withStyle(TITLE_FORMAT),
                PLATED_ARMOR_TRIM_BASE_SLOT_DESCRIPTION,
                PLATED_ARMOR_TRIM_ADDITIONS_SLOT_DESCRIPTION,
                List.of(EMPTY_SLOT_CHESTPLATE),
                List.of(EMPTY_SLOT_INGOT));
    }

    public static SmithingTemplateItem createSamuraiArmorTemplate() {
        return new SmithingTemplateItem(
                SAMURAI_ARMOR_TRIM_APPLIES_TO,
                SAMURAI_ARMOR_TRIM_INGREDIENTS,
                Component.translatable("customization.sniffsweapons.samurai").withStyle(TITLE_FORMAT),
                SAMURAI_ARMOR_TRIM_BASE_SLOT_DESCRIPTION,
                SAMURAI_ARMOR_TRIM_ADDITIONS_SLOT_DESCRIPTION,
                List.of(EMPTY_SLOT_CHESTPLATE, EMPTY_SLOT_HELMET),
                List.of(EMPTY_SLOT_NUGGET));
    }

    public static SmithingTemplateItem createLandsknechtArmorTemplate() {
        return new SmithingTemplateItem(
                LANDSKNECHT_ARMOR_TRIM_APPLIES_TO,
                LANDSKNECHT_ARMOR_TRIM_INGREDIENTS,
                Component.translatable("customization.sniffsweapons.landsknecht").withStyle(TITLE_FORMAT),
                LANDSKNECHT_ARMOR_TRIM_BASE_SLOT_DESCRIPTION,
                LANDSKNECHT_ARMOR_TRIM_ADDITIONS_SLOT_DESCRIPTION,
                List.of(EMPTY_SLOT_CHESTPLATE),
                List.of(EMPTY_SLOT_LINEN));
    }
}
