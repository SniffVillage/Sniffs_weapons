package nl.sniffiandros.sniffsweapons.reg;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import nl.sniffiandros.sniffsweapons.SniffsWeaponsMod;

public class ParticlesReg {
    public static final DeferredRegister<ParticleType<?>> PARTICLES =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, SniffsWeaponsMod.MODID);

    public static RegistryObject<SimpleParticleType> HIT_PARTICLE =
            PARTICLES.register("hit", () -> new SimpleParticleType(true));

    public static RegistryObject<SimpleParticleType> SHOCKWAVE_PARTICLE =
            PARTICLES.register("shockwave", () -> new SimpleParticleType(true));

    public static RegistryObject<SimpleParticleType> BONK_SWEEP_PARTICLE =
            PARTICLES.register("bonk_sweep", () -> new SimpleParticleType(true));

    public static RegistryObject<SimpleParticleType> BOW_SHOCKWAVE_PARTICLE =
            PARTICLES.register("bow_shockwave", () -> new SimpleParticleType(true));

    public static RegistryObject<SimpleParticleType> HEAVY_SWEEP_PARTICLE =
            PARTICLES.register("heavy_sweep", () -> new SimpleParticleType(true));

    public static RegistryObject<SimpleParticleType> CRITICAL_SWEEP_PARTICLE =
            PARTICLES.register("critical_sweep", () -> new SimpleParticleType(true));

    public static RegistryObject<SimpleParticleType> BIG_SWEEP_PARTICLE =
            PARTICLES.register("big_sweep", () -> new SimpleParticleType(true));

    public static RegistryObject<SimpleParticleType> POKE_SWEEP_PARTICLE =
            PARTICLES.register("poke_sweep", () -> new SimpleParticleType(true));

    public static void register(IEventBus eventBus) {
        PARTICLES.register(eventBus);
    }
}
