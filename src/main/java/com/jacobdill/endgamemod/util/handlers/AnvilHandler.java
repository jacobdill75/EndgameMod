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
	
	@SubscribeEvent
	public void onAnvilUpdate(AnvilUpdateEvent event) {
		ItemStack left = event.getLeft();
		ItemStack right = event.getRight();
		if(left.getItem() == Items.ELYTRA && right.getItem() == EndgameItems.HYDE) {
			ItemStack output = left.copy();
			event.setCanceled(false);
			
			int damage = left.getDamage() - (Integer.min(87 * right.getCount(),left.getDamage()));
			output.setDamage(damage);
			
			int cost = 2 * (int)Math.ceil((left.getDamage() - damage) / 87D);
			event.setCost(cost);
			
			event.setMaterialCost(Integer.min(5, right.getCount()));
			event.setOutput(output);
		}
	}

}
