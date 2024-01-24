package com.example.examplemod.register;

import com.example.examplemod.VampireBloodline;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CreativeModeTabRegister {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, VampireBloodline.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXAMPLE_TAB_ITEM = CREATIVE_MODE_TABS.register("example_tab_item", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> ItemRegister.TEST_ITEM_1.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(ItemRegister.TEST_ITEM_1.get());// Add the example item to the tab. For your own tabs, this method is preferred over the event
                output.accept(ItemRegister.EXAMPLE_ITEM.get());
            }).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXAMPLE_TAB_BLOCK = CREATIVE_MODE_TABS.register("example_tab_block", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.BUILDING_BLOCKS)
            .icon(() -> ItemRegister.TEST_BLOCK_1_ITEM.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(ItemRegister.TEST_BLOCK_1_ITEM.get());// Add the example item to the tab. For your own tabs, this method is preferred over the event
                output.accept(ItemRegister.TEST_BLOCK_2_ITEM.get());
                output.accept(ItemRegister.EXAMPLE_BLOCK_ITEM.get());
            }).build());
}
