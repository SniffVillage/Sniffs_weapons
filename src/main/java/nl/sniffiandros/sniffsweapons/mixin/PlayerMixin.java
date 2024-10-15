package nl.sniffiandros.sniffsweapons.mixin;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.particle.Particle;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.player.CriticalHitEvent;
import nl.sniffiandros.sniffsweapons.item.ISpecialItem;
import nl.sniffiandros.sniffsweapons.misc.Utils;
import nl.sniffiandros.sniffsweapons.reg.ParticlesReg;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Iterator;
import java.util.List;

@Mixin(Player.class)
public abstract class PlayerMixin extends LivingEntity {

    protected PlayerMixin(EntityType<? extends LivingEntity> p_20966_, Level p_20967_) {
        super(p_20966_, p_20967_);
    }

    @Inject(at = @At("HEAD"), method = "sweepAttack", cancellable = true)
    public void getSweepAttackParticles(CallbackInfo ci) {
        ItemStack stack = this.getMainHandItem();

        Item item = stack.getItem();
        if (item instanceof ISpecialItem specialItem) {
            ParticleOptions particle = specialItem.getSweepParticle();
            if (particle != null) {
                Utils.spawnSweepParticles(this, specialItem.getSweepParticle(), 2);
                ci.cancel();
            }
        }
    }


    @Inject(method = "attack", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/world/entity/LivingEntity;knockback(DDD)V", ordinal = 1),
            locals = LocalCapture.CAPTURE_FAILHARD)
    public void catchEntityFromSweep(Entity target, CallbackInfo ci, float f1, float f2, float f3, boolean b1, boolean b2, float f4,
                                     boolean b3, CriticalHitEvent criticalHitEvent, boolean b4, double d1, float f5, boolean b5, int i, Vec3 pos, boolean b6, float f6,
                                     Iterator<LivingEntity> entityIterator, LivingEntity entity) {
        ItemStack stack = this.getMainHandItem();

        Player plr = (Player)(Object)this;
        Item item = stack.getItem();
        if (item instanceof ISpecialItem specialItem) {
            specialItem.catchEntityFromSweep(plr, entity, stack);
        }
        Utils.spawnParticle(entity, ParticlesReg.HIT_PARTICLE.get(), 0);
    }

    @Inject(method = "attack", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/Player;sweepAttack()V"),  locals = LocalCapture.CAPTURE_FAILHARD)
    public void onSweepAttack(Entity entity, CallbackInfo ci) {
        ItemStack stack = this.getMainHandItem();

        Player plr = (Player)(Object)this;
        Item item = stack.getItem();
        if (item instanceof ISpecialItem specialItem) {
            specialItem.onSweepAttack(plr, stack);
        }

        if (entity instanceof LivingEntity livingEntity) {
            Utils.spawnParticle(livingEntity, ParticlesReg.HIT_PARTICLE.get(), 0);
        }
    }
}
