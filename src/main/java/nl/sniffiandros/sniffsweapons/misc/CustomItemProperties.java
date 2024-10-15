package nl.sniffiandros.sniffsweapons.misc;

import net.minecraft.Util;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SmithingTemplateItem;
import nl.sniffiandros.sniffsweapons.reg.ItemReg;

public class CustomItemProperties {
    public static void addCustomItemProperties() {
        makeBow(ItemReg.GREAT_BOW.get());
        makeShield(ItemReg.WOODEN_GREAT_PICKAXE.get());
        makeShield(ItemReg.STONE_GREAT_PICKAXE.get());
        makeShield(ItemReg.GOLDEN_GREAT_PICKAXE.get());
        makeShield(ItemReg.IRON_GREAT_PICKAXE.get());
        makeShield(ItemReg.DIAMOND_GREAT_PICKAXE.get());
        makeShield(ItemReg.NETHERITE_GREAT_PICKAXE.get());
    }

    public static void makeBow(Item item) {
        ItemProperties.register(item, new ResourceLocation("pull"), (stack, clientLevel, entity, i) -> {
            if (entity == null) {
                return 0.0F;
            } else {
                return entity.getUseItem() != stack ? 0.0F : (float)(stack.getUseDuration() - entity.getUseItemRemainingTicks()) / 30.0F;
            }
        });
        ItemProperties.register(item, new ResourceLocation("pulling"), (stack, clientLevel, entity, i) -> entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F);
    }
    public static void makeShield(Item item) {
        ItemProperties.register(item, new ResourceLocation("blocking"), (stack, clientLevel, entity, i) -> entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F);
    }
}
