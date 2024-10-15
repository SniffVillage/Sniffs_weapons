package nl.sniffiandros.sniffsweapons.item;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import nl.sniffiandros.sniffsweapons.misc.Utils;
import nl.sniffiandros.sniffsweapons.reg.ParticlesReg;
import nl.sniffiandros.sniffsweapons.reg.SoundsReg;

import java.util.List;

public class GreatAxeItem extends AxeItem implements ISpecialItem {
    public final Vec3 boundingBox = new Vec3(3.5D, 0.25D, 3.5D);

    public GreatAxeItem(Tier tier, float damage, float speed, Properties properties) {
        super(tier, damage, speed, properties);
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        return super.getMaxDamage(stack) * 2;
    }

    @Override
    public void getHoldingPose(HumanoidModel<LivingEntity> humanoidModel, float ageInTicks, LivingEntity entity, ItemStack stack, float delta) {

        boolean left_handed = entity.getMainArm() == HumanoidArm.LEFT;

        float f = 1.0F - humanoidModel.attackTime;
        f *= f;
        f *= f;
        f = 1.0F - f;
        float f1 = -Mth.sin(f * (float)Math.PI)/1.15F;

        float f0 = 0.9599311F;
        float f2 = 0.6108652F;
        float f3 = 1.919862F;
        float f4 = 0.3490659F;
        float fa = f1 * 0.2617994F;

        humanoidModel.rightArm.xRot = left_handed ? -f3 - f1 : -f0 - f1;
        humanoidModel.rightArm.yRot = left_handed ? -f4 - fa : -f2;
        humanoidModel.leftArm.xRot = left_handed ? -f0 - f1 : -f3 - f1;
        humanoidModel.leftArm.yRot = left_handed ? f2 : f4 + fa;
    }

    @Override
    public boolean hurtEnemy(ItemStack item, LivingEntity target, LivingEntity attacker) {

        if (attacker instanceof Player player && !attacker.level().isClientSide()) {
            float f = player.getAttackStrengthScale(0.5F);
            boolean flag = f > 0.9F;

            if (attacker.fallDistance > 0 && flag) {
                slam(player, target);
            }

            Utils.spawnSweepParticles(player, ParticlesReg.HEAVY_SWEEP_PARTICLE.get(), 1);
            attacker.level().playSound(null, target.getX(), target.getY(), target.getZ(),
                    SoundsReg.GREAT_AXE_HIT.get(), attacker.getSoundSource(), 1.2F, 1.0F - attacker.getRandom().nextFloat() / 4.0F);
        }
        return super.hurtEnemy(item, target, attacker);
    }

    public void slam(Player attacker, LivingEntity target){

        AABB aabb = target.getBoundingBox().inflate(this.boundingBox.x(), this.boundingBox.y(), this.boundingBox.z());

        List list = attacker.level().getEntitiesOfClass(LivingEntity.class, aabb);

        attacker.level().playSound(null, target.getX(), target.getY(), target.getZ(),
                SoundsReg.GREAT_AXE_SLAM.get(), attacker.getSoundSource(), 1.8F, 1.0F - attacker.getRandom().nextFloat() / 4.0F);

        Utils.spawnParticle(target, ParticlesReg.SHOCKWAVE_PARTICLE.get(), 0);

        for (int i = 0; i < list.size(); ++i) {
            LivingEntity entity = (LivingEntity) list.get(i);
            if (entity != attacker) {
                entity.hurt(attacker.damageSources().playerAttack(attacker), this.getAttackDamage() / 2);
                Utils.spawnSurroundingParticles(attacker, entity, ParticleTypes.CRIT);

                Utils.spawnParticle(entity, ParticlesReg.HIT_PARTICLE.get(), 0);
            }
        }
    }


}
