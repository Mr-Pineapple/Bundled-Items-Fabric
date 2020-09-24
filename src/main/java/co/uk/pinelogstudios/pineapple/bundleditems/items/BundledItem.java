package co.uk.pinelogstudios.pineapple.bundleditems.items;

import co.uk.pinelogstudios.pineapple.bundleditems.BundledItems;
import co.uk.pinelogstudios.pineapple.bundleditems.init.ItemList;
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
	boolean hasBowl, hasVial;
	
	public BundledItem(Item nonBundledItem) {
		super(new FabricItemSettings().group(BundledItems.ITEM_GROUP).maxCount(32));
		this.nonBundledItem = nonBundledItem;
		this.amount = 9;
	}
	
	public BundledItem(Item nonBundledItem, int amount, boolean hasBowl, boolean hasVail) {
		super(new FabricItemSettings().group(BundledItems.ITEM_GROUP).maxCount(32));
		this.nonBundledItem = nonBundledItem;
		this.amount = amount;
		this.hasBowl = hasBowl;
		this.hasVial = hasVail;
	}
	
	public BundledItem(FabricItemSettings settings, Item nonBundledItem) {
		super(settings);
		this.nonBundledItem = nonBundledItem;
	}
	
	public BundledItem(FabricItemSettings settings, Item nonBundledItem, int amount, boolean hasBowl, boolean hasVail) {
		super(settings);
		this.nonBundledItem = nonBundledItem;
		this.amount = amount;
		this.hasBowl = hasBowl;
		this.hasVial = hasVail;
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
	
}
