package net.mcreator.gratestinventions.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.BlockState;

import net.mcreator.gratestinventions.block.ZahnstangeSNBlock;
import net.mcreator.gratestinventions.block.ZahnstangeEWBlock;
import net.mcreator.gratestinventions.GratestInventionsModElements;

import java.util.Map;

@GratestInventionsModElements.ModElement.Tag
public class ZahnstangeEWNeighbourBlockChangesProcedure extends GratestInventionsModElements.ModElement {
	public ZahnstangeEWNeighbourBlockChangesProcedure(GratestInventionsModElements instance) {
		super(instance, 7);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure ZahnstangeEWNeighbourBlockChanges!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure ZahnstangeEWNeighbourBlockChanges!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure ZahnstangeEWNeighbourBlockChanges!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure ZahnstangeEWNeighbourBlockChanges!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((!((((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == ZahnstangeSNBlock.block.getDefaultState()
				.getBlock())
				|| ((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == ZahnstangeEWBlock.block.getDefaultState()
						.getBlock()))
				|| (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == ZahnstangeSNBlock.block.getDefaultState()
						.getBlock())
						|| ((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == ZahnstangeEWBlock.block
								.getDefaultState().getBlock()))))) {
			if ((((((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == ZahnstangeSNBlock.block.getDefaultState()
					.getBlock())
					|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == ZahnstangeEWBlock.block.getDefaultState()
							.getBlock()))
					|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == ZahnstangeSNBlock.block.getDefaultState()
							.getBlock())
							|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == ZahnstangeEWBlock.block
									.getDefaultState().getBlock())))
					&& ((new Object() {
						public boolean getValue(BlockPos pos, String tag) {
							TileEntity tileEntity = world.getTileEntity(pos);
							if (tileEntity != null)
								return tileEntity.getTileData().getBoolean(tag);
							return false;
						}
					}.getValue(new BlockPos((int) x, (int) y, (int) (z + 1)), "Single")) || (new Object() {
						public boolean getValue(BlockPos pos, String tag) {
							TileEntity tileEntity = world.getTileEntity(pos);
							if (tileEntity != null)
								return tileEntity.getTileData().getBoolean(tag);
							return false;
						}
					}.getValue(new BlockPos((int) x, (int) y, (int) (z - 1)), "Single"))))) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), ZahnstangeSNBlock.block.getDefaultState(), 3);
			} else {
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putBoolean("Single", (true));
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			}
		} else {
			if (!world.getWorld().isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putBoolean("Single", (false));
				world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
		}
	}
}
