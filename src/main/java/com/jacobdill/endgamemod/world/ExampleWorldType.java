package com.jacobdill.endgamemod.world;

import com.jacobdill.endgamemod.init.EndgameBiomes;
import com.jacobdill.endgamemod.init.EndgameBlocks;
import com.jacobdill.endgamemod.world.biomes.ExampleBiome;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.provider.EndBiomeProvider;
import net.minecraft.world.biome.provider.EndBiomeProviderSettings;
import net.minecraft.world.biome.provider.SingleBiomeProvider;
import net.minecraft.world.biome.provider.SingleBiomeProviderSettings;
import net.minecraft.world.dimension.EndDimension;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.ChunkGeneratorType;
import net.minecraft.world.gen.EndChunkGenerator;
import net.minecraft.world.gen.EndGenerationSettings;

public class ExampleWorldType extends WorldType{

	public ExampleWorldType() {
		super("endgamemod");
	}
	
	@Override
	public ChunkGenerator<?> createChunkGenerator(World world){
		if(world.getDimension() instanceof EndDimension) {
		EndGenerationSettings settings = ChunkGeneratorType.FLOATING_ISLANDS.createSettings();
		EndBiomeProviderSettings single = new EndBiomeProviderSettings();
		settings.setDefaultBlock(EndgameBlocks.END_SOIL.getDefaultState());
		settings.setDefaultFluid(Blocks.AIR.getDefaultState());
		//single.setBiome(EndgameBiomes.EXAMPLE_BIOME);
		//single.setBiome(Biomes.END_HIGHLANDS);
		return ChunkGeneratorType.FLOATING_ISLANDS.create(world, new ExampleBiomeProvider(single), settings);
		}else return super.createChunkGenerator(world);
	}
	
	public class ExampleBiomeProvider extends EndBiomeProvider{

		public ExampleBiomeProvider(EndBiomeProviderSettings p_i48970_1_) {
			super(p_i48970_1_);
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public List<Biome> getBiomesToSpawnIn() {
			List<Biome> biomes = new ArrayList<Biome>();//super.getBiomesToSpawnIn();
			biomes.add(new ExampleBiome());
			return biomes;
		}
		
	}

}
