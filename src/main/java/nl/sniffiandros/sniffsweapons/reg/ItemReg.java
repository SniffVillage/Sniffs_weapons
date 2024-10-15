package nl.sniffiandros.sniffsweapons.reg;

import net.minecraft.world.item.*;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import nl.sniffiandros.sniffsweapons.SniffsWeaponsMod;
import nl.sniffiandros.sniffsweapons.item.*;

public class ItemReg {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SniffsWeaponsMod.MODID);

    public static final int GREAT_SWORD_ATTACK_DAMAGE = 7;
    public static final int GREAT_AXE_ATTACK_DAMAGE = 9;
    public static final int GREAT_PICKAXE_ATTACK_DAMAGE = 5;
    public static final int NAGINATA_ATTACK_DAMAGE = 6;

    // Great swords
    public static final RegistryObject<Item> WOODEN_GREAT_SWORD = ITEMS.register("wooden_great_sword", () -> new GreatSwordItem(Tiers.WOOD, GREAT_SWORD_ATTACK_DAMAGE - 2, -2.9F, new Item.Properties()));
    public static final RegistryObject<Item> STONE_GREAT_SWORD = ITEMS.register("stone_great_sword", () -> new GreatSwordItem(Tiers.STONE, GREAT_SWORD_ATTACK_DAMAGE - 2, -2.9F, new Item.Properties()));
    public static final RegistryObject<Item> GOLDEN_GREAT_SWORD = ITEMS.register("golden_great_sword", () -> new GreatSwordItem(Tiers.GOLD, GREAT_SWORD_ATTACK_DAMAGE - 2, -2.9F, new Item.Properties()));
    public static final RegistryObject<Item> IRON_GREAT_SWORD = ITEMS.register("iron_great_sword", () -> new GreatSwordItem(Tiers.IRON, GREAT_SWORD_ATTACK_DAMAGE - 2, -2.9F, new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_GREAT_SWORD = ITEMS.register("diamond_great_sword", () -> new GreatSwordItem(Tiers.DIAMOND, GREAT_SWORD_ATTACK_DAMAGE - 2, -2.9F, new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_GREAT_SWORD = ITEMS.register("netherite_great_sword", () -> new GreatSwordItem(Tiers.NETHERITE, GREAT_SWORD_ATTACK_DAMAGE - 2, -2.9F, new Item.Properties().fireResistant()));

    // Great axes
    public static final RegistryObject<Item> WOODEN_GREAT_AXE = ITEMS.register("wooden_great_axe", () -> new GreatAxeItem(Tiers.WOOD, GREAT_AXE_ATTACK_DAMAGE - 2, -3.2F, new Item.Properties()));
    public static final RegistryObject<Item> STONE_GREAT_AXE = ITEMS.register("stone_great_axe", () -> new GreatAxeItem(Tiers.STONE, GREAT_AXE_ATTACK_DAMAGE - 2, -3.2F, new Item.Properties()));
    public static final RegistryObject<Item> GOLDEN_GREAT_AXE = ITEMS.register("golden_great_axe", () -> new GreatAxeItem(Tiers.GOLD, GREAT_AXE_ATTACK_DAMAGE - 2, -3.2F, new Item.Properties()));
    public static final RegistryObject<Item> IRON_GREAT_AXE = ITEMS.register("iron_great_axe", () -> new GreatAxeItem(Tiers.IRON, GREAT_AXE_ATTACK_DAMAGE - 2, -3.2F, new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_GREAT_AXE = ITEMS.register("diamond_great_axe", () -> new GreatAxeItem(Tiers.DIAMOND, GREAT_AXE_ATTACK_DAMAGE - 2, -3.2F, new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_GREAT_AXE = ITEMS.register("netherite_great_axe", () -> new GreatAxeItem(Tiers.NETHERITE, GREAT_AXE_ATTACK_DAMAGE - 2, -3.2F, new Item.Properties().fireResistant()));

    // Great Pickaxes
    public static final RegistryObject<Item> WOODEN_GREAT_PICKAXE = ITEMS.register("wooden_great_pickaxe", () -> new GreatPickaxeItem(Tiers.WOOD, GREAT_PICKAXE_ATTACK_DAMAGE - 2, -3.05F, new Item.Properties()));
    public static final RegistryObject<Item> STONE_GREAT_PICKAXE = ITEMS.register("stone_great_pickaxe", () -> new GreatPickaxeItem(Tiers.STONE, GREAT_PICKAXE_ATTACK_DAMAGE - 2, -3.05F, new Item.Properties()));
    public static final RegistryObject<Item> GOLDEN_GREAT_PICKAXE = ITEMS.register("golden_great_pickaxe", () -> new GreatPickaxeItem(Tiers.GOLD, GREAT_PICKAXE_ATTACK_DAMAGE - 2, -3.05F, new Item.Properties()));
    public static final RegistryObject<Item> IRON_GREAT_PICKAXE = ITEMS.register("iron_great_pickaxe", () -> new GreatPickaxeItem(Tiers.IRON, GREAT_PICKAXE_ATTACK_DAMAGE - 2, -3.05F, new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_GREAT_PICKAXE = ITEMS.register("diamond_great_pickaxe", () -> new GreatPickaxeItem(Tiers.DIAMOND, GREAT_PICKAXE_ATTACK_DAMAGE - 2, -3.05F, new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_GREAT_PICKAXE = ITEMS.register("netherite_great_pickaxe", () -> new GreatPickaxeItem(Tiers.NETHERITE, GREAT_PICKAXE_ATTACK_DAMAGE - 2, -3.05F, new Item.Properties().fireResistant()));

    // Naginata
    public static final RegistryObject<Item> WOODEN_NAGINATA = ITEMS.register("wooden_naginata", () -> new NaginataItem(Tiers.WOOD, NAGINATA_ATTACK_DAMAGE - 2, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> STONE_NAGINATA = ITEMS.register("stone_naginata", () -> new NaginataItem(Tiers.STONE, NAGINATA_ATTACK_DAMAGE - 2, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> GOLDEN_NAGINATA = ITEMS.register("golden_naginata", () -> new NaginataItem(Tiers.GOLD, NAGINATA_ATTACK_DAMAGE - 2, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> IRON_NAGINATA = ITEMS.register("iron_naginata", () -> new NaginataItem(Tiers.IRON, NAGINATA_ATTACK_DAMAGE - 2, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_NAGINATA = ITEMS.register("diamond_naginata", () -> new NaginataItem(Tiers.DIAMOND, NAGINATA_ATTACK_DAMAGE - 2, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_NAGINATA = ITEMS.register("netherite_naginata", () -> new NaginataItem(Tiers.NETHERITE, NAGINATA_ATTACK_DAMAGE - 2, -3.0F, new Item.Properties().fireResistant()));

    // Armor
    public static final RegistryObject<Item> NERHERITE_SURCOAT = ITEMS.register("netherite_surcoat", () -> new StylishArmorItem(ArmorMaterials.NETHERITE, ArmorItem.Type.CHESTPLATE, "stylish", 10511680, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> DIAMOND_SURCOAT = ITEMS.register("diamond_surcoat", () -> new StylishArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE,"stylish", 10511680, new Item.Properties()));
    public static final RegistryObject<Item> IRON_SURCOAT = ITEMS.register("iron_surcoat", () -> new StylishArmorItem(ArmorMaterials.IRON, ArmorItem.Type.CHESTPLATE, "stylish",10511680, new Item.Properties()));
    public static final RegistryObject<Item> GOLDEN_SURCOAT = ITEMS.register("golden_surcoat", () -> new StylishArmorItem(ArmorMaterials.GOLD, ArmorItem.Type.CHESTPLATE, "stylish",10511680, new Item.Properties()));

    public static final RegistryObject<Item> NERHERITE_HELM = ITEMS.register("netherite_helm", () -> new StylishArmorItem(ArmorMaterials.NETHERITE, ArmorItem.Type.HELMET, "stylish",16777215, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> DIAMOND_HELM = ITEMS.register("diamond_helm", () -> new StylishArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, "stylish",16777215, new Item.Properties()));
    public static final RegistryObject<Item> IRON_HELM = ITEMS.register("iron_helm", () -> new StylishArmorItem(ArmorMaterials.IRON, ArmorItem.Type.HELMET, "stylish",16777215, new Item.Properties()));
    public static final RegistryObject<Item> GOLDEN_HELM = ITEMS.register("golden_helm", () -> new StylishArmorItem(ArmorMaterials.GOLD, ArmorItem.Type.HELMET, "stylish",16777215, new Item.Properties()));

    public static final RegistryObject<Item> PLATED_NETHERITE_CHESTPLATE = ITEMS.register("plated_netherite_chestplate", () -> new HornedArmorItem(ArmorMaterials.NETHERITE, ArmorItem.Type.CHESTPLATE, 10511680, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> PLATED_DIAMOND_CHESTPLATE = ITEMS.register("plated_diamond_chestplate", () -> new HornedArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, 10511680, new Item.Properties()));
    public static final RegistryObject<Item> PLATED_IRON_CHESTPLATE = ITEMS.register("plated_iron_chestplate", () -> new HornedArmorItem(ArmorMaterials.IRON, ArmorItem.Type.CHESTPLATE, 10511680, new Item.Properties()));
    public static final RegistryObject<Item> PLATED_GOLDEN_CHESTPLATE = ITEMS.register("plated_golden_chestplate", () -> new HornedArmorItem(ArmorMaterials.GOLD, ArmorItem.Type.CHESTPLATE, 10511680, new Item.Properties()));

    public static final RegistryObject<Item> NETHERITE_HORNED_HELM = ITEMS.register("netherite_horned_helm", () -> new HornedArmorItem(ArmorMaterials.NETHERITE, ArmorItem.Type.HELMET, 16777215, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> DIAMOND_HORNED_HELM = ITEMS.register("diamond_horned_helm", () -> new HornedArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, 16777215, new Item.Properties()));
    public static final RegistryObject<Item> IRON_HORNED_HELM = ITEMS.register("iron_horned_helm", () -> new HornedArmorItem(ArmorMaterials.IRON, ArmorItem.Type.HELMET, 16777215, new Item.Properties()));
    public static final RegistryObject<Item> GOLDEN_HORNED_HELM = ITEMS.register("golden_horned_helm", () -> new HornedArmorItem(ArmorMaterials.GOLD, ArmorItem.Type.HELMET, 16777215, new Item.Properties()));

    public static final RegistryObject<Item> NETHERITE_KABUTO = ITEMS.register("netherite_kabuto", () -> new SamuraiArmorItem(ArmorMaterials.NETHERITE, ArmorItem.Type.HELMET, 16777215, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> DIAMOND_KABUTO = ITEMS.register("diamond_kabuto", () -> new SamuraiArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, 16777215, new Item.Properties()));
    public static final RegistryObject<Item> GOLDEN_KABUTO = ITEMS.register("golden_kabuto", () -> new SamuraiArmorItem(ArmorMaterials.GOLD, ArmorItem.Type.HELMET, 16777215, new Item.Properties()));
    public static final RegistryObject<Item> IRON_KABUTO = ITEMS.register("iron_kabuto", () -> new SamuraiArmorItem(ArmorMaterials.IRON, ArmorItem.Type.HELMET, 16777215, new Item.Properties()));

    public static final RegistryObject<Item> NETHERITE_DO = ITEMS.register("netherite_do", () -> new SamuraiArmorItem(ArmorMaterials.NETHERITE, ArmorItem.Type.CHESTPLATE, 10511680, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> DIAMOND_DO = ITEMS.register("diamond_do", () -> new SamuraiArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, 10511680, new Item.Properties()));
    public static final RegistryObject<Item> GOLDEN_DO = ITEMS.register("golden_do", () -> new SamuraiArmorItem(ArmorMaterials.GOLD, ArmorItem.Type.CHESTPLATE, 10511680, new Item.Properties()));
    public static final RegistryObject<Item> IRON_DO = ITEMS.register("iron_do", () -> new SamuraiArmorItem(ArmorMaterials.IRON, ArmorItem.Type.CHESTPLATE, 10511680, new Item.Properties()));

    public static final RegistryObject<Item> TELLERBARRET = ITEMS.register("tellerbarret", () -> new TellerbarretItem(ArmorMaterials.LEATHER, ArmorItem.Type.HELMET, 10511680, new Item.Properties()));

    public static final RegistryObject<Item> CLOTHED_GOLDEN_CUIRASS = ITEMS.register("clothed_golden_cuirass", () -> new ClothedCuirassItem(ArmorMaterials.GOLD, 10511680, new Item.Properties()));
    public static final RegistryObject<Item> CLOTHED_IRON_CUIRASS = ITEMS.register("clothed_iron_cuirass", () -> new ClothedCuirassItem(ArmorMaterials.IRON, 10511680, new Item.Properties()));
    public static final RegistryObject<Item> CLOTHED_DIAMOND_CUIRASS = ITEMS.register("clothed_diamond_cuirass", () -> new ClothedCuirassItem(ArmorMaterials.DIAMOND, 10511680, new Item.Properties()));
    public static final RegistryObject<Item> CLOTHED_NETHERITE_CUIRASS = ITEMS.register("clothed_netherite_cuirass", () -> new ClothedCuirassItem(ArmorMaterials.NETHERITE, 10511680, new Item.Properties().fireResistant()));

    // Other
    public static final RegistryObject<Item> GREAT_BOW = ITEMS.register("great_bow", () -> new GreatBowItem(new Item.Properties().durability(768)));
    public static final RegistryObject<Item> BINDING_STRING = ITEMS.register("binding_string", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> HELM_ARMOR_TRIM_SMITHING_TEMPLATE = ITEMS.register("helm_armor_trim_smithing_template", CustomSmithingTemplateItem::createArmorHelmTemplate);
    public static final RegistryObject<Item> SURCOAT_ARMOR_TRIM_SMITHING_TEMPLATE = ITEMS.register("surcoat_armor_trim_smithing_template", CustomSmithingTemplateItem::createArmorSurcoatTemplate);
    public static final RegistryObject<Item> HORNED_ARMOR_TRIM_SMITHING_TEMPLATE = ITEMS.register("horned_armor_trim_smithing_template", CustomSmithingTemplateItem::createArmorHornedTemplate);
    public static final RegistryObject<Item> PLATED_ARMOR_TRIM_SMITHING_TEMPLATE = ITEMS.register("plated_armor_trim_smithing_template", CustomSmithingTemplateItem::createArmorPlatedTemplate);
    public static final RegistryObject<Item> SAMURAI_ARMOR_TRIM_SMITHING_TEMPLATE = ITEMS.register("samurai_armor_trim_smithing_template", CustomSmithingTemplateItem::createSamuraiArmorTemplate);
    public static final RegistryObject<Item> LANDSKNECHT_ARMOR_TRIM_SMITHING_TEMPLATE = ITEMS.register("landsknecht_armor_trim_smithing_template", CustomSmithingTemplateItem::createLandsknechtArmorTemplate);
    public static final RegistryObject<Item> PATTERNED_LINEN = ITEMS.register("patterned_linen", () -> new Item(new Item.Properties()));


    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }

    public static void addToTabs(BuildCreativeModeTabContentsEvent event) {

        CreativeModeTab.TabVisibility visibility = CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS;

        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.getEntries().putAfter(new ItemStack(Items.STRING), new ItemStack(BINDING_STRING.get()), visibility);
            event.getEntries().putAfter(new ItemStack(Items.RABBIT_HIDE), new ItemStack(PATTERNED_LINEN.get()), visibility);
            event.getEntries().putAfter(new ItemStack(Items.VEX_ARMOR_TRIM_SMITHING_TEMPLATE), new ItemStack(HELM_ARMOR_TRIM_SMITHING_TEMPLATE.get()), visibility);
            event.getEntries().putAfter(new ItemStack(HELM_ARMOR_TRIM_SMITHING_TEMPLATE.get()), new ItemStack(SURCOAT_ARMOR_TRIM_SMITHING_TEMPLATE.get()), visibility);
            event.getEntries().putAfter(new ItemStack(SURCOAT_ARMOR_TRIM_SMITHING_TEMPLATE.get()), new ItemStack(HORNED_ARMOR_TRIM_SMITHING_TEMPLATE.get()), visibility);
            event.getEntries().putAfter(new ItemStack(HORNED_ARMOR_TRIM_SMITHING_TEMPLATE.get()), new ItemStack(PLATED_ARMOR_TRIM_SMITHING_TEMPLATE.get()), visibility);
            event.getEntries().putAfter(new ItemStack(PLATED_ARMOR_TRIM_SMITHING_TEMPLATE.get()), new ItemStack(SAMURAI_ARMOR_TRIM_SMITHING_TEMPLATE.get()), visibility);
            event.getEntries().putAfter(new ItemStack(SAMURAI_ARMOR_TRIM_SMITHING_TEMPLATE.get()), new ItemStack(LANDSKNECHT_ARMOR_TRIM_SMITHING_TEMPLATE.get()), visibility);
        }

        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.getEntries().putAfter(new ItemStack(Items.NETHERITE_SWORD), new ItemStack(WOODEN_GREAT_SWORD.get()), visibility);
            event.getEntries().putAfter(new ItemStack(WOODEN_GREAT_SWORD.get()), new ItemStack(STONE_GREAT_SWORD.get()), visibility);
            event.getEntries().putAfter(new ItemStack(STONE_GREAT_SWORD.get()), new ItemStack(GOLDEN_GREAT_SWORD.get()), visibility);
            event.getEntries().putAfter(new ItemStack(GOLDEN_GREAT_SWORD.get()), new ItemStack(IRON_GREAT_SWORD.get()), visibility);
            event.getEntries().putAfter(new ItemStack(IRON_GREAT_SWORD.get()), new ItemStack(DIAMOND_GREAT_SWORD.get()), visibility);
            event.getEntries().putAfter(new ItemStack(DIAMOND_GREAT_SWORD.get()), new ItemStack(NETHERITE_GREAT_SWORD.get()), visibility);

            event.getEntries().putAfter(new ItemStack(NETHERITE_GREAT_SWORD.get()), new ItemStack(WOODEN_NAGINATA.get()), visibility);
            event.getEntries().putAfter(new ItemStack(WOODEN_NAGINATA.get()), new ItemStack(STONE_NAGINATA.get()), visibility);
            event.getEntries().putAfter(new ItemStack(STONE_NAGINATA.get()), new ItemStack(GOLDEN_NAGINATA.get()), visibility);
            event.getEntries().putAfter(new ItemStack(GOLDEN_NAGINATA.get()), new ItemStack(IRON_NAGINATA.get()), visibility);
            event.getEntries().putAfter(new ItemStack(IRON_NAGINATA.get()), new ItemStack(DIAMOND_NAGINATA.get()), visibility);
            event.getEntries().putAfter(new ItemStack(DIAMOND_NAGINATA.get()), new ItemStack(NETHERITE_NAGINATA.get()), visibility);

            event.getEntries().putAfter(new ItemStack(Items.NETHERITE_AXE), new ItemStack(WOODEN_GREAT_AXE.get()), visibility);
            event.getEntries().putAfter(new ItemStack(WOODEN_GREAT_AXE.get()), new ItemStack(STONE_GREAT_AXE.get()), visibility);
            event.getEntries().putAfter(new ItemStack(STONE_GREAT_AXE.get()), new ItemStack(GOLDEN_GREAT_AXE.get()), visibility);
            event.getEntries().putAfter(new ItemStack(GOLDEN_GREAT_AXE.get()), new ItemStack(IRON_GREAT_AXE.get()), visibility);
            event.getEntries().putAfter(new ItemStack(IRON_GREAT_AXE.get()), new ItemStack(DIAMOND_GREAT_AXE.get()), visibility);
            event.getEntries().putAfter(new ItemStack(DIAMOND_GREAT_AXE.get()), new ItemStack(NETHERITE_GREAT_AXE.get()), visibility);

            event.getEntries().putAfter(new ItemStack(NETHERITE_GREAT_AXE.get()), new ItemStack(WOODEN_GREAT_PICKAXE.get()), visibility);
            event.getEntries().putAfter(new ItemStack(WOODEN_GREAT_PICKAXE.get()), new ItemStack(STONE_GREAT_PICKAXE.get()), visibility);
            event.getEntries().putAfter(new ItemStack(STONE_GREAT_PICKAXE.get()), new ItemStack(GOLDEN_GREAT_PICKAXE.get()), visibility);
            event.getEntries().putAfter(new ItemStack(GOLDEN_GREAT_PICKAXE.get()), new ItemStack(IRON_GREAT_PICKAXE.get()), visibility);
            event.getEntries().putAfter(new ItemStack(IRON_GREAT_PICKAXE.get()), new ItemStack(DIAMOND_GREAT_PICKAXE.get()), visibility);
            event.getEntries().putAfter(new ItemStack(DIAMOND_GREAT_PICKAXE.get()), new ItemStack(NETHERITE_GREAT_PICKAXE.get()), visibility);

            event.getEntries().putAfter(new ItemStack(Items.GOLDEN_HELMET), new ItemStack(GOLDEN_HELM.get()), visibility);
            event.getEntries().putAfter(new ItemStack(GOLDEN_HELM.get()), new ItemStack(GOLDEN_HORNED_HELM.get()), visibility);
            event.getEntries().putAfter(new ItemStack(GOLDEN_HORNED_HELM.get()), new ItemStack(GOLDEN_KABUTO.get()), visibility);

            event.getEntries().putAfter(new ItemStack(Items.GOLDEN_CHESTPLATE), new ItemStack(GOLDEN_SURCOAT.get()), visibility);
            event.getEntries().putAfter(new ItemStack(GOLDEN_SURCOAT.get()), new ItemStack(PLATED_GOLDEN_CHESTPLATE.get()), visibility);
            event.getEntries().putAfter(new ItemStack(PLATED_GOLDEN_CHESTPLATE.get()), new ItemStack(GOLDEN_DO.get()), visibility);
            event.getEntries().putAfter(new ItemStack(GOLDEN_DO.get()), new ItemStack(CLOTHED_GOLDEN_CUIRASS.get()), visibility);

            event.getEntries().putAfter(new ItemStack(Items.IRON_HELMET), new ItemStack(IRON_HELM.get()), visibility);
            event.getEntries().putAfter(new ItemStack(IRON_HELM.get()), new ItemStack(IRON_HORNED_HELM.get()), visibility);
            event.getEntries().putAfter(new ItemStack(IRON_HORNED_HELM.get()), new ItemStack(IRON_KABUTO.get()), visibility);

            event.getEntries().putAfter(new ItemStack(Items.IRON_CHESTPLATE), new ItemStack(IRON_SURCOAT.get()), visibility);
            event.getEntries().putAfter(new ItemStack(IRON_SURCOAT.get()), new ItemStack(PLATED_IRON_CHESTPLATE.get()), visibility);
            event.getEntries().putAfter(new ItemStack(PLATED_IRON_CHESTPLATE.get()), new ItemStack(IRON_DO.get()), visibility);
            event.getEntries().putAfter(new ItemStack(IRON_DO.get()), new ItemStack(CLOTHED_IRON_CUIRASS.get()), visibility);

            event.getEntries().putAfter(new ItemStack(Items.DIAMOND_HELMET), new ItemStack(DIAMOND_HELM.get()), visibility);
            event.getEntries().putAfter(new ItemStack(DIAMOND_HELM.get()), new ItemStack(DIAMOND_HORNED_HELM.get()), visibility);
            event.getEntries().putAfter(new ItemStack(DIAMOND_HORNED_HELM.get()), new ItemStack(DIAMOND_KABUTO.get()), visibility);

            event.getEntries().putAfter(new ItemStack(Items.DIAMOND_CHESTPLATE), new ItemStack(DIAMOND_SURCOAT.get()), visibility);
            event.getEntries().putAfter(new ItemStack(DIAMOND_SURCOAT.get()), new ItemStack(PLATED_DIAMOND_CHESTPLATE.get()), visibility);
            event.getEntries().putAfter(new ItemStack(PLATED_DIAMOND_CHESTPLATE.get()), new ItemStack(DIAMOND_DO.get()), visibility);
            event.getEntries().putAfter(new ItemStack(DIAMOND_DO.get()), new ItemStack(CLOTHED_DIAMOND_CUIRASS.get()), visibility);

            event.getEntries().putAfter(new ItemStack(Items.NETHERITE_HELMET), new ItemStack(NERHERITE_HELM.get()), visibility);
            event.getEntries().putAfter(new ItemStack(NERHERITE_HELM.get()), new ItemStack(NETHERITE_HORNED_HELM.get()), visibility);
            event.getEntries().putAfter(new ItemStack(NETHERITE_HORNED_HELM.get()), new ItemStack(NETHERITE_KABUTO.get()), visibility);

            event.getEntries().putAfter(new ItemStack(Items.NETHERITE_CHESTPLATE), new ItemStack(NERHERITE_SURCOAT.get()), visibility);
            event.getEntries().putAfter(new ItemStack(NERHERITE_SURCOAT.get()), new ItemStack(PLATED_NETHERITE_CHESTPLATE.get()), visibility);
            event.getEntries().putAfter(new ItemStack(PLATED_NETHERITE_CHESTPLATE.get()), new ItemStack(NETHERITE_DO.get()), visibility);
            event.getEntries().putAfter(new ItemStack(NETHERITE_DO.get()), new ItemStack(CLOTHED_NETHERITE_CUIRASS.get()), visibility);

            event.getEntries().putAfter(new ItemStack(Items.LEATHER_HELMET), new ItemStack(TELLERBARRET.get()), visibility);

            event.getEntries().putAfter(new ItemStack(Items.BOW), new ItemStack(GREAT_BOW.get()), visibility);
        }
    }
}
