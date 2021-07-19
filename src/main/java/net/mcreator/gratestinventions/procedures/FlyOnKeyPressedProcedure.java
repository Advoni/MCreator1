package net.mcreator.gratestinventions.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.gratestinventions.GratestInventionsModElements;
import net.mcreator.gratestinventions.GratestInventionsMod;

import java.util.Map;

@GratestInventionsModElements.ModElement.Tag
public class FlyOnKeyPressedProcedure extends GratestInventionsModElements.ModElement {
	public FlyOnKeyPressedProcedure(GratestInventionsModElements instance) {
		super(instance, 146);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				GratestInventionsMod.LOGGER.warn("Failed to load dependency entity for procedure FlyOnKeyPressed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putBoolean("jump", (true));
	}
}
