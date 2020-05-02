package com.jacobdill.endgamemod.util.handlers;

import com.jacobdill.endgamemod.EndgameMod;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class SoundsHandler {

	public static SoundEvent BRAHMIN_MOO = SoundsHandler.initSound("entity.brahmin.moo"),
							 BRAHMIN_HURT = SoundsHandler.initSound("entity.brahmin.hurt"),
							 BRAHMIN_DEATH1 = SoundsHandler.initSound("entity.brahmin.death1"),
							 BRAHMIN_DEATH2 = SoundsHandler.initSound("entity.brahmin.death2");
	
	public static SoundEvent initSound(String name) {
		ResourceLocation location = new ResourceLocation(EndgameMod.modid, name);
		SoundEvent event = new SoundEvent(location);
		event.setRegistryName(name);
		return event;
	}
}
