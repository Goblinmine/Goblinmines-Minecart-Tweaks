package net.goblinmine.gmt.mixin;

import net.goblinmine.gmt.GoblinminesMinecartTweaks;
import net.minecraft.block.BlockState;
import net.minecraft.entity.vehicle.AbstractMinecartEntity;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractMinecartEntity.class)
public class AbstractMinecartEntityMixin {
    @Inject(method = "moveOnRail", at = @At("RETURN"))
    private void injectAtMoveOnRail(BlockPos pos, BlockState state, CallbackInfo info){
        GoblinminesMinecartTweaks.LOGGER.info("This line is printed by an example mod mixin!");
    }
}
