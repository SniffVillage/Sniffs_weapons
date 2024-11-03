package nl.sniffiandros.sniffsweapons.item;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import nl.sniffiandros.sniffsweapons.misc.Utils;
import nl.sniffiandros.sniffsweapons.reg.ParticlesReg;
import nl.sniffiandros.sniffsweapons.reg.SoundsReg;
import org.jetbrains.annotations.NotNull;

public class GreatSwordItem extends SwordItem implements ISpecialItem {
    public final Vec3 boundingBox = new Vec3(3.0D, 0.25D, 3.0D);

    public GreatSwordItem(Tier tier, int damage, float speed, Properties properties) {
        super(tier, damage, speed, properties);
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        return super.getMaxDamage(stack) * 2;
    }

    @Override
    public void getHoldingPose(HumanoidModel<LivingEntity> humanoidModel, float ageInTicks, LivingEntity entity, ItemStack stack, float delta) {

        float f = 1.0F - humanoidModel.attackTime;
        f *= f;
        f *= f;
        f = 1.0F - f;
        float f1 = Mth.sin(f * (float)Math.PI);

        humanoidModel.rightArm.xRot = -1.22173F - f1;
        humanoidModel.rightArm.yRot = -0.6108652F;
        humanoidModel.leftArm.xRot = -1.22173F - f1;
        humanoidModel.leftArm.yRot = 0.6108652F;
    }


    public void crit(LivingEntity target, LivingEntity attacker) {

        if (attacker instanceof Player player) {
            float f1 = target.isDamageSourceBlocked(target.damageSources().playerAttack(player)) ? 0.5F : 0.75F;

            if (target.isDamageSourceBlocked(target.damageSources().playerAttack(player))) {
                if (target instanceof Player playerTarget) {
                    playerTarget.disableShield(true);
                }
            }
            target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 12, 2, false,false));

            player.level().playSound(null,player.getX(), player.getY(), player.getZ(), SoundsReg.GREAT_SWORD_CRITICAL.get(),
                    SoundSource.PLAYERS, 1.2F, 1.0F - attacker.getRandom().nextFloat() / 4.0F);

            Vec3 vec3 = target.getDeltaMovement();
            target.setDeltaMovement(vec3.x, f1, vec3.z);

            target.hurt(target.damageSources().playerAttack(player), this.getDamage() + 3);
            Utils.spawnSweepParticles(player, ParticlesReg.CRITICAL_SWEEP_PARTICLE.get(), 1);
        }
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof Player player) {
            boolean canCrit = player.isCrouching() && !player.getCooldowns().isOnCooldown(stack.getItem());
            if (canCrit) {
                player.getCooldowns().addCooldown(stack.getItem(), 20);
                crit(target,attacker);

            }
        }
        return super.hurtEnemy(stack, target, attacker);
    }

    @Override
    public ParticleOptions getSweepParticle() {
        return ParticlesReg.BIG_SWEEP_PARTICLE.get();
    }

    @Override
    public void catchEntityFromSweep(Player player, LivingEntity livingentity, ItemStack stack) {
        Utils.spawnParticle(livingentity, ParticlesReg.HIT_PARTICLE.get(), 0);
        livingentity.playSound(SoundsReg.GREAT_SWORD_HIT.get(), 1.0F,  0.75F + livingentity.getRandom().nextFloat() / 3);
        int fi = getEnchantmentLevel(stack, Enchantments.FIRE_ASPECT);
        if (fi > 0) {
            livingentity.setSecondsOnFire(fi * 4);
        }
    }

    @Override
    public @NotNull AABB getSweepHitBox(@NotNull ItemStack stack, @NotNull Player player, @NotNull Entity target) {

        return target.getBoundingBox().inflate(this.boundingBox.x(), this.boundingBox.y(), this.boundingBox.z());
    }

}
