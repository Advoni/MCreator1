package net.mcreator.gratestinventions.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import net.mcreator.gratestinventions.block.SupportBeamBlock;
import net.mcreator.gratestinventions.block.SupportBeam4Block;
import net.mcreator.gratestinventions.block.SupportBeam3Block;
import net.mcreator.gratestinventions.block.SupportBeam2Block;
import net.mcreator.gratestinventions.block.SupportBeam1bBlock;
import net.mcreator.gratestinventions.GratestInventionsModElements;

import java.util.Map;
import java.util.HashMap;

@GratestInventionsModElements.ModElement.Tag
public class SupportBeamBlockDestroyedByPlayerProcedure extends GratestInventionsModElements.ModElement {
	public SupportBeamBlockDestroyedByPlayerProcedure(GratestInventionsModElements instance) {
		super(instance, 19);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure SupportBeamBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure SupportBeamBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure SupportBeamBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure SupportBeamBlockDestroyedByPlayer!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == SupportBeamBlock.block.getDefaultState().getBlock())
				|| (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == SupportBeam2Block.block.getDefaultState()
						.getBlock())
						|| (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == SupportBeam3Block.block
								.getDefaultState().getBlock())
								|| (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == SupportBeam4Block.block
										.getDefaultState().getBlock())
										|| ((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z)))
												.getBlock() == SupportBeam1bBlock.block.getDefaultState().getBlock())))))) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("world", world);
				$_dependencies.put("x", x);
				$_dependencies.put("y", (y - 1));
				$_dependencies.put("z", z);
				HelpMePleaseProcedure.executeProcedure($_dependencies);
			}
		}
		if ((((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == SupportBeamBlock.block.getDefaultState().getBlock())
				|| (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == SupportBeam2Block.block.getDefaultState()
						.getBlock())
						|| (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == SupportBeam3Block.block
								.getDefaultState().getBlock())
								|| (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == SupportBeam4Block.block
										.getDefaultState().getBlock())
										|| ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)))
												.getBlock() == SupportBeam1bBlock.block.getDefaultState().getBlock())))))) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("world", world);
				$_dependencies.put("x", x);
				$_dependencies.put("y", (y + 1));
				$_dependencies.put("z", z);
				HelpMePleaseProcedure.executeProcedure($_dependencies);
			}
		}
	}
}
