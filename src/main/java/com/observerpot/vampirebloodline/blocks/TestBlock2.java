package com.observerpot.vampirebloodline.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class TestBlock2 extends Block {
    public TestBlock2() {
        super(BlockBehaviour.Properties.of().sound(SoundType.BAMBOO).strength(10L));
    }
}
