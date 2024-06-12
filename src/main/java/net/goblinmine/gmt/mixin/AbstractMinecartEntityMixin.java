package net.goblinmine.gmt.mixin;

import net.goblinmine.gmt.CopperRailBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.vehicle.AbstractMinecartEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(AbstractMinecartEntity.class)
public abstract class AbstractMinecartEntityMixin {
    private double maxSpeed = 8.0;
    @Redirect(method = "moveOnRail", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z"))
    private boolean checkForNewPoweredRailTypes(BlockState state, Block block) {
        return state.isOf(CopperRailBlock.BLOCK) || state.isOf(Blocks.POWERED_RAIL);
    }

    @Redirect(method = "moveOnRail", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/vehicle/AbstractMinecartEntity;getMaxSpeed()D"))
    public double increaseMaxSpeed(AbstractMinecartEntity instance) {
        double speed = maxSpeed;
        AbstractMinecartEntity minecartEntity = (AbstractMinecartEntity) (Object) this;
        BlockState blockState = minecartEntity.getWorld().getBlockState(minecartEntity.getBlockPos());

        if (blockState.isOf(Blocks.POWERED_RAIL)) {
            speed = 24.0;
        } else if (blockState.isOf(CopperRailBlock.BLOCK)) {
            speed = 10.0;
        }
        maxSpeed = speed;
        return speed / (minecartEntity.isTouchingWater() ? 40.0 : 20.0);
    }

}
