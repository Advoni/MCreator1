package net.mcreator.gratestinventions.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;

import net.mcreator.gratestinventions.GratestInventionsModVariables;
import net.mcreator.gratestinventions.GratestInventionsModElements;
import net.mcreator.gratestinventions.GratestInventionsMod;

import java.util.Map;
import java.util.HashMap;

@GratestInventionsModElements.ModElement.Tag
public class WorldLoaderProcedure extends GratestInventionsModElements.ModElement {
	public WorldLoaderProcedure(GratestInventionsModElements instance) {
		super(instance, 161);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				GratestInventionsMod.LOGGER.warn("Failed to load dependency entity for procedure WorldLoader!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity.getPersistentData()
				.getDouble("slot1")) != ((entity.getCapability(GratestInventionsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new GratestInventionsModVariables.PlayerVariables())).slot1))) {
			entity.getPersistentData().putDouble("slot1", ((entity.getCapability(GratestInventionsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new GratestInventionsModVariables.PlayerVariables())).slot1));
		}
		if (((entity.getPersistentData()
				.getDouble("slot2")) != ((entity.getCapability(GratestInventionsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new GratestInventionsModVariables.PlayerVariables())).slot2))) {
			entity.getPersistentData().putDouble("slot2", ((entity.getCapability(GratestInventionsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new GratestInventionsModVariables.PlayerVariables())).slot2));
		}
		if (((entity.getPersistentData()
				.getDouble("slot3")) != ((entity.getCapability(GratestInventionsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new GratestInventionsModVariables.PlayerVariables())).slot3))) {
			entity.getPersistentData().putDouble("slot3", ((entity.getCapability(GratestInventionsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new GratestInventionsModVariables.PlayerVariables())).slot3));
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			World world = entity.world;
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
