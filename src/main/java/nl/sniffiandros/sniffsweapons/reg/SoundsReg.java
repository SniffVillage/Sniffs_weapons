package nl.sniffiandros.sniffsweapons.reg;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import nl.sniffiandros.sniffsweapons.SniffsWeaponsMod;

public class SoundsReg {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, SniffsWeaponsMod.MODID);

    public static final RegistryObject<SoundEvent> GREAT_SWORD_HIT = registerSoundEvent("great_sword_hit");
    public static final RegistryObject<SoundEvent> GREAT_SWORD_CRITICAL = registerSoundEvent("great_sword_critical");

    public static final RegistryObject<SoundEvent> GREAT_AXE_SLAM = registerSoundEvent("great_axe_slam");
    public static final RegistryObject<SoundEvent> GREAT_AXE_HIT = registerSoundEvent("great_axe_hit");

    public static final RegistryObject<SoundEvent> GREAT_PICKAXE_SLAM = registerSoundEvent("great_pickaxe_slam");
    public static final RegistryObject<SoundEvent> GREAT_PICKAXE_HIT = registerSoundEvent("great_pickaxe_hit");
    public static final RegistryObject<SoundEvent> GREAT_PICKAXE_BLOCK = registerSoundEvent("great_pickaxe_block");
    public static final RegistryObject<SoundEvent> GREAT_PICKAXE_WITHDRAW = registerSoundEvent("great_pickaxe_withdraw");
    public static final RegistryObject<SoundEvent> GREAT_PICKAXE_DRAW = registerSoundEvent("great_pickaxe_draw");

    public static final RegistryObject<SoundEvent> NAGINATA_SWEEP = registerSoundEvent("naginata_sweep");

    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(SniffsWeaponsMod.MODID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
