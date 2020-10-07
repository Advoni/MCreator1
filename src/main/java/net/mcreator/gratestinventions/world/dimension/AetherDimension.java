
package net.mcreator.gratestinventions.world.dimension;

import net.minecraft.block.material.Material;

@GratestInventionsModElements.ModElement.Tag
public class AetherDimension extends GratestInventionsModElements.ModElement {

	@ObjectHolder("gratest_inventions:aether")
	public static final ModDimension dimension = null;

	public static DimensionType type = null;

	private static Biome[] dimensionBiomes;

	public AetherDimension(GratestInventionsModElements instance) {
		super(instance, 107);

		MinecraftForge.EVENT_BUS.register(this);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerDimension(RegistryEvent.Register<ModDimension> event) {
		event.getRegistry().register(new CustomModDimension().setRegistryName("aether"));
	}

	@SubscribeEvent
	public void onRegisterDimensionsEvent(RegisterDimensionsEvent event) {
		if (DimensionType.byName(new ResourceLocation("gratest_inventions:aether")) == null) {
			DimensionManager.registerDimension(new ResourceLocation("gratest_inventions:aether"), dimension, null, true);
		}

		type = DimensionType.byName(new ResourceLocation("gratest_inventions:aether"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		dimensionBiomes = new Biome[]{};
	}

	public static class CustomModDimension extends ModDimension {

		@Override
		public BiFunction<World, DimensionType, ? extends Dimension> getFactory() {
			return CustomDimension::new;
		}

	}

	public static class CustomDimension extends Dimension {

		private BiomeProviderCustom biomeProviderCustom = null;

		public CustomDimension(World world, DimensionType type) {
			super(world, type, 0.5f);
			this.nether = false;
		}

		@Override public void calculateInitialWeather() {
		}

    	@Override public void updateWeather(Runnable defaultWeather) {
		}

		@Override public boolean canDoLightning(Chunk chunk) {
			return false;
		}

		@Override public boolean canDoRainSnowIce(Chunk chunk) {
			return false;
		}

		@Override @OnlyIn(Dist.CLIENT) public Vec3d getFogColor(float cangle, float ticks) {
			return new Vec3d(0.752941176471,0.847058823529,1);
		}

		@Override public ChunkGenerator<?> createChunkGenerator() {
			if(this.biomeProviderCustom == null) {
				this.biomeProviderCustom = new BiomeProviderCustom(this.world);
			}
			return new ChunkProviderModded(this.world, this.biomeProviderCustom);
		}

		@Override public boolean isSurfaceWorld() {
			return false;
		}

		@Override public boolean canRespawnHere() {
			return false;
		}

		@OnlyIn(Dist.CLIENT) @Override public boolean doesXZShowFog(int x, int z) {
			return false;
		}

		@Override public SleepResult canSleepAt(PlayerEntity player, BlockPos pos){
        	return SleepResult.ALLOW;
		}

		@Nullable public BlockPos findSpawn(ChunkPos chunkPos, boolean checkValid) {
   		   return null;
   		}

   		@Nullable public BlockPos findSpawn(int x, int z, boolean checkValid) {
   		   return null;
   		}

		@Override public boolean doesWaterVaporize() {
      		return false;
   		}

		@Override /* failed to load code for net.minecraft.world.dimension.OverworldDimension */

	}

	public static class ChunkProviderModded extends EndChunkGenerator {

		public ChunkProviderModded(IWorld world, BiomeProvider provider) {
			super(world, provider, new EndGenerationSettings() {
				public BlockState getDefaultBlock() {
					return CloudBlockBlock.block.getDefaultState();
				}

				public BlockState getDefaultFluid() {
					return MilkBlock.block.getDefaultState();
				}
			});
			this.randomSeed.skip(3946);
		}

	}

	public static class BiomeLayerCustom implements IC0Transformer {

		@Override
		public int apply(INoiseRandom context, int value) {
			return Registry.BIOME.getId(dimensionBiomes[context.random(dimensionBiomes.length)]);
		}

	}

	public static class BiomeProviderCustom extends BiomeProvider {

		private Layer genBiomes;

		public BiomeProviderCustom(World world) {
			super(new HashSet<Biome>(Arrays.asList(dimensionBiomes)));

			this.genBiomes = getBiomeLayer(world.getSeed());

		}

		public Biome getNoiseBiome(int x, int y, int z) {
			return this.genBiomes.func_215738_a(x, z);
		}

		private Layer getBiomeLayer(long seed) {
			LongFunction<IExtendedNoiseRandom<LazyArea>> contextFactory = l -> new LazyAreaLayerContext(25, seed, l);

			IAreaFactory<LazyArea> parentLayer = IslandLayer.INSTANCE.apply(contextFactory.apply(1));
			IAreaFactory<LazyArea> biomeLayer = (new BiomeLayerCustom()).apply(contextFactory.apply(200), parentLayer);

			biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1000), biomeLayer);
			biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1001), biomeLayer);
			biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1002), biomeLayer);
			biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1003), biomeLayer);
			biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1004), biomeLayer);
			biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1005), biomeLayer);

			return new Layer(biomeLayer);
		}

	}

}
