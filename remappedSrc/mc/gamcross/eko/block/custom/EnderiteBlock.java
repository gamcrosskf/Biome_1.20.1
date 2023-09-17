package mc.gamcross.eko.block.custom;

import mc.gamcross.eko.block.EkoBlocks;
import mc.gamcross.eko.world.dimension.EkoDimensions;
import net.minecraft.block.Block;
import net.minecraft.util.ActionResult;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EnderiteBlock extends Block {
    public EnderiteBlock(Settings settings) {
        super(settings);
    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            if (!player.isSneaking()) {
                MinecraftServer server = world.getServer();
                if (server != null) {
                    if (player instanceof ServerPlayerEntity serverPlayer) {
                        if (world.getRegistryKey() == EkoDimensions.OPAL_KEY) {
                            ServerWorld overWorld = server.getWorld(World.OVERWORLD);
                            if (overWorld != null) {
                                BlockPos destPos = getDest(player.getBlockPos(), overWorld, false);
                                serverPlayer.teleport(overWorld, destPos.getX(), destPos.getY(), destPos.getZ(),
                                        serverPlayer.bodyYaw, serverPlayer.prevPitch);
                            }
                        } else {
                            ServerWorld kjdim = server.getWorld(EkoDimensions.OPAL_KEY);
                            if (kjdim != null) {
                                BlockPos destPos = getDest(serverPlayer.getBlockPos(), kjdim, true);
                                boolean doSetBlock = true;
                                for (BlockPos checkPos : BlockPos.iterate(destPos.down(10)
                                        .west(10).south(10), destPos.up(10).east(10).north(10))) {
                                    if (kjdim.getBlockState(checkPos).getBlock() == EkoBlocks.ENDERITE_BLOCK) {
                                        doSetBlock = false;
                                        break;
                                    }
                                }
                                if (doSetBlock) {
                                    kjdim.setBlockState(destPos, EkoBlocks.ENDERITE_BLOCK.getDefaultState());
                                }
                                serverPlayer.teleport(kjdim, destPos.getX(), destPos.getY(), destPos.getZ(),
                                        serverPlayer.bodyYaw, serverPlayer.prevPitch);
                            }
                        }
                        return ActionResult.SUCCESS;
                    }
                }
            }
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }

    public static BlockPos getDest(BlockPos pos, World destWorld, boolean isInDimension) {
        int y = 61;

        if (!isInDimension) {
            y = pos.getY();
        }

        BlockPos destPos = new BlockPos(pos.getX(), y, pos.getZ());
        int tries = 0;
        while ((!destWorld.getBlockState(destPos).isAir() && !destWorld.getBlockState(destPos)
                .canBucketPlace(Fluids.WATER)) &&
                (!destWorld.getBlockState(destPos.up()).isAir() && !destWorld.getBlockState(destPos.up())
                        .canBucketPlace(Fluids.WATER)) && tries < 25) {
            destPos = destPos.up(2);
            tries++;
        }

        return destPos;
    }

}
