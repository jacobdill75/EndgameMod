package com.jacobdill.endgamemod.entities;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.world.World;

public class ExampleEntity extends CowEntity{ //CreatureEntity

	/*@SuppressWarnings("unchecked")
	protected ExampleEntity(EntityType<? extends CreatureEntity> type, World worldIn) {
		super((EntityType<? extends CreatureEntity>) ExampleEntities.EXAMPLE_ENTITY,worldIn); //extends CreatureEntity
	}*/
	
	public ExampleEntity(EntityType<? extends CowEntity> type, World worldIn) {
		super(type, worldIn);
	}
		
	@Override
	protected void registerGoals(){
		this.goalSelector.addGoal(0,(new SwimGoal(this)));
		this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 1.2d));
		this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
	}
	/*
	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		//this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0d);
		//this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.8d);
	}*/
	
	@SuppressWarnings("unchecked")
	@Override
	public CowEntity createChild(AgeableEntity ageable) {
		return new ExampleEntity((EntityType<? extends CowEntity>)super.getType(), super.world);
	}
	
}
