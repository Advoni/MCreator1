
package net.mcreator.gratestinventions.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.gratestinventions.item.ObsidianShardItem;
import net.mcreator.gratestinventions.GratestInventionsModElements;

@GratestInventionsModElements.ModElement.Tag
public class GratestInventionsItemGroup extends GratestInventionsModElements.ModElement {
	public GratestInventionsItemGroup(GratestInventionsModElements instance) {
		super(instance, 40);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabgratest_inventions") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(ObsidianShardItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
