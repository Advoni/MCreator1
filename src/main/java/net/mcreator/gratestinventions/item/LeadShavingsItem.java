
package net.mcreator.gratestinventions.item;

@GratestInventionsModElements.ModElement.Tag
public class LeadShavingsItem extends GratestInventionsModElements.ModElement {

	@ObjectHolder("gratest_inventions:lead_shavings")
	public static final Item block = null;

	public LeadShavingsItem(GratestInventionsModElements instance) {
		super(instance, 114);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(GratestInventionsItemGroup.tab).maxStackSize(64));
			setRegistryName("lead_shavings");
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
