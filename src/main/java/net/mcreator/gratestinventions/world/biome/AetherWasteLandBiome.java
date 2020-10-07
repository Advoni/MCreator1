
package net.mcreator.gratestinventions.world.biome;

import net.minecraft.block.material.Material;

@GratestInventionsModElements.ModElement.Tag
public class AetherWasteLandBiome extends GratestInventionsModElements.ModElement {

	@ObjectHolder("gratest_inventions:aether_waste_land")
	public static final CustomBiome biome = null;

	public AetherWasteLandBiome(GratestInventionsModElements instance) {
		super(instance, 107);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new CustomBiome());
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
	}

	static class CustomBiome extends Biome {

		public CustomBiome() {
			super(new Biome.Builder().downfall(0f).depth(0.1f).scale(0.2f).temperature(0.5f).precipitation(Biome.RainType.NONE)
					.category(Biome.Category.NONE).waterColor(4159204).waterFogColor(329011)
					.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(CloudBlockBlock.block.getDefaultState(),
							CloudBlockBlock.block.getDefaultState(), CloudBlockBlock.block.getDefaultState())));

			setRegistryName("aether_waste_land");

			DefaultBiomeFeatures.addCarvers(this);
			DefaultBiomeFeatures.addStructures(this);
			DefaultBiomeFeatures.addMonsterRooms(this);
			DefaultBiomeFeatures.addOres(this);

			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
					Feature.RANDOM_SELECTOR
							.withConfiguration(new MultipleRandomFeatureConfig(
									ImmutableList.of(Feature.NORMAL_TREE.withConfiguration(DefaultBiomeFeatures.field_230129_h_).withChance(0.2F),
											Feature.FANCY_TREE.withConfiguration(DefaultBiomeFeatures.field_230131_m_).withChance(0.1F)),
									Feature.NORMAL_TREE.withConfiguration(DefaultBiomeFeatures.field_230132_o_)))
							.withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(3, 0.1F, 1))));

		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public int getSkyColor() {
			return -10027060;
		}

	}

}
