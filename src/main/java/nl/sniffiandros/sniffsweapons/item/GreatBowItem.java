package nl.sniffiandros.sniffsweapons.item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import nl.sniffiandros.sniffsweapons.reg.ParticlesReg;

import java.util.function.Predicate;

public class GreatBowItem extends BowItem {

    public static final int MAX_DRAW_DURATION = 30;
    public static final double BASE_ARROW_DAMAGE = 4.0D;
    public static final int BASE_ARROW_KNOCKBACK = 1;
    public static final int DEFAULT_RANGE = 15;

    public GreatBowItem(Properties p) {
        super(p);
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        return super.getMaxDamage(stack) * 2;
    }

    public void releaseUsing(ItemStack stack, Level level, LivingEntity entity, int i1) {
        if (entity instanceof Player player) {
            boolean flag = player.getAbilities().instabuild || EnchantmentHelper.getTagEnchantmentLevel(Enchantments.INFINITY_ARROWS, stack) > 0;
            ItemStack itemstack = player.getProjectile(stack);

            int i = this.getUseDuration(stack) - i1;
            i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, level, player, i, !itemstack.isEmpty() || flag);
            if (i < 0) return;

            if (!itemstack.isEmpty() || flag) {
                if (itemstack.isEmpty()) {
                    itemstack = new ItemStack(Items.ARROW);
                }

                float f = GreatBowItem.getPowerForTime(i);

                if (!((double)f < 0.1D)) {
                    boolean flag1 = player.getAbilities().instabuild || (itemstack.getItem() instanceof ArrowItem && ((ArrowItem)itemstack.getItem()).isInfinite(itemstack, stack, player));
                    if (!level.isClientSide) {
                        ArrowItem arrowitem = (ArrowItem)(itemstack.getItem() instanceof ArrowItem ? itemstack.getItem() : Items.ARROW);
                        AbstractArrow abstractarrow = arrowitem.createArrow(level, itemstack, player);
                        abstractarrow = customArrow(abstractarrow);
                        abstractarrow.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, f * 4.0F, 2.0F);
                        if (f == 1.0F) {
                            abstractarrow.setCritArrow(true);
                        }

                        int j = EnchantmentHelper.getTagEnchantmentLevel(Enchantments.POWER_ARROWS, stack);
                        abstractarrow.setBaseDamage(j > 0 ? BASE_ARROW_DAMAGE + (double)j * 0.5D + 0.5D : BASE_ARROW_DAMAGE);

                        int k = EnchantmentHelper.getTagEnchantmentLevel(Enchantments.PUNCH_ARROWS, stack);
                        abstractarrow.setKnockback(k > 0 ? BASE_ARROW_KNOCKBACK + k : BASE_ARROW_KNOCKBACK);

                        if (EnchantmentHelper.getTagEnchantmentLevel(Enchantments.FLAMING_ARROWS, stack) > 0) {
                            abstractarrow.setSecondsOnFire(100);
                        }

                        stack.hurtAndBreak(1, player, (p_40665_) -> {
                            p_40665_.broadcastBreakEvent(player.getUsedItemHand());
                        });
                        if (flag1 || player.getAbilities().instabuild && (itemstack.is(Items.SPECTRAL_ARROW) || itemstack.is(Items.TIPPED_ARROW))) {
                            abstractarrow.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                        }

                        level.addFreshEntity(abstractarrow);
                    }
                    if (f == 1.0F) {
                        launchParticles(player, level);
                    }

                    level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 0.5F / (level.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F);

                    if (!flag1 && !player.getAbilities().instabuild) {
                        itemstack.shrink(1);
                        if (itemstack.isEmpty()) {
                            player.getInventory().removeItem(itemstack);
                        }
                    }

                    player.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }

    public static void launchParticles(Player player, Level level) {

        Vec3 front = Vec3.directionFromRotation(player.getXRot(), player.getYRot());
        HumanoidArm arm = player.getMainArm();
        boolean isRightHand = arm == HumanoidArm.RIGHT;
        Vec3 side = Vec3.directionFromRotation(0, player.getYRot() + (isRightHand ? 90 : -90));
        Vec3 down = Vec3.directionFromRotation(player.getXRot() + 90, player.getYRot());

        Vec3 origin = new Vec3(player.getX(), player.getEyeY(), player.getZ());
        origin.add(side.add(down).scale(0.15));
        Vec3 p = origin.add(front.scale(1.25));
        Vec3 v = front.scale(0.1);
        level.addParticle(ParticlesReg.BOW_SHOCKWAVE_PARTICLE.get(), p.x, p.y, p.z, v.x, v.y, v.z);
    }


    public static float getPowerForTime(int i) {
        float f = (float)i / 30.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }

    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BOW;
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        boolean flag = !player.getProjectile(itemstack).isEmpty();

        InteractionResultHolder<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, level, player, hand, flag);
        if (ret != null) return ret;

        if (!player.getAbilities().instabuild && !flag) {
            return InteractionResultHolder.fail(itemstack);
        } else {
            player.startUsingItem(hand);
            return InteractionResultHolder.consume(itemstack);
        }
    }

    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return ARROW_ONLY;
    }

    public AbstractArrow customArrow(AbstractArrow arrow) {
        return arrow;
    }

    public int getDefaultProjectileRange() {
        return DEFAULT_RANGE;
    }
}
