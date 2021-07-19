package net.mcreator.gratestinventions.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.GameType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.gratestinventions.entity.ShearedCowEntity;
import net.mcreator.gratestinventions.GratestInventionsModElements;
import net.mcreator.gratestinventions.GratestInventionsMod;

import java.util.Random;
import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;

@GratestInventionsModElements.ModElement.Tag
public class ShearOnCowProcedure extends GratestInventionsModElements.ModElement {
	public ShearOnCowProcedure(GratestInventionsModElements instance) {
		super(instance, 129);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				GratestInventionsMod.LOGGER.warn("Failed to load dependency entity for procedure ShearOnCow!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				GratestInventionsMod.LOGGER.warn("Failed to load dependency sourceentity for procedure ShearOnCow!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				GratestInventionsMod.LOGGER.warn("Failed to load dependency world for procedure ShearOnCow!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		IWorld world = (IWorld) dependencies.get("world");
		double xPos = 0;
		double yPos = 0;
		double zPos = 0;
		double yaw = 0;
		double pitch = 0;
		double vX = 0;
		double vY = 0;
		double vZ = 0;
		double luck = 0;
		if ((((("CowEntity").equals((((entity) + "" + ("")).substring((int) 0, (int) 9)))) && (Math.ceil((entity.getHeight())) == 2))
				&& ((new ItemStack(Items.SHEARS, (int) (1))
						.getItem() == ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemOffhand() : ItemStack.EMPTY)
								.getItem())
						|| (new ItemStack(Items.SHEARS, (int) (1)).getItem() == ((sourceentity instanceof LivingEntity)
								? ((LivingEntity) sourceentity).getHeldItemMainhand()
								: ItemStack.EMPTY).getItem())))) {
			xPos = (double) (entity.getPosX());
			yPos = (double) (entity.getPosY());
			zPos = (double) (entity.getPosZ());
			yaw = (double) (entity.rotationYaw);
			pitch = (double) (entity.rotationPitch);
			vX = (double) (entity.getMotion().getX());
			vY = (double) (entity.getMotion().getY());
			vZ = (double) (entity.getMotion().getZ());
			if (!entity.world.isRemote)
				entity.remove();
			if (world instanceof World && !world.getWorld().isRemote) {
				Entity entityToSpawn = new ShearedCowEntity.CustomEntity(ShearedCowEntity.entity, world.getWorld());
				entityToSpawn.setLocationAndAngles((xPos), (yPos), (zPos), (float) (yaw), (float) (pitch));
				entityToSpawn.setRenderYawOffset((float) (yaw));
				entityToSpawn.setMotion((vX), (vY), (vZ));
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn(world, world.getDifficultyForLocation(new BlockPos(entityToSpawn)),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			if (!world.getWorld().isRemote) {
				world.playSound(null, new BlockPos((int) (xPos), (int) (yPos), (int) (zPos)),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.sheep.shear")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1);
			} else {
				world.getWorld().playSound((xPos), (yPos), (zPos),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.sheep.shear")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
			}
			if (!world.getWorld().isRemote) {
				world.playSound(null, new BlockPos((int) (xPos), (int) (yPos), (int) (zPos)),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chorus_flower.death")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1.5);
			} else {
				world.getWorld().playSound((xPos), (yPos), (zPos),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chorus_flower.death")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1.5, false);
			}
			if (!world.getWorld().isRemote) {
				world.playSound(null, new BlockPos((int) (xPos), (int) (yPos), (int) (zPos)),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ui.stonecutter.take_result")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1.5);
			} else {
				world.getWorld().playSound((xPos), (yPos), (zPos),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ui.stonecutter.take_result")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1.5, false);
			}
			if (!world.getWorld().isRemote) {
				world.playSound(null, new BlockPos((int) (xPos), (int) (yPos), (int) (zPos)),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.cow.death")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1.4);
			} else {
				world.getWorld().playSound((xPos), (yPos), (zPos),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.cow.death")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1.4, false);
			}
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.LAVA, (xPos), (yPos), (zPos), (int) 100, 0.5, 0.5, 0.5, 2);
			}
			if ((((EnchantmentHelper.getEnchantmentLevel(Enchantments.LOOTING,
					((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY))) >= 3)
					|| ((EnchantmentHelper.getEnchantmentLevel(Enchantments.LOOTING,
							((sourceentity instanceof LivingEntity)
									? ((LivingEntity) sourceentity).getHeldItemOffhand()
									: ItemStack.EMPTY))) == 3))) {
				luck = (double) 5;
			} else if ((((EnchantmentHelper.getEnchantmentLevel(Enchantments.LOOTING,
					((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY))) == 2)
					|| ((EnchantmentHelper.getEnchantmentLevel(Enchantments.LOOTING,
							((sourceentity instanceof LivingEntity)
									? ((LivingEntity) sourceentity).getHeldItemOffhand()
									: ItemStack.EMPTY))) == 2))) {
				luck = (double) 4;
			} else if ((((EnchantmentHelper.getEnchantmentLevel(Enchantments.LOOTING,
					((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY))) == 1)
					|| ((EnchantmentHelper.getEnchantmentLevel(Enchantments.LOOTING,
							((sourceentity instanceof LivingEntity)
									? ((LivingEntity) sourceentity).getHeldItemOffhand()
									: ItemStack.EMPTY))) == 1))) {
				luck = (double) 3;
			} else {
				luck = (double) 2;
			}
			for (int index0 = 0; index0 < (int) (Math.ceil(((luck) * Math.random()))); index0++) {
				if (!world.getWorld().isRemote) {
					ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), (xPos), (yPos), (zPos), new ItemStack(Items.LEATHER, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			}
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
			}.checkGamemode(sourceentity)))) {
				if ((new ItemStack(Items.SHEARS, (int) (1))
						.getItem() == ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
								.getItem())) {
					{
						ItemStack _ist = ((sourceentity instanceof LivingEntity)
								? ((LivingEntity) sourceentity).getHeldItemMainhand()
								: ItemStack.EMPTY);
						if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
							_ist.shrink(1);
							_ist.setDamage(0);
						}
					}
				} else {
					{
						ItemStack _ist = ((sourceentity instanceof LivingEntity)
								? ((LivingEntity) sourceentity).getHeldItemOffhand()
								: ItemStack.EMPTY);
						if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
							_ist.shrink(1);
							_ist.setDamage(0);
						}
					}
				}
			}
			if (sourceentity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) sourceentity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("gratest_inventions:thats_just_wrong"));
				AdvancementProgress _ap = ((ServerPlayerEntity) sourceentity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) sourceentity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
		Entity entity = event.getTarget();
		PlayerEntity sourceentity = event.getPlayer();
		if (event.getHand() != sourceentity.getActiveHand())
			return;
		int i = event.getPos().getX();
		int j = event.getPos().getY();
		int k = event.getPos().getZ();
		World world = event.getWorld();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("x", i);
		dependencies.put("y", j);
		dependencies.put("z", k);
		dependencies.put("world", world);
		dependencies.put("entity", entity);
		dependencies.put("sourceentity", sourceentity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
