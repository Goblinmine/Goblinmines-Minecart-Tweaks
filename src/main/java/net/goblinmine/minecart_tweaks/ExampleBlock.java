package net.goblinmine.minecart_tweaks;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ExampleBlock extends Block {
    public ExampleBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(CHARGED, false));
    }

    public static final BooleanProperty CHARGED = BooleanProperty.of("charged");
    public static final ExampleBlock BLOCK = new ExampleBlock(FabricBlockSettings.create().requiresTool().strength(4.0f));
    public static final BlockItem ITEM = new BlockItem(ExampleBlock.BLOCK, new FabricItemSettings());

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder){
        builder.add(CHARGED);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        player.sendMessage(Text.literal("Block is charged"), false);
        world.setBlockState(pos, state.with(CHARGED, true));
        return ActionResult.SUCCESS;


//        if (world.isClient) {
//            player.sendMessage(Text.literal("Hello, world!"), false);
//        }
//
//        return ActionResult.SUCCESS;
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity){
        if(world.getBlockState(pos).get(CHARGED)){
            LightningEntity lightningEntity = (LightningEntity) EntityType.LIGHTNING_BOLT.create(world);
            lightningEntity.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(pos));
            world.spawnEntity(lightningEntity);
        }
    }
}
