package net.mcreator.gratestinventions.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.FluidStack;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.world.GameType;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tags.ItemTags;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.BucketItem;
import net.minecraft.fluid.Fluids;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.gratestinventions.block.MilkBlock;
import net.mcreator.gratestinventions.block.EthanolBlock;
import net.mcreator.gratestinventions.GratestInventionsModElements;
import net.mcreator.gratestinventions.GratestInventionsMod;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.Map;

@GratestInventionsModElements.ModElement.Tag
public class DrumOnBlockRightClickedProcedure extends GratestInventionsModElements.ModElement {
	public DrumOnBlockRightClickedProcedure(GratestInventionsModElements instance) {
		super(instance, 139);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				GratestInventionsMod.LOGGER.warn("Failed to load dependency entity for procedure DrumOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				GratestInventionsMod.LOGGER.warn("Failed to load dependency x for procedure DrumOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				GratestInventionsMod.LOGGER.warn("Failed to load dependency y for procedure DrumOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				GratestInventionsMod.LOGGER.warn("Failed to load dependency z for procedure DrumOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				GratestInventionsMod.LOGGER.warn("Failed to load dependency world for procedure DrumOnBlockRightClicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		boolean bucketing = false;
		String targetItem = "";
		ItemStack nbtItem = ItemStack.EMPTY;
		if ((ItemTags.getCollection().getOrCreate(new ResourceLocation(("forge:liquids").toLowerCase(java.util.Locale.ENGLISH)))
				.contains(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem()))) {
			if ((/* @BlockState */(new Object() {
				public BlockState toBlock(ItemStack _bckt) {
					if (_bckt.getItem() instanceof BucketItem) {
						return ((BucketItem) _bckt.getItem()).getFluid().getDefaultState().getBlockState();
					}
					return Blocks.AIR.getDefaultState();
				}
			}.toBlock(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)))
					.getBlock() == MilkBlock.block.getDefaultState().getBlock())) {
				if (((new Object() {
					public int fillTankSimulate(IWorld world, BlockPos pos, int amount) {
						AtomicInteger _retval = new AtomicInteger(0);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null)
							_ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null).ifPresent(capability -> _retval
									.set(capability.fill(new FluidStack(MilkBlock.still, amount), IFluidHandler.FluidAction.SIMULATE)));
						return _retval.get();
					}
				}.fillTankSimulate(world, new BlockPos((int) x, (int) y, (int) z), (int) 1000)) == 1000)) {
					{
						TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
						int _amount = (int) 1000;
						if (_ent != null)
							_ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null).ifPresent(
									capability -> capability.fill(new FluidStack(MilkBlock.still, _amount), IFluidHandler.FluidAction.EXECUTE));
					}
					bucketing = (boolean) (true);
				}
			} else if ((/* @BlockState */(new Object() {
				public BlockState toBlock(ItemStack _bckt) {
					if (_bckt.getItem() instanceof BucketItem) {
						return ((BucketItem) _bckt.getItem()).getFluid().getDefaultState().getBlockState();
					}
					return Blocks.AIR.getDefaultState();
				}
			}.toBlock(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)))
					.getBlock() == EthanolBlock.block.getDefaultState().getBlock())) {
				if (((new Object() {
					public int fillTankSimulate(IWorld world, BlockPos pos, int amount) {
						AtomicInteger _retval = new AtomicInteger(0);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null)
							_ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null).ifPresent(capability -> _retval
									.set(capability.fill(new FluidStack(EthanolBlock.still, amount), IFluidHandler.FluidAction.SIMULATE)));
						return _retval.get();
					}
				}.fillTankSimulate(world, new BlockPos((int) x, (int) y, (int) z), (int) 1000)) == 1000)) {
					{
						TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
						int _amount = (int) 1000;
						if (_ent != null)
							_ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null).ifPresent(
									capability -> capability.fill(new FluidStack(EthanolBlock.still, _amount), IFluidHandler.FluidAction.EXECUTE));
					}
					bucketing = (boolean) (true);
				}
			} else if ((/* @BlockState */(new Object() {
				public BlockState toBlock(ItemStack _bckt) {
					if (_bckt.getItem() instanceof BucketItem) {
						return ((BucketItem) _bckt.getItem()).getFluid().getDefaultState().getBlockState();
					}
					return Blocks.AIR.getDefaultState();
				}
			}.toBlock(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)))
					.getBlock() == Blocks.WATER.getDefaultState().getBlock())) {
				if (((new Object() {
					public int fillTankSimulate(IWorld world, BlockPos pos, int amount) {
						AtomicInteger _retval = new AtomicInteger(0);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null)
							_ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null).ifPresent(capability -> _retval
									.set(capability.fill(new FluidStack(Fluids.WATER, amount), IFluidHandler.FluidAction.SIMULATE)));
						return _retval.get();
					}
				}.fillTankSimulate(world, new BlockPos((int) x, (int) y, (int) z), (int) 1000)) == 1000)) {
					{
						TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
						int _amount = (int) 1000;
						if (_ent != null)
							_ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null).ifPresent(
									capability -> capability.fill(new FluidStack(Fluids.WATER, _amount), IFluidHandler.FluidAction.EXECUTE));
					}
					bucketing = (boolean) (true);
				}
			} else if ((/* @BlockState */(new Object() {
				public BlockState toBlock(ItemStack _bckt) {
					if (_bckt.getItem() instanceof BucketItem) {
						return ((BucketItem) _bckt.getItem()).getFluid().getDefaultState().getBlockState();
					}
					return Blocks.AIR.getDefaultState();
				}
			}.toBlock(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))).getBlock() == Blocks.LAVA
					.getDefaultState().getBlock())) {
				if (((new Object() {
					public int fillTankSimulate(IWorld world, BlockPos pos, int amount) {
						AtomicInteger _retval = new AtomicInteger(0);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null)
							_ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null).ifPresent(capability -> _retval
									.set(capability.fill(new FluidStack(Fluids.LAVA, amount), IFluidHandler.FluidAction.SIMULATE)));
						return _retval.get();
					}
				}.fillTankSimulate(world, new BlockPos((int) x, (int) y, (int) z), (int) 1000)) == 1000)) {
					{
						TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
						int _amount = (int) 1000;
						if (_ent != null)
							_ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null).ifPresent(
									capability -> capability.fill(new FluidStack(Fluids.LAVA, _amount), IFluidHandler.FluidAction.EXECUTE));
					}
					bucketing = (boolean) (true);
				}
			}
			if ((bucketing)) {
				if ((!(new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayerEntity) {
							return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
						} else if (_ent instanceof PlayerEntity && _ent.world.isRemote) {
							NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
									.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
							return _npi != null && _npi.getGameType() == GameType.CREATIVE;
						}
						return false;
					}
				}.checkGamemode(entity)))) {
					if (entity instanceof LivingEntity) {
						ItemStack _setstack = new ItemStack(Items.BUCKET, (int) (1));
						_setstack.setCount((int) 1);
						((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
						if (entity instanceof ServerPlayerEntity)
							((ServerPlayerEntity) entity).inventory.markDirty();
					}
				}
				if (!world.getWorld().isRemote) {
					world.playSound(null, new BlockPos((int) x, (int) y, (int) z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.empty")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1);
				} else {
					world.getWorld().playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.empty")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
				}
			}
		} else if ((((new Object() {
			public int drainTankSimulate(IWorld world, BlockPos pos, int amount) {
				AtomicInteger _retval = new AtomicInteger(0);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null)
							.ifPresent(capability -> _retval.set(capability.drain(amount, IFluidHandler.FluidAction.SIMULATE).getAmount()));
				return _retval.get();
			}
		}.drainTankSimulate(world, new BlockPos((int) x, (int) y, (int) z), (int) 1000)) == 1000)
				&& (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(Items.BUCKET, (int) (1)).getItem()))) {
			if ((!(new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayerEntity) {
						return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
					} else if (_ent instanceof PlayerEntity && _ent.world.isRemote) {
						NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
								.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
						return _npi != null && _npi.getGameType() == GameType.CREATIVE;
					}
					return false;
				}
			}.checkGamemode(entity)))) {
				targetItem = (String) (new Object() {
					public String getValue(IWorld world, BlockPos pos, String tag) {
						TileEntity tileEntity = world.getTileEntity(pos);
						if (tileEntity != null)
							return tileEntity.getTileData().getString(tag);
						return "";
					}
				}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "fluid"));
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
					_setstack.setCount(
							(int) (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).getCount())
									- 1));
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
				{
					Entity _ent = entity;
					if (!_ent.world.isRemote && _ent.world.getServer() != null) {
						_ent.world.getServer().getCommandManager().handleCommand(
								_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
								(("give @s ") + "" + ((targetItem)) + "" + ("_bucket")));
					}
				}
			}
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
				int _amount = (int) 1000;
				if (_ent != null)
					_ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null)
							.ifPresent(capability -> capability.drain(_amount, IFluidHandler.FluidAction.EXECUTE));
			}
			if (!world.getWorld().isRemote) {
				world.playSound(null, new BlockPos((int) x, (int) y, (int) z),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.fill")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1);
			} else {
				world.getWorld().playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.fill")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
			}
		}
		if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
			world.getWorld().getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""),
							world.getWorld().getServer(), null).withFeedbackDisabled(),
					"data modify block ~ ~ ~ ForgeData.fluid set from block ~ ~ ~ fluidTank.FluidName");
		}
	}
}
