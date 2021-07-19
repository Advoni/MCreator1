package net.mcreator.gratestinventions.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.gratestinventions.GratestInventionsModVariables;
import net.mcreator.gratestinventions.GratestInventionsModElements;
import net.mcreator.gratestinventions.GratestInventionsMod;

import java.util.Map;

@GratestInventionsModElements.ModElement.Tag
public class TestBlockOnBlockRightClickedProcedure extends GratestInventionsModElements.ModElement {
	public TestBlockOnBlockRightClickedProcedure(GratestInventionsModElements instance) {
		super(instance, 159);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				GratestInventionsMod.LOGGER.warn("Failed to load dependency entity for procedure TestBlockOnBlockRightClicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			double _setval = (double) 1;
			entity.getCapability(GratestInventionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.slot1 = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = (double) 2;
			entity.getCapability(GratestInventionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.slot2 = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = (double) 3;
			entity.getCapability(GratestInventionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.slot3 = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
