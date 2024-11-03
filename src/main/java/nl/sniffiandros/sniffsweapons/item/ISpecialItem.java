package nl.sniffiandros.sniffsweapons.item;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public interface ISpecialItem {
    
    /**
     * Used to set a custom sweep particle
     * @return the particle
     */

    default ParticleOptions getSweepParticle() {
        return null;
    }

    /**
     * Called when the player performs a sweep attack
     *
     * @param player The player that performs the attack
     * @param usedStack The stack used to do the attack
     */


    default void onSweepAttack(Player player, ItemStack usedStack) {
    }

    /**
     * Called when an entity gets hit with the sweep attack
     *
     * @param player The player that performs the attack
     * @param livingentity The entity caught in the attack
     * @param stack The stack used to do the attack
     */


    default void catchEntityFromSweep(Player player, LivingEntity livingentity, ItemStack stack) {

    }

    /**
     * This function is used if you want to animate
     * an entity if it's holding the item
     *
     * @param humanoidModel The model of the Entity
     * @param ageInTicks A value that's counting up
     * @param entity The entity of course
     * @param stack The item in the Entity's main hand
     * @param delta The time between the current and the last frame
     */


    default void getHoldingPose(HumanoidModel<LivingEntity> humanoidModel,float ageInTicks, LivingEntity entity, ItemStack stack, float delta) {
    }

    /**
     *
     * Overwrite this to animate the item itself
     *
     * @param poseStack The Coordinates/Rotation of the item
     * @param displayContext The context at which the item is displayed
     * @param left If the entity is left-handed
     * @param entity The entity of course
     * @param stack The item in the Entity's main hand
     * @param delta The time between the current and the last frame
     */

    default void itemPoseStack(PoseStack poseStack, ItemDisplayContext displayContext, boolean left, LivingEntity entity, ItemStack stack,  float delta) {}
}
