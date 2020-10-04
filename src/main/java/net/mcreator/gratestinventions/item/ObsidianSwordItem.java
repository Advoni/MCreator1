
package net.mcreator.gratestinventions.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.gratestinventions.itemgroup.GratestInventionsItemGroup;
import net.mcreator.gratestinventions.GratestInventionsModElements;

@GratestInventionsModElements.ModElement.Tag
public class ObsidianSwordItem extends GratestInventionsModElements.ModElement {
	@ObjectHolder("gratest_inventions:obsidian_sword")
	public static final Item block = null;
	public ObsidianSwordItem(GratestInventionsModElements instance) {
		super(instance, 46);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 2000;
			}

			public float getEfficiency() {
				return 1f;
			}

			public float getAttackDamage() {
				return 3.5f;
			}

			public int getHarvestLevel() {
				return 0;
			}

			public int getEnchantability() {
				return 14;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(ObsidianShardItem.block, (int) (1)));
			}
		}, 3, -2.4f, new Item.Properties().group(GratestInventionsItemGroup.tab)) {
		}.setRegistryName("obsidian_sword"));
	}
}
