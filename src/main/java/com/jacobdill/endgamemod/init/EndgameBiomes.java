package com.jacobdill.endgamemod.init;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

public abstract class EndgameBiomes {

	public static Biome EXAMPLE_BIOME;

	public static void registerBiomes() {
		registerBiome(EXAMPLE_BIOME, Type.END);
	}
	
	public static void registerBiome(Biome biome, Type... types) {
		BiomeDictionary.addTypes(biome, types);
	}
	
}
