package nl.sniffiandros.sniffsweapons.item;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import nl.sniffiandros.sniffsweapons.misc.Utils;
import nl.sniffiandros.sniffsweapons.reg.ParticlesReg;
import nl.sniffiandros.sniffsweapons.reg.SoundsReg;

import java.util.List;

public class GreatPickaxeItem extends PickaxeItem implements ISpecialItem {
    public final Vec3 boundingBox = new Vec3(1.0D, 0.25D, 1.0D);

    private final int MAX_HITS = 2;

    public GreatPickaxeItem(Tier tier, int damage, float speed, Properties properties) {
        super(tier, damage, speed, properties);
    }



    @Override
    public int getMaxDamage(ItemStack stack) {
        return super.getMaxDamage(stack) * 2;
    }

    @Override
    public void getHoldingPose(HumanoidModel<LivingEntity> humanoidModel, float ageInTicks, LivingEntity entity, ItemStack stack, float delta) {

        boolean left_handed = entity.getMainArm() == HumanoidArm.LEFT;

        if (entity.isUsingItem()) {

            float f0 = 1.570796F;
            float f1 = 0.6108652F;
            float f2 = 1.22173F;
            float f3 = 0.3490659F;

            humanoidModel.rightArm.xRot = left_handed ? -f2 : -f0;
            humanoidModel.rightArm.yRot = left_handed ? -f3 : -f1;
            humanoidModel.leftArm.xRot = left_handed ? -f0 : -f2;
            humanoidModel.leftArm.yRot = left_handed ? f1 : f3;
            return;
        }

        float f = 1.0F - humanoidModel.attackTime;
        f *= f;
        f *= f;
        f = 1.0F - f;
        float f1 = -Mth.sin(f * (float)Math.PI)/1.15F;

        float f0 = 1.22173F;
        float f2 = 0.6981317F;
        float f3 = 1.745329F;
        float f4 = 0.6108652F;
        float fa = f1 * 0.2617994F;

        humanoidModel.rightArm.xRot = left_handed ? -f3 - f1 : -f0 - f1;
        humanoidModel.rightArm.yRot = left_handed ? -f4 - fa : -f2;
        humanoidModel.leftArm.xRot = left_handed ? -f0 - f1 : -f3 - f1;
        humanoidModel.leftArm.yRot = left_handed ? f2 : f4 + fa;
    }

    public int getUseDuration(ItemStack p_43107_) {
        return 30;
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (!player.getOffhandItem().equals(itemstack) && !player.getCooldowns().isOnCooldown(itemstack.getItem()) && canBlock(player)) {
            player.startUsingItem(hand);
            itemstack.getOrCreateTag().putInt("hits_remaining", MAX_HITS);
            player.playSound(SoundsReg.GREAT_PICKAXE_DRAW.get(), 1.0F, 1.0F);
            return InteractionResultHolder.consume(itemstack);
        }

        return InteractionResultHolder.pass(itemstack);
    }

    public boolean canBlock(LivingEntity entity) {
        if (entity instanceof Player player && !(entity.getOffhandItem().getItem() instanceof BlockItem)) {
            return !(player.getFoodData().needsFood() && player.getOffhandItem().getFoodProperties(entity) != null);
        }
        return false;
    }

    @Override
    public void onUseTick(Level level, LivingEntity entity, ItemStack stack, int count) {
        if (stack.getTag() != null) {
            int i = stack.getTag().getInt("hits_remaining");
            if (i <= 0) {
                entity.stopUsingItem();
            }
        }
        super.onUseTick(level, entity, stack, count);
    }

    @Override
    public void onStopUsing(ItemStack stack, LivingEntity entity, int count) {

        int add = 0;

        if (stack.getTag() != null) {
            int i = stack.getTag().getInt("hits_remaining");
            if (i <= 0) {
                add = 30;
            }
        }
        applyCooldown(entity, stack, Math.max((getUseDuration(stack) - count) * 3, 20) + add);
        entity.playSound(SoundsReg.GREAT_PICKAXE_WITHDRAW.get(), 1.0F, 1.0F);
    }

    private void applyCooldown(LivingEntity entity, ItemStack itemStack,int durration) {
        if (entity instanceof Player player) {
            player.getCooldowns().addCooldown(itemStack.getItem(), durration);
        }
    }

    @Override
    public boolean hurtEnemy(ItemStack item, LivingEntity target, LivingEntity attacker) {

        if (attacker instanceof Player player && !attacker.level().isClientSide()) {
            float f = player.getAttackStrengthScale(0.5F);
            boolean flag = f > 0.9F;

            if (attacker.fallDistance > 0 && flag) {
                slam(player, target);
            } else {
                target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 1, true, false));
                Utils.spawnSweepParticles(player, ParticlesReg.HEAVY_SWEEP_PARTICLE.get(), 1);
                attacker.level().playSound(null, target.getX(), target.getY(), target.getZ(),
                        SoundsReg.GREAT_PICKAXE_HIT.get(), attacker.getSoundSource(), 1.2F, 1.0F - attacker.getRandom().nextFloat() / 4.0F);
            }
        }
        return super.hurtEnemy(item, target, attacker);
    }

    public void slam(Player attacker, LivingEntity target){

        AABB aabb = target.getBoundingBox().inflate(this.boundingBox.x(), this.boundingBox.y(), this.boundingBox.z());

        List list = attacker.level().getEntitiesOfClass(LivingEntity.class, aabb);

        attacker.level().playSound(null, target.getX(), target.getY(), target.getZ(),
                SoundsReg.GREAT_PICKAXE_SLAM.get(), attacker.getSoundSource(), 1.8F, 1.0F - attacker.getRandom().nextFloat() / 4.0F);

        Utils.spawnParticle(target, ParticlesReg.BONK_SWEEP_PARTICLE.get(), 0);

        for (int i = 0; i < list.size(); ++i) {
            LivingEntity entity = (LivingEntity) list.get(i);
            if (entity != attacker) {
                Vec3 vec3 = target.getDeltaMovement();
                target.setDeltaMovement(vec3.x, -0.5F, vec3.z);


                entity.hurt(attacker.damageSources().playerAttack(attacker), this.getAttackDamage() / 4);

                Utils.spawnSurroundingParticles(attacker, entity, ParticleTypes.CRIT);

                target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 80, 2, true, false));
            }
        }
    }

    @Override
    public boolean canPerformAction(ItemStack stack, net.minecraftforge.common.ToolAction toolAction) {
        return net.minecraftforge.common.ToolActions.DEFAULT_SHIELD_ACTIONS.contains(toolAction);
    }
}
