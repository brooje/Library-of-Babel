package us.brog.libraryofbabel.dimension;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.TickEvent;
import us.brog.libraryofbabel.dimension.BabelBiomeProvider;
import us.brog.libraryofbabel.dimension.BabelGenerator;

public class BabelDimension {
    public static final RegistryKey<World> BABEL_WORLD_KEY = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("libraryofbabel", "libraryofbabel"));

    public static void setupDimension() {
        Registry.register(Registry.CHUNK_GENERATOR_CODEC, new ResourceLocation("libraryofbabel", "terrain"), BabelGenerator.CODEC);
        Registry.register(Registry.BIOME_PROVIDER_CODEC, new ResourceLocation("libraryofbabel", "biome_source"), BabelBiomeProvider.CODEC);
    }
}