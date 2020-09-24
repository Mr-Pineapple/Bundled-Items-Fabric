package co.uk.pinelogstudios.pineapple.bundleditems.init;

import co.uk.pinelogstudios.pineapple.bundleditems.BundledItems;
import co.uk.pinelogstudios.pineapple.bundleditems.items.BundledItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

/**
 *	Author:	Mr. Pineapple
 */
public class ItemList {
	
	public static Item SECRET_ITEM, GLASS_VIAL;
	
	public static void registerItems() {
		registerItem("porkchop", Items.PORKCHOP);
		registerItem("cooked_porkchop", Items.COOKED_PORKCHOP);
		registerItem("raw_beef", Items.BEEF);
		registerItem("cooked_beef", Items.COOKED_BEEF);
		registerItem("bread", Items.BREAD);
		registerItem("raw_chicken", Items.CHICKEN);
		registerItem("cooked_chicken", Items.COOKED_CHICKEN);
		registerItem("raw_mutton", Items.MUTTON);
		registerItem("cooked_mutton", Items.COOKED_MUTTON);
		registerItem("raw_rabbit", Items.RABBIT);
		registerItem("cooked_rabbit", Items.COOKED_RABBIT);
		registerItem("cookies", Items.COOKIE);
		registerItem("potatoes", Items.POTATO);
		registerItem("baked_potatoes", Items.BAKED_POTATO);
		registerItem("rotten_flesh", Items.ROTTEN_FLESH);
		registerItem("carrots", Items.CARROT);
		registerItem("golden_carrots", Items.GOLDEN_CARROT);
		registerItem("blaze_rods", Items.BLAZE_ROD);
		registerItem("arrows", Items.ARROW);
		registerItem("bones", Items.BONE);
		registerItem("sticks", Items.STICK);
		registerItem("fireworks", Items.FIREWORK_ROCKET);
		registerItem("feathers", Items.FEATHER);
		registerItem("paper", Items.PAPER);
		registerItem("books", Items.BOOK);
		registerItem("chorus_fruits", Items.CHORUS_FRUIT);
		registerItem("popped_chorus_fruits", Items.POPPED_CHORUS_FRUIT);
		registerItem("buckets", Items.BUCKET);
		registerItem("apples", new FabricItemSettings().group(BundledItems.ITEM_GROUP).maxCount(32).recipeRemainder(Items.BOWL), Items.APPLE, 8, true, false);
		registerItem("golden_apples", new FabricItemSettings().group(BundledItems.ITEM_GROUP).maxCount(32).recipeRemainder(Items.BOWL),  Items.GOLDEN_APPLE, 8, true, false);
		Registry.register(Registry.ITEM, new Identifier(BundledItems.MOD_ID, "bundled_enchanted_golden_apples"), new BundledItem(new FabricItemSettings().group(BundledItems.ITEM_GROUP).maxCount(32).rarity(Rarity.EPIC).recipeRemainder(Items.BOWL), Items.ENCHANTED_GOLDEN_APPLE, 8, true, false) {
		@Override
		public boolean hasGlint(ItemStack stack) {
			return true;
		}});
		registerItem("snowballs", new FabricItemSettings().group(BundledItems.ITEM_GROUP).maxCount(32).recipeRemainder(Items.BOWL), Items.SNOWBALL, 8, true, false);
		registerItem("bowls", Items.BOWL);
		registerItem("bricks", Items.BRICK);
		registerItem("clay_balls", new FabricItemSettings().group(BundledItems.ITEM_GROUP).maxCount(32).recipeRemainder(Items.BOWL), Items.CLAY_BALL, 8, true, false);
		registerItem("flints", Items.FLINT);
		registerItem("name_tags", Items.NAME_TAG);
		Registry.register(Registry.ITEM, new Identifier(BundledItems.MOD_ID, "bundled_nether_stars"), new BundledItem(new FabricItemSettings().group(BundledItems.ITEM_GROUP).maxCount(32).rarity(Rarity.UNCOMMON), Items.NETHER_STAR) {
		@Override
		public boolean hasGlint(ItemStack stack) {
			return true;
		}});
		registerItem("nether_warts", new FabricItemSettings().group(BundledItems.ITEM_GROUP).maxCount(32).recipeRemainder(Items.BOWL), Items.NETHER_WART, 8, true, false);
		registerItem("netherbricks", Items.NETHER_BRICK);
		registerItem("sugar_cane", Items.SUGAR_CANE);
		registerItem("glowstone_dust", new FabricItemSettings().group(BundledItems.ITEM_GROUP).maxCount(32).recipeRemainder(GLASS_VIAL), Items.GLOWSTONE_DUST, 8, false, true);
		registerItem("gunpowder", new FabricItemSettings().group(BundledItems.ITEM_GROUP).maxCount(32).recipeRemainder(GLASS_VIAL), Items.GUNPOWDER, 8, false, true);
		registerItem("redstone", new FabricItemSettings().group(BundledItems.ITEM_GROUP).maxCount(32).recipeRemainder(GLASS_VIAL), Items.REDSTONE, 8, false, true);
		registerItem("blaze_powder", new FabricItemSettings().group(BundledItems.ITEM_GROUP).maxCount(32).recipeRemainder(Items.BOWL), Items.BLAZE_POWDER, 8, true, false);
		registerItem("slimeballs", new FabricItemSettings().group(BundledItems.ITEM_GROUP).maxCount(32).recipeRemainder(Items.BOWL), Items.SLIME_BALL, 8, true, false);
		registerItem("leather", Items.LEATHER);
		registerItem("empty_bottles", Items.GLASS_BOTTLE);
		registerItem("water_bottles", Items.GLASS_BOTTLE);
		registerItem("sugar", new FabricItemSettings().group(BundledItems.ITEM_GROUP).maxCount(32).recipeRemainder(GLASS_VIAL), Items.SUGAR, 8, false, true);
		GLASS_VIAL = registerItemNoProperties("small_bottle", new FabricItemSettings().group(BundledItems.ITEM_GROUP).maxCount(64));
		registerItem("cod", Items.COD);
		registerItem("salmon", Items.SALMON);
		registerItem("cooked_cod", Items.COOKED_COD);
		registerItem("cooked_salmon", Items.COOKED_SALMON);
		SECRET_ITEM = registerItemNoProperties("secret_item", new FabricItemSettings());
		
	}
	
	private static void registerItem(String name, Item nonBundledItem) {
		Registry.register(Registry.ITEM, new Identifier(BundledItems.MOD_ID, "bundled_" + name), new BundledItem(nonBundledItem));
	}
	
	private static void registerItem(String name, FabricItemSettings settings, Item nonBundledItem, int amount, boolean hasBowl, boolean hasVial) {
		Registry.register(Registry.ITEM, new Identifier(BundledItems.MOD_ID, "bundled_" + name), new BundledItem(settings, nonBundledItem, amount, hasBowl, hasVial));
	}
	
	private static Item registerItemNoProperties(String name, FabricItemSettings settings) {
		return Registry.register(Registry.ITEM, new Identifier(BundledItems.MOD_ID, name), new Item(settings));
	}

}
