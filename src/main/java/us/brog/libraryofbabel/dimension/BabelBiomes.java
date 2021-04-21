package us.brog.libraryofbabel.dimension;

import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeMaker;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class BabelBiomes {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, "libraryofbabel");

    public static RegistryObject<Biome>  LIBRARYBIOMEKEY = createBiome("library", BiomeMaker::makeVoidBiome);


    public static RegistryObject<Biome> createBiome(String name, Supplier<Biome> biome) {
        RegistryObject<Biome> biomeRegistryObject = BIOMES.register(name, biome);
        return biomeRegistryObject;
    }
}