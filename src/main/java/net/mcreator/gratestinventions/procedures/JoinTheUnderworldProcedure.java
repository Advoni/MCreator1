package net.mcreator.gratestinventions.procedures;

import net.minecraftforge.accesstransformer.Target;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.gratestinventions.GratestInventionsModVariables;
import net.mcreator.gratestinventions.GratestInventionsModElements;

import java.util.Map;
import java.util.Collections;

@GratestInventionsModElements.ModElement.Tag
public class JoinTheUnderworldProcedure extends GratestInventionsModElements.ModElement {
	public JoinTheUnderworldProcedure(GratestInventionsModElements instance) {
		super(instance, 38);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure JoinTheUnderworld!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure JoinTheUnderworld!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure JoinTheUnderworld!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure JoinTheUnderworld!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure JoinTheUnderworld!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		String X = "";
		String FinalX = "";
		String Z = "";
		String FinalZ = "";
		String Y = "";
		String FinalY = "";
		double XCounter = 0;
		double ZCounter = 0;
		double TargetY = 0;
		double TargetX = 0;
		double TargetZ = 0;
		double Target = 0;
		boolean Solution = false;
		Solution = (boolean) (false);
		Target = (double) ((GratestInventionsModVariables.WorldVariables.get(world).NetherCoords)).length();
		for (int index0 = 0; index0 < (int) (Math
				.round((((GratestInventionsModVariables.WorldVariables.get(world).NetherCoords)).length() / 24))); index0++) {
			Target = (double) ((Target) - 24);
			TargetX = (double) new Object() {
				int convert(String s) {
					try {
						return Integer.parseInt(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(((GratestInventionsModVariables.WorldVariables.get(world).NetherCoords).substring((int) (Target), (int) ((Target) + 9))));
			TargetZ = (double) new Object() {
				int convert(String s) {
					try {
						return Integer.parseInt(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(
					((GratestInventionsModVariables.WorldVariables.get(world).NetherCoords).substring((int) ((Target) + 14), (int) ((Target) + 23))));
			if ((Math.abs((x - (TargetX))) <= 40)) {
				if ((Math.abs((z - (TargetZ))) <= 40)) {
					Solution = (boolean) (true);
					break;
				}
			}
		}
		if (((Solution) == (true))) {
			TargetY = (double) new Object() {
				int convert(String s) {
					try {
						return Integer.parseInt(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(
					((GratestInventionsModVariables.WorldVariables.get(world).NetherCoords).substring((int) ((Target) + 10), (int) ((Target) + 13))));
			{
				Entity _ent = entity;
				_ent.setPositionAndUpdate(((TargetX) + 0.5), ((TargetY) + 2), ((TargetZ) + 0.5));
				if (_ent instanceof ServerPlayerEntity) {
					((ServerPlayerEntity) _ent).connection.setPlayerLocation(((TargetX) + 0.5), ((TargetY) + 2), ((TargetZ) + 0.5), _ent.rotationYaw,
							_ent.rotationPitch, Collections.emptySet());
				}
			}
		} else {
			X = (String) (new java.text.DecimalFormat("#########").format(Math.floor(x)));
			if ((Math.floor(x) < 0)) {
				X = (String) ((X).substring((int) 1, (int) ((X)).length()));
				XCounter = (double) (8 - ((X)).length());
				FinalX = (String) "-";
			} else {
				XCounter = (double) (9 - ((X)).length());
			}
			for (int index1 = 0; index1 < (int) ((XCounter)); index1++) {
				FinalX = (String) (((FinalX)) + "" + (0));
			}
			FinalX = (String) (((FinalX)) + "" + ((X)));
			Y = (String) (new java.text.DecimalFormat("###").format(Math.floor(y)));
			for (int index2 = 0; index2 < (int) ((3 - ((Y)).length())); index2++) {
				FinalY = (String) (((FinalY)) + "" + (0));
			}
			FinalY = (String) (((FinalY)) + "" + ((Y)));
			Z = (String) (new java.text.DecimalFormat("#########").format(Math.floor(z)));
			if ((Math.floor(z) < 0)) {
				Z = (String) ((Z).substring((int) 1, (int) ((Z)).length()));
				ZCounter = (double) (8 - ((Z)).length());
				FinalZ = (String) "-";
			} else {
				ZCounter = (double) (9 - ((Z)).length());
			}
			for (int index3 = 0; index3 < (int) ((ZCounter)); index3++) {
				FinalZ = (String) (((FinalZ)) + "" + (0));
			}
			FinalZ = (String) (((FinalZ)) + "" + ((Z)));
			GratestInventionsModVariables.WorldVariables
					.get(world).NetherCoords = (String) (((GratestInventionsModVariables.WorldVariables.get(world).NetherCoords)) + ""
							+ ((((FinalX)) + "" + (((":") + "" + ((((FinalY)) + "" + (((":") + "" + ((((FinalZ)) + "" + ("#"))))))))))));
			GratestInventionsModVariables.WorldVariables.get(world).syncData(world);
			System.out.println((GratestInventionsModVariables.WorldVariables.get(world).NetherCoords));
			world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), Blocks.NETHERRACK.getDefaultState(), 3);
			{
				Entity _ent = entity;
				_ent.setPositionAndUpdate((Math.floor(x) + 0.5), (y + 2), (Math.floor(z) + 0.5));
				if (_ent instanceof ServerPlayerEntity) {
					((ServerPlayerEntity) _ent).connection.setPlayerLocation((Math.floor(x) + 0.5), (y + 2), (Math.floor(z) + 0.5), _ent.rotationYaw,
							_ent.rotationPitch, Collections.emptySet());
				}
			}
		}
		entity.getPersistentData().putBoolean("ToNether", (false));
	}
}
