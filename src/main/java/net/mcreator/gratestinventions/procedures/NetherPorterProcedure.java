package net.mcreator.gratestinventions.procedures;

import org.w3c.dom.css.Counter;

import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.potion.EffectInstance;
import net.minecraft.network.play.server.SPlayerAbilitiesPacket;
import net.minecraft.network.play.server.SPlaySoundEventPacket;
import net.minecraft.network.play.server.SPlayEntityEffectPacket;
import net.minecraft.network.play.server.SChangeGameStatePacket;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.gratestinventions.GratestInventionsModVariables;
import net.mcreator.gratestinventions.GratestInventionsModElements;

import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

@GratestInventionsModElements.ModElement.Tag
public class NetherPorterProcedure extends GratestInventionsModElements.ModElement {
	public NetherPorterProcedure(GratestInventionsModElements instance) {
		super(instance, 29);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure NetherPorter!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure NetherPorter!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure NetherPorter!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure NetherPorter!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure NetherPorter!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		boolean SolidBlock = false;
		double Counter = 0;
		double NetherX = 0;
		double NetherZ = 0;
		Counter = (double) 0;
		SolidBlock = (boolean) (false);
		NetherX = (double) (x / 8);
		NetherZ = (double) (z / 8);
		if ((((entity.dimension.getId()) == (-1)) && ((entity.getPersistentData().getDouble("ToNether")) == 1))) {
			System.out.println((GratestInventionsModVariables.WorldVariables.get(world).NetherCoords));
			while (((SolidBlock) == (false))) {
				if (((world.getBlockState(new BlockPos((int) (entity.getPosX()), (int) (255 - (Counter)), (int) (entity.getPosZ()))))
						.getBlock() == Blocks.AIR.getDefaultState().getBlock())) {
					Counter = (double) ((Counter) + 1);
				} else if (((world.getBlockState(new BlockPos((int) (entity.getPosX()), (int) (255 - (Counter)), (int) (entity.getPosZ()))))
						.getBlock() == Blocks.LAVA.getDefaultState().getBlock())) {
					SolidBlock = (boolean) (true);
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("entity", entity);
						$_dependencies.put("world", world);
						$_dependencies.put("x", (entity.getPosX()));
						$_dependencies.put("y", (255 - (Counter)));
						$_dependencies.put("z", (entity.getPosZ()));
						JoinTheUnderworldProcedure.executeProcedure($_dependencies);
					}
				} else {
					SolidBlock = (boolean) (true);
					{
						Entity _ent = entity;
						_ent.setPositionAndUpdate((Math.floor((entity.getPosX())) + 0.5), (256 - (Counter)), (Math.floor((entity.getPosZ())) + 0.5));
						if (_ent instanceof ServerPlayerEntity) {
							((ServerPlayerEntity) _ent).connection.setPlayerLocation((Math.floor((entity.getPosX())) + 0.5), (256 - (Counter)),
									(Math.floor((entity.getPosZ())) + 0.5), _ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
						}
					}
				}
			}
			System.out.println((world.getBlockState(new BlockPos((int) (entity.getPosX()), (int) (255 - (Counter)), (int) (entity.getPosZ())))));
			System.out.println((entity.getPosX()));
			System.out.println((255 - (Counter)));
			System.out.println((entity.getPosZ()));
			System.out.println((entity.dimension.getId()));
			entity.getPersistentData().putDouble("ToNether", 0);
		}
		if ((((entity.dimension.getId()) == 0) && ((y < 0) && ((entity.getPersistentData().getDouble("ToNether")) == 0)))) {
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
					DimensionType destinationType = DimensionType.THE_NETHER;
					ObfuscationReflectionHelper.setPrivateValue(ServerPlayerEntity.class, (ServerPlayerEntity) _ent, true, "field_184851_cj");
					ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
					((ServerPlayerEntity) _ent).connection.sendPacket(new SChangeGameStatePacket(4, 0));
					((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(), nextWorld.getSpawnPoint().getY() + 1,
							nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw, _ent.rotationPitch);
					((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
					for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
						((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
					}
					((ServerPlayerEntity) _ent).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
				}
			}
			{
				Entity _ent = entity;
				_ent.setPositionAndUpdate((NetherX), 256, (NetherZ));
				if (_ent instanceof ServerPlayerEntity) {
					((ServerPlayerEntity) _ent).connection.setPlayerLocation((NetherX), 256, (NetherZ), _ent.rotationYaw, _ent.rotationPitch,
							Collections.emptySet());
				}
			}
			entity.getPersistentData().putDouble("ToNether", 5);
		} else if ((((entity.dimension.getId()) == (-1)) && (y > 256))) {
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
					DimensionType destinationType = DimensionType.OVERWORLD;
					ObfuscationReflectionHelper.setPrivateValue(ServerPlayerEntity.class, (ServerPlayerEntity) _ent, true, "field_184851_cj");
					ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
					((ServerPlayerEntity) _ent).connection.sendPacket(new SChangeGameStatePacket(4, 0));
					((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(), nextWorld.getSpawnPoint().getY() + 1,
							nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw, _ent.rotationPitch);
					((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
					for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
						((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
					}
					((ServerPlayerEntity) _ent).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
				}
			}
			{
				Entity _ent = entity;
				_ent.setPositionAndUpdate((x * 8), 80, (z * 8));
				if (_ent instanceof ServerPlayerEntity) {
					((ServerPlayerEntity) _ent).connection.setPlayerLocation((x * 8), 80, (z * 8), _ent.rotationYaw, _ent.rotationPitch,
							Collections.emptySet());
				}
			}
		}
		if (((entity.getPersistentData().getDouble("ToNether")) > 0)) {
			entity.getPersistentData().putDouble("ToNether", ((entity.getPersistentData().getDouble("ToNether")) - 1));
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
