package com.observerpot.vampirebloodline.register;

import com.observerpot.vampirebloodline.VampireBloodline;
import com.observerpot.vampirebloodline.blocks.TestBlock1;
import com.observerpot.vampirebloodline.blocks.TestBlock2;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BlockRegister {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(VampireBloodline.MODID);

    public static final DeferredBlock<Block> EXAMPLE_BLOCK = registerBlock("example_block", BlockBehaviour.Properties.of().mapColor(MapColor.STONE));
    public static final DeferredBlock<Block> TEST_BLOCK_1 = BLOCKS.register("test_block_1", TestBlock1::new);
    public static final DeferredBlock<Block> TEST_BLOCK_2 = BLOCKS.register("test_block_2", TestBlock2::new);

    public static DeferredBlock<Block> registerBlock(String name, BlockBehaviour.Properties properties) {
        DeferredBlock<Block> block = BLOCKS.registerSimpleBlock(name, properties);
        return block;
    }
}
