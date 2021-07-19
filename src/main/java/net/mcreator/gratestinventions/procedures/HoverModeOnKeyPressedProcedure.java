package net.mcreator.gratestinventions.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.gratestinventions.GratestInventionsModElements;
import net.mcreator.gratestinventions.GratestInventionsMod;

import java.util.Map;

@GratestInventionsModElements.ModElement.Tag
public class HoverModeOnKeyPressedProcedure extends GratestInventionsModElements.ModElement {
	public HoverModeOnKeyPressedProcedure(GratestInventionsModElements instance) {
		super(instance, 149);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				GratestInventionsMod.LOGGER.warn("Failed to load dependency entity for procedure HoverModeOnKeyPressed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getPersistentData().getBoolean("HoverMode"))) {
			entity.getPersistentData().putBoolean("HoverMode", (false));
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Hover Mode: \"off\""), (true));
			}
		} else {
			entity.getPersistentData().putBoolean("HoverMode", (true));
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Hover Mode: \"on\""), (true));
			}
		}
	}
}
