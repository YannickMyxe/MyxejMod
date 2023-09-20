package com.myxej.myxejmod.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class BasicBlock extends Block {

    public BasicBlock() {
        // Let our block behave like a metal block
        super(Properties.of()
                .strength(3.5F)
                .sound(SoundType.METAL)
                .randomTicks()
        );
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (level.isClientSide) {
            level.explode(null, pos.getX() + .5, pos.getY() + .5, pos.getZ() + .5, 2f, false, Level.ExplosionInteraction.MOB);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }
}
