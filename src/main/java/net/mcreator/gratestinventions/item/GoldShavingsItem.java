
package net.mcreator.gratestinventions.item;

@GratestInventionsModElements.ModElement.Tag
public class GoldShavingsItem extends GratestInventionsModElements.ModElement {

	@ObjectHolder("gratest_inventions:gold_shavings")
	public static final Item block = null;

	public GoldShavingsItem(GratestInventionsModElements instance) {
		super(instance, 110);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(GratestInventionsItemGroup.tab).maxStackSize(64));
			setRegistryName("gold_shavings");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

	}

}
