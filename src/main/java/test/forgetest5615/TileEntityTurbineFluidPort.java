package test.forgetest5615;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class TileEntityTurbineFluidPort extends TileEntity implements IInputOutputPort {

    public static final TileEntityType<TileEntityTurbineFluidPort> TILE_ENTITY_TYPE =
            ExampleMod.createType(ExampleMod.MODID, TileEntityTurbineFluidPort.class, TileEntityTurbineFluidPort::new);

    public TileEntityTurbineFluidPort() {

        super(TILE_ENTITY_TYPE);
        this._direction = Direction.Input;
    }

    @Override
    public Direction getDirection() {
        return this._direction;
    }

    @Override
    public void setDirection(Direction direction, boolean markForUpdate) {

        if (direction == this._direction)
            return;

        this._direction = direction;
    }

    @Override
    public void toggleDirection(boolean markForUpdate) {
        this.setDirection(this._direction.opposite(), markForUpdate);
    }

    private Direction _direction;
}
