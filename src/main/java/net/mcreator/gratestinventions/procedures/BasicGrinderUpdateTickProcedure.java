package net.mcreator.gratestinventions.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.energy.CapabilityEnergy;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.gratestinventions.item.SilverShavingsItem;
import net.mcreator.gratestinventions.item.SilverIngotItem;
import net.mcreator.gratestinventions.item.PlatinumShavingsItem;
import net.mcreator.gratestinventions.item.PlatinumIngotItem;
import net.mcreator.gratestinventions.item.LeadShavingsItem;
import net.mcreator.gratestinventions.item.LeadIngotItem;
import net.mcreator.gratestinventions.item.IronShavingsItem;
import net.mcreator.gratestinventions.item.GoldShavingsItem;
import net.mcreator.gratestinventions.item.CopperShavingsItem;
import net.mcreator.gratestinventions.item.CopperIngotItem;
import net.mcreator.gratestinventions.block.SilverOreBlock;
import net.mcreator.gratestinventions.block.PlatinumOreBlock;
import net.mcreator.gratestinventions.block.LeadOreBlock;
import net.mcreator.gratestinventions.block.CopperOreBlock;
import net.mcreator.gratestinventions.GratestInventionsModElements;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Map;

@GratestInventionsModElements.ModElement.Tag
public class BasicGrinderUpdateTickProcedure extends GratestInventionsModElements.ModElement {
	public BasicGrinderUpdateTickProcedure(GratestInventionsModElements instance) {
		super(instance, 91);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure BasicGrinderUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure BasicGrinderUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure BasicGrinderUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure BasicGrinderUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		ItemStack providetItem = ItemStack.EMPTY;
		ItemStack result = ItemStack.EMPTY;
		ItemStack target = ItemStack.EMPTY;
		boolean on = false;
		boolean nb = false;
		boolean eb = false;
		boolean sb = false;
		boolean wb = false;
		boolean ub = false;
		boolean db = false;
		double charging = 0;
		double n = 0;
		double e = 0;
		double s = 0;
		double w = 0;
		double d = 0;
		double u = 0;
		double extracted = 0;
		double repeater = 0;
		double small = 0;
		double pos = 0;
		double required = 0;
		if (((new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "redstone")) == 0)) {
			on = (boolean) (true);
		} else if (((new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "redstone")) == 1)) {
			on = (boolean) (new Object() {
				public boolean getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "powered"));
		} else if (((new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "redstone")) == 2)) {
			on = (boolean) (!(new Object() {
				public boolean getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "powered")));
		} else {
			on = (boolean) (false);
		}
		if (((new Object() {
			public int getEnergyStored(BlockPos pos) {
				AtomicInteger _retval = new AtomicInteger(0);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
				return _retval.get();
			}
		}.getEnergyStored(new BlockPos((int) x, (int) y, (int) z))) < (new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "capacity")))) {
			nb = (boolean) (false);
			eb = (boolean) (false);
			sb = (boolean) (false);
			wb = (boolean) (false);
			ub = (boolean) (false);
			db = (boolean) (false);
			charging = (double) (new Object() {
				public double getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "charging"));
			extracted = (double) (charging);
			repeater = (double) 6;
			if ((BlockTags.getCollection().getOrCreate(new ResourceLocation(("gratest_inventions:generator").toLowerCase(java.util.Locale.ENGLISH)))
					.contains((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock()))) {
				n = (double) (new Object() {
					public int extractEnergySimulate(BlockPos pos, int _amount) {
						AtomicInteger _retval = new AtomicInteger(0);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null)
							_ent.getCapability(CapabilityEnergy.ENERGY, null)
									.ifPresent(capability -> _retval.set(capability.extractEnergy(_amount, true)));
						return _retval.get();
					}
				}.extractEnergySimulate(new BlockPos((int) (x + 1), (int) y, (int) z), (int) (charging)));
			}
			if ((BlockTags.getCollection().getOrCreate(new ResourceLocation(("gratest_inventions:generator").toLowerCase(java.util.Locale.ENGLISH)))
					.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock()))) {
				e = (double) (new Object() {
					public int extractEnergySimulate(BlockPos pos, int _amount) {
						AtomicInteger _retval = new AtomicInteger(0);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null)
							_ent.getCapability(CapabilityEnergy.ENERGY, null)
									.ifPresent(capability -> _retval.set(capability.extractEnergy(_amount, true)));
						return _retval.get();
					}
				}.extractEnergySimulate(new BlockPos((int) x, (int) y, (int) (z + 1)), (int) (charging)));
			}
			if ((BlockTags.getCollection().getOrCreate(new ResourceLocation(("gratest_inventions:generator").toLowerCase(java.util.Locale.ENGLISH)))
					.contains((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock()))) {
				s = (double) (new Object() {
					public int extractEnergySimulate(BlockPos pos, int _amount) {
						AtomicInteger _retval = new AtomicInteger(0);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null)
							_ent.getCapability(CapabilityEnergy.ENERGY, null)
									.ifPresent(capability -> _retval.set(capability.extractEnergy(_amount, true)));
						return _retval.get();
					}
				}.extractEnergySimulate(new BlockPos((int) (x - 1), (int) y, (int) z), (int) (charging)));
			}
			if ((BlockTags.getCollection().getOrCreate(new ResourceLocation(("gratest_inventions:generator").toLowerCase(java.util.Locale.ENGLISH)))
					.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock()))) {
				w = (double) (new Object() {
					public int extractEnergySimulate(BlockPos pos, int _amount) {
						AtomicInteger _retval = new AtomicInteger(0);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null)
							_ent.getCapability(CapabilityEnergy.ENERGY, null)
									.ifPresent(capability -> _retval.set(capability.extractEnergy(_amount, true)));
						return _retval.get();
					}
				}.extractEnergySimulate(new BlockPos((int) x, (int) y, (int) (z - 1)), (int) (charging)));
			}
			if ((BlockTags.getCollection().getOrCreate(new ResourceLocation(("gratest_inventions:generator").toLowerCase(java.util.Locale.ENGLISH)))
					.contains((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock()))) {
				u = (double) (new Object() {
					public int extractEnergySimulate(BlockPos pos, int _amount) {
						AtomicInteger _retval = new AtomicInteger(0);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null)
							_ent.getCapability(CapabilityEnergy.ENERGY, null)
									.ifPresent(capability -> _retval.set(capability.extractEnergy(_amount, true)));
						return _retval.get();
					}
				}.extractEnergySimulate(new BlockPos((int) x, (int) (y + 1), (int) z), (int) (charging)));
			}
			if ((BlockTags.getCollection().getOrCreate(new ResourceLocation(("gratest_inventions:generator").toLowerCase(java.util.Locale.ENGLISH)))
					.contains((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock()))) {
				d = (double) (new Object() {
					public int extractEnergySimulate(BlockPos pos, int _amount) {
						AtomicInteger _retval = new AtomicInteger(0);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null)
							_ent.getCapability(CapabilityEnergy.ENERGY, null)
									.ifPresent(capability -> _retval.set(capability.extractEnergy(_amount, true)));
						return _retval.get();
					}
				}.extractEnergySimulate(new BlockPos((int) x, (int) (y - 1), (int) z), (int) (charging)));
			}
			for (int index0 = 0; index0 < (int) (6); index0++) {
				small = (double) Double.POSITIVE_INFINITY;
				if (((nb) != (true))) {
					small = (double) (n);
					pos = (double) 1;
				}
				if (((eb) != (true))) {
					if (((e) < (small))) {
						small = (double) (e);
						pos = (double) 2;
					}
				}
				if (((sb) != (true))) {
					if (((s) < (small))) {
						small = (double) (s);
						pos = (double) 3;
					}
				}
				if (((wb) != (true))) {
					if (((w) < (small))) {
						small = (double) (w);
						pos = (double) 4;
					}
				}
				if (((ub) != (true))) {
					if (((u) < (small))) {
						small = (double) (u);
						pos = (double) 5;
					}
				}
				if (((db) != (true))) {
					if (((d) < (small))) {
						small = (double) (d);
						pos = (double) 6;
					}
				}
				if (((pos) == 1)) {
					if (((n) < ((extracted) / (repeater)))) {
						{
							TileEntity _ent = world.getTileEntity(new BlockPos((int) (x + 1), (int) y, (int) z));
							int _amount = (int) Math.floor((n));
							if (_ent != null)
								_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
						}
						extracted = (double) ((extracted) - Math.floor((n)));
					} else {
						{
							TileEntity _ent = world.getTileEntity(new BlockPos((int) (x + 1), (int) y, (int) z));
							int _amount = (int) Math.floor(((extracted) / (repeater)));
							if (_ent != null)
								_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
						}
						extracted = (double) ((extracted) - Math.floor(((extracted) / (repeater))));
					}
					nb = (boolean) (true);
				} else if (((pos) == 2)) {
					if (((e) < ((extracted) / (repeater)))) {
						{
							TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) (z + 1)));
							int _amount = (int) Math.floor((e));
							if (_ent != null)
								_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
						}
						extracted = (double) ((extracted) - Math.floor((e)));
					} else {
						{
							TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) (z + 1)));
							int _amount = (int) Math.floor(((extracted) / (repeater)));
							if (_ent != null)
								_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
						}
						extracted = (double) ((extracted) - Math.floor(((extracted) / (repeater))));
					}
					eb = (boolean) (true);
				} else if (((pos) == 3)) {
					if (((s) < ((extracted) / (repeater)))) {
						{
							TileEntity _ent = world.getTileEntity(new BlockPos((int) (x - 1), (int) y, (int) z));
							int _amount = (int) Math.floor((s));
							if (_ent != null)
								_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
						}
						extracted = (double) ((extracted) - Math.floor((s)));
					} else {
						{
							TileEntity _ent = world.getTileEntity(new BlockPos((int) (x - 1), (int) y, (int) z));
							int _amount = (int) Math.floor(((extracted) / (repeater)));
							if (_ent != null)
								_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
						}
						extracted = (double) ((extracted) - Math.floor(((extracted) / (repeater))));
					}
					sb = (boolean) (true);
				} else if (((pos) == 4)) {
					if (((w) < ((extracted) / (repeater)))) {
						{
							TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) (z - 1)));
							int _amount = (int) Math.floor((w));
							if (_ent != null)
								_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
						}
						extracted = (double) ((extracted) - Math.floor((w)));
					} else {
						{
							TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) (z - 1)));
							int _amount = (int) Math.floor(((extracted) / (repeater)));
							if (_ent != null)
								_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
						}
						extracted = (double) ((extracted) - Math.floor(((extracted) / (repeater))));
					}
					wb = (boolean) (true);
				} else if (((pos) == 5)) {
					if (((u) < ((extracted) / (repeater)))) {
						{
							TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) (y + 1), (int) z));
							int _amount = (int) Math.floor((u));
							if (_ent != null)
								_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
						}
						extracted = (double) ((extracted) - Math.floor((u)));
					} else {
						{
							TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) (y + 1), (int) z));
							int _amount = (int) Math.floor(((extracted) / (repeater)));
							if (_ent != null)
								_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
						}
						extracted = (double) ((extracted) - Math.floor(((extracted) / (repeater))));
					}
					ub = (boolean) (true);
				} else if (((pos) == 6)) {
					if (((d) < ((extracted) / (repeater)))) {
						{
							TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) (y - 1), (int) z));
							int _amount = (int) Math.floor((d));
							if (_ent != null)
								_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
						}
						extracted = (double) ((extracted) - Math.floor((d)));
					} else {
						{
							TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) (y - 1), (int) z));
							int _amount = (int) Math.floor(((extracted) / (repeater)));
							if (_ent != null)
								_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
						}
						extracted = (double) ((extracted) - Math.floor(((extracted) / (repeater))));
					}
					db = (boolean) (true);
				}
				repeater = (double) ((repeater) - 1);
				if (((repeater) == 0)) {
					{
						TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
						int _amount = (int) Math.floor(((charging) - (extracted)));
						if (_ent != null)
							_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.receiveEnergy(_amount, false));
					}
				}
			}
		}
		if (((new Object() {
			public int getEnergyStored(BlockPos pos) {
				AtomicInteger _retval = new AtomicInteger(0);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
				return _retval.get();
			}
		}.getEnergyStored(new BlockPos((int) x, (int) y, (int) z))) > (new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "consumbtion")))) {
			if ((((ItemTags.getCollection().getOrCreate(new ResourceLocation(("gratest_inventions:grinding").toLowerCase(java.util.Locale.ENGLISH)))
					.contains((new Object() {
						public ItemStack getItemStack(BlockPos pos, int sltid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							TileEntity _ent = world.getTileEntity(pos);
							if (_ent != null) {
								_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									_retval.set(capability.getStackInSlot(sltid).copy());
								});
							}
							return _retval.get();
						}
					}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem())) && ((new Object() {
						public double getValue(BlockPos pos, String tag) {
							TileEntity tileEntity = world.getTileEntity(pos);
							if (tileEntity != null)
								return tileEntity.getTileData().getDouble(tag);
							return -1;
						}
					}.getValue(new BlockPos((int) x, (int) y, (int) z), "gear")) == 0)) && ((on) == (true)))) {
				target = (new Object() {
					public ItemStack getItemStack(BlockPos pos, int sltid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null) {
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).copy());
							});
						}
						return _retval.get();
					}
				}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0)));
				if (((target).getItem() == new ItemStack(Blocks.COBBLESTONE, (int) (1)).getItem())) {
					result = new ItemStack(Blocks.GRAVEL, (int) (1));
					required = (double) 64;
				} else if (((target).getItem() == new ItemStack(Blocks.GRAVEL, (int) (1)).getItem())) {
					result = new ItemStack(Blocks.SAND, (int) (1));
					required = (double) 64;
				} else if (((target).getItem() == new ItemStack(CopperOreBlock.block, (int) (1)).getItem())) {
					result = new ItemStack(CopperShavingsItem.block, (int) (1));
					required = (double) 63;
				} else if (((target).getItem() == new ItemStack(SilverOreBlock.block, (int) (1)).getItem())) {
					result = new ItemStack(SilverShavingsItem.block, (int) (1));
					required = (double) 63;
				} else if (((target).getItem() == new ItemStack(LeadOreBlock.block, (int) (1)).getItem())) {
					result = new ItemStack(LeadShavingsItem.block, (int) (1));
					required = (double) 63;
				} else if (((target).getItem() == new ItemStack(PlatinumOreBlock.block, (int) (1)).getItem())) {
					result = new ItemStack(PlatinumShavingsItem.block, (int) (1));
					required = (double) 63;
				} else if (((target).getItem() == new ItemStack(Blocks.IRON_ORE, (int) (1)).getItem())) {
					result = new ItemStack(IronShavingsItem.block, (int) (1));
					required = (double) 63;
				} else if (((target).getItem() == new ItemStack(Blocks.GOLD_ORE, (int) (1)).getItem())) {
					result = new ItemStack(GoldShavingsItem.block, (int) (1));
					required = (double) 63;
				} else if (((target).getItem() == new ItemStack(CopperIngotItem.block, (int) (1)).getItem())) {
					result = new ItemStack(CopperShavingsItem.block, (int) (1));
					required = (double) 64;
				} else if (((target).getItem() == new ItemStack(PlatinumIngotItem.block, (int) (1)).getItem())) {
					result = new ItemStack(PlatinumShavingsItem.block, (int) (1));
					required = (double) 64;
				} else if (((target).getItem() == new ItemStack(SilverIngotItem.block, (int) (1)).getItem())) {
					result = new ItemStack(SilverShavingsItem.block, (int) (1));
					required = (double) 64;
				} else if (((target).getItem() == new ItemStack(LeadIngotItem.block, (int) (1)).getItem())) {
					result = new ItemStack(LeadShavingsItem.block, (int) (1));
					required = (double) 64;
				} else if (((target).getItem() == new ItemStack(Items.IRON_INGOT, (int) (1)).getItem())) {
					result = new ItemStack(IronShavingsItem.block, (int) (1));
					required = (double) 64;
				} else if (((target).getItem() == new ItemStack(Items.GOLD_INGOT, (int) (1)).getItem())) {
					result = new ItemStack(GoldShavingsItem.block, (int) (1));
					required = (double) 64;
				}
				if ((((((result).getItem() == (new Object() {
					public ItemStack getItemStack(BlockPos pos, int sltid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null) {
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).copy());
							});
						}
						return _retval.get();
					}
				}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (1))).getItem()) && ((new Object() {
					public int getAmount(BlockPos pos, int sltid) {
						AtomicInteger _retval = new AtomicInteger(0);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null) {
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).getCount());
							});
						}
						return _retval.get();
					}
				}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (1))) < (required))) || ((new Object() {
					public int getAmount(BlockPos pos, int sltid) {
						AtomicInteger _retval = new AtomicInteger(0);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null) {
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).getCount());
							});
						}
						return _retval.get();
					}
				}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (1))) == 0)) && ((new Object() {
					public int getAmount(BlockPos pos, int sltid) {
						AtomicInteger _retval = new AtomicInteger(0);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null) {
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).getCount());
							});
						}
						return _retval.get();
					}
				}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (0))) != 0))) {
					if (!world.getWorld().isRemote) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putDouble("duration", 80);
						world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					if (!world.getWorld().isRemote) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putDouble("gear", 100);
						world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					{
						TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
						if (_ent != null) {
							final int _sltid = (int) (2);
							final ItemStack _setstack = (new Object() {
								public ItemStack getItemStack(BlockPos pos, int sltid) {
									AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
									TileEntity _ent = world.getTileEntity(pos);
									if (_ent != null) {
										_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
											_retval.set(capability.getStackInSlot(sltid).copy());
										});
									}
									return _retval.get();
								}
							}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0)));
							_setstack.setCount((int) 1);
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								if (capability instanceof IItemHandlerModifiable) {
									((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
								}
							});
						}
					}
					{
						TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
						if (_ent != null) {
							final int _sltid = (int) (0);
							final ItemStack _setstack = (new Object() {
								public ItemStack getItemStack(BlockPos pos, int sltid) {
									AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
									TileEntity _ent = world.getTileEntity(pos);
									if (_ent != null) {
										_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
											_retval.set(capability.getStackInSlot(sltid).copy());
										});
									}
									return _retval.get();
								}
							}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0)));
							_setstack.setCount((int) ((new Object() {
								public int getAmount(BlockPos pos, int sltid) {
									AtomicInteger _retval = new AtomicInteger(0);
									TileEntity _ent = world.getTileEntity(pos);
									if (_ent != null) {
										_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
											_retval.set(capability.getStackInSlot(sltid).getCount());
										});
									}
									return _retval.get();
								}
							}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (0))) - 1));
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								if (capability instanceof IItemHandlerModifiable) {
									((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
								}
							});
						}
					}
				}
			}
			if (((new Object() {
				public double getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "gear")) > 0)) {
				{
					TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
					int _amount = (int) (new Object() {
						public double getValue(BlockPos pos, String tag) {
							TileEntity tileEntity = world.getTileEntity(pos);
							if (tileEntity != null)
								return tileEntity.getTileData().getDouble(tag);
							return -1;
						}
					}.getValue(new BlockPos((int) x, (int) y, (int) z), "consumbtion"));
					if (_ent != null)
						_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
				}
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("gear", ((new Object() {
							public double getValue(BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getDouble(tag);
								return -1;
							}
						}.getValue(new BlockPos((int) x, (int) y, (int) z), "gear")) - (100 / (new Object() {
							public double getValue(BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getDouble(tag);
								return -1;
							}
						}.getValue(new BlockPos((int) x, (int) y, (int) z), "duration")))));
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (((new Object() {
					public double getValue(BlockPos pos, String tag) {
						TileEntity tileEntity = world.getTileEntity(pos);
						if (tileEntity != null)
							return tileEntity.getTileData().getDouble(tag);
						return -1;
					}
				}.getValue(new BlockPos((int) x, (int) y, (int) z), "gear")) <= 0)) {
					if (!world.getWorld().isRemote) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putDouble("gear", 0);
						world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					if (!world.getWorld().isRemote) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putDouble("duration", 0);
						world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					providetItem = (new Object() {
						public ItemStack getItemStack(BlockPos pos, int sltid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							TileEntity _ent = world.getTileEntity(pos);
							if (_ent != null) {
								_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									_retval.set(capability.getStackInSlot(sltid).copy());
								});
							}
							return _retval.get();
						}
					}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (2)));
					if (((providetItem).getItem() == new ItemStack(Blocks.COBBLESTONE, (int) (1)).getItem())) {
						{
							TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
							if (_ent != null) {
								final int _sltid = (int) (1);
								final ItemStack _setstack = new ItemStack(Blocks.GRAVEL, (int) (1));
								_setstack.setCount((int) ((new Object() {
									public int getAmount(BlockPos pos, int sltid) {
										AtomicInteger _retval = new AtomicInteger(0);
										TileEntity _ent = world.getTileEntity(pos);
										if (_ent != null) {
											_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
												_retval.set(capability.getStackInSlot(sltid).getCount());
											});
										}
										return _retval.get();
									}
								}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (1))) + 1));
								_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable) {
										((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
									}
								});
							}
						}
					} else if (((providetItem).getItem() == new ItemStack(Blocks.GRAVEL, (int) (1)).getItem())) {
						{
							TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
							if (_ent != null) {
								final int _sltid = (int) (1);
								final ItemStack _setstack = new ItemStack(Blocks.SAND, (int) (1));
								_setstack.setCount((int) ((new Object() {
									public int getAmount(BlockPos pos, int sltid) {
										AtomicInteger _retval = new AtomicInteger(0);
										TileEntity _ent = world.getTileEntity(pos);
										if (_ent != null) {
											_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
												_retval.set(capability.getStackInSlot(sltid).getCount());
											});
										}
										return _retval.get();
									}
								}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (1))) + 1));
								_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable) {
										((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
									}
								});
							}
						}
					} else if (((providetItem).getItem() == new ItemStack(CopperOreBlock.block, (int) (1)).getItem())) {
						{
							TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
							if (_ent != null) {
								final int _sltid = (int) (1);
								final ItemStack _setstack = new ItemStack(CopperShavingsItem.block, (int) (1));
								_setstack.setCount((int) ((new Object() {
									public int getAmount(BlockPos pos, int sltid) {
										AtomicInteger _retval = new AtomicInteger(0);
										TileEntity _ent = world.getTileEntity(pos);
										if (_ent != null) {
											_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
												_retval.set(capability.getStackInSlot(sltid).getCount());
											});
										}
										return _retval.get();
									}
								}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (1))) + 2));
								_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable) {
										((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
									}
								});
							}
						}
					} else if (((providetItem).getItem() == new ItemStack(SilverOreBlock.block, (int) (1)).getItem())) {
						{
							TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
							if (_ent != null) {
								final int _sltid = (int) (1);
								final ItemStack _setstack = new ItemStack(SilverShavingsItem.block, (int) (1));
								_setstack.setCount((int) ((new Object() {
									public int getAmount(BlockPos pos, int sltid) {
										AtomicInteger _retval = new AtomicInteger(0);
										TileEntity _ent = world.getTileEntity(pos);
										if (_ent != null) {
											_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
												_retval.set(capability.getStackInSlot(sltid).getCount());
											});
										}
										return _retval.get();
									}
								}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (1))) + 2));
								_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable) {
										((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
									}
								});
							}
						}
					} else if (((providetItem).getItem() == new ItemStack(PlatinumOreBlock.block, (int) (1)).getItem())) {
						{
							TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
							if (_ent != null) {
								final int _sltid = (int) (1);
								final ItemStack _setstack = new ItemStack(PlatinumShavingsItem.block, (int) (1));
								_setstack.setCount((int) ((new Object() {
									public int getAmount(BlockPos pos, int sltid) {
										AtomicInteger _retval = new AtomicInteger(0);
										TileEntity _ent = world.getTileEntity(pos);
										if (_ent != null) {
											_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
												_retval.set(capability.getStackInSlot(sltid).getCount());
											});
										}
										return _retval.get();
									}
								}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (1))) + 2));
								_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable) {
										((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
									}
								});
							}
						}
					} else if (((providetItem).getItem() == new ItemStack(LeadOreBlock.block, (int) (1)).getItem())) {
						{
							TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
							if (_ent != null) {
								final int _sltid = (int) (1);
								final ItemStack _setstack = new ItemStack(LeadShavingsItem.block, (int) (1));
								_setstack.setCount((int) ((new Object() {
									public int getAmount(BlockPos pos, int sltid) {
										AtomicInteger _retval = new AtomicInteger(0);
										TileEntity _ent = world.getTileEntity(pos);
										if (_ent != null) {
											_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
												_retval.set(capability.getStackInSlot(sltid).getCount());
											});
										}
										return _retval.get();
									}
								}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (1))) + 2));
								_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable) {
										((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
									}
								});
							}
						}
					} else if (((providetItem).getItem() == new ItemStack(Blocks.GOLD_ORE, (int) (1)).getItem())) {
						{
							TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
							if (_ent != null) {
								final int _sltid = (int) (1);
								final ItemStack _setstack = new ItemStack(GoldShavingsItem.block, (int) (1));
								_setstack.setCount((int) ((new Object() {
									public int getAmount(BlockPos pos, int sltid) {
										AtomicInteger _retval = new AtomicInteger(0);
										TileEntity _ent = world.getTileEntity(pos);
										if (_ent != null) {
											_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
												_retval.set(capability.getStackInSlot(sltid).getCount());
											});
										}
										return _retval.get();
									}
								}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (1))) + 2));
								_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable) {
										((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
									}
								});
							}
						}
					} else if (((providetItem).getItem() == new ItemStack(Blocks.IRON_ORE, (int) (1)).getItem())) {
						{
							TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
							if (_ent != null) {
								final int _sltid = (int) (1);
								final ItemStack _setstack = new ItemStack(IronShavingsItem.block, (int) (1));
								_setstack.setCount((int) ((new Object() {
									public int getAmount(BlockPos pos, int sltid) {
										AtomicInteger _retval = new AtomicInteger(0);
										TileEntity _ent = world.getTileEntity(pos);
										if (_ent != null) {
											_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
												_retval.set(capability.getStackInSlot(sltid).getCount());
											});
										}
										return _retval.get();
									}
								}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (1))) + 2));
								_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable) {
										((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
									}
								});
							}
						}
					} else if (((providetItem).getItem() == new ItemStack(CopperIngotItem.block, (int) (1)).getItem())) {
						{
							TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
							if (_ent != null) {
								final int _sltid = (int) (1);
								final ItemStack _setstack = new ItemStack(CopperShavingsItem.block, (int) (1));
								_setstack.setCount((int) ((new Object() {
									public int getAmount(BlockPos pos, int sltid) {
										AtomicInteger _retval = new AtomicInteger(0);
										TileEntity _ent = world.getTileEntity(pos);
										if (_ent != null) {
											_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
												_retval.set(capability.getStackInSlot(sltid).getCount());
											});
										}
										return _retval.get();
									}
								}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (1))) + 1));
								_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable) {
										((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
									}
								});
							}
						}
					} else if (((providetItem).getItem() == new ItemStack(PlatinumIngotItem.block, (int) (1)).getItem())) {
						{
							TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
							if (_ent != null) {
								final int _sltid = (int) (1);
								final ItemStack _setstack = new ItemStack(PlatinumShavingsItem.block, (int) (1));
								_setstack.setCount((int) ((new Object() {
									public int getAmount(BlockPos pos, int sltid) {
										AtomicInteger _retval = new AtomicInteger(0);
										TileEntity _ent = world.getTileEntity(pos);
										if (_ent != null) {
											_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
												_retval.set(capability.getStackInSlot(sltid).getCount());
											});
										}
										return _retval.get();
									}
								}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (1))) + 1));
								_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable) {
										((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
									}
								});
							}
						}
					} else if (((providetItem).getItem() == new ItemStack(SilverIngotItem.block, (int) (1)).getItem())) {
						{
							TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
							if (_ent != null) {
								final int _sltid = (int) (1);
								final ItemStack _setstack = new ItemStack(SilverShavingsItem.block, (int) (1));
								_setstack.setCount((int) ((new Object() {
									public int getAmount(BlockPos pos, int sltid) {
										AtomicInteger _retval = new AtomicInteger(0);
										TileEntity _ent = world.getTileEntity(pos);
										if (_ent != null) {
											_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
												_retval.set(capability.getStackInSlot(sltid).getCount());
											});
										}
										return _retval.get();
									}
								}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (1))) + 1));
								_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable) {
										((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
									}
								});
							}
						}
					} else if (((providetItem).getItem() == new ItemStack(LeadIngotItem.block, (int) (1)).getItem())) {
						{
							TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
							if (_ent != null) {
								final int _sltid = (int) (1);
								final ItemStack _setstack = new ItemStack(LeadShavingsItem.block, (int) (1));
								_setstack.setCount((int) ((new Object() {
									public int getAmount(BlockPos pos, int sltid) {
										AtomicInteger _retval = new AtomicInteger(0);
										TileEntity _ent = world.getTileEntity(pos);
										if (_ent != null) {
											_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
												_retval.set(capability.getStackInSlot(sltid).getCount());
											});
										}
										return _retval.get();
									}
								}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (1))) + 1));
								_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable) {
										((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
									}
								});
							}
						}
					} else if (((providetItem).getItem() == new ItemStack(Items.IRON_INGOT, (int) (1)).getItem())) {
						{
							TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
							if (_ent != null) {
								final int _sltid = (int) (1);
								final ItemStack _setstack = new ItemStack(IronShavingsItem.block, (int) (1));
								_setstack.setCount((int) ((new Object() {
									public int getAmount(BlockPos pos, int sltid) {
										AtomicInteger _retval = new AtomicInteger(0);
										TileEntity _ent = world.getTileEntity(pos);
										if (_ent != null) {
											_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
												_retval.set(capability.getStackInSlot(sltid).getCount());
											});
										}
										return _retval.get();
									}
								}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (1))) + 1));
								_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable) {
										((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
									}
								});
							}
						}
					} else if (((providetItem).getItem() == new ItemStack(Items.GOLD_INGOT, (int) (1)).getItem())) {
						{
							TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
							if (_ent != null) {
								final int _sltid = (int) (1);
								final ItemStack _setstack = new ItemStack(GoldShavingsItem.block, (int) (1));
								_setstack.setCount((int) ((new Object() {
									public int getAmount(BlockPos pos, int sltid) {
										AtomicInteger _retval = new AtomicInteger(0);
										TileEntity _ent = world.getTileEntity(pos);
										if (_ent != null) {
											_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
												_retval.set(capability.getStackInSlot(sltid).getCount());
											});
										}
										return _retval.get();
									}
								}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (1))) + 1));
								_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable) {
										((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
									}
								});
							}
						}
					}
					{
						TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
						if (_ent != null) {
							final int _sltid = (int) (2);
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								if (capability instanceof IItemHandlerModifiable) {
									((IItemHandlerModifiable) capability).setStackInSlot(_sltid, ItemStack.EMPTY);
								}
							});
						}
					}
				}
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("tick", ((new Object() {
							public double getValue(BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getDouble(tag);
								return -1;
							}
						}.getValue(new BlockPos((int) x, (int) y, (int) z), "tick")) + 1));
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (((new Object() {
					public double getValue(BlockPos pos, String tag) {
						TileEntity tileEntity = world.getTileEntity(pos);
						if (tileEntity != null)
							return tileEntity.getTileData().getDouble(tag);
						return -1;
					}
				}.getValue(new BlockPos((int) x, (int) y, (int) z), "tick")) > 23)) {
					if (!world.getWorld().isRemote) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putDouble("tick", 0);
						world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				}
			}
			if (!world.getWorld().isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("energy", (new Object() {
						public int getEnergyStored(BlockPos pos) {
							AtomicInteger _retval = new AtomicInteger(0);
							TileEntity _ent = world.getTileEntity(pos);
							if (_ent != null)
								_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
							return _retval.get();
						}
					}.getEnergyStored(new BlockPos((int) x, (int) y, (int) z))));
				world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
		}
	}
}
