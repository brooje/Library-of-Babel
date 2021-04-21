package us.brog.libraryofbabel.dimension;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import us.brog.libraryofbabel.mixin.dimension.ChunkGeneratorMixins;

public class BabelGenerator extends ChunkGenerator  {

    public static final Codec<DimensionStructuresSettings> BABEL_SETTINGS_CODEC = (DimensionStructuresSettings.field_236190_a_);



    public static final Codec<ChunkGenerator> CODEC = RecordCodecBuilder.create((chunkGeneratorInstance) -> chunkGeneratorInstance.group(
            BiomeProvider.CODEC.fieldOf("biome_source").forGetter((chunkGenerator) -> ((ChunkGeneratorMixins)chunkGenerator).lob_getbiomeProvider()),
            BABEL_SETTINGS_CODEC.fieldOf("settings").forGetter((chunkGenerator) -> ((ChunkGeneratorMixins)chunkGenerator).lob_invokefunc_235957_b_()))
            .apply(chunkGeneratorInstance, chunkGeneratorInstance.stable(BabelGenerator::new)));



    public BabelGenerator(BiomeProvider biomeProvider, DimensionStructuresSettings dimensionStructuresSettings) {
        super(biomeProvider, dimensionStructuresSettings);
    }



    @Override
    protected Codec<? extends ChunkGenerator> func_230347_a_() {
        return CODEC;
    }

    @Override
    public ChunkGenerator func_230349_a_(long seed) {
        return new BabelGenerator(this.biomeProvider.getBiomeProvider(seed), ((ChunkGeneratorMixins)this).lob_getsettings());
    }

    @Override
    public void generateSurface(WorldGenRegion p_225551_1_, IChunk chunk) {
        for(int xInChunk = 0; xInChunk < 16; xInChunk++) {
            for (int zInChunk = 0; zInChunk < 16; zInChunk++) {
                chunk.setBlockState(new BlockPos(xInChunk, 1, zInChunk), Blocks.OAK_PLANKS.getDefaultState(), false);
            }
        }
    }

    @Override
    public void func_230352_b_(IWorld p_230352_1_, StructureManager p_230352_2_, IChunk p_230352_3_) {

    }

    @Override
    public int getHeight(int x, int z, Heightmap.Type heightmapType) {
        return 0;
    }

    @Override
    public IBlockReader func_230348_a_(int p_230348_1_, int p_230348_2_) {
        return null;
    }
}
