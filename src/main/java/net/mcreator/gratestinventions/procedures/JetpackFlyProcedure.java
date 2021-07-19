package net.mcreator.gratestinventions.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.gratestinventions.item.JetpackItem;
import net.mcreator.gratestinventions.GratestInventionsModElements;
import net.mcreator.gratestinventions.GratestInventionsMod;

import java.util.Map;
import java.util.HashMap;

@GratestInventionsModElements.ModElement.Tag
public class JetpackFlyProcedure extends GratestInventionsModElements.ModElement {
	public JetpackFlyProcedure(GratestInventionsModElements instance) {
		super(instance, 148);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				GratestInventionsMod.LOGGER.warn("Failed to load dependency entity for procedure JetpackFly!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				GratestInventionsMod.LOGGER.warn("Failed to load dependency x for procedure JetpackFly!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				GratestInventionsMod.LOGGER.warn("Failed to load dependency y for procedure JetpackFly!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				GratestInventionsMod.LOGGER.warn("Failed to load dependency z for procedure JetpackFly!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				GratestInventionsMod.LOGGER.warn("Failed to load dependency world for procedure JetpackFly!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double a = 0;
		double vt_1 = 0;
		double terminalVelocity = 0;
		double vX = 0;
		double vZ = 0;
		double vXpre = 0;
		if ((((entity instanceof LivingEntity)
				? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 2))
				: ItemStack.EMPTY).getItem() == new ItemStack(JetpackItem.body, (int) (1)).getItem())) {
			if ((entity.getPersistentData().getBoolean("jump"))) {
				if ((entity.getPersistentData().getBoolean("HoverMode"))) {
					a = (double) 0.05;
					terminalVelocity = (double) 0.75;
					entity.getPersistentData().putDouble("time", ((entity.getPersistentData().getDouble("time")) + 1));
					vt_1 = (double) ((entity.getMotion().getY())
							* Math.pow(Math.E, ((-0.2) * ((a) * (entity.getPersistentData().getDouble("time"))))));
					entity.setMotion((entity.getMotion().getX()),
							(((((-1) * (terminalVelocity)) * Math.pow(Math.E, ((-1) * ((a) * (entity.getPersistentData().getDouble("time"))))))
									+ (terminalVelocity)) + (vt_1)),
							(entity.getMotion().getZ()));
					if (!world.getWorld().isRemote) {
						world.playSound(null, new BlockPos((int) x, (int) y, (int) z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.llama.swag")),
								SoundCategory.NEUTRAL, (float) 0.1, (float) 2);
					} else {
						world.getWorld().playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.llama.swag")),
								SoundCategory.NEUTRAL, (float) 0.1, (float) 2, false);
					}
					if (!world.getWorld().isRemote) {
						world.playSound(null, new BlockPos((int) x, (int) y, (int) z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.shulker.shoot")),
								SoundCategory.NEUTRAL, (float) 0.1, (float) 1.4);
					} else {
						world.getWorld().playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.shulker.shoot")),
								SoundCategory.NEUTRAL, (float) 0.1, (float) 1.4, false);
					}
				} else {
					a = (double) 0.05;
					terminalVelocity = (double) 1;
					entity.getPersistentData().putDouble("time", ((entity.getPersistentData().getDouble("time")) + 1));
					vt_1 = (double) ((entity.getMotion().getY()) * Math.pow(Math.E, ((-1) * ((a) * (entity.getPersistentData().getDouble("time"))))));
					entity.setMotion((entity.getMotion().getX()),
							(((((-1) * (terminalVelocity)) * Math.pow(Math.E, ((-1) * ((a) * (entity.getPersistentData().getDouble("time"))))))
									+ (terminalVelocity)) + (vt_1)),
							(entity.getMotion().getZ()));
					if (!world.getWorld().isRemote) {
						world.playSound(null, new BlockPos((int) x, (int) y, (int) z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.llama.swag")),
								SoundCategory.NEUTRAL, (float) 0.1, (float) 2);
					} else {
						world.getWorld().playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.llama.swag")),
								SoundCategory.NEUTRAL, (float) 0.1, (float) 2, false);
					}
					if (!world.getWorld().isRemote) {
						world.playSound(null, new BlockPos((int) x, (int) y, (int) z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.shulker.shoot")),
								SoundCategory.NEUTRAL, (float) 0.1, (float) 1.4);
					} else {
						world.getWorld().playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.shulker.shoot")),
								SoundCategory.NEUTRAL, (float) 0.1, (float) 1.4, false);
					}
				}
			} else if ((entity.getPersistentData().getBoolean("HoverMode"))) {
				if ((!(entity.getPersistentData().getBoolean("sneak")))) {
					entity.setMotion((entity.getMotion().getX()), 0, (entity.getMotion().getZ()));
					if (!world.getWorld().isRemote) {
						world.playSound(null, new BlockPos((int) x, (int) y, (int) z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.llama.swag")),
								SoundCategory.NEUTRAL, (float) 0.1, (float) 2);
					} else {
						world.getWorld().playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.llama.swag")),
								SoundCategory.NEUTRAL, (float) 0.1, (float) 2, false);
					}
					if (!world.getWorld().isRemote) {
						world.playSound(null, new BlockPos((int) x, (int) y, (int) z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.shulker.shoot")),
								SoundCategory.NEUTRAL, (float) 0.1, (float) 1.4);
					} else {
						world.getWorld().playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.shulker.shoot")),
								SoundCategory.NEUTRAL, (float) 0.1, (float) 1.4, false);
					}
				}
			} else {
				entity.getPersistentData().putDouble("time", 0);
			}
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			World world = entity.world;
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
