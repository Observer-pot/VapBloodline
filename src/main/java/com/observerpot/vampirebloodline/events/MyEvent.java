package com.observerpot.vampirebloodline.events;

import com.observerpot.vampirebloodline.VampireBloodline;
import com.observerpot.vampirebloodline.register.ItemRegister;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

@Mod.EventBusSubscriber(modid = VampireBloodline.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class MyEvent {

    @SubscribeEvent
    public static void useAdvanceStaff(PlayerInteractEvent.RightClickItem event) {
        Player player = event.getEntity();
        ItemStack item = event.getItemStack();
        if (item.is(ItemRegister.ADVANCE_STAFF.asItem())) {
            MobEffectInstance instance = new MobEffectInstance(MobEffects.ABSORPTION, 2000, 5);
            player.addEffect(instance);
            player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 2000));
            player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 2000, 5));
            player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 2000));
        }
    }
}
