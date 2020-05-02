package com.jacobdill.endgamemod.renders;

import com.jacobdill.endgamemod.entities.BrahminEntity;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

@OnlyIn(Dist.CLIENT)
public class EndgameRenderRegistry {

	public static void registryEntityrenders() {
		RenderingRegistry.registerEntityRenderingHandler(BrahminEntity.class, new BrahminRender.RenderFactory());
	}

}
