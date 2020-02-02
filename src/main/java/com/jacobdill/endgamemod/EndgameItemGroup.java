package com.jacobdill.endgamemod;

import com.jacobdill.endgamemod.init.EndgameItems;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class EndgameItemGroup extends ItemGroup{

	public EndgameItemGroup() {
		super("examplemod");
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(EndgameItems.RUBY_BLOCK); //Item.BLOCK_TO_ITEM.get(BlockList.RUBY_BLOCK)
	}

}
