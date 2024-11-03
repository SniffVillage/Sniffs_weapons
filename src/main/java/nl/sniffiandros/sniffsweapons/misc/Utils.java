package nl.sniffiandros.sniffsweapons.misc;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

public class Utils {
    public static void spawnSweepParticles(LivingEntity livingEntity, ParticleOptions particle, float m) {
        double d0 = (-Mth.sin(livingEntity.getYRot() * ((float)Math.PI / 180F))) * m;
        double d1 = Mth.cos(livingEntity.getYRot() * ((float)Math.PI / 180F)) * m;
        if (livingEntity.level() instanceof ServerLevel) {
            ((ServerLevel)livingEntity.level()).sendParticles(particle, livingEntity.getX() + d0, livingEntity.getY(0.5D), livingEntity.getZ() + d1, 0, d0, 0.0D, d1, 0.0D);
        }
    }
    public static void spawnParticle(LivingEntity livingEntity, ParticleOptions particle, float y) {
        if (livingEntity.level() instanceof ServerLevel) {
            ((ServerLevel)livingEntity.level()).sendParticles(particle, livingEntity.getX(), livingEntity.getY(0.5D) + y, livingEntity.getZ(), 0, 0, 0.0D, 0, 0.0D);
        }
    }

    public static void spawnSurroundingParticles(Player player, LivingEntity target, SimpleParticleType type) {
        for(int i = 0; i < 20; ++i) {
            ((ServerLevel) player.level()).sendParticles(type, target.getRandomX(0.5D), target.getRandomY(), target.getRandomZ(0.5D), 0, 0, 0.0D, 0, 0.0D);
        }
    }

    public static Pair<Double, Entity> getEntityOnRay(LivingEntity entity, double distance) {
        Vec3 vec3 = entity.getEyePosition();
        Vec3 vec31 = entity.getViewVector(1.0F);
        Vec3 vec32 = vec3.add(vec31.x * distance, vec31.y * distance, vec31.z * distance);

        AABB aabb = entity.getBoundingBox().inflate(distance);

        EntityHitResult hitResult = ProjectileUtil.getEntityHitResult(entity.level(), entity, vec3, vec32, aabb, Entity::isAttackable);
        if (hitResult == null) {
            return null;
        }
        return new Pair<>(hitResult.distanceTo(entity), hitResult.getEntity());
    }

    public static String generateRandomColorCode(RandomSource randomSource) {
        int red = randomSource.nextInt(256);
        int green = randomSource.nextInt(256);
        int blue = randomSource.nextInt(256);
        return String.format("0x%02X%02X%02X", red, green, blue);
    }

}
