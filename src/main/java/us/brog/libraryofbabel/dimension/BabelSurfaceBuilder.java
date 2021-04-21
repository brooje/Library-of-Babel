package us.brog.libraryofbabel.dimension;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeMaker;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Random;

public class BabelSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {

    public static final DeferredRegister<SurfaceBuilder<?>> SURFACE_BUILDERS = DeferredRegister.create(ForgeRegistries.SURFACE_BUILDERS, "libraryofbabel");

    public static final RegistryObject<SurfaceBuilder<?>> LIBRARYSURFACEGEN = register("librarybuilder");

    public BabelSurfaceBuilder() {
        super(SurfaceBuilderConfig.CODEC);
    }

    private static RegistryObject<SurfaceBuilder<?>> register(String name) {
        return SURFACE_BUILDERS.register(name, BabelSurfaceBuilder::new);
    }


    @Override
    public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {

    }
}
