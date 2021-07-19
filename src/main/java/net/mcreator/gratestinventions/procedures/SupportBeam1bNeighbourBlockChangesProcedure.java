package net.mcreator.gratestinventions.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import net.mcreator.gratestinventions.block.SupportBeamBlock;
import net.mcreator.gratestinventions.block.SupportBeam4Block;
import net.mcreator.gratestinventions.block.SupportBeam3Block;
import net.mcreator.gratestinventions.block.SupportBeam2Block;
import net.mcreator.gratestinventions.GratestInventionsModElements;
import net.mcreator.gratestinventions.GratestInventionsMod;

import java.util.Map;

@GratestInventionsModElements.ModElement.Tag
public class SupportBeam1bNeighbourBlockChangesProcedure extends GratestInventionsModElements.ModElement {
	public SupportBeam1bNeighbourBlockChangesProcedure(GratestInventionsModElements instance) {
		super(instance, 17);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				GratestInventionsMod.LOGGER.warn("Failed to load dependency x for procedure SupportBeam1bNeighbourBlockChanges!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				GratestInventionsMod.LOGGER.warn("Failed to load dependency y for procedure SupportBeam1bNeighbourBlockChanges!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				GratestInventionsMod.LOGGER.warn("Failed to load dependency z for procedure SupportBeam1bNeighbourBlockChanges!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				GratestInventionsMod.LOGGER.warn("Failed to load dependency world for procedure SupportBeam1bNeighbourBlockChanges!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == SupportBeam4Block.block.getDefaultState()
				.getBlock())) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), SupportBeam3Block.block.getDefaultState(), 3);
		} else if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == SupportBeam3Block.block.getDefaultState()
				.getBlock())) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), SupportBeam2Block.block.getDefaultState(), 3);
		} else if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == SupportBeam2Block.block.getDefaultState()
				.getBlock())) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), SupportBeamBlock.block.getDefaultState(), 3);
		} else if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == SupportBeamBlock.block.getDefaultState()
				.getBlock())) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), SupportBeamBlock.block.getDefaultState(), 3);
		} else {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), SupportBeamBlock.block.getDefaultState(), 3);
		}
	}
}
