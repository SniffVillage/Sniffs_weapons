package nl.sniffiandros.sniffsweapons.events;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import nl.sniffiandros.sniffsweapons.SniffsWeaponsMod;
import nl.sniffiandros.sniffsweapons.reg.ItemReg;

import java.util.List;

@Mod.EventBusSubscriber(modid = SniffsWeaponsMod.MODID)
public class ModEvents {


    @SubscribeEvent
    public static void addTrades(VillagerTradesEvent event) {
        if (event.getType() == VillagerProfession.SHEPHERD) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(1).add((trader, random) -> new MerchantOffer(
                new ItemStack(ItemReg.PATTERNED_LINEN.get(), 6),
                    new ItemStack(Items.EMERALD, 1),
                    12, 2, 0.02f));

            trades.get(3).add((trader, random) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 4),
                    new ItemStack(ItemReg.PATTERNED_LINEN.get(), 1),
                    12, 12, 0.02f));

        }
    }
}
