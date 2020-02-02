package com.jacobdill.endgamemod.renders;

import com.jacobdill.endgamemod.entities.ExampleEntity;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

@OnlyIn(Dist.CLIENT)
public class ExampleRenderRegistry {

	public static void registryEntityrenders() {
		RenderingRegistry.registerEntityRenderingHandler(ExampleEntity.class, new ExampleEntityRender.RenderFactory());
	}

}
