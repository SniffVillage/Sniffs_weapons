package nl.sniffiandros.sniffsweapons.reg;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import nl.sniffiandros.sniffsweapons.SniffsWeaponsMod;

public class TagReg {
    public static class Items {
        public static final TagKey<Item> NAMEABLE_ITEMS = tag("nameable_items");
        public static final TagKey<Item> GREAT_SWORDS = tag("great_swords");
        public static final TagKey<Item> GREAT_AXES = tag("great_axes");
        public static final TagKey<Item> GREAT_PICKAXES = tag("great_pickaxes");
        public static final TagKey<Item> NAGINATA = tag("naginata");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(SniffsWeaponsMod.MODID, name));
        }
    }
}
