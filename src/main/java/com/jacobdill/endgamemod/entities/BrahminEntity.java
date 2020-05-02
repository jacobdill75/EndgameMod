package com.jacobdill.endgamemod.entities;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

import com.jacobdill.endgamemod.init.EndgameBlocks;
import com.jacobdill.endgamemod.init.EndgameItems;
import com.jacobdill.endgamemod.util.handlers.SoundsHandler;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.BreakBlockGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.PrioritizedGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.Ingredient.IItemList;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.IndirectEntityDamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BrahminEntity extends CowEntity{ //CreatureEntity

	/*@SuppressWarnings("unchecked")
	protected ExampleEntity(EntityType<? extends CreatureEntity> type, World worldIn) {
		super((EntityType<? extends CreatureEntity>) ExampleEntities.EXAMPLE_ENTITY,worldIn); //extends CreatureEntity
	}*/
	
	public BrahminEntity(EntityType<? extends CowEntity> type, World worldIn) {
		super(type, worldIn);
	}
		
	@Override
	public void livingTick() {
		if (this.world.isRemote) {
	         for(int i = 0; i < 2; ++i) {
	            this.world.addParticle(ParticleTypes.PORTAL, this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.getWidth(), this.posY + this.rand.nextDouble() * (double)this.getHeight() - 0.25D, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.getWidth(), (this.rand.nextDouble() - 0.5D) * 2.0D, -this.rand.nextDouble(), (this.rand.nextDouble() - 0.5D) * 2.0D);
	         }
	      }
		super.livingTick();
		if(this.rand.nextInt(240) == 10)
			try{this.teleportRandomly(0.25D);}catch(Exception e) {}
		
	}
	
	@Override
	protected void registerGoals(){
		this.goalSelector.addGoal(0,(new SwimGoal(this)));
		this.goalSelector.addGoal(1, new PanicGoal(this, 2D));
		this.goalSelector.addGoal(2, new TemptGoal(this, 1.5D, Ingredient.fromItemListStream(Arrays.asList(new Ingredient.SingleItemList(new ItemStack(EndgameItems.RUBY_BLOCK))).stream()), false));
		this.goalSelector.addGoal(3, new BreakBlockGoal(EndgameBlocks.RUBY_BLOCK, this, -1D, 64));
		this.goalSelector.addGoal(3, new RandomWalkingGoal(this, 1.2d));
		this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
		
	}
	
	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public CowEntity createChild(AgeableEntity ageable) {
		return new BrahminEntity((EntityType<? extends CowEntity>)super.getType(), super.world);
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		return SoundsHandler.BRAHMIN_MOO;
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return SoundsHandler.BRAHMIN_HURT;
	}
	
	@Override
	protected SoundEvent getDeathSound() {
		return this.rand.nextInt(10) < 5 ? SoundsHandler.BRAHMIN_DEATH1 : SoundsHandler.BRAHMIN_DEATH2;
	}
	
	protected boolean teleportRandomly(double scale) throws Exception {
		 if (this.goalSelector.getRunningGoals().anyMatch(goal -> (goal.getGoal().getClass() == TemptGoal.class || goal.getGoal().getClass() == BreakBlockGoal.class))) {
			  throw new Exception();
		  }
	      double d0 = this.posX + scale * (this.rand.nextDouble() - 0.5D) * 64.0D;
	      double d1 = this.posY + scale * (double)(this.rand.nextInt(64) - 32);
	      double d2 = this.posZ + scale * (this.rand.nextDouble() - 0.5D) * 64.0D;
	      return this.teleportTo(d0, d1, d2);
	   }
	
	private boolean teleportTo(double x, double y, double z) {
	      BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos(x, y, z);

	      while(blockpos$mutableblockpos.getY() > 0 && !this.world.getBlockState(blockpos$mutableblockpos).getMaterial().blocksMovement()) {
	         blockpos$mutableblockpos.move(Direction.DOWN);
	      }

	      if (!this.world.getBlockState(blockpos$mutableblockpos).getMaterial().blocksMovement()) {
	         return false;
	      } else {
	         net.minecraftforge.event.entity.living.EnderTeleportEvent event = new net.minecraftforge.event.entity.living.EnderTeleportEvent(this, x, y, z, 0);
	         if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event)) return false;
	         boolean flag = this.attemptTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ(), true);
	         if (flag) {
	            this.world.playSound((PlayerEntity)null, this.prevPosX, this.prevPosY, this.prevPosZ, SoundEvents.ENTITY_ENDERMAN_TELEPORT, this.getSoundCategory(), 1.0F, 1.0F);
	            this.playSound(SoundEvents.ENTITY_ENDERMAN_TELEPORT, 1.0F, 1.0F);
	         }
	         return flag;
	      }
	   }
	
	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
		
		if (this.isInvulnerableTo(source))
	         return false;
		
		boolean flag = false;
		if (!(source instanceof IndirectEntityDamageSource) && source != DamageSource.FIREWORKS)
	         flag = super.attackEntityFrom(source, amount);
	         
	    if (this.getHealth() - amount > 0) {
	    	try {
	    	for(int i = 0; i < 64; ++i) {
	            if (this.teleportRandomly(0.5D)) {
	               return true;
	            }
	    	}
	    	}catch(Exception e) {return flag;}
	    }
	    return flag;
	}
}
