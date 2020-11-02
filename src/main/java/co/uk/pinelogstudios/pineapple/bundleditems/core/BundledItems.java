package co.uk.pinelogstudios.pineapple.bundleditems.core;

import co.uk.pinelogstudios.pineapple.bundleditems.core.init.ItemList;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

/**
 *	Author:	Mr. Pineapple
 */
public class BundledItems implements ModInitializer {
	
	public static final String MOD_ID = "bundleditems";

	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
			new Identifier(MOD_ID, "items"),
			() -> new ItemStack(ItemList.SECRET_ITEM));
	
	@Override
	public void onInitialize() {
		ItemList.registerItems();
	}

}
