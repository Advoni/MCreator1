package net.mcreator.gratestinventions.procedures;

import net.minecraftforge.energy.CapabilityEnergy;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;

import net.mcreator.gratestinventions.GratestInventionsModElements;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.Map;

@GratestInventionsModElements.ModElement.Tag
public class EnergyExtractionProcedure extends GratestInventionsModElements.ModElement {
	public EnergyExtractionProcedure(GratestInventionsModElements instance) {
		super(instance, 116);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure EnergyExtraction!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure EnergyExtraction!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure EnergyExtraction!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure EnergyExtraction!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		boolean nb = false;
		boolean eb = false;
		boolean sb = false;
		boolean wb = false;
		boolean ub = false;
		boolean db = false;
		double n = 0;
		double e = 0;
		double s = 0;
		double w = 0;
		double u = 0;
		double d = 0;
		double charging = 0;
		double extracted = 0;
		double repeater = 0;
		double small = 0;
		double pos = 0;
		nb = (boolean) (false);
		eb = (boolean) (false);
		sb = (boolean) (false);
		wb = (boolean) (false);
		ub = (boolean) (false);
		db = (boolean) (false);
		charging = (double) (new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "charging"));
		extracted = (double) (charging);
		n = (double) (new Object() {
			public int extractEnergySimulate(BlockPos pos, int _amount) {
				AtomicInteger _retval = new AtomicInteger(0);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.extractEnergy(_amount, true)));
				return _retval.get();
			}
		}.extractEnergySimulate(new BlockPos((int) (x + 1), (int) y, (int) z), (int) (charging)));
		e = (double) (new Object() {
			public int extractEnergySimulate(BlockPos pos, int _amount) {
				AtomicInteger _retval = new AtomicInteger(0);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.extractEnergy(_amount, true)));
				return _retval.get();
			}
		}.extractEnergySimulate(new BlockPos((int) x, (int) y, (int) (z + 1)), (int) (charging)));
		s = (double) (new Object() {
			public int extractEnergySimulate(BlockPos pos, int _amount) {
				AtomicInteger _retval = new AtomicInteger(0);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.extractEnergy(_amount, true)));
				return _retval.get();
			}
		}.extractEnergySimulate(new BlockPos((int) (x - 1), (int) y, (int) z), (int) (charging)));
		w = (double) (new Object() {
			public int extractEnergySimulate(BlockPos pos, int _amount) {
				AtomicInteger _retval = new AtomicInteger(0);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.extractEnergy(_amount, true)));
				return _retval.get();
			}
		}.extractEnergySimulate(new BlockPos((int) x, (int) y, (int) (z - 1)), (int) (charging)));
		u = (double) (new Object() {
			public int extractEnergySimulate(BlockPos pos, int _amount) {
				AtomicInteger _retval = new AtomicInteger(0);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.extractEnergy(_amount, true)));
				return _retval.get();
			}
		}.extractEnergySimulate(new BlockPos((int) x, (int) (y + 1), (int) z), (int) (charging)));
		d = (double) (new Object() {
			public int extractEnergySimulate(BlockPos pos, int _amount) {
				AtomicInteger _retval = new AtomicInteger(0);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.extractEnergy(_amount, true)));
				return _retval.get();
			}
		}.extractEnergySimulate(new BlockPos((int) x, (int) (y - 1), (int) z), (int) (charging)));
		repeater = (double) 6;
		for (int index0 = 0; index0 < (int) (6); index0++) {
			small = (double) Double.POSITIVE_INFINITY;
			if (((nb) != (true))) {
				small = (double) (n);
				pos = (double) 1;
			}
			if (((eb) != (true))) {
				if (((e) < (small))) {
					small = (double) (e);
					pos = (double) 2;
				}
			}
			if (((sb) != (true))) {
				if (((s) < (small))) {
					small = (double) (s);
					pos = (double) 3;
				}
			}
			if (((wb) != (true))) {
				if (((w) < (small))) {
					small = (double) (w);
					pos = (double) 4;
				}
			}
			if (((ub) != (true))) {
				if (((u) < (small))) {
					small = (double) (u);
					pos = (double) 5;
				}
			}
			if (((db) != (true))) {
				if (((d) < (small))) {
					small = (double) (d);
					pos = (double) 6;
				}
			}
			if (((pos) == 1)) {
				if (((n) < ((extracted) / (repeater)))) {
					{
						TileEntity _ent = world.getTileEntity(new BlockPos((int) (x + 1), (int) y, (int) z));
						int _amount = (int) (n);
						if (_ent != null)
							_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
					}
					extracted = (double) ((extracted) - (n));
				} else {
					{
						TileEntity _ent = world.getTileEntity(new BlockPos((int) (x + 1), (int) y, (int) z));
						int _amount = (int) ((extracted) / (repeater));
						if (_ent != null)
							_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
					}
				}
				nb = (boolean) (true);
			} else if (((pos) == 2)) {
				if (((e) < ((extracted) / (repeater)))) {
					{
						TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) (z + 1)));
						int _amount = (int) (e);
						if (_ent != null)
							_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
					}
					extracted = (double) ((extracted) - (e));
				} else {
					{
						TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) (z + 1)));
						int _amount = (int) ((extracted) / (repeater));
						if (_ent != null)
							_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
					}
				}
				eb = (boolean) (true);
			} else if (((pos) == 3)) {
				if (((s) < ((extracted) / (repeater)))) {
					{
						TileEntity _ent = world.getTileEntity(new BlockPos((int) (x - 1), (int) y, (int) z));
						int _amount = (int) (s);
						if (_ent != null)
							_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
					}
					extracted = (double) ((extracted) - (s));
				} else {
					{
						TileEntity _ent = world.getTileEntity(new BlockPos((int) (x - 1), (int) y, (int) z));
						int _amount = (int) ((extracted) / (repeater));
						if (_ent != null)
							_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
					}
				}
				sb = (boolean) (true);
			} else if (((pos) == 4)) {
				if (((w) < ((extracted) / (repeater)))) {
					{
						TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) (z - 1)));
						int _amount = (int) (w);
						if (_ent != null)
							_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
					}
					extracted = (double) ((extracted) - (w));
				} else {
					{
						TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) (z - 1)));
						int _amount = (int) ((extracted) / (repeater));
						if (_ent != null)
							_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
					}
				}
				wb = (boolean) (true);
			} else if (((pos) == 5)) {
				if (((u) < ((extracted) / (repeater)))) {
					{
						TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) (y + 1), (int) z));
						int _amount = (int) (u);
						if (_ent != null)
							_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
					}
					extracted = (double) ((extracted) - (u));
				} else {
					{
						TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) (y + 1), (int) z));
						int _amount = (int) ((extracted) / (repeater));
						if (_ent != null)
							_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
					}
				}
				ub = (boolean) (true);
			} else if (((pos) == 6)) {
				if (((d) < ((extracted) / (repeater)))) {
					{
						TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) (y - 1), (int) z));
						int _amount = (int) (d);
						if (_ent != null)
							_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
					}
					extracted = (double) ((extracted) - (d));
				} else {
					{
						TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) (y - 1), (int) z));
						int _amount = (int) ((extracted) / (repeater));
						if (_ent != null)
							_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
					}
				}
				ub = (boolean) (true);
			}
			repeater = (double) ((repeater) - 1);
			if (((repeater) == 0)) {
				{
					TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
					int _amount = (int) ((charging) - (extracted));
					if (_ent != null)
						_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.receiveEnergy(_amount, false));
				}
			}
		}
	}
}
