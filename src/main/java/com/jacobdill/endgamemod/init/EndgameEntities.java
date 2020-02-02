package com.jacobdill.endgamemod.init;

import com.jacobdill.endgamemod.entities.ExampleEntity;
import com.jacobdill.endgamemod.EndgameRegistryEvents;
import com.jacobdill.endgamemod.EndgameMod;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.biome.Biomes;

public class EndgameEntities {

	public static EntityType<?> EXAMPLE_ENTITY = EntityType.Builder.create(ExampleEntity::new, EntityClassification.CREATURE).build(EndgameMod.modid + ":example_entity").setRegistryName(EndgameRegistryEvents.location("example_entity"));
	
	public static void registryEntitySpawnEggs(final RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(
				EndgameItems.EXAMPLE_ENTITY_EGG = registerEntitySpawnEgg(EXAMPLE_ENTITY, 0x2b1c36, 0x0, "example_entity_egg")
		);
	}
	
	public static void registerEntityWorldSpawns() {
		registerEntityWorldSpawn(EXAMPLE_ENTITY, Biomes.PLAINS, Biomes.BEACH, Biomes.BIRCH_FOREST, Biomes.DESERT, Biomes.FOREST);
	}
	
	private static SpawnEggItem registerEntitySpawnEgg(EntityType<?> type, int color1, int color2, String name) {
		SpawnEggItem item = new SpawnEggItem(type, color1, color2, new Item.Properties().group(EndgameMod.endgameItemGroup));
		item.setRegistryName(EndgameRegistryEvents.location(name));
		return item;
	}
	
	private static void registerEntityWorldSpawn(EntityType<?> entity, Biome ...biomes) {
		for (Biome biome : biomes) {
			if(biome != null) {
				biome.getSpawns(entity.getClassification()).add(new SpawnListEntry(entity, 10, 1, 10));
			}
		}
	}

}
