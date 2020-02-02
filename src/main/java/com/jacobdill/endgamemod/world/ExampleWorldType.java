package com.jacobdill.endgamemod.world;

import com.jacobdill.endgamemod.init.EndgameBiomes;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.provider.SingleBiomeProvider;
import net.minecraft.world.biome.provider.SingleBiomeProviderSettings;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.EndChunkGenerator;
import net.minecraft.world.gen.EndGenerationSettings;

public class ExampleWorldType extends WorldType{

	public ExampleWorldType() {
		super("ExampleType");
	}
	
	@Override
	public ChunkGenerator<?> createChunkGenerator(World world){
		EndGenerationSettings settings = new EndGenerationSettings();
		SingleBiomeProviderSettings single = new SingleBiomeProviderSettings();
		single.setBiome(EndgameBiomes.EXAMPLE_BIOME);
		return new EndChunkGenerator(world, new SingleBiomeProvider(single), settings);
	}

}
