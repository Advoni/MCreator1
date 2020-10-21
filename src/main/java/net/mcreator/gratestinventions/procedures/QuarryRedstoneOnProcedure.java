package net.mcreator.gratestinventions.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.gratestinventions.GratestInventionsModElements;

import java.util.Map;

@GratestInventionsModElements.ModElement.Tag
public class QuarryRedstoneOnProcedure extends GratestInventionsModElements.ModElement {
	public QuarryRedstoneOnProcedure(GratestInventionsModElements instance) {
		super(instance, 2);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure QuarryRedstoneOn!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure QuarryRedstoneOn!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure QuarryRedstoneOn!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure QuarryRedstoneOn!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double X = 0;
		double Y = 0;
		double Z = 0;
		double scan = 0;
		X = (double) (x + ((new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "dX")) + 1));
		Y = (double) (new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "dY"));
		Z = (double) (z + ((new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "dZ")) + 1));
		if (((new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "dX")) > 9)) {
			X = (double) (x + 1);
			if (!world.getWorld().isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("dX", 0);
				world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			if (((new Object() {
				public double getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "dZ")) > 8)) {
				Z = (double) (z + 1);
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("dZ", 0);
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (((new Object() {
					public double getValue(BlockPos pos, String tag) {
						TileEntity tileEntity = world.getTileEntity(pos);
						if (tileEntity != null)
							return tileEntity.getTileData().getDouble(tag);
						return -1;
					}
				}.getValue(new BlockPos((int) x, (int) y, (int) z), "dY")) == 0)) {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
				} else {
					Y = (double) ((Y) - 1);
					if (!world.getWorld().isRemote) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putDouble("dY", ((new Object() {
								public double getValue(BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getDouble(tag);
									return -1;
								}
							}.getValue(new BlockPos((int) x, (int) y, (int) z), "dY")) - 1));
						world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				}
			} else {
				Z = (double) ((Z) + 1);
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("dZ", ((new Object() {
							public double getValue(BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getDouble(tag);
								return -1;
							}
						}.getValue(new BlockPos((int) x, (int) y, (int) z), "dZ")) + 1));
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			}
		}
		scan = (double) (y - (Y));
		for (int index0 = 0; index0 < (int) (((y - (Y)) + 1)); index0++) {
			if (((scan) == 0)) {
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("dX", ((new Object() {
							public double getValue(BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getDouble(tag);
								return -1;
							}
						}.getValue(new BlockPos((int) x, (int) y, (int) z), "dX")) + 1));
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			}
			if ((((world.getBlockState(new BlockPos((int) (X), (int) ((Y) + (scan)), (int) (Z))).getBlockHardness(world,
					new BlockPos((int) (X), (int) ((Y) + (scan)), (int) (Z)))) != (-1))
					&& ((((world.getBlockState(new BlockPos((int) (X), (int) ((Y) + (scan)), (int) (Z)))).getBlock() == Blocks.AIR.getDefaultState()
							.getBlock()) == (false))
							&& ((((world.getBlockState(new BlockPos((int) (X), (int) ((Y) + (scan)), (int) (Z))))
									.getMaterial() == net.minecraft.block.material.Material.WATER) == (false))
									&& (((world.getBlockState(new BlockPos((int) (X), (int) ((Y) + (scan)), (int) (Z))))
											.getMaterial() == net.minecraft.block.material.Material.LAVA) == (false)))))) {
				Block.spawnDrops(world.getBlockState(new BlockPos((int) (X), (int) ((Y) + (scan)), (int) (Z))), world.getWorld(),
						new BlockPos((int) x, (int) (y + 0.5), (int) (z + 1)));
				world.destroyBlock(new BlockPos((int) (X), (int) ((Y) + (scan)), (int) (Z)), false);
				break;
			}
			scan = (double) ((scan) - 1);
		}
	}
}
