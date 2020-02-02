package com.jacobdill.endgamemod.renders;

import com.jacobdill.endgamemod.entities.ExampleEntity;
import com.jacobdill.endgamemod.EndgameRegistryEvents;
import com.jacobdill.endgamemod.models.ExampleEntityModel;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class ExampleEntityRender extends LivingRenderer<ExampleEntity, ExampleEntityModel>{
	
	public ExampleEntityRender(EntityRendererManager manager) {
		super(manager, new ExampleEntityModel(), 0f);
	}

	@Override
	protected ResourceLocation getEntityTexture(ExampleEntity entity) {
		return EndgameRegistryEvents.location("textures/entity/example_entity.png");
	}

	public static class RenderFactory implements IRenderFactory<ExampleEntity>{
		@Override
		public EntityRenderer<? super ExampleEntity> createRenderFor(EntityRendererManager manager){
			return new ExampleEntityRender(manager);
		}
	}
	
}
