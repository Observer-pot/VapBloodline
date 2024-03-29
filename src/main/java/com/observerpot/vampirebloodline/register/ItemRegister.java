package com.observerpot.vampirebloodline.register;

import com.observerpot.vampirebloodline.VampireBloodline;
import com.observerpot.vampirebloodline.items.AdvanceStaff;
import com.observerpot.vampirebloodline.items.BasicStaff;
import com.observerpot.vampirebloodline.items.DragonSlayer;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemRegister {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(VampireBloodline.MODID);

    public static final DeferredItem<BlockItem> EXAMPLE_BLOCK_ITEM = registerBlockItem(BlockRegister.EXAMPLE_BLOCK, new Item.Properties());
    public static final DeferredItem<BlockItem> TEST_BLOCK_1_ITEM = registerBlockItem(BlockRegister.TEST_BLOCK_1, new Item.Properties());
    public static final DeferredItem<BlockItem> TEST_BLOCK_2_ITEM = registerBlockItem(BlockRegister.TEST_BLOCK_2, new Item.Properties());

    public static final DeferredItem<Item> EXAMPLE_ITEM = registerItem("example_item", new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEat().nutrition(1).saturationMod(2f).build()));
    public static final DeferredItem<Item> TEST_ITEM_1 = registerItem("test_item_1", new Item.Properties());
    public static final DeferredItem<Item> BASIC_STAFF = ITEMS.register("basic_staff", BasicStaff::new);
    public static final DeferredItem<Item> ADVANCE_STAFF = ITEMS.register("advance_staff", AdvanceStaff::new);
    public static final DeferredItem<Item> Dragon_SLAYER_SWORD = ITEMS.register("dragon_slayer_sword", DragonSlayer::new);

    public static DeferredItem<BlockItem> registerBlockItem(DeferredBlock<Block> block, Item.Properties properties) {
        DeferredItem<BlockItem> blockItemObj = ITEMS.registerSimpleBlockItem(block, properties);
        return blockItemObj;
    }

    public static DeferredItem<Item> registerItem(String name, Item.Properties properties) {
        DeferredItem<Item> itemObj = ITEMS.registerSimpleItem(name, properties);
        return itemObj;
    }
}
