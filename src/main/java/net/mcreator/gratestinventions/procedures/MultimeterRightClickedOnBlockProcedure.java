package net.mcreator.gratestinventions.procedures;

import net.minecraftforge.fluids.capability.CapabilityFluidHandler;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tags.BlockTags;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import net.mcreator.gratestinventions.GratestInventionsModElements;
import net.mcreator.gratestinventions.GratestInventionsMod;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.Map;

@GratestInventionsModElements.ModElement.Tag
public class MultimeterRightClickedOnBlockProcedure extends GratestInventionsModElements.ModElement {
	public MultimeterRightClickedOnBlockProcedure(GratestInventionsModElements instance) {
		super(instance, 119);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				GratestInventionsMod.LOGGER.warn("Failed to load dependency entity for procedure MultimeterRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				GratestInventionsMod.LOGGER.warn("Failed to load dependency x for procedure MultimeterRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				GratestInventionsMod.LOGGER.warn("Failed to load dependency y for procedure MultimeterRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				GratestInventionsMod.LOGGER.warn("Failed to load dependency z for procedure MultimeterRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				GratestInventionsMod.LOGGER.warn("Failed to load dependency world for procedure MultimeterRightClickedOnBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		String searchedChar = "";
		double laufvariabel = 0;
		if ((((BlockTags.getCollection().getOrCreate(new ResourceLocation(("gratest_inventions:machine").toLowerCase(java.util.Locale.ENGLISH)))
				.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))
				|| (BlockTags.getCollection()
						.getOrCreate(new ResourceLocation(("gratest_inventions:generator").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock())))
				|| (BlockTags.getCollection().getOrCreate(new ResourceLocation(("forge:tank").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock())))) {
			entity.getPersistentData().putDouble("brodcast", 100);
			entity.getPersistentData().putString("block",
					((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock())).getDisplayName().getString()));
			if ((!(BlockTags.getCollection().getOrCreate(new ResourceLocation(("forge:tank").toLowerCase(java.util.Locale.ENGLISH)))
					.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock())))) {
				entity.getPersistentData().putString("capacity", (("Capacity: ") + "" + (((((new Object() {
					public double getValue(IWorld world, BlockPos pos, String tag) {
						TileEntity tileEntity = world.getTileEntity(pos);
						if (tileEntity != null)
							return tileEntity.getTileData().getDouble(tag);
						return -1;
					}
				}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "capacity")) / 10)) + "" + (" IE")))));
				entity.getPersistentData().putString("level", (("Energy Stored: ") + "" + (((((new Object() {
					public double getValue(IWorld world, BlockPos pos, String tag) {
						TileEntity tileEntity = world.getTileEntity(pos);
						if (tileEntity != null)
							return tileEntity.getTileData().getDouble(tag);
						return -1;
					}
				}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "energy")) / 10)) + "" + (" IE")))));
				if ((BlockTags.getCollection()
						.getOrCreate(new ResourceLocation(("gratest_inventions:generator").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))) {
					entity.getPersistentData().putString("tickevent", (("Generating: ") + "" + (((((new Object() {
						public double getValue(IWorld world, BlockPos pos, String tag) {
							TileEntity tileEntity = world.getTileEntity(pos);
							if (tileEntity != null)
								return tileEntity.getTileData().getDouble(tag);
							return -1;
						}
					}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "generation")) / 10)) + "" + (" IE/T")))));
					entity.getPersistentData().putString("charging", "");
					entity.getPersistentData().putString("type", "Block Type: Generator");
				} else {
					entity.getPersistentData().putString("tickevent", (("Using. ") + "" + (((((new Object() {
						public double getValue(IWorld world, BlockPos pos, String tag) {
							TileEntity tileEntity = world.getTileEntity(pos);
							if (tileEntity != null)
								return tileEntity.getTileData().getDouble(tag);
							return -1;
						}
					}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "consumbtion")) / 10)) + "" + (" IE/T")))));
					entity.getPersistentData().putString("charging", (("Charging Rate: ") + "" + (((((new Object() {
						public double getValue(IWorld world, BlockPos pos, String tag) {
							TileEntity tileEntity = world.getTileEntity(pos);
							if (tileEntity != null)
								return tileEntity.getTileData().getDouble(tag);
							return -1;
						}
					}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "charging")) / 10)) + "" + (" IE/T")))));
					entity.getPersistentData().putString("type", "Block Type: Machine");
				}
			} else {
				if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
					world.getWorld().getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
							"data modify block ~ ~ ~ ForgeData.fluid set from block ~ ~ ~ fluidTank.FluidName");
				}
				entity.getPersistentData().putString("type", "Block Type: Tank");
				entity.getPersistentData().putString("capacity", (("Capacity: ") + "" + ((((new Object() {
					public int getFluidTankCapacity(BlockPos pos, int tank) {
						AtomicInteger _retval = new AtomicInteger(0);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null)
							_ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null)
									.ifPresent(capability -> _retval.set(capability.getTankCapacity(tank)));
						return _retval.get();
					}
				}.getFluidTankCapacity(new BlockPos((int) x, (int) y, (int) z), (int) 1))) + "" + (" mB")))));
				entity.getPersistentData().putString("level", (("Fluid Stored: ") + "" + ((((new Object() {
					public int getFluidTankLevel(BlockPos pos, int tank) {
						AtomicInteger _retval = new AtomicInteger(0);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null)
							_ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null)
									.ifPresent(capability -> _retval.set(capability.getFluidInTank(tank).getAmount()));
						return _retval.get();
					}
				}.getFluidTankLevel(new BlockPos((int) x, (int) y, (int) z), (int) 1))) + "" + (" mB")))));
				if ((!(((new Object() {
					public String getValue(IWorld world, BlockPos pos, String tag) {
						TileEntity tileEntity = world.getTileEntity(pos);
						if (tileEntity != null)
							return tileEntity.getTileData().getString(tag);
						return "";
					}
				}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "fluid"))).equals("")))) {
					laufvariabel = (double) 0;
					while ((!(((searchedChar)).equals(":")))) {
						searchedChar = (String) ((new Object() {
							public String getValue(IWorld world, BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getString(tag);
								return "";
							}
						}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "fluid")).substring((int) (laufvariabel),
								(int) ((laufvariabel) + 1)));
						laufvariabel = (double) ((laufvariabel) + 1);
					}
					searchedChar = (String) ((new Object() {
						public String getValue(IWorld world, BlockPos pos, String tag) {
							TileEntity tileEntity = world.getTileEntity(pos);
							if (tileEntity != null)
								return tileEntity.getTileData().getString(tag);
							return "";
						}
					}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "fluid")).substring((int) (laufvariabel), (int) ((new Object() {
						public String getValue(IWorld world, BlockPos pos, String tag) {
							TileEntity tileEntity = world.getTileEntity(pos);
							if (tileEntity != null)
								return tileEntity.getTileData().getString(tag);
							return "";
						}
					}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "fluid"))).length()));
					if ((((searchedChar)).equals("empty"))) {
						searchedChar = (String) "None";
					} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("a"))) {
						searchedChar = (String) (("A") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
					} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("b"))) {
						searchedChar = (String) (("B") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
					} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("c"))) {
						searchedChar = (String) (("C") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
					} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("d"))) {
						searchedChar = (String) (("D") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
					} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("e"))) {
						searchedChar = (String) (("E") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
					} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("f"))) {
						searchedChar = (String) (("F") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
					} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("g"))) {
						searchedChar = (String) (("G") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
					} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("h"))) {
						searchedChar = (String) (("H") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
					} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("i"))) {
						searchedChar = (String) (("I") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
					} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("j"))) {
						searchedChar = (String) (("J") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
					} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("k"))) {
						searchedChar = (String) (("K") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
					} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("l"))) {
						searchedChar = (String) (("L") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
					} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("m"))) {
						searchedChar = (String) (("M") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
					} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("n"))) {
						searchedChar = (String) (("N") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
					} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("o"))) {
						searchedChar = (String) (("O") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
					} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("p"))) {
						searchedChar = (String) (("P") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
					} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("q"))) {
						searchedChar = (String) (("Q") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
					} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("r"))) {
						searchedChar = (String) (("R") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
					} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("s"))) {
						searchedChar = (String) (("S") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
					} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("t"))) {
						searchedChar = (String) (("T") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
					} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("u"))) {
						searchedChar = (String) (("U") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
					} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("v"))) {
						searchedChar = (String) (("V") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
					} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("w"))) {
						searchedChar = (String) (("W") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
					} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("x"))) {
						searchedChar = (String) (("X") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
					} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("y"))) {
						searchedChar = (String) (("Y") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
					} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("z"))) {
						searchedChar = (String) (("Z") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
					}
				}
				entity.getPersistentData().putString("tickevent", (("Liquid: ") + "" + ((searchedChar))));
				entity.getPersistentData().putString("charging", "");
			}
		}
	}
}
