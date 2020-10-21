package net.mcreator.gratestinventions.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.entity.player.PlayerEntity;

import net.mcreator.gratestinventions.GratestInventionsModVariables;
import net.mcreator.gratestinventions.GratestInventionsModElements;

import java.util.Map;
import java.util.HashMap;

@GratestInventionsModElements.ModElement.Tag
public class TickManagerProcedure extends GratestInventionsModElements.ModElement {
	public TickManagerProcedure(GratestInventionsModElements instance) {
		super(instance, 30);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure TickManager!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		GratestInventionsModVariables.WorldVariables.get(world).NetherCoords = (String) "";
		GratestInventionsModVariables.WorldVariables.get(world).syncData(world);
	}

	@SubscribeEvent
	public void onUseHoe(UseHoeEvent event) {
		PlayerEntity entity = event.getPlayer();
		int i = event.getContext().getPos().getX();
		int j = event.getContext().getPos().getY();
		int k = event.getContext().getPos().getZ();
		World world = entity.world;
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
