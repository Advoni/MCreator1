package net.mcreator.gratestinventions.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.inventory.Inventory;
import net.minecraft.entity.item.minecart.HopperMinecartEntity;

import net.mcreator.gratestinventions.GratestInventionsModElements;

import java.util.Map;
import java.util.Comparator;

@GratestInventionsModElements.ModElement.Tag
public class QuarryEntityCollidesInTheBlockProcedure extends GratestInventionsModElements.ModElement {
	public QuarryEntityCollidesInTheBlockProcedure(GratestInventionsModElements instance) {
		super(instance, 25);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure QuarryEntityCollidesInTheBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure QuarryEntityCollidesInTheBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure QuarryEntityCollidesInTheBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure QuarryEntityCollidesInTheBlock!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double GUISize = 0;
		double GUICounter = 0;
		double Count = 0;
		boolean Inventory = false;
		if (((world
				.getEntitiesWithinAABB(HopperMinecartEntity.class,
						new AxisAlignedBB(x - 4 / 2, y - 4 / 2, z - 4 / 2, x + 4 / 2, y + 4 / 2, z + 4 / 2), null)
				.stream().sorted(Comparator.comparing(_entcnd -> _entcnd.getDistanceSq(x, y, z))).findFirst().orElse(null)) != null)) {
			(world.getEntitiesWithinAABB(HopperMinecartEntity.class,
					new AxisAlignedBB(x - 4 / 2, y - 4 / 2, z - 4 / 2, x + 4 / 2, y + 4 / 2, z + 4 / 2), null).stream()
					.sorted(Comparator.comparing(_entcnd -> _entcnd.getDistanceSq(x, y, z))).findFirst().orElse(null)).setMotion(0, 3, 0);
		}
	}
}
