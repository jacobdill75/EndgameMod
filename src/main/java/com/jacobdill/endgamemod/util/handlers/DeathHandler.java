package com.jacobdill.endgamemod.util.handlers;

import java.util.Random;

import com.jacobdill.endgamemod.EndgameMod;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EndgameMod.modid)
public class DeathHandler {
	
	Random rand = new Random();
	
	public DeathHandler() {
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	@SubscribeEvent
	public void onLivingDeath(LivingDamageEvent event) {
		Entity entity = event.getEntity();
		if(entity instanceof PlayerEntity && event.getSource().equals(DamageSource.OUT_OF_WORLD)) {
			if (((PlayerEntity) entity).getHeldItemOffhand().getItem() == Items.TOTEM_OF_UNDYING || ((PlayerEntity) entity).getHeldItemMainhand().getItem() == Items.TOTEM_OF_UNDYING) 
			{
				for(int i = 0; i < 16; ++i) {
		            if (teleportRandomly((PlayerEntity)entity, 1.0D)) {
		            	event.setCanceled(true);
		            	return;
		            }
		    	}
			}
		}
	}
	
	protected boolean teleportRandomly(PlayerEntity player, double scale) {
		  
	      double d0 = player.posX + scale * (rand.nextDouble() - 0.5D) * 64.0D;
	      double d1 = 70.0D;
	      double d2 = player.posZ + scale * (this.rand.nextDouble() - 0.5D) * 64.0D;
	      return this.teleportTo(player, d0, d1, d2);
	   }
	
	private boolean teleportTo(PlayerEntity player, double x, double y, double z) {
	      BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos(x, y, z);

	      while(blockpos$mutableblockpos.getY() > 0 && !player.world.getBlockState(blockpos$mutableblockpos).getMaterial().blocksMovement()) {
	         blockpos$mutableblockpos.move(Direction.DOWN);
	      }

	      if (!player.world.getBlockState(blockpos$mutableblockpos).getMaterial().blocksMovement()) {
	         return false;
	      } else {
	         net.minecraftforge.event.entity.living.EnderTeleportEvent event = new net.minecraftforge.event.entity.living.EnderTeleportEvent(player, x, y, z, 0);
	         if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event)) return false;
	         return player.attemptTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ(), true);
	      }
	   }
}
