package com.jacobdill.endgamemod.util.handlers;

import java.util.ArrayList;
import java.util.List;

import com.jacobdill.endgamemod.EndgameMod;
import com.jacobdill.endgamemod.init.EndgameItems;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent.WorldTickEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EndgameMod.modid)
public class LavaResistHandler {

	public List<ItemEntity> fireproofEntities = new ArrayList<ItemEntity>();
	
	public LavaResistHandler() {
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	@SubscribeEvent
	public void onItemSpawn(EntityJoinWorldEvent event) {
		Entity entity = event.getEntity();
		if(entity instanceof ItemEntity && isItemFireProof((ItemEntity) entity)) {
			entity.setInvulnerable(true);
			fireproofEntities.add((ItemEntity)entity);
		}
	}
	
	@SubscribeEvent
	public void onWorldTick(WorldTickEvent event) {
		List<ItemEntity> toRemove = new ArrayList<ItemEntity>();
		for(ItemEntity entity : fireproofEntities) {
			if(entity.isAlive()) {
				entity.extinguish();
				if(entity.isInLava())
					entity.setVelocity(0, 0.4, 0);
			}
			else
				toRemove.add(entity);
				
		}
		fireproofEntities.removeAll(toRemove);
	}
	
	public boolean isItemFireProof(ItemEntity item) {
		return (item.getItem().getItem() == EndgameItems.OBSIDIAN_AXE
		     || item.getItem().getItem() == EndgameItems.OBSIDIAN_PICKAXE
		     || item.getItem().getItem() == EndgameItems.OBSIDIAN_SHOVEL
		     || item.getItem().getItem() == EndgameItems.OBSIDIAN_HOE
		     || item.getItem().getItem() == EndgameItems.OBSIDIAN_SWORD);
	}
	
	
	
}
