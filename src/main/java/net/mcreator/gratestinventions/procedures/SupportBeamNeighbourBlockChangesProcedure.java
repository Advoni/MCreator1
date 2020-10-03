package net.mcreator.gratestinventions.procedures;

import net.mcreator.gratestinventions.GratestInventionsModElements;

import javax.print.attribute.standard.Sides;

import java.util.Map;

@GratestInventionsModElements.ModElement.Tag
public class SupportBeamNeighbourBlockChangesProcedure extends GratestInventionsModElements.ModElement {
	public SupportBeamNeighbourBlockChangesProcedure(GratestInventionsModElements instance) {
		super(instance, 13);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		double Sides = 0;
		boolean North = false;
		boolean East = false;
		boolean South = false;
		boolean West = false;
	}
}
