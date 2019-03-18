package test.forgetest5615;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.state.StateContainer;

import javax.annotation.Nonnull;

public class BlockMultiblockDevice extends Block {

    public BlockMultiblockDevice(String blockName) {

        super(Block.Properties.create(Material.IRON));
        this.setRegistryName(blockName);
        this.setDefaultState(this.buildDefaultState(this.getStateContainer().getBaseState()));
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    //region internals

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, IBlockState> builder) {
        this.buildBlockState(builder);
    }

    protected void buildBlockState(@Nonnull final StateContainer.Builder<Block, IBlockState> builder) {
        builder.add(BlockStateProperties.PARTSTATE);
    }

    protected IBlockState buildDefaultState(IBlockState state) {
        return state.with(BlockStateProperties.PARTSTATE, MachinePartState.Disassembled);
    }
}
