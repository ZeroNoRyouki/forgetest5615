package test.forgetest5615;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;
import java.util.Locale;
import java.util.function.Supplier;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ExampleMod.MODID)
public class ExampleMod
{
    public static final String MODID = "forgetest5615";

    public static <T extends TileEntity> TileEntityType<T> createType(@Nonnull final String modId,
                                                                      @Nonnull final Class<? extends TileEntity> teClass,
                                                                      @Nonnull final Supplier<? extends T> teFactory) {
        return createType(new ResourceLocation(modId, teClass.getSimpleName().toLowerCase(Locale.ROOT)), teFactory);
    }

    public static <T extends TileEntity> TileEntityType<T> createType(@Nonnull final ResourceLocation id,
                                                                      @Nonnull final Supplier<? extends T> teFactory) {

        final TileEntityType.Builder<T> builder = TileEntityType.Builder.create(teFactory);
        final TileEntityType<T> type = builder.build(null);

        type.setRegistryName(id);
        return type;
    }

    public ExampleMod() {
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents1 {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {

            event.getRegistry().register(new BlockMultiblockIOPort("turbinefluidport", false));
            event.getRegistry().register(new BlockMultiblockIOPort("turbinecreativesteamgenerator", true));
        }

        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {

            event.getRegistry().register(create(Holder.turbinefluidport));
            event.getRegistry().register(create(Holder.turbinecreativesteamgenerator));
        }

        private static Item create(Block block) {
            return new ItemBlock(block, new Item.Properties().group(ItemGroup.MISC)).setRegistryName(block.getRegistryName());
        }
    }
}
