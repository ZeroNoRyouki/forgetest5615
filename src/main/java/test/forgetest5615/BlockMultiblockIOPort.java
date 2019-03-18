package test.forgetest5615;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class BlockMultiblockIOPort extends BlockMultiblockDevice {

    public BlockMultiblockIOPort(String blockName, boolean isCreative) {

        super(blockName);
        this.fakeTypeCreative = isCreative;
    }

    @Override
    public boolean onBlockActivated(IBlockState state, World world, BlockPos pos, EntityPlayer player, EnumHand hand,
                                    EnumFacing side, float hitX, float hitY, float hitZ) {

        if (player.isSneaking()) {

            final TileEntity te = world.getTileEntity(pos);

            if (te instanceof TileEntityTurbineFluidPort) {

                state = state.cycle(BlockStateProperties.PORTDIRECTION);
                world.setBlockState(pos, state, 1|2);
                return true;
            }
        } else {

            state = state.cycle(BlockStateProperties.PARTSTATE);
            world.setBlockState(pos, state, 1|2);
            return true;
        }

        return super.onBlockActivated(state, world, pos, player, hand, side, hitX, hitY, hitZ);
    }

    @Override
    public TileEntity createTileEntity(IBlockState state, IBlockReader world) {
        return this.fakeTypeCreative ? new TileEntityTurbineCreativeSteamGenerator() : new TileEntityTurbineFluidPort();
    }

    //region internals

    @Override
    protected void buildBlockState(@Nonnull final StateContainer.Builder<Block, IBlockState> builder) {

        super.buildBlockState(builder);
        builder.add(BlockStateProperties.PORTDIRECTION);
    }

    @Override
    protected IBlockState buildDefaultState(IBlockState state) {
        return super.buildDefaultState(state).with(BlockStateProperties.PORTDIRECTION, PortDirection.Inlet);
    }

    private boolean fakeTypeCreative;
}
