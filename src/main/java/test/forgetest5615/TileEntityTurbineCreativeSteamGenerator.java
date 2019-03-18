package test.forgetest5615;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class TileEntityTurbineCreativeSteamGenerator extends TileEntity {

    public static final TileEntityType<TileEntityTurbineCreativeSteamGenerator> TILE_ENTITY_TYPE =
            ExampleMod.createType(ExampleMod.MODID, TileEntityTurbineCreativeSteamGenerator.class, TileEntityTurbineCreativeSteamGenerator::new);

    public TileEntityTurbineCreativeSteamGenerator() {
        super(TILE_ENTITY_TYPE);
    }
}
