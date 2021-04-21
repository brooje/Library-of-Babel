package us.brog.libraryofbabel;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import us.brog.libraryofbabel.dimension.BabelBiomes;
import us.brog.libraryofbabel.dimension.BabelDimension;
import us.brog.libraryofbabel.dimension.BabelSurfaceBuilder;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("libraryofbabel")
public class LibraryOfBabel {

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public LibraryOfBabel() {

        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);


        BabelBiomes.BIOMES.register(FMLJavaModLoadingContext.get().getModEventBus());


        BabelSurfaceBuilder.SURFACE_BUILDERS.register(FMLJavaModLoadingContext.get().getModEventBus());

        BabelDimension.setupDimension();
    }

    private void setup(final FMLCommonSetupEvent event) {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());

    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
    }


    @SubscribeEvent
    public void onRightClick(PlayerInteractEvent.RightClickBlock event) {
        // do something when the server starts
        //System.out.println("BIOME ID: " + DynamicRegistries.func_239770_b_().getRegistry(Registry.BIOME_KEY).getId(BabelBiomes.LIBRARYBIOMEKEY.get()));
    }


    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
        }

        @SubscribeEvent
        public static void onRegistry(final RegistryEvent.Register<Biome> biomeRegistryEvent) {
        }

    }
}
