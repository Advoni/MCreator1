package net.mcreator.gratestinventions.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.world.GameType;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec2f;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.Minecraft;

import net.mcreator.gratestinventions.GratestInventionsModElements;
import net.mcreator.gratestinventions.GratestInventionsMod;

import java.util.Map;

@GratestInventionsModElements.ModElement.Tag
public class DrumBlockDestroyedByPlayerProcedure extends GratestInventionsModElements.ModElement {
	public DrumBlockDestroyedByPlayerProcedure(GratestInventionsModElements instance) {
		super(instance, 140);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				GratestInventionsMod.LOGGER.warn("Failed to load dependency entity for procedure DrumBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				GratestInventionsMod.LOGGER.warn("Failed to load dependency x for procedure DrumBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				GratestInventionsMod.LOGGER.warn("Failed to load dependency y for procedure DrumBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				GratestInventionsMod.LOGGER.warn("Failed to load dependency z for procedure DrumBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				GratestInventionsMod.LOGGER.warn("Failed to load dependency world for procedure DrumBlockDestroyedByPlayer!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		String searchedChar = "";
		String fluid = "";
		double laufvariabel = 0;
		double amount = 0;
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
			fluid = (String) (entity.getPersistentData().getString("fluid"));
			amount = (double) (entity.getPersistentData().getDouble("amount"));
			if ((!(((fluid)).equals("")))) {
				laufvariabel = (double) 0;
				while ((!(((searchedChar)).equals(":")))) {
					searchedChar = (String) ((fluid).substring((int) (laufvariabel), (int) ((laufvariabel) + 1)));
					laufvariabel = (double) ((laufvariabel) + 1);
				}
				searchedChar = (String) ((fluid).substring((int) (laufvariabel), (int) ((fluid)).length()));
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
			if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
				world.getWorld().getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
						(("/summon minecraft:item ~ ~ ~ {Item:{id:\"gratest_inventions:drum\",Count:1,tag:{ForgeData:{Content:\"") + "" + ((fluid))
								+ "" + ("\",Amount:") + "" + ((amount)) + "" + ("},display:{Lore:['\"Fluid: ") + "" + ((searchedChar)) + ""
								+ ("\"','\"Amount: ") + "" + ((amount)) + "" + ("mB\"']}}}}")));
			}
		}
	}
}
