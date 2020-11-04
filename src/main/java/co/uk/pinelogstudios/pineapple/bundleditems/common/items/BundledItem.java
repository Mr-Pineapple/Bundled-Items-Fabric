package co.uk.pinelogstudios.pineapple.bundleditems.common.items;

import co.uk.pinelogstudios.pineapple.bundleditems.core.BundledItems;
import co.uk.pinelogstudios.pineapple.bundleditems.core.init.ItemList;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 *	Author:	Mr. Pineapple
 */
public class BundledItem extends Item {
	
	Item nonBundledItem;
	int amount;
	boolean hasBowl, hasVial, hasQuiver, isGlowing;
	
	public BundledItem(Item nonBundledItem) {
		super(new FabricItemSettings().group(BundledItems.ITEM_GROUP).maxCount(32));
		this.nonBundledItem = nonBundledItem;
		this.amount = 9;
		this.isGlowing = false;
	}
	
	public BundledItem(Item nonBundledItem, int amount, boolean hasBowl, boolean hasVail, boolean hasQuiver) {
		super(new FabricItemSettings().group(BundledItems.ITEM_GROUP).maxCount(32));
		this.nonBundledItem = nonBundledItem;
		this.amount = amount;
		this.hasBowl = hasBowl;
		this.hasVial = hasVail;
		this.hasQuiver = hasQuiver;
		this.isGlowing = false;
	}
	
	public BundledItem(FabricItemSettings settings, Item nonBundledItem) {
		super(settings);
		this.nonBundledItem = nonBundledItem;
		this.isGlowing = false;
	}
	
	public BundledItem(FabricItemSettings settings, Item nonBundledItem, boolean isGlowing) {
		super(settings);
		this.nonBundledItem = nonBundledItem;
		this.isGlowing = isGlowing;
	}
	
	public BundledItem(FabricItemSettings settings, Item nonBundledItem, int amount, boolean hasBowl, boolean hasVail, boolean hasQuiver) {
		super(settings);
		this.nonBundledItem = nonBundledItem;
		this.amount = amount;
		this.hasBowl = hasBowl;
		this.hasVial = hasVail;
		this.hasQuiver = hasQuiver;
		this.isGlowing = false;
	}
	
	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
		ItemStack item = player.getStackInHand(hand);
		BlockPos pos = player.getBlockPos();
		
		if(player.isInSneakingPose()) {
			if(this.hasBowl) {
				if(player.inventory.getEmptySlot() != -1) {
					giveContainerItem(player, Items.BOWL);
				} else if(player.inventory.contains(new ItemStack(Items.BOWL))) {
					giveContainerItem(player, Items.BOWL);
				} else {
					world.spawnEntity(new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 1.25, pos.getZ() + 0.5, new ItemStack(Items.BOWL)));
				}
			} if(this.hasVial) {
				if(player.inventory.getEmptySlot() != -1) {
					giveContainerItem(player, ItemList.GLASS_VIAL);
				} else if(player.inventory.contains(new ItemStack(ItemList.GLASS_VIAL))) {
					giveContainerItem(player, ItemList.GLASS_VIAL);
				} else {
					world.spawnEntity(new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 1.25, pos.getZ() + 0.5, new ItemStack(ItemList.GLASS_VIAL)));
				}
			} if(this.hasQuiver) {
				if(player.inventory.getEmptySlot() != -1) {
					giveContainerItem(player, ItemList.QUIVER);
				} else if(player.inventory.contains(new ItemStack(ItemList.GLASS_VIAL))) {
					giveContainerItem(player, ItemList.QUIVER);
				} else {
					world.spawnEntity(new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 1.25, pos.getZ() + 0.5, new ItemStack(ItemList.QUIVER)));
				}
			}
			
			if(player.inventory.getEmptySlot() != -1) {
				giveMultipleItem(player, this.nonBundledItem);
			} else if(player.inventory.contains(new ItemStack(this.nonBundledItem))) {
				giveMultipleItem(player, this.nonBundledItem);
			} else {
				world.spawnEntity(new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 1.125, pos.getZ() + 0.5, new ItemStack(this.nonBundledItem)));
			}
			
			item.decrement(1);
			player.getItemCooldownManager().set(this, 20*1);
		}
		return TypedActionResult.success(item);
	}
	
	void giveMultipleItem(PlayerEntity player, Item item) {
		for(int x = 0; x < this.amount; x++) {
			player.inventory.insertStack(new ItemStack(item));
		}
	}
	
	void giveContainerItem(PlayerEntity player, Item item) {
		player.inventory.insertStack(new ItemStack(item));
	}
	
	public boolean hasGlint(ItemStack stack) {
		return this.isGlowing;
	}
	
}
