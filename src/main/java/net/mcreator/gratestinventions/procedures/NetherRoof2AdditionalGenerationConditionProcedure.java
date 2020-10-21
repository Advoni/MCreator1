package net.mcreator.gratestinventions.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import net.mcreator.gratestinventions.block.NetherBuilderBlock;
import net.mcreator.gratestinventions.GratestInventionsModElements;

import java.util.Map;

@GratestInventionsModElements.ModElement.Tag
public class NetherRoof2AdditionalGenerationConditionProcedure extends GratestInventionsModElements.ModElement {
	public NetherRoof2AdditionalGenerationConditionProcedure(GratestInventionsModElements instance) {
		super(instance, 37);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure NetherRoof2AdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure NetherRoof2AdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure NetherRoof2AdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure NetherRoof2AdditionalGenerationCondition!");
			return false;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double OriginX = 0;
		double OriginZ = 0;
		double X = 0;
		double Z = 0;
		boolean success = false;
		OriginX = (double) (Math.floor((x / 16)) * 16);
		OriginZ = (double) (Math.floor((z / 16)) * 16);
		X = (double) 15;
		Z = (double) 15;
		success = (boolean) (true);
		for (int index0 = 0; index0 < (int) (16); index0++) {
			for (int index1 = 0; index1 < (int) (16); index1++) {
				X = (double) 0;
				if (((world.getBlockState(new BlockPos((int) ((X) + (OriginX)), (int) y, (int) ((Z) + (OriginZ)))))
						.getBlock() == NetherBuilderBlock.block.getDefaultState().getBlock())) {
					success = (boolean) (false);
				}
				X = (double) ((X) - 1);
			}
			Z = (double) ((Z) - 1);
		}
		return (success);
	}
}
