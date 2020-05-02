package com.jacobdill.endgamemod.renders;

import com.jacobdill.endgamemod.entities.BrahminEntity;
import com.jacobdill.endgamemod.EndgameRegistryEvents;
import com.jacobdill.endgamemod.models.BrahminModel;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
//import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class BrahminRender extends MobRenderer<BrahminEntity, BrahminModel>{
	
	public BrahminRender(EntityRendererManager manager) {
		super(manager, new BrahminModel(), 0f);
	}

	@Override
	protected ResourceLocation getEntityTexture(BrahminEntity entity) {
		return EndgameRegistryEvents.location("textures/entity/brahmin.png");
	}

	public static class RenderFactory implements IRenderFactory<BrahminEntity>{
		@Override
		public EntityRenderer<? super BrahminEntity> createRenderFor(EntityRendererManager manager){
			return new BrahminRender(manager);
		}
	}
	
}
