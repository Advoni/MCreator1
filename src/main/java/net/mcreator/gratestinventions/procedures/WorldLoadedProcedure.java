package net.mcreator.gratestinventions.procedures;

import net.minecraftforge.accesstransformer.Target;

import net.minecraft.world.IWorld;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.gratestinventions.GratestInventionsModVariables;
import net.mcreator.gratestinventions.GratestInventionsModElements;

import java.util.Map;
import java.util.Collections;

@GratestInventionsModElements.ModElement.Tag
public class WorldLoadedProcedure extends GratestInventionsModElements.ModElement {
	public WorldLoadedProcedure(GratestInventionsModElements instance) {
		super(instance, 30);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure WorldLoaded!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure WorldLoaded!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure WorldLoaded!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure WorldLoaded!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure WorldLoaded!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		String X = "";
		String FinalX = "";
		String Y = "";
		String FinalY = "";
		String Z = "";
		String FinalZ = "";
		double XCounter = 0;
		double ZCounter = 0;
		double TargetX = 0;
		double TargetY = 0;
		double TargetZ = 0;
		double Target = 0;
		X = (String) (new java.text.DecimalFormat("#########").format(Math.floor(x)));
		if ((Math.floor(x) < 0)) {
			X = (String) ((X).substring((int) 1, (int) ((X)).length()));
			XCounter = (double) (8 - ((X)).length());
			FinalX = (String) "-";
		} else {
			XCounter = (double) (9 - ((X)).length());
		}
		for (int index0 = 0; index0 < (int) ((XCounter)); index0++) {
			FinalX = (String) (((FinalX)) + "" + (0));
		}
		FinalX = (String) (((FinalX)) + "" + ((X)));
		Y = (String) (new java.text.DecimalFormat("###").format(Math.floor(y)));
		for (int index1 = 0; index1 < (int) ((3 - ((Y)).length())); index1++) {
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
		for (int index2 = 0; index2 < (int) ((ZCounter)); index2++) {
			FinalZ = (String) (((FinalZ)) + "" + (0));
		}
		FinalZ = (String) (((FinalZ)) + "" + ((Z)));
		GratestInventionsModVariables.WorldVariables
				.get(world).NetherCoords = (String) (((GratestInventionsModVariables.WorldVariables.get(world).NetherCoords)) + ""
						+ ((((FinalX)) + "" + (((":") + "" + ((((FinalY)) + "" + (((":") + "" + ((((FinalZ)) + "" + ("#"))))))))))));
		GratestInventionsModVariables.WorldVariables.get(world).syncData(world);
		System.out.println((GratestInventionsModVariables.WorldVariables.get(world).NetherCoords));
		Target = (double) 9;
		Target = (double) ((Target) * 24);
		TargetX = (double) new Object() {
			int convert(String s) {
				try {
					return Integer.parseInt(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(((GratestInventionsModVariables.WorldVariables.get(world).NetherCoords).substring((int) (Target), (int) ((Target) + 9))));
		TargetY = (double) new Object() {
			int convert(String s) {
				try {
					return Integer.parseInt(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(((GratestInventionsModVariables.WorldVariables.get(world).NetherCoords).substring((int) ((Target) + 10), (int) ((Target) + 13))));
		TargetZ = (double) new Object() {
			int convert(String s) {
				try {
					return Integer.parseInt(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(((GratestInventionsModVariables.WorldVariables.get(world).NetherCoords).substring((int) ((Target) + 14), (int) ((Target) + 23))));
		System.out.println((TargetX));
		System.out.println((TargetY));
		System.out.println((TargetZ));
		{
			Entity _ent = entity;
			_ent.setPositionAndUpdate((TargetX), (TargetY), (TargetZ));
			if (_ent instanceof ServerPlayerEntity) {
				((ServerPlayerEntity) _ent).connection.setPlayerLocation((TargetX), (TargetY), (TargetZ), _ent.rotationYaw, _ent.rotationPitch,
						Collections.emptySet());
			}
		}
	}
}
