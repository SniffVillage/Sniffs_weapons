package nl.sniffiandros.sniffsweapons.client;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ComputeFovModifierEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import nl.sniffiandros.sniffsweapons.item.GreatBowItem;

import static nl.sniffiandros.sniffsweapons.SniffsWeaponsMod.MODID;


@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class SniffsWeaponsClient {

    @SubscribeEvent
    public static void onFOVUpdate(ComputeFovModifierEvent event)
    {
        LivingEntity player = event.getPlayer();
        Item item = player.getUseItem().getItem();
        if(item instanceof GreatBowItem) {
            float FOVModifier = player.getTicksUsingItem() / (float)GreatBowItem.MAX_DRAW_DURATION;
            if (FOVModifier > 1.0f) {
                FOVModifier = 1.0f;
            }
            else {
                FOVModifier *= FOVModifier;
            }
            event.setNewFovModifier(event.getNewFovModifier() * (1.0f - FOVModifier * 0.15f));
        }
    }
}
