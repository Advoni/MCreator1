package net.mcreator.gratestinventions.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.BlockState;

import net.mcreator.gratestinventions.GratestInventionsModElements;
import net.mcreator.gratestinventions.GratestInventionsMod;

import java.util.Map;

@GratestInventionsModElements.ModElement.Tag
public class CoalGeneratorButtonPushedProcedure extends GratestInventionsModElements.ModElement {
	public CoalGeneratorButtonPushedProcedure(GratestInventionsModElements instance) {
		super(instance, 86);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				GratestInventionsMod.LOGGER.warn("Failed to load dependency x for procedure CoalGeneratorButtonPushed!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				GratestInventionsMod.LOGGER.warn("Failed to load dependency y for procedure CoalGeneratorButtonPushed!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				GratestInventionsMod.LOGGER.warn("Failed to load dependency z for procedure CoalGeneratorButtonPushed!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				GratestInventionsMod.LOGGER.warn("Failed to load dependency world for procedure CoalGeneratorButtonPushed!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (!world.getWorld().isRemote) {
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().putDouble("redstone", ((new Object() {
					public double getValue(IWorld world, BlockPos pos, String tag) {
						TileEntity tileEntity = world.getTileEntity(pos);
						if (tileEntity != null)
							return tileEntity.getTileData().getDouble(tag);
						return -1;
					}
				}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "redstone")) + 1));
			world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
		if (((new Object() {
			public double getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "redstone")) > 3)) {
			if (!world.getWorld().isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("redstone", 0);
				world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
		}
	}
}
