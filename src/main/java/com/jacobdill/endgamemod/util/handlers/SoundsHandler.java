package com.jacobdill.endgamemod.util.handlers;

import com.jacobdill.endgamemod.EndgameMod;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundsHandler {

	public static SoundEvent ENTITY_EXAMPLE_MOO = SoundsHandler.initSound("entity.example.moo"),
							 ENTITY_EXAMPLE_HURT = SoundsHandler.initSound("entity.example.hurt"),
							 ENTITY_EXAMPLE_DEATH = SoundsHandler.initSound("entity.example.death");
	
	public static SoundEvent initSound(String name) {
		ResourceLocation location = new ResourceLocation(EndgameMod.modid, name);
		SoundEvent event = new SoundEvent(location);
		event.setRegistryName(name);
		return event;
	}
}
