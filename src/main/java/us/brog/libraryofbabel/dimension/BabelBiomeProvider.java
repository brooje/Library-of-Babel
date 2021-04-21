package us.brog.libraryofbabel.dimension;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryLookupCodec;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeContainer;
import net.minecraft.world.biome.BiomeRegistry;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.provider.BiomeProvider;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BabelBiomeProvider extends BiomeProvider {


    public static final Codec<BabelBiomeProvider> CODEC =
            RecordCodecBuilder.create((instance) -> instance.group(
                    Biome.CODEC.listOf().fieldOf("biomes").forGetter((BabelBiomeProvider b) -> b.biomes)).apply(instance, instance.stable(BabelBiomeProvider::new)));



    protected BabelBiomeProvider(List<Biome> biomes) {
        super(biomes);
    }

    @Override
    protected Codec<? extends BiomeProvider> getBiomeProviderCodec() {
        return CODEC;
    }

    @Override
    public BiomeProvider getBiomeProvider(long seed) {
        return this;
    }


    @Override
    public Biome getNoiseBiome(int x, int y, int z) {
        return WorldGenRegistries.BIOME.getValueForKey(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation("libraryofbabel", "library")));
    }
}
