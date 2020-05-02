package com.jacobdill.endgamemod.util.handlers;

import com.jacobdill.endgamemod.EndgameMod;
import com.jacobdill.endgamemod.EndgameRegistryEvents;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.TableLootEntry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EndgameMod.modid)
public class LootHandler {

	public LootHandler() {
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	@SubscribeEvent
	public static void lootLoad(LootTableLoadEvent evt) {
		String prefix = "minecraft:chests/";
		String name = evt.getName().toString();

		if (name.startsWith(prefix)) {
			String file = name.substring(name.indexOf(prefix) + prefix.length());
			switch (file) {
			/*case "abandoned_mineshaft":
			case "desert_pyramid":
			case "jungle_temple":
			case "simple_dungeon":
			case "spawn_bonus_chest":*/
			case "end_city_treasure":
			case "stronghold_corridor":
			//case "village_blacksmith":
				evt.getTable().addPool(getInjectPool(file));
				break;
			default:
				break;
			}
		}
	}

	public static LootPool getInjectPool(String entryName) {
		return LootPool.builder()
				.addEntry(getInjectEntry(entryName, 1))
				.bonusRolls(0, 1)
				.name("endgamemod_inject")
				.build();
	}

	@SuppressWarnings("rawtypes")
	private static LootEntry.Builder getInjectEntry(String name, int weight) {
		ResourceLocation table = EndgameRegistryEvents.location("inject/" + name);
		return TableLootEntry.builder(table)
				.weight(weight);
	}
	
}
