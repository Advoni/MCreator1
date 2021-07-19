package net.mcreator.gratestinventions.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.gratestinventions.GratestInventionsModElements;
import net.mcreator.gratestinventions.GratestInventionsMod;

import java.util.Map;

@GratestInventionsModElements.ModElement.Tag
public class FlyOnKeyReleasedProcedure extends GratestInventionsModElements.ModElement {
	public FlyOnKeyReleasedProcedure(GratestInventionsModElements instance) {
		super(instance, 147);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				GratestInventionsMod.LOGGER.warn("Failed to load dependency entity for procedure FlyOnKeyReleased!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putBoolean("jump", (false));
	}
}
