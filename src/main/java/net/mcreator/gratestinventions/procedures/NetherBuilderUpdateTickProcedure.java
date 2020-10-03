package net.mcreator.gratestinventions.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Mirror;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import net.mcreator.gratestinventions.GratestInventionsModElements;

import java.util.Map;

@GratestInventionsModElements.ModElement.Tag
public class NetherBuilderUpdateTickProcedure extends GratestInventionsModElements.ModElement {
	public NetherBuilderUpdateTickProcedure(GratestInventionsModElements instance) {
		super(instance, 34);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure NetherBuilderUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure NetherBuilderUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure NetherBuilderUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure NetherBuilderUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double HightSeed = 0;
		double Count = 0;
		double BetterEX = 0;
		double BetterZet = 0;
		double RandomDandom = 0;
		double OriginX = 0;
		double OriginZ = 0;
		OriginX = (double) (Math.floor((x / 16)) * 16);
		OriginZ = (double) (Math.floor((z / 16)) * 16);
		BetterEX = (double) (0.0005 * (Math.floor((x / 16)) * 16));
		BetterZet = (double) (0.0005 * (Math.floor((z / 16)) * 16));
		HightSeed = (double) (((6
				+ ((Math.sin((1.2656 * (BetterEX))) + (Math.sin(((5.4762 * (BetterEX)) - 45.8675)) + Math.cos(((9.3845 * (BetterEX)) + 58.642))))
						- (Math.cos(((45.3648 * (BetterEX)) + 4.5974))
								+ (Math.sin(((89.6529 * (BetterEX)) - 5)) + Math.sin(((25.6947 * (BetterEX)) + 8.36))))))
				+ (6 + ((Math.cos(((45.3648 * (BetterZet)) + 4.5974))
						+ (Math.sin(((89.6529 * (BetterZet)) - 5)) + Math.sin(((25.6947 * (BetterZet)) + 8.36))))
						- (Math.sin((1.2656 * (BetterZet)))
								+ (Math.sin(((5.4762 * (BetterZet)) - 45.8675)) + Math.cos(((9.3845 * (BetterZet)) + 58.642)))))))
				/ 2);
		Count = (double) (HightSeed);
		for (int index0 = 0; index0 < (int) (Math.ceil((HightSeed))); index0++) {
			if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
				world.getWorld().getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vec3d((OriginX), Math.floor((y + (((Count) - 1) * 8))), (OriginZ)), Vec2f.ZERO,
								(ServerWorld) world, 4, "", new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
						"fill ~ ~ ~ ~15 ~8 ~15 minecraft:netherrack");
			}
			Count = (double) ((Count) - 1);
			if (((Count) < 0)) {
				Count = (double) 0;
			}
		}
		RandomDandom = (double) Math.floor((Math.random() * 5));
		if (((RandomDandom) == 0)) {
			if (!world.getWorld().isRemote) {
				Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
						.getTemplateDefaulted(new ResourceLocation("gratest_inventions", "nether.a"));
				if (template != null) {
					template.addBlocksToWorld(world,
							new BlockPos((int) ((OriginX) - 8), (int) Math.floor((y + (((HightSeed) - 1) * 8))), (int) ((OriginZ) - 8)),
							new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false));
				}
			}
		} else if (((RandomDandom) == 1)) {
			if (!world.getWorld().isRemote) {
				Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
						.getTemplateDefaulted(new ResourceLocation("gratest_inventions", "nether.b"));
				if (template != null) {
					template.addBlocksToWorld(world,
							new BlockPos((int) ((OriginX) - 8), (int) Math.floor((y + (((HightSeed) - 1) * 8))), (int) ((OriginZ) - 8)),
							new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false));
				}
			}
		} else if (((RandomDandom) == 2)) {
			if (!world.getWorld().isRemote) {
				Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
						.getTemplateDefaulted(new ResourceLocation("gratest_inventions", "nether.c"));
				if (template != null) {
					template.addBlocksToWorld(world,
							new BlockPos((int) ((OriginX) - 8), (int) Math.floor((y + (((HightSeed) - 1) * 8))), (int) ((OriginZ) - 8)),
							new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false));
				}
			}
		} else if (((RandomDandom) == 3)) {
			if (!world.getWorld().isRemote) {
				Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
						.getTemplateDefaulted(new ResourceLocation("gratest_inventions", "nether.d"));
				if (template != null) {
					template.addBlocksToWorld(world,
							new BlockPos((int) ((OriginX) - 8), (int) Math.floor((y + (((HightSeed) - 1) * 8))), (int) ((OriginZ) - 8)),
							new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false));
				}
			}
		} else {
			if (!world.getWorld().isRemote) {
				Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
						.getTemplateDefaulted(new ResourceLocation("gratest_inventions", "nether.e"));
				if (template != null) {
					template.addBlocksToWorld(world,
							new BlockPos((int) ((OriginX) - 8), (int) Math.floor((y + (((HightSeed) - 1) * 8))), (int) ((OriginZ) - 8)),
							new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false));
				}
			}
		}
		Count = (double) 2;
		for (int index1 = 0; index1 < (int) (2); index1++) {
			if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
				world.getWorld().getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vec3d((OriginX), (170 - (((Count) - 1) * 8)), (OriginZ)), Vec2f.ZERO,
								(ServerWorld) world, 4, "", new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
						"fill ~ ~ ~ ~15 ~-8 ~15 minecraft:lava replace minecraft:air");
			}
			Count = (double) ((Count) - 1);
		}
	}
}
