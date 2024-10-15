package nl.sniffiandros.sniffsweapons;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.registries.ForgeRegistries;
import nl.sniffiandros.sniffsweapons.misc.ItemNameGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Forge's config APIs
//@Mod.EventBusSubscriber(modid = SniffsWeaponsMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec.IntValue NAMING_CHANCE = BUILDER
            .comment("Chance for an item to be named in a modified loot table")
            .defineInRange("percentage", 50, 0, 100);


    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> NAME_CLASSES = BUILDER
            .comment("Used for the custom name generator name classes.")
            .defineListAllowEmpty("name classes", ItemNameGenerator.classes(), Config::validateItemName);

    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> NAME_STORIES = BUILDER
            .comment("Used for the custom name generator stories.")
            .defineListAllowEmpty("name stories", ItemNameGenerator.stories(), Config::validateItemName);

    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> NAME_NAMES = BUILDER
            .comment("Used for the custom name generator names.")
            .defineListAllowEmpty("names", ItemNameGenerator.names(), Config::validateItemName);

    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> NAME_SEC_NAMES = BUILDER
            .comment("Used for the custom name generator second names.")
            .defineListAllowEmpty("second names", ItemNameGenerator.sec_names(), Config::validateItemName);

    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> NAME_COUNT = BUILDER
            .comment("Used for the custom name generator count.")
            .defineListAllowEmpty("count", ItemNameGenerator.count(), Config::validateItemName);

    public static final ForgeConfigSpec.ConfigValue<Boolean> ANIMATIONS = BUILDER
            .comment("Gives almost every weapon custom animations.")
            .define("enable weapon animations", true);

    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static int namingChance;
    public static List<String> nameClasses = new ArrayList<>();
    public static List<String> nameStories = new ArrayList<>();
    public static List<String> nameNames = new ArrayList<>();
    public static List<String> nameSecNames = new ArrayList<>();
    public static List<String> nameCount = new ArrayList<>();
    public static boolean animations;

    private static boolean validateItemName(final Object obj)
    {
        return obj instanceof final String itemName && ForgeRegistries.ITEMS.containsKey(new ResourceLocation(itemName));
    }

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        namingChance = NAMING_CHANCE.get();
        nameClasses = new ArrayList<>(NAME_CLASSES.get());
        nameStories = new ArrayList<>(NAME_STORIES.get());
        nameNames = new ArrayList<>(NAME_NAMES.get());
        nameSecNames = new ArrayList<>(NAME_SEC_NAMES.get());
        nameCount = new ArrayList<>(NAME_COUNT.get());
        animations = ANIMATIONS.get();
    }
}
