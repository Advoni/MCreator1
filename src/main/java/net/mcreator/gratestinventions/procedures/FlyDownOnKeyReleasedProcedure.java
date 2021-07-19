package net.mcreator.gratestinventions.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.gratestinventions.GratestInventionsModElements;
import net.mcreator.gratestinventions.GratestInventionsMod;

import java.util.Map;

@GratestInventionsModElements.ModElement.Tag
public class FlyDownOnKeyReleasedProcedure extends GratestInventionsModElements.ModElement {
	public FlyDownOnKeyReleasedProcedure(GratestInventionsModElements instance) {
		super(instance, 151);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				GratestInventionsMod.LOGGER.warn("Failed to load dependency entity for procedure FlyDownOnKeyReleased!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putBoolean("sneak", (false));
	}
}
