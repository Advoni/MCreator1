package net.mcreator.gratestinventions.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.gratestinventions.GratestInventionsModElements;
import net.mcreator.gratestinventions.GratestInventionsMod;

import java.util.Map;

@GratestInventionsModElements.ModElement.Tag
public class MultimeterScreenDisplayOverlayIngameProcedure extends GratestInventionsModElements.ModElement {
	public MultimeterScreenDisplayOverlayIngameProcedure(GratestInventionsModElements instance) {
		super(instance, 120);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				GratestInventionsMod.LOGGER.warn("Failed to load dependency entity for procedure MultimeterScreenDisplayOverlayIngame!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity.getPersistentData().getDouble("brodcast")) > 0)) {
			return (true);
		}
		return (false);
	}
}
