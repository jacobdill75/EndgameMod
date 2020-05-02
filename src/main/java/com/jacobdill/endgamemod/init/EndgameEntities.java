package com.jacobdill.endgamemod.init;

import com.jacobdill.endgamemod.entities.BrahminEntity;
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

	public static EntityType<?> BRAHMIN = EntityType.Builder.create(BrahminEntity::new, EntityClassification.CREATURE).build(EndgameMod.modid + ":brahmin").setRegistryName(EndgameRegistryEvents.location("brahmin"));
	
	public static void registryEntitySpawnEggs(final RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(
				EndgameItems.BRAHMIN_EGG = registerEntitySpawnEgg(BRAHMIN, 0x2b1c36, 0x0, "brahmin_egg")
		);
	}
	
	public static void registerEntityWorldSpawns() {
		registerEntityWorldSpawn(BRAHMIN, EndgameBiomes.END_FIELD, Biomes.END_HIGHLANDS);
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
