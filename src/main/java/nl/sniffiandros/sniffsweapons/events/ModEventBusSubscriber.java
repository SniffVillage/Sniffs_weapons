package nl.sniffiandros.sniffsweapons.events;

import net.minecraft.client.particle.AttackSweepParticle;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import nl.sniffiandros.sniffsweapons.SniffsWeaponsMod;
import nl.sniffiandros.sniffsweapons.particle.BigShockwaveParticle;
import nl.sniffiandros.sniffsweapons.particle.BigSweepParticle;
import nl.sniffiandros.sniffsweapons.particle.BowShockwaveParticle;
import nl.sniffiandros.sniffsweapons.particle.SmallSweepParticle;
import nl.sniffiandros.sniffsweapons.reg.ItemReg;
import nl.sniffiandros.sniffsweapons.reg.ParticlesReg;

@Mod.EventBusSubscriber(modid = SniffsWeaponsMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusSubscriber {

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerParticleFactories(final RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(ParticlesReg.BIG_SWEEP_PARTICLE.get(), BigSweepParticle.Factory::new);
        event.registerSpriteSet(ParticlesReg.HIT_PARTICLE.get(), SmallSweepParticle.Factory::new);
        event.registerSpriteSet(ParticlesReg.SHOCKWAVE_PARTICLE.get(), BigShockwaveParticle.Factory::new);
        event.registerSpriteSet(ParticlesReg.BONK_SWEEP_PARTICLE.get(), BigShockwaveParticle.Factory::new);
        event.registerSpriteSet(ParticlesReg.BOW_SHOCKWAVE_PARTICLE.get(), BowShockwaveParticle.Factory::new);
        event.registerSpriteSet(ParticlesReg.HEAVY_SWEEP_PARTICLE.get(), AttackSweepParticle.Provider::new);
        event.registerSpriteSet(ParticlesReg.CRITICAL_SWEEP_PARTICLE.get(), AttackSweepParticle.Provider::new);
        event.registerSpriteSet(ParticlesReg.POKE_SWEEP_PARTICLE.get(), AttackSweepParticle.Provider::new);
    }
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
        event.register((stack, layer) ->
                        layer > 0 ? -1 : ((DyeableLeatherItem)stack.getItem()).getColor(stack),
                ItemReg.NERHERITE_SURCOAT.get(), ItemReg.DIAMOND_SURCOAT.get(),ItemReg.IRON_SURCOAT.get(), ItemReg.GOLDEN_SURCOAT.get(),
                ItemReg.NERHERITE_HELM.get(),ItemReg.DIAMOND_HELM.get(),ItemReg.IRON_HELM.get(), ItemReg.GOLDEN_HELM.get(),
                ItemReg.NETHERITE_HORNED_HELM.get(),ItemReg.DIAMOND_HORNED_HELM.get(),ItemReg.IRON_HORNED_HELM.get(), ItemReg.GOLDEN_HORNED_HELM.get(),
                ItemReg.PLATED_NETHERITE_CHESTPLATE.get(),ItemReg.PLATED_DIAMOND_CHESTPLATE.get(),ItemReg.PLATED_GOLDEN_CHESTPLATE.get(), ItemReg.PLATED_IRON_CHESTPLATE.get(),
                ItemReg.NETHERITE_DO.get(), ItemReg.DIAMOND_DO.get(), ItemReg.GOLDEN_DO.get(), ItemReg.IRON_DO.get(),
                ItemReg.NETHERITE_KABUTO.get(), ItemReg.DIAMOND_KABUTO.get(), ItemReg.GOLDEN_KABUTO.get(), ItemReg.IRON_KABUTO.get(),
                ItemReg.TELLERBARRET.get(),
                ItemReg.CLOTHED_GOLDEN_CUIRASS.get(),ItemReg.CLOTHED_IRON_CUIRASS.get(),ItemReg.CLOTHED_DIAMOND_CUIRASS.get(),ItemReg.CLOTHED_NETHERITE_CUIRASS.get());
    }
}
