package us.brog.libraryofbabel.mixin.dimension;

import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(ChunkGenerator.class)
public interface ChunkGeneratorMixins {
    @Accessor("biomeProvider")
    BiomeProvider lob_getbiomeProvider();

    @Accessor("settings")
    DimensionStructuresSettings lob_getsettings();

    @Invoker("func_235957_b_")
    DimensionStructuresSettings lob_invokefunc_235957_b_();
}
