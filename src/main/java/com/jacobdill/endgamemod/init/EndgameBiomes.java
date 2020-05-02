package com.jacobdill.endgamemod.init;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;

public abstract class EndgameBiomes {

	public static Biome END_FIELD;

	public static void registerBiomes() {
		registerBiome(END_FIELD, Type.END);
	}
	
	public static void registerBiome(Biome biome, Type... types) {
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addSpawnBiome(biome);
	}
	
}
