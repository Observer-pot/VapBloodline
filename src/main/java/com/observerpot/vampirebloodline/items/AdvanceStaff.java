package com.observerpot.vampirebloodline.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class AdvanceStaff extends Item {
    public AdvanceStaff() {
        super(new Item.Properties().rarity(Rarity.EPIC).durability(2000).fireResistant().setNoRepair());
    }
}
