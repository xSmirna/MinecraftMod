package com.smirna.WeatherSwordmod.item.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;

public class WeatherSwordItem extends SwordItem {
    public WeatherSwordItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        Level level = attacker.level();
        
        // Clear weather effects
        if (!level.isRaining() && !level.isThundering()) {
            target.setRemainingFireTicks(100); // Sets target on fire for 5 seconds (100 ticks)
        }
        // Rain effects
        else if (level.isRaining() && !level.isThundering()) {
            target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 1)); // Slowness II for 5 seconds
        }
        // Thunder effects
        else if (level.isThundering()) {
            // Summon lightning bolt
            if (!target.level().isClientSide()) {
                LightningBolt lightningBolt = EntityType.LIGHTNING_BOLT.create(level);
                lightningBolt.moveTo(target.position());
                level.addFreshEntity(lightningBolt);
            }
            target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 1)); // Weakness II for 5 seconds
        }

        return super.hurtEnemy(stack, target, attacker);
    }
} 