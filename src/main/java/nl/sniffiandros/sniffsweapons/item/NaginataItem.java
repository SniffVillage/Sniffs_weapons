package nl.sniffiandros.sniffsweapons.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import nl.sniffiandros.sniffsweapons.reg.ParticlesReg;
import nl.sniffiandros.sniffsweapons.reg.SoundsReg;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class NaginataItem extends TieredItem implements Vanishable, ISpecialItem {

    private final Multimap<Attribute, AttributeModifier> modifiers;
    protected static final UUID BASE_REACH_UUID = UUID.fromString("246b078f-d600-447f-9623-0be957e7f39e");

    public NaginataItem(Tier tier, int damage, float speed, Properties properties) {
        super(tier, properties);
        float attackDamage = (float) damage + tier.getAttackDamageBonus();
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(ForgeMod.ENTITY_REACH.get(), new AttributeModifier(BASE_REACH_UUID, "Weapon modifier", 3, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", attackDamage, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", speed, AttributeModifier.Operation.ADDITION));

        this.modifiers = builder.build();

    }

    public boolean mineBlock(ItemStack p_43282_, Level p_43283_, BlockState p_43284_, BlockPos p_43285_, LivingEntity p_43286_) {
        if (p_43284_.getDestroySpeed(p_43283_, p_43285_) != 0.0F) {
            p_43282_.hurtAndBreak(2, p_43286_, (p_43276_) -> {
                p_43276_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
            });
        }

        return true;
    }


    @Override
    public @NotNull Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot p_43274_) {
        return p_43274_ == EquipmentSlot.MAINHAND ? this.modifiers : super.getDefaultAttributeModifiers(p_43274_);
    }


    @Override
    public void getHoldingPose(HumanoidModel<LivingEntity> humanoidModel, float ageInTicks, LivingEntity entity, ItemStack stack, float delta) {

        boolean left_handed = entity.getMainArm() == HumanoidArm.LEFT;

        float f = 1.0F - humanoidModel.attackTime;
        f *= f;
        f *= f;
        f = 1.0F - f;
        float f1 = -Mth.sin(f * (float)Math.PI)/1.15F;

        float f0 = 1.134464F;
        float f2 = 0.6108652F;
        float f3 = 2.268928F;
        float f4 = 0.3490659F;
        float fa = f1 * 0.2617994F;

        humanoidModel.rightArm.xRot = left_handed ? -f3 - f1 : -f0 - f1;
        humanoidModel.rightArm.yRot = left_handed ? -f4 - fa : -f2;
        humanoidModel.leftArm.xRot = left_handed ? -f0 - f1 : -f3 - f1;
        humanoidModel.leftArm.yRot = left_handed ? f2 : f4 + fa;
    }

    @Override
    public void onSweepAttack(Player attacker, ItemStack usedStack) {
        attacker.level().playSound(null, attacker.getX(), attacker.getY(), attacker.getZ(), SoundsReg.NAGINATA_SWEEP.get(), attacker.getSoundSource(), 1.0F, 1.0F);

    }

    @Override
    public @NotNull AABB getSweepHitBox(@NotNull ItemStack stack, @NotNull Player player, @NotNull Entity target) {
        return target.getBoundingBox().inflate(1.5D, 0.25D, 1.5D);
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        return ToolActions.DEFAULT_SWORD_ACTIONS.contains(toolAction);
    }

    @Override
    public void itemPoseStack(PoseStack poseStack, ItemDisplayContext displayContext, boolean left, LivingEntity entity, ItemStack stack, float delta) {
        float f = 1.0F - entity.getAttackAnim(delta);
        f *= f;
        f *= f;
        f = 1.0F - f;
        float f1 = -Mth.sin(f * (float)Math.PI);
        poseStack.mulPose(Axis.XP.rotation((float) (f1 * (Math.PI/4))));
        //poseStack.translate(0,f1,f1);
    }

    @Override
    public ParticleOptions getSweepParticle() {
        return ParticlesReg.POKE_SWEEP_PARTICLE.get();
    }
}
