
package net.mcreator.gratestinventions.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.gratestinventions.itemgroup.GratestInventionsItemGroup;
import net.mcreator.gratestinventions.GratestInventionsModElements;

@GratestInventionsModElements.ModElement.Tag
public class PlatinumShavingsItem extends GratestInventionsModElements.ModElement {
	@ObjectHolder("gratest_inventions:platinum_shavings")
	public static final Item block = null;
	public PlatinumShavingsItem(GratestInventionsModElements instance) {
		super(instance, 113);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(GratestInventionsItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("platinum_shavings");
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
