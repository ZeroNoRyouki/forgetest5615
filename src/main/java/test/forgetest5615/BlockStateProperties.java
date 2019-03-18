package test.forgetest5615;

import net.minecraft.state.EnumProperty;

public final class BlockStateProperties {

    public static final EnumProperty<MachinePartState> PARTSTATE = EnumProperty.create("afstate", MachinePartState.class);
    public static final EnumProperty<PortDirection> PORTDIRECTION = EnumProperty.create("portdirection", PortDirection.class);

    private BlockStateProperties() {
    }
}
