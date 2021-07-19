package net.mcreator.gratestinventions.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import net.mcreator.gratestinventions.block.EthanolBlock;
import net.mcreator.gratestinventions.GratestInventionsModElements;
import net.mcreator.gratestinventions.GratestInventionsMod;

import java.util.Map;

@GratestInventionsModElements.ModElement.Tag
public class ShearedCowOnEntityTickUpdateProcedure extends GratestInventionsModElements.ModElement {
	public ShearedCowOnEntityTickUpdateProcedure(GratestInventionsModElements instance) {
		super(instance, 132);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				GratestInventionsMod.LOGGER.warn("Failed to load dependency entity for procedure ShearedCowOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				GratestInventionsMod.LOGGER.warn("Failed to load dependency x for procedure ShearedCowOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				GratestInventionsMod.LOGGER.warn("Failed to load dependency y for procedure ShearedCowOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				GratestInventionsMod.LOGGER.warn("Failed to load dependency z for procedure ShearedCowOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				GratestInventionsMod.LOGGER.warn("Failed to load dependency world for procedure ShearedCowOnEntityTickUpdate!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((!((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == EthanolBlock.block.getDefaultState().getBlock()))) {
			if (((entity.getPersistentData().getDouble("HurtTimer")) > 20)) {
				entity.attackEntityFrom(DamageSource.CRAMMING, (float) 1);
				entity.getPersistentData().putDouble("HurtTimer", 0);
			} else {
				entity.getPersistentData().putDouble("HurtTimer", ((entity.getPersistentData().getDouble("HurtTimer")) + 1));
			}
		}
	}
}
