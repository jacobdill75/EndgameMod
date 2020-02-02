package com.jacobdill.endgamemod.world.biomes;

import com.jacobdill.endgamemod.init.EndgameEntities;
import com.jacobdill.endgamemod.EndgameRegistryEvents;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.EndHighlandsBiome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class ExampleBiome extends EndHighlandsBiome {

	public ExampleBiome() {
		//super(
				/*new Biome.Builder()
				.surfaceBuilder(
						
				)
				.precipitation(RainType.NONE)
				.category(Category.THEEND)
				.depth(0.01F)
				.temperature(0.5F)
				.scale(0.2F)
				.downfall(0.5F)
				.waterColor(4159204)
				.waterFogColor(329011)
				.parent(null);*/
		//);
		//DefaultBiomeFeatures.addCarvers(this);
		this.addCarver(
				GenerationStage.Carving.AIR, 
				Biome.createCarver(
						WorldCarver.CAVE, 
						new ProbabilityConfig(0.25F)
				)
		);
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EndgameEntities.EXAMPLE_ENTITY, 100, 1, 5));
		this.addSpawn(EntityClassification.MONSTER, Biomes.THE_END.getSpawns(EntityClassification.MONSTER).get(0));
		
		this.setRegistryName(EndgameRegistryEvents.location("example_biome"));
	}
	/*
	@Override
	public ConfiguredSurfaceBuilder<?> getSurfaceBuilder(){
		return new ConfiguredSurfaceBuilder<SurfaceBuilderConfig>(
				(SurfaceBuilder<SurfaceBuilderConfig>)
				SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(
						BlockList.END_SOIL.getDefaultState(), 
						Blocks.END_STONE.getDefaultState(), 
						Blocks.OBSIDIAN.getDefaultState()
				)
		);
	}*/

}
