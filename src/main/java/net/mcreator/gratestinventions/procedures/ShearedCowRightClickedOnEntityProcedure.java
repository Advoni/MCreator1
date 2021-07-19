package net.mcreator.gratestinventions.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Entity;

import net.mcreator.gratestinventions.GratestInventionsModElements;
import net.mcreator.gratestinventions.GratestInventionsMod;

import java.util.Map;

@GratestInventionsModElements.ModElement.Tag
public class ShearedCowRightClickedOnEntityProcedure extends GratestInventionsModElements.ModElement {
	public ShearedCowRightClickedOnEntityProcedure(GratestInventionsModElements instance) {
		super(instance, 136);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				GratestInventionsMod.LOGGER.warn("Failed to load dependency entity for procedure ShearedCowRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				GratestInventionsMod.LOGGER.warn("Failed to load dependency itemstack for procedure ShearedCowRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				GratestInventionsMod.LOGGER.warn("Failed to load dependency world for procedure ShearedCowRightClickedOnEntity!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		IWorld world = (IWorld) dependencies.get("world");
		double xPos = 0;
		double yPos = 0;
		double zPos = 0;
		double yaw = 0;
		double pitch = 0;
		double vX = 0;
		double vY = 0;
		double vZ = 0;
		if (((itemstack).getItem() == new ItemStack(Items.WHEAT, (int) (1)).getItem())) {
			xPos = (double) (entity.getPosX());
			yPos = (double) (entity.getPosY());
			zPos = (double) (entity.getPosZ());
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.HEART, (xPos), (yPos), (zPos), (int) 10, 0.75, 0.75, 0.75, 1);
			}
			((itemstack)).shrink((int) 1);
			if ((0 == Math.floor((5 * Math.random())))) {
				yaw = (double) (entity.rotationYaw);
				pitch = (double) (entity.rotationPitch);
				vX = (double) (entity.getMotion().getX());
				vY = (double) (entity.getMotion().getY());
				vZ = (double) (entity.getMotion().getZ());
				if (!entity.world.isRemote)
					entity.remove();
				if (world instanceof World && !world.getWorld().isRemote) {
					Entity entityToSpawn = new CowEntity(EntityType.COW, world.getWorld());
					entityToSpawn.setLocationAndAngles((xPos), (yPos), (zPos), (float) (yaw), (float) (pitch));
					entityToSpawn.setRenderYawOffset((float) (yaw));
					entityToSpawn.setMotion((vX), (vY), (vZ));
					if (entityToSpawn instanceof MobEntity)
						((MobEntity) entityToSpawn).onInitialSpawn(world, world.getDifficultyForLocation(new BlockPos(entityToSpawn)),
								SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
					world.addEntity(entityToSpawn);
				}
				if (world instanceof World && !world.getWorld().isRemote) {
					world.getWorld()
							.addEntity(new ExperienceOrbEntity(world.getWorld(), (xPos), (yPos), (zPos), (int) Math.ceil((7 * Math.random()))));
				}
				if (!world.getWorld().isRemote) {
					world.playSound(null, new BlockPos((int) (xPos), (int) (yPos), (int) (zPos)),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
									.getValue(new ResourceLocation("entity.player.attack.nodamage")),
							SoundCategory.NEUTRAL, (float) 0.8, (float) 0.65);
				} else {
					world.getWorld().playSound((xPos), (yPos), (zPos),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
									.getValue(new ResourceLocation("entity.player.attack.nodamage")),
							SoundCategory.NEUTRAL, (float) 0.8, (float) 0.65, false);
				}
			}
		}
	}
}
