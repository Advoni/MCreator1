package net.mcreator.gratestinventions.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.state.DirectionProperty;
import net.minecraft.block.BlockState;

import net.mcreator.gratestinventions.block.ZahnstangeSNBlock;
import net.mcreator.gratestinventions.block.SupportBeamTripleBlock;
import net.mcreator.gratestinventions.block.SupportBeamSingleBlock;
import net.mcreator.gratestinventions.block.SupportBeamQuatrupleBlock;
import net.mcreator.gratestinventions.block.SupportBeamDoubleBlock;
import net.mcreator.gratestinventions.block.SupportBeamDouble2Block;
import net.mcreator.gratestinventions.block.SupportBeamBlock;
import net.mcreator.gratestinventions.block.SupportBeam4Block;
import net.mcreator.gratestinventions.block.SupportBeam3Block;
import net.mcreator.gratestinventions.block.SupportBeam2Block;
import net.mcreator.gratestinventions.block.SupportBeam1bBlock;
import net.mcreator.gratestinventions.GratestInventionsModElements;

import javax.print.attribute.standard.Sides;

import java.util.Map;

@GratestInventionsModElements.ModElement.Tag
public class HelpMePleaseProcedure extends GratestInventionsModElements.ModElement {
	public HelpMePleaseProcedure(GratestInventionsModElements instance) {
		super(instance, 18);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure HelpMePlease!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure HelpMePlease!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure HelpMePlease!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure HelpMePlease!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		boolean North = false;
		boolean East = false;
		boolean South = false;
		boolean West = false;
		double minY = 0;
		double maxY = 0;
		double counterOfSuffering = 0;
		double Sides = 0;
		minY = (double) 0;
		while ((((world.getBlockState(new BlockPos((int) x, (int) (y - (minY)), (int) z))).getBlock() == SupportBeamBlock.block.getDefaultState()
				.getBlock())
				|| (((world.getBlockState(new BlockPos((int) x, (int) (y - (minY)), (int) z))).getBlock() == SupportBeam2Block.block.getDefaultState()
						.getBlock())
						|| (((world.getBlockState(new BlockPos((int) x, (int) (y - (minY)), (int) z))).getBlock() == SupportBeam3Block.block
								.getDefaultState().getBlock())
								|| (((world.getBlockState(new BlockPos((int) x, (int) (y - (minY)), (int) z))).getBlock() == SupportBeam4Block.block
										.getDefaultState().getBlock())
										|| (((world.getBlockState(new BlockPos((int) x, (int) (y - (minY)), (int) z)))
												.getBlock() == SupportBeam1bBlock.block.getDefaultState().getBlock())
												|| (((world.getBlockState(new BlockPos((int) x, (int) (y - (minY)), (int) z)))
														.getBlock() == SupportBeamSingleBlock.block.getDefaultState().getBlock())
														|| (((world.getBlockState(new BlockPos((int) x, (int) (y - (minY)), (int) z)))
																.getBlock() == SupportBeamDoubleBlock.block.getDefaultState().getBlock())
																|| (((world.getBlockState(new BlockPos((int) x, (int) (y - (minY)), (int) z)))
																		.getBlock() == SupportBeamDouble2Block.block.getDefaultState().getBlock())
																		|| (((world.getBlockState(new BlockPos((int) x, (int) (y - (minY)), (int) z)))
																				.getBlock() == SupportBeamTripleBlock.block.getDefaultState()
																						.getBlock())
																				|| ((world.getBlockState(
																						new BlockPos((int) x, (int) (y - (minY)), (int) z)))
																								.getBlock() == SupportBeamQuatrupleBlock.block
																										.getDefaultState().getBlock()))))))))))) {
			minY = (double) ((minY) + 1);
		}
		minY = (double) ((y - (minY)) + 1);
		maxY = (double) 0;
		while ((((world.getBlockState(new BlockPos((int) x, (int) (y + (maxY)), (int) z))).getBlock() == SupportBeamBlock.block.getDefaultState()
				.getBlock())
				|| (((world.getBlockState(new BlockPos((int) x, (int) (y + (maxY)), (int) z))).getBlock() == SupportBeam2Block.block.getDefaultState()
						.getBlock())
						|| (((world.getBlockState(new BlockPos((int) x, (int) (y + (maxY)), (int) z))).getBlock() == SupportBeam3Block.block
								.getDefaultState().getBlock())
								|| (((world.getBlockState(new BlockPos((int) x, (int) (y + (maxY)), (int) z))).getBlock() == SupportBeam4Block.block
										.getDefaultState().getBlock())
										|| (((world.getBlockState(new BlockPos((int) x, (int) (y + (maxY)), (int) z)))
												.getBlock() == SupportBeam1bBlock.block.getDefaultState().getBlock())
												|| (((world.getBlockState(new BlockPos((int) x, (int) (y + (maxY)), (int) z)))
														.getBlock() == SupportBeamSingleBlock.block.getDefaultState().getBlock())
														|| (((world.getBlockState(new BlockPos((int) x, (int) (y + (maxY)), (int) z)))
																.getBlock() == SupportBeamDoubleBlock.block.getDefaultState().getBlock())
																|| (((world.getBlockState(new BlockPos((int) x, (int) (y + (maxY)), (int) z)))
																		.getBlock() == SupportBeamDouble2Block.block.getDefaultState().getBlock())
																		|| (((world.getBlockState(new BlockPos((int) x, (int) (y + (maxY)), (int) z)))
																				.getBlock() == SupportBeamTripleBlock.block.getDefaultState()
																						.getBlock())
																				|| ((world.getBlockState(
																						new BlockPos((int) x, (int) (y + (maxY)), (int) z)))
																								.getBlock() == SupportBeamQuatrupleBlock.block
																										.getDefaultState().getBlock()))))))))))) {
			maxY = (double) ((maxY) + 1);
		}
		maxY = (double) ((y + (maxY)) - 1);
		if ((((maxY) - (minY)) == 1)) {
			world.setBlockState(new BlockPos((int) x, (int) (minY), (int) z), SupportBeam2Block.block.getDefaultState(), 3);
		} else if ((((maxY) - (minY)) == 2)) {
			world.setBlockState(new BlockPos((int) x, (int) (minY), (int) z), SupportBeam3Block.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) x, (int) ((minY) + 1), (int) z), SupportBeam2Block.block.getDefaultState(), 3);
		} else if ((((maxY) - (minY)) > 2)) {
			world.setBlockState(new BlockPos((int) x, (int) (minY), (int) z), SupportBeam4Block.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) x, (int) ((minY) + 1), (int) z), SupportBeam3Block.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) x, (int) ((minY) + 2), (int) z), SupportBeam2Block.block.getDefaultState(), 3);
			counterOfSuffering = (double) (((maxY) - (minY)) - 3);
			while (((counterOfSuffering) > 0)) {
				world.setBlockState(new BlockPos((int) x, (int) (((minY) + 2) + (counterOfSuffering)), (int) z),
						SupportBeam1bBlock.block.getDefaultState(), 3);
				counterOfSuffering = (double) ((counterOfSuffering) - 1);
			}
		}
		Sides = (double) 0;
		North = (boolean) (false);
		East = (boolean) (false);
		South = (boolean) (false);
		West = (boolean) (false);
		if ((((world.getBlockState(new BlockPos((int) x, (int) (maxY), (int) (z + 1)))).getBlock() == ZahnstangeSNBlock.block.getDefaultState()
				.getBlock()) && (((new Object() {
					public Direction getDirection(BlockPos pos) {
						try {
							BlockState _bs = world.getBlockState(pos);
							DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
							return _bs.get(property);
						} catch (Exception e) {
							return Direction.NORTH;
						}
					}
				}.getDirection(new BlockPos((int) x, (int) (maxY), (int) (z + 1)))) == Direction.NORTH) || ((new Object() {
					public Direction getDirection(BlockPos pos) {
						try {
							BlockState _bs = world.getBlockState(pos);
							DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
							return _bs.get(property);
						} catch (Exception e) {
							return Direction.NORTH;
						}
					}
				}.getDirection(new BlockPos((int) x, (int) (maxY), (int) (z + 1)))) == Direction.SOUTH)))) {
			Sides = (double) ((Sides) + 1);
			South = (boolean) (true);
		}
		if ((((world.getBlockState(new BlockPos((int) x, (int) (maxY), (int) (z - 1)))).getBlock() == ZahnstangeSNBlock.block.getDefaultState()
				.getBlock()) && (((new Object() {
					public Direction getDirection(BlockPos pos) {
						try {
							BlockState _bs = world.getBlockState(pos);
							DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
							return _bs.get(property);
						} catch (Exception e) {
							return Direction.NORTH;
						}
					}
				}.getDirection(new BlockPos((int) x, (int) (maxY), (int) (z - 1)))) == Direction.NORTH) || ((new Object() {
					public Direction getDirection(BlockPos pos) {
						try {
							BlockState _bs = world.getBlockState(pos);
							DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
							return _bs.get(property);
						} catch (Exception e) {
							return Direction.NORTH;
						}
					}
				}.getDirection(new BlockPos((int) x, (int) (maxY), (int) (z - 1)))) == Direction.SOUTH)))) {
			Sides = (double) ((Sides) + 1);
			North = (boolean) (true);
		}
		if ((((world.getBlockState(new BlockPos((int) (x + 1), (int) (maxY), (int) z))).getBlock() == ZahnstangeSNBlock.block.getDefaultState()
				.getBlock()) && (((new Object() {
					public Direction getDirection(BlockPos pos) {
						try {
							BlockState _bs = world.getBlockState(pos);
							DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
							return _bs.get(property);
						} catch (Exception e) {
							return Direction.NORTH;
						}
					}
				}.getDirection(new BlockPos((int) (x + 1), (int) (maxY), (int) z))) == Direction.EAST) || ((new Object() {
					public Direction getDirection(BlockPos pos) {
						try {
							BlockState _bs = world.getBlockState(pos);
							DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
							return _bs.get(property);
						} catch (Exception e) {
							return Direction.NORTH;
						}
					}
				}.getDirection(new BlockPos((int) (x + 1), (int) (maxY), (int) z))) == Direction.WEST)))) {
			Sides = (double) ((Sides) + 1);
			East = (boolean) (true);
		}
		if ((((world.getBlockState(new BlockPos((int) (x - 1), (int) (maxY), (int) z))).getBlock() == ZahnstangeSNBlock.block.getDefaultState()
				.getBlock()) && (((new Object() {
					public Direction getDirection(BlockPos pos) {
						try {
							BlockState _bs = world.getBlockState(pos);
							DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
							return _bs.get(property);
						} catch (Exception e) {
							return Direction.NORTH;
						}
					}
				}.getDirection(new BlockPos((int) (x - 1), (int) (maxY), (int) z))) == Direction.EAST) || ((new Object() {
					public Direction getDirection(BlockPos pos) {
						try {
							BlockState _bs = world.getBlockState(pos);
							DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
							return _bs.get(property);
						} catch (Exception e) {
							return Direction.NORTH;
						}
					}
				}.getDirection(new BlockPos((int) (x - 1), (int) (maxY), (int) z))) == Direction.WEST)))) {
			Sides = (double) ((Sides) + 1);
			West = (boolean) (true);
		}
		if (((Sides) == 0)) {
			world.setBlockState(new BlockPos((int) x, (int) (maxY), (int) z), SupportBeamBlock.block.getDefaultState(), 3);
		} else if (((Sides) == 1)) {
			if ((North)) {
				world.setBlockState(new BlockPos((int) x, (int) (maxY), (int) z), SupportBeamSingleBlock.block.getDefaultState(), 3);
				try {
					BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) (maxY), (int) z));
					world.setBlockState(new BlockPos((int) x, (int) (maxY), (int) z),
							_bs.with((DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing"), Direction.NORTH), 3);
				} catch (Exception e) {
				}
			} else if ((East)) {
				world.setBlockState(new BlockPos((int) x, (int) (maxY), (int) z), SupportBeamSingleBlock.block.getDefaultState(), 3);
				try {
					BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) (maxY), (int) z));
					world.setBlockState(new BlockPos((int) x, (int) (maxY), (int) z),
							_bs.with((DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing"), Direction.EAST), 3);
				} catch (Exception e) {
				}
			} else if ((South)) {
				world.setBlockState(new BlockPos((int) x, (int) (maxY), (int) z), SupportBeamSingleBlock.block.getDefaultState(), 3);
				try {
					BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) (maxY), (int) z));
					world.setBlockState(new BlockPos((int) x, (int) (maxY), (int) z),
							_bs.with((DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing"), Direction.SOUTH), 3);
				} catch (Exception e) {
				}
			} else if ((West)) {
				world.setBlockState(new BlockPos((int) x, (int) (maxY), (int) z), SupportBeamSingleBlock.block.getDefaultState(), 3);
				try {
					BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) (maxY), (int) z));
					world.setBlockState(new BlockPos((int) x, (int) (maxY), (int) z),
							_bs.with((DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing"), Direction.WEST), 3);
				} catch (Exception e) {
				}
			}
		} else if (((Sides) == 2)) {
			if (((North) && (East))) {
				world.setBlockState(new BlockPos((int) x, (int) (maxY), (int) z), SupportBeamDoubleBlock.block.getDefaultState(), 3);
				try {
					BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) (maxY), (int) z));
					world.setBlockState(new BlockPos((int) x, (int) (maxY), (int) z),
							_bs.with((DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing"), Direction.NORTH), 3);
				} catch (Exception e) {
				}
			} else if (((East) && (South))) {
				world.setBlockState(new BlockPos((int) x, (int) (maxY), (int) z), SupportBeamDoubleBlock.block.getDefaultState(), 3);
				try {
					BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) (maxY), (int) z));
					world.setBlockState(new BlockPos((int) x, (int) (maxY), (int) z),
							_bs.with((DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing"), Direction.EAST), 3);
				} catch (Exception e) {
				}
			} else if (((South) && (West))) {
				world.setBlockState(new BlockPos((int) x, (int) (maxY), (int) z), SupportBeamDoubleBlock.block.getDefaultState(), 3);
				try {
					BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) (maxY), (int) z));
					world.setBlockState(new BlockPos((int) x, (int) (maxY), (int) z),
							_bs.with((DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing"), Direction.SOUTH), 3);
				} catch (Exception e) {
				}
			} else if (((West) && (North))) {
				world.setBlockState(new BlockPos((int) x, (int) (maxY), (int) z), SupportBeamDoubleBlock.block.getDefaultState(), 3);
				try {
					BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) (maxY), (int) z));
					world.setBlockState(new BlockPos((int) x, (int) (maxY), (int) z),
							_bs.with((DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing"), Direction.WEST), 3);
				} catch (Exception e) {
				}
			} else if (((North) && (South))) {
				world.setBlockState(new BlockPos((int) x, (int) (maxY), (int) z), SupportBeamDouble2Block.block.getDefaultState(), 3);
				try {
					BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) (maxY), (int) z));
					world.setBlockState(new BlockPos((int) x, (int) (maxY), (int) z),
							_bs.with((DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing"), Direction.NORTH), 3);
				} catch (Exception e) {
				}
			} else if (((East) && (West))) {
				world.setBlockState(new BlockPos((int) x, (int) (maxY), (int) z), SupportBeamDouble2Block.block.getDefaultState(), 3);
				try {
					BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) (maxY), (int) z));
					world.setBlockState(new BlockPos((int) x, (int) (maxY), (int) z),
							_bs.with((DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing"), Direction.EAST), 3);
				} catch (Exception e) {
				}
			}
		} else if (((Sides) == 3)) {
			if (((North) && ((East) && (South)))) {
				world.setBlockState(new BlockPos((int) x, (int) (maxY), (int) z), SupportBeamTripleBlock.block.getDefaultState(), 3);
				try {
					BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) (maxY), (int) z));
					world.setBlockState(new BlockPos((int) x, (int) (maxY), (int) z),
							_bs.with((DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing"), Direction.NORTH), 3);
				} catch (Exception e) {
				}
			} else if (((East) && ((South) && (West)))) {
				world.setBlockState(new BlockPos((int) x, (int) (maxY), (int) z), SupportBeamTripleBlock.block.getDefaultState(), 3);
				try {
					BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) (maxY), (int) z));
					world.setBlockState(new BlockPos((int) x, (int) (maxY), (int) z),
							_bs.with((DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing"), Direction.EAST), 3);
				} catch (Exception e) {
				}
			} else if (((South) && ((West) && (North)))) {
				world.setBlockState(new BlockPos((int) x, (int) (maxY), (int) z), SupportBeamTripleBlock.block.getDefaultState(), 3);
				try {
					BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) (maxY), (int) z));
					world.setBlockState(new BlockPos((int) x, (int) (maxY), (int) z),
							_bs.with((DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing"), Direction.SOUTH), 3);
				} catch (Exception e) {
				}
			} else if (((West) && ((North) && (East)))) {
				world.setBlockState(new BlockPos((int) x, (int) (maxY), (int) z), SupportBeamTripleBlock.block.getDefaultState(), 3);
				try {
					BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) (maxY), (int) z));
					world.setBlockState(new BlockPos((int) x, (int) (maxY), (int) z),
							_bs.with((DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing"), Direction.WEST), 3);
				} catch (Exception e) {
				}
			}
		} else if (((Sides) == 4)) {
			world.setBlockState(new BlockPos((int) x, (int) (maxY), (int) z), SupportBeamQuatrupleBlock.block.getDefaultState(), 3);
		}
	}
}
