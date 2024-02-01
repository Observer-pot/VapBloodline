package com.observerpot.vampirebloodline.items;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class BasicStaff extends Item {
    public BasicStaff() {
        super(new Item.Properties().durability(30).setNoRepair().rarity(Rarity.UNCOMMON));
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.BRUSH;
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 200;
    }

    @Override
    public void releaseUsing(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity, int pTimeCharged) {
        Player player = (Player)pLivingEntity;
        int i = this.getUseDuration(pStack) - pTimeCharged;
        if (i < 0) return;
        MobEffectInstance instance = new MobEffectInstance(MobEffects.ABSORPTION, 2000, (int) (20 * getPowerForTime(i)));
        pStack.hurtAndBreak((int) (30 * getPowerForTime(i)), player, p_311711_ -> p_311711_.broadcastBreakEvent(player.getUsedItemHand()));
        player.addEffect(instance);
        pLevel.playSound(player,
                player.getX(),
                player.getY(),
                player.getZ(),
                SoundEvents.EXPERIENCE_ORB_PICKUP,
                SoundSource.PLAYERS,
                0.5F,
                0.4F / (pLevel.getRandom().nextFloat() * 0.4F + 0.8F));
        player.startUsingItem(player.getUsedItemHand());
    }


    public static float getPowerForTime(int pCharge) {
        float f = (float)pCharge / 200F;
        if (f > 1.0F) {
            f = 1.0F;
        }
        return f;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
        pLevel.playSound(pPlayer,
                pPlayer.getX(),
                pPlayer.getY(),
                pPlayer.getZ(),
                SoundEvents.CROSSBOW_LOADING_MIDDLE,
                SoundSource.PLAYERS,
                0.5F,
                0.4F / (pLevel.getRandom().nextFloat() * 0.4F + 0.8F));
        pPlayer.startUsingItem(pUsedHand);
        return InteractionResultHolder.consume(itemstack);
    }
}
