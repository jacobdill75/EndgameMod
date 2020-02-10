package com.jacobdill.endgamemod.world.biomes;

import com.jacobdill.endgamemod.init.EndgameEntities;

import com.jacobdill.endgamemod.EndgameRegistryEvents;

import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.EndHighlandsBiome;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;

public class ExampleBiome extends EndHighlandsBiome {
	
	public ExampleBiome() {
		super();
		/*super(
				new Biome.Builder()
				.surfaceBuilder(SurfaceBuilder.NETHER, SurfaceBuilder.NETHERRACK_CONFIG)
				.precipitation(RainType.NONE)
				.category(Category.THEEND)
				.depth(0.01F)
				.temperature(0.5F)
				.scale(0.2F)
				.downfall(0.5F)
				.waterColor(4159204)
				.waterFogColor(329011)
				.parent(null)
		);*/
		//DefaultBiomeFeatures.addCarvers(this);
		/*this.addCarver(
				GenerationStage.Carving.AIR, 
				Biome.createCarver(
						WorldCarver.HELL_CAVE, 
						new ProbabilityConfig(0.2F)
				)
		);*/
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EndgameEntities.EXAMPLE_ENTITY, 100, 1, 5));
		this.addSpawn(EntityClassification.MONSTER, Biomes.THE_END.getSpawns(EntityClassification.MONSTER).get(0));
		
		this.setRegistryName(EndgameRegistryEvents.location("example_biome"));
		
	}
}
