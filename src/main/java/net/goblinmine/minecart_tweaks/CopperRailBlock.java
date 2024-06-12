package net.goblinmine.minecart_tweaks;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.PoweredRailBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.sound.BlockSoundGroup;

public class CopperRailBlock extends PoweredRailBlock {
    public CopperRailBlock(Settings settings) {
        super(settings);
    }

    public static final CopperRailBlock BLOCK = new CopperRailBlock(
            FabricBlockSettings.create()
                    .strength(0.7f, 0.7f)
                    .sounds(BlockSoundGroup.METAL)
                    .notSolid()
                    .noCollision()
                    .requiresTool()
    );

    public static final BlockItem ITEM = new BlockItem(CopperRailBlock.BLOCK, new FabricItemSettings());
}
