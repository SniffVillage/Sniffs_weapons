package nl.sniffiandros.sniffsweapons;

import com.mojang.logging.LogUtils;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import nl.sniffiandros.sniffsweapons.misc.CustomItemProperties;
import nl.sniffiandros.sniffsweapons.reg.*;
import org.slf4j.Logger;

@Mod(SniffsWeaponsMod.MODID)
public class SniffsWeaponsMod
{

    public static final String MODID = "sniffsweapons";

    public static final Logger LOGGER = LogUtils.getLogger();


    public SniffsWeaponsMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);
        ItemReg.register(modEventBus);
        ParticlesReg.register(modEventBus);
        SoundsReg.register(modEventBus);
        LootModifierReg.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(ItemReg::addToTabs);


        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        CauldronInteraction.WATER.put(ItemReg.GOLDEN_HELM.get(), CauldronInteraction.DYED_ITEM);
        CauldronInteraction.WATER.put(ItemReg.IRON_HELM.get(), CauldronInteraction.DYED_ITEM);
        CauldronInteraction.WATER.put(ItemReg.DIAMOND_HELM.get(), CauldronInteraction.DYED_ITEM);
        CauldronInteraction.WATER.put(ItemReg.NERHERITE_HELM.get(), CauldronInteraction.DYED_ITEM);

        CauldronInteraction.WATER.put(ItemReg.GOLDEN_SURCOAT.get(), CauldronInteraction.DYED_ITEM);
        CauldronInteraction.WATER.put(ItemReg.IRON_SURCOAT.get(), CauldronInteraction.DYED_ITEM);
        CauldronInteraction.WATER.put(ItemReg.DIAMOND_SURCOAT.get(), CauldronInteraction.DYED_ITEM);
        CauldronInteraction.WATER.put(ItemReg.NERHERITE_SURCOAT.get(), CauldronInteraction.DYED_ITEM);

        CauldronInteraction.WATER.put(ItemReg.GOLDEN_HORNED_HELM.get(), CauldronInteraction.DYED_ITEM);
        CauldronInteraction.WATER.put(ItemReg.IRON_HORNED_HELM.get(), CauldronInteraction.DYED_ITEM);
        CauldronInteraction.WATER.put(ItemReg.DIAMOND_HORNED_HELM.get(), CauldronInteraction.DYED_ITEM);
        CauldronInteraction.WATER.put(ItemReg.NETHERITE_HORNED_HELM.get(), CauldronInteraction.DYED_ITEM);

        CauldronInteraction.WATER.put(ItemReg.PLATED_GOLDEN_CHESTPLATE.get(), CauldronInteraction.DYED_ITEM);
        CauldronInteraction.WATER.put(ItemReg.PLATED_IRON_CHESTPLATE.get(), CauldronInteraction.DYED_ITEM);
        CauldronInteraction.WATER.put(ItemReg.PLATED_DIAMOND_CHESTPLATE.get(), CauldronInteraction.DYED_ITEM);
        CauldronInteraction.WATER.put(ItemReg.PLATED_NETHERITE_CHESTPLATE.get(), CauldronInteraction.DYED_ITEM);

        CauldronInteraction.WATER.put(ItemReg.TELLERBARRET.get(), CauldronInteraction.DYED_ITEM);

        CauldronInteraction.WATER.put(ItemReg.CLOTHED_GOLDEN_CUIRASS.get(), CauldronInteraction.DYED_ITEM);
        CauldronInteraction.WATER.put(ItemReg.CLOTHED_IRON_CUIRASS.get(), CauldronInteraction.DYED_ITEM);
        CauldronInteraction.WATER.put(ItemReg.CLOTHED_DIAMOND_CUIRASS.get(), CauldronInteraction.DYED_ITEM);
        CauldronInteraction.WATER.put(ItemReg.CLOTHED_NETHERITE_CUIRASS.get(), CauldronInteraction.DYED_ITEM);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {}

    private void clientSetup(final FMLClientSetupEvent event) {
        CustomItemProperties.addCustomItemProperties();
    }
}
