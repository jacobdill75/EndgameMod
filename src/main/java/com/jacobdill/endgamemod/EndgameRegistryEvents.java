package com.jacobdill.endgamemod;

import org.apache.logging.log4j.Logger;

import com.jacobdill.endgamemod.init.EndgameBiomes;
import com.jacobdill.endgamemod.init.EndgameBlocks;
import com.jacobdill.endgamemod.init.EndgameEntities;
import com.jacobdill.endgamemod.init.EndgameItems;
import com.jacobdill.endgamemod.init.EndgameToolMaterials;
import com.jacobdill.endgamemod.util.handlers.AnvilHandler;
import com.jacobdill.endgamemod.util.handlers.DeathHandler;
import com.jacobdill.endgamemod.util.handlers.LavaResistHandler;
import com.jacobdill.endgamemod.util.handlers.LootHandler;
import com.jacobdill.endgamemod.util.handlers.SoundsHandler;
import com.jacobdill.endgamemod.world.biomes.EndFieldBiome;

import net.minecraft.block.Block;
import net.minecraft.block.GrassBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

//You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
// Event bus for receiving Registry Events)
@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public abstract class EndgameRegistryEvents {
    
	public static final Logger LOGGER = EndgameMod.LOGGER;
	public static final ItemGroup endgameItemGroup = EndgameMod.endgameItemGroup;
	
	static {
		new AnvilHandler();
		new LootHandler();
		new DeathHandler();
		new LavaResistHandler();
	}
	
	@SubscribeEvent
    public static void onItemRegistry(final RegistryEvent.Register<Item> itemRegistryEvent) {
        
		
		itemRegistryEvent.getRegistry().registerAll(
				
				EndgameItems.RUBY = new Item(new Item.Properties().group(ItemGroup.MISC).group(endgameItemGroup)).setRegistryName(location("ruby_item")),
	    		EndgameItems.RUBY_BLOCK = new BlockItem(EndgameBlocks.RUBY_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS).group(endgameItemGroup)).setRegistryName(EndgameBlocks.RUBY_BLOCK.getRegistryName()),
	    		EndgameItems.END_SOIL = new BlockItem(EndgameBlocks.END_SOIL, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS).group(endgameItemGroup)).setRegistryName(EndgameBlocks.END_SOIL.getRegistryName()),
	    		EndgameItems.PURPUREUS = new BlockItem(EndgameBlocks.PURPUREUS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS).group(endgameItemGroup)).setRegistryName(EndgameBlocks.PURPUREUS.getRegistryName()),
	    		EndgameItems.OLIVA = new BlockItem(EndgameBlocks.OLIVA, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS).group(endgameItemGroup)).setRegistryName(EndgameBlocks.OLIVA.getRegistryName()),
	    		EndgameItems.HYDE = new Item(new Item.Properties().group(ItemGroup.MISC).group(endgameItemGroup)).setRegistryName(location("hyde")),
	   
	    		EndgameItems.OBSIDIAN_INGOT = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("obsidian_ingot")),
	    		EndgameItems.OBSIDIAN_SWORD = new SwordItem(EndgameToolMaterials.obsidian, 0, 6.0f, new Item.Properties().group(ItemGroup.COMBAT).group(endgameItemGroup)).setRegistryName(location("obsidian_sword")),
	    	    EndgameItems.OBSIDIAN_SHOVEL = new ShovelItem(EndgameToolMaterials.obsidian, -1.0f, 6.0f, new Item.Properties().group(ItemGroup.TOOLS).group(endgameItemGroup)).setRegistryName(location("obsidian_shovel")),
	    	    EndgameItems.OBSIDIAN_PICKAXE = new PickaxeItem(EndgameToolMaterials.obsidian, -2, 6.0f, new Item.Properties().group(ItemGroup.TOOLS).group(endgameItemGroup)).setRegistryName(location("obsidian_pickaxe")),
	    		EndgameItems.OBSIDIAN_AXE = new AxeItem(EndgameToolMaterials.obsidian, -1.0f, 6.0f, new Item.Properties().group(ItemGroup.TOOLS).group(endgameItemGroup)).setRegistryName(location("obsidian_axe")),
	    		EndgameItems.OBSIDIAN_HOE = new HoeItem(EndgameToolMaterials.obsidian, 6.0f, new Item.Properties().group(ItemGroup.TOOLS).group(endgameItemGroup)).setRegistryName(location("obsidian_hoe"))
	    		
	    		
		);
		
		EndgameEntities.registryEntitySpawnEggs(itemRegistryEvent);
    }
	
	@SubscribeEvent
    public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
        // register a new block here
		
		blockRegistryEvent.getRegistry().registerAll(
				
				EndgameBlocks.RUBY_BLOCK = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5f, 30f).harvestTool(ToolType.PICKAXE).lightValue(0).sound(SoundType.METAL)).setRegistryName(location("ruby_block")),
				EndgameBlocks.END_SOIL = new Block(Block.Properties.create(Material.EARTH).hardnessAndResistance(0.5f).harvestTool(ToolType.SHOVEL).lightValue(0).sound(SoundType.GROUND)).setRegistryName(location("end_soil")),
				EndgameBlocks.PURPUREUS = new GrassBlock(Block.Properties.create(Material.ORGANIC).tickRandomly().hardnessAndResistance(0.5F).harvestTool(ToolType.SHOVEL).sound(SoundType.PLANT)).setRegistryName("purpureus"),
				EndgameBlocks.OLIVA = new GrassBlock(Block.Properties.create(Material.ORGANIC).tickRandomly().hardnessAndResistance(0.5F).harvestTool(ToolType.SHOVEL).sound(SoundType.PLANT)).setRegistryName("oliva")
				
		);
		
    }
	
	@SubscribeEvent
	public static void onEntitiesRegistry(final RegistryEvent.Register<EntityType<?>> entityRegistryEvent) {
		entityRegistryEvent.getRegistry().registerAll(
				EndgameEntities.BRAHMIN
		);
		
		EndgameEntities.registerEntityWorldSpawns();
	}
	
	@SubscribeEvent
	public static void onBiomesRegistry(final RegistryEvent.Register<Biome> biomeRegistryEvent) {
		biomeRegistryEvent.getRegistry().registerAll(
				EndgameBiomes.END_FIELD = new EndFieldBiome()
		);
		for(Biome biome : ForgeRegistries.BIOMES) {
			if (biome == Biomes.END_BARRENS || biome == Biomes.SMALL_END_ISLANDS || biome == Biomes.END_MIDLANDS)
				biome.getSpawns(EntityClassification.MONSTER).add(new SpawnListEntry(EntityType.PHANTOM, 20, 1, 2));
		}
		EndgameBiomes.registerBiomes();
	}
	
	@SubscribeEvent
    public void registerSoundEvents(RegistryEvent.Register<SoundEvent> event) {
		event.getRegistry().registerAll(
    		   SoundsHandler.BRAHMIN_MOO,
    		   SoundsHandler.BRAHMIN_HURT,
    		   SoundsHandler.BRAHMIN_DEATH1,
    		   SoundsHandler.BRAHMIN_DEATH2
       );
    }
	
	/*
	//@OnlyIn(Dist.DEDICATED_SERVER)
	@SubscribeEvent
	public static void onBlockBreak(BreakEvent blockBreakEvent) {
		LOGGER.info("BLOCK BROKEN");
		if(blockBreakEvent.getState().getBlock() == BlockList.END_SOIL && blockBreakEvent.getWorld().getRandom().nextInt(100) < 100) {
			LOGGER.info("ENDSOIL BROKEN");
			EndermiteEntity endermite = new EndermiteEntity(EntityType.ENDERMITE, blockBreakEvent.getPlayer().getEntityWorld());
			endermite.setPosition(blockBreakEvent.getPos().getX() + 0.5, blockBreakEvent.getPos().getY() + 0.5, blockBreakEvent.getPos().getZ() + 0.5);
			LOGGER.info("Endermite position at:" + Double.toString(endermite.getPosition().getX()) + ", "+ Double.toString(endermite.getPosition().getY()) + ", " + Double.toString(endermite.getPosition().getZ()) + ", ");
			blockBreakEvent.getPlayer().addExperienceLevel(20);
			blockBreakEvent.getPlayer().sendMessage(new TranslationTextComponent("Created a MITE!"));
			blockBreakEvent.getWorld().addEntity(endermite);
		}
		
	}
	*/
	
	public static ResourceLocation location(String name) {
    	return new ResourceLocation(EndgameMod.modid, name);
    }
}
