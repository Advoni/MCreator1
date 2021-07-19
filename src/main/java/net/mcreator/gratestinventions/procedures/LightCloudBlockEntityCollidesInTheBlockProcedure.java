package net.mcreator.gratestinventions.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.gratestinventions.GratestInventionsModElements;
import net.mcreator.gratestinventions.GratestInventionsMod;

import java.util.Map;

@GratestInventionsModElements.ModElement.Tag
public class LightCloudBlockEntityCollidesInTheBlockProcedure extends GratestInventionsModElements.ModElement {
	public LightCloudBlockEntityCollidesInTheBlockProcedure(GratestInventionsModElements instance) {
		super(instance, 94);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				GratestInventionsMod.LOGGER.warn("Failed to load dependency entity for procedure LightCloudBlockEntityCollidesInTheBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.setMotion(((entity.getMotion().getX()) * (-0.7)), ((entity.getMotion().getY()) * (-0.7)), ((entity.getMotion().getZ()) * (-0.7)));
	}
}
