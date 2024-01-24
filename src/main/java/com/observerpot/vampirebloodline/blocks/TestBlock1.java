package com.observerpot.vampirebloodline.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class TestBlock1 extends Block {
    public TestBlock1() {
        super(BlockBehaviour.Properties.of().sound(SoundType.BONE_BLOCK).strength(1f));
    }
}
