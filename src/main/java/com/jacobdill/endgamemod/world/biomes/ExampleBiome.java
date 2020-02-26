package com.jacobdill.endgamemod.world.biomes;

import com.jacobdill.endgamemod.init.EndgameBlocks;
import com.jacobdill.endgamemod.init.EndgameEntities;
import com.jacobdill.endgamemod.EndgameRegistryEvents;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class ExampleBiome extends Biome {
	
	private static BlockState PURPUREUS = EndgameBlocks.PURPUREUS.getDefaultState(), END_SOIL = EndgameBlocks.END_SOIL.getDefaultState(), OBSIDIAN = Blocks.OBSIDIAN.getDefaultState();
	
	public ExampleBiome() {
		super((new Builder())
				.surfaceBuilder(new ConfiguredSurfaceBuilder<>(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(PURPUREUS, END_SOIL, OBSIDIAN)))
				.precipitation(RainType.NONE)
				.category(Category.THEEND)
				.depth(0.1F)
				.scale(0.2F)
				.temperature(0.5F)
				.downfall(0.5F)
				.waterColor(4159204)
				.waterFogColor(329011)
				.parent(null)
		);
		DefaultBiomeFeatures.func_225489_aq(this);
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
