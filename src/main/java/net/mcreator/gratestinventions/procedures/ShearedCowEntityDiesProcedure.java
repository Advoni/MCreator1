package net.mcreator.gratestinventions.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.EnchantmentHelper;

import net.mcreator.gratestinventions.GratestInventionsModElements;
import net.mcreator.gratestinventions.GratestInventionsMod;

import java.util.Map;

@GratestInventionsModElements.ModElement.Tag
public class ShearedCowEntityDiesProcedure extends GratestInventionsModElements.ModElement {
	public ShearedCowEntityDiesProcedure(GratestInventionsModElements instance) {
		super(instance, 134);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				GratestInventionsMod.LOGGER.warn("Failed to load dependency entity for procedure ShearedCowEntityDies!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				GratestInventionsMod.LOGGER.warn("Failed to load dependency sourceentity for procedure ShearedCowEntityDies!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				GratestInventionsMod.LOGGER.warn("Failed to load dependency world for procedure ShearedCowEntityDies!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		IWorld world = (IWorld) dependencies.get("world");
		double looting = 0;
		double xPos = 0;
		double yPos = 0;
		double zPos = 0;
		xPos = (double) (entity.getPosX());
		yPos = (double) (entity.getPosY());
		zPos = (double) (entity.getPosZ());
		if (((EnchantmentHelper.getEnchantmentLevel(Enchantments.LOOTING,
				((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY))) >= 3)) {
			looting = (double) 4;
		} else if (((EnchantmentHelper.getEnchantmentLevel(Enchantments.LOOTING,
				((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY))) == 2)) {
			looting = (double) 3;
		} else if (((EnchantmentHelper.getEnchantmentLevel(Enchantments.LOOTING,
				((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY))) == 1)) {
			looting = (double) 2;
		} else {
			looting = (double) 1;
		}
		if (((looting) != 1)) {
			if ((entity.isBurning())) {
				for (int index0 = 0; index0 < (int) (Math.floor(((looting) * Math.random()))); index0++) {
					if (!world.getWorld().isRemote) {
						ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), (xPos), (yPos), (zPos),
								new ItemStack(Items.COOKED_BEEF, (int) (1)));
						entityToSpawn.setPickupDelay((int) 10);
						world.addEntity(entityToSpawn);
					}
				}
			} else {
				for (int index1 = 0; index1 < (int) (Math.floor(((looting) * Math.random()))); index1++) {
					if (!world.getWorld().isRemote) {
						ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), (xPos), (yPos), (zPos), new ItemStack(Items.BEEF, (int) (1)));
						entityToSpawn.setPickupDelay((int) 10);
						world.addEntity(entityToSpawn);
					}
				}
			}
		}
	}
}
