package net.goblinmine.gmt;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.PoweredRailBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;

public class CopperRailBlock extends PoweredRailBlock {
    public static final Block BLOCK = new CopperRailBlock(
            AbstractBlock.Settings.create()
                    .strength(0.7f, 0.7f)
                    .sounds(BlockSoundGroup.METAL)
                    .noCollision()
                    .requiresTool()
    );

    public static final BlockItem BLOCK_ITEM = new BlockItem(BLOCK,
            new Item.Settings()
    );

    public CopperRailBlock(Settings settings){
        super(settings);
    }

//    @Override
//    public BlockState getPlacementState(ItemPlacementContext ctx) {
//        return super.getPlacementState(ctx);
//    }

//    public Vec3d getPushVector(BlockState state) {
//        return switch(state.get(getShapeProperty())){
//            case ASCENDING_EAST, ASCENDING_WEST, EAST_WEST -> new Vec3d(.5,0,0);
//            case ASCENDING_SOUTH, ASCENDING_NORTH, NORTH_SOUTH -> new Vec3d(0,0,.5);
//            default -> throw new UnsupportedOperationException();
//        };
//    }
//
//    public void affectMinecart(AbstractMinecartEntity minecart, BlockState state){
//        Vec3d pushForce = getPushVector(state);
//        minecart.setVelocity(minecart.getVelocity().add(pushForce));
//    }

//    @Override
//    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
//        builder.add(new Property[]{SHAPE, POWERED, WATERLOGGED});
//    }
}
