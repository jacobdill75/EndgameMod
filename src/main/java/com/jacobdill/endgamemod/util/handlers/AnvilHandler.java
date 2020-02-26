package com.jacobdill.endgamemod.util.handlers;

import com.jacobdill.endgamemod.init.EndgameItems;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.event.entity.player.AnvilRepairEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class AnvilHandler {

	
	public AnvilHandler() {
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	//TODO: Fix Item Damage, enchantment cost, and consumption of hyde
	@SubscribeEvent
	public void onAnvilUpdate(AnvilUpdateEvent event) {
		ItemStack left = event.getLeft();
		ItemStack right = event.getRight();
		if(left.getItem() == Items.ELYTRA && right.getItem() == EndgameItems.HYDE) {
			ItemStack output = left.copy();
			event.setCanceled(false);
			output.setDamage(right.getDamage() - 87 * right.getCount());
			event.setCost((int)((1 - (right.getDamage() / 431D)) * 4));
			event.setMaterialCost(Integer.max(4, right.getCount()));
			event.setOutput(output);
		}
	}
	/*
	@SubscribeEvent
	public void onAnvilCraft(AnvilRepairEvent event) {
		if(event.getItemResult().getItem() == Items.ELYTRA && event.getItemInput().getItem() == EndgameItems.HYDE) {
			event.setCanceled(false);
		}
	}*/

}
