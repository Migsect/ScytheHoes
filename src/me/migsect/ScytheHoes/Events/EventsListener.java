package me.migsect.ScytheHoes.Events;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.migsect.ScytheHoes.Helper;
import me.migsect.ScytheHoes.ScytheHoes;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class EventsListener implements Listener
{
	List<Event> no_do_break = new ArrayList<Event>();
	List<Event> no_do_place = new ArrayList<Event>();
	
	ScytheHoes plugin;
	
	public EventsListener(ScytheHoes plugin)
	{
		this.plugin = plugin;
	}
	
	private int getSpanLeaves(Material mat)
	{
		// Scythes
		if(mat.equals(Material.WOOD_HOE)) 		return plugin.getConfig().getInt("Leaves-Reach." + Material.WOOD_HOE.toString());
		if(mat.equals(Material.STONE_HOE)) 		return plugin.getConfig().getInt("Leaves-Reach." + Material.STONE_HOE.toString());
		if(mat.equals(Material.IRON_HOE)) 		return plugin.getConfig().getInt("Leaves-Reach." + Material.IRON_HOE.toString());
		if(mat.equals(Material.GOLD_HOE)) 		return plugin.getConfig().getInt("Leaves-Reach." + Material.GOLD_HOE.toString());
		if(mat.equals(Material.DIAMOND_HOE))	return plugin.getConfig().getInt("Leaves-Reach." + Material.DIAMOND_HOE.toString());
		// Machetes
		if(mat.equals(Material.WOOD_SWORD)) 	return plugin.getConfig().getInt("Leaves-Reach." + Material.WOOD_SWORD.toString());
		if(mat.equals(Material.STONE_SWORD)) 	return plugin.getConfig().getInt("Leaves-Reach." + Material.STONE_SWORD.toString());
	  if(mat.equals(Material.IRON_SWORD)) 	return plugin.getConfig().getInt("Leaves-Reach." + Material.IRON_SWORD.toString());
		if(mat.equals(Material.GOLD_SWORD)) 	return plugin.getConfig().getInt("Leaves-Reach." + Material.GOLD_SWORD.toString());
		if(mat.equals(Material.DIAMOND_SWORD))return plugin.getConfig().getInt("Leaves-Reach." + Material.DIAMOND_SWORD.toString());
		return 0;
	}
	private int getSpanCrops(Material mat)
	{
		// Scythes
		if(mat.equals(Material.WOOD_HOE)) 		return plugin.getConfig().getInt("Crop-Reach." + Material.WOOD_HOE.toString());
		if(mat.equals(Material.STONE_HOE)) 		return plugin.getConfig().getInt("Crop-Reach." + Material.STONE_HOE.toString());
		if(mat.equals(Material.IRON_HOE)) 		return plugin.getConfig().getInt("Crop-Reach." + Material.IRON_HOE.toString());
		if(mat.equals(Material.GOLD_HOE)) 		return plugin.getConfig().getInt("Crop-Reach." + Material.GOLD_HOE.toString());
		if(mat.equals(Material.DIAMOND_HOE))	return plugin.getConfig().getInt("Crop-Reach." + Material.DIAMOND_HOE.toString());
		// Machetes
		if(mat.equals(Material.WOOD_SWORD)) 	return plugin.getConfig().getInt("Crop-Reach." + Material.WOOD_SWORD.toString());
		if(mat.equals(Material.STONE_SWORD)) 	return plugin.getConfig().getInt("Crop-Reach." + Material.STONE_SWORD.toString());
	  if(mat.equals(Material.IRON_SWORD)) 	return plugin.getConfig().getInt("Crop-Reach." + Material.IRON_SWORD.toString());
		if(mat.equals(Material.GOLD_SWORD)) 	return plugin.getConfig().getInt("Crop-Reach." + Material.GOLD_SWORD.toString());
		if(mat.equals(Material.DIAMOND_SWORD))return plugin.getConfig().getInt("Crop-Reach." + Material.DIAMOND_SWORD.toString());
		return 0;
	}
	private int getSpanPlants(Material mat)
	{
		// Scythes
		if(mat.equals(Material.WOOD_HOE)) 		return plugin.getConfig().getInt("Plants-Reach." + Material.WOOD_HOE.toString());
		if(mat.equals(Material.STONE_HOE)) 		return plugin.getConfig().getInt("Plants-Reach." + Material.STONE_HOE.toString());
		if(mat.equals(Material.IRON_HOE)) 		return plugin.getConfig().getInt("Plants-Reach." + Material.IRON_HOE.toString());
		if(mat.equals(Material.GOLD_HOE)) 		return plugin.getConfig().getInt("Plants-Reach." + Material.GOLD_HOE.toString());
		if(mat.equals(Material.DIAMOND_HOE))	return plugin.getConfig().getInt("Plants-Reach." + Material.DIAMOND_HOE.toString());
		// Machetes
		if(mat.equals(Material.WOOD_SWORD)) 	return plugin.getConfig().getInt("Plants-Reach." + Material.WOOD_SWORD.toString());
		if(mat.equals(Material.STONE_SWORD)) 	return plugin.getConfig().getInt("Plants-Reach." + Material.STONE_SWORD.toString());
	  if(mat.equals(Material.IRON_SWORD)) 	return plugin.getConfig().getInt("Plants-Reach." + Material.IRON_SWORD.toString());
		if(mat.equals(Material.GOLD_SWORD)) 	return plugin.getConfig().getInt("Plants-Reach." + Material.GOLD_SWORD.toString());
		if(mat.equals(Material.DIAMOND_SWORD))return plugin.getConfig().getInt("Plants-Reach." + Material.DIAMOND_SWORD.toString());
		return 0;
	}
	private double getDurCoeff(Material mat)
	{
		Material raw_mat = Helper.getRawMaterial(mat);
		if(raw_mat.equals(null)) 									return 0.0;
		if(raw_mat.equals(Material.WOOD)) 				return plugin.getConfig().getDouble("Extra-Durability-Coeff.WOOD");
		if(raw_mat.equals(Material.COBBLESTONE)) 	return plugin.getConfig().getDouble("Extra-Durability-Coeff.STONE");
		if(raw_mat.equals(Material.IRON_INGOT)) 	return plugin.getConfig().getDouble("Extra-Durability-Coeff.IRON");
		if(raw_mat.equals(Material.GOLD_INGOT)) 	return plugin.getConfig().getDouble("Extra-Durability-Coeff.GOLD");
		if(raw_mat.equals(Material.DIAMOND)) 			return plugin.getConfig().getDouble("Extra-Durability-Coeff.D");
		return 0.0;
	}
	
	@EventHandler
	public void onFarmBreak(BlockBreakEvent event)
	{
		if(event.isCancelled()) return;
		if(no_do_break.contains(event)) return; // For when we call the event again below.
		Player player = event.getPlayer();
		ItemStack in_hand = player.getItemInHand();
		
		BlockState broken_block = event.getBlock().getState();
		Material crop_type = null;
		List<Material> crop_types = Helper.stringToMaterial(plugin.getConfig().getStringList("Crop-Types"));
		for(int i = 0 ; i < crop_types.size(); i++)
		{	
			Material check_mat = crop_types.get(i);
			short mature_data =  Helper.getMaturityAge(check_mat);
			if(broken_block.getType().equals(check_mat) && broken_block.getData().toItemStack().getDurability() == mature_data)
			{
				crop_type = check_mat;
				break;
			}
		}
		
		// getting the range of the scythe being used.
		int span = this.getSpanCrops(in_hand.getType());
		if(span == 0) return;
		
		double dur_coeff = this.getDurCoeff(Helper.getRawMaterial(player.getItemInHand().getType()));
		
		// break and stop of the tool is tool damaged.
		Helper.simulateItemDamage(player, player.getItemInHand());
		
		// Start the block breaking:  This will do an area sweep and not a connected branch.  Sycthes don't work the other way.
		
		// Beging block looping
		List<BlockState> block_breaks = new ArrayList<BlockState>();
		for(int x = -span; x <= span; x++)
		{
			for(int z = -span; z <= span; z++)
			{
				BlockState target = event.getBlock().getRelative(x, 0, z).getState();
				if(target.getType().equals(crop_type) && target.getData().toItemStack().getDurability() == 7) // only breaking the blocks of sufficient level.
				{
					if(x == 0 && z == 0) continue; // block 0,0 is already broken.
					block_breaks.add(target);
					Helper.simulateBlockBreak(target.getBlock(), player, no_do_break, dur_coeff); // we're going to need to do the seed thing here as well...
				}
			}
		}
		for(int i = 0; i < block_breaks.size(); i++)
		{
			Helper.simulateBlockBreak(block_breaks.get(i).getBlock(), player, no_do_break, dur_coeff);
		}
		// End block looping.
	}
	
	@EventHandler
	public void onLeafBreak(BlockBreakEvent event)
	{
		if(event.isCancelled()) return;
		if(no_do_break.contains(event)) return; // For when we call the event again below.
		Player player = event.getPlayer();
		ItemStack in_hand = player.getItemInHand();
		
		BlockState broken_block = event.getBlock().getState();
		// We only want to break leaves.
		if(!(broken_block.getType().equals(Material.LEAVES) || broken_block.getType().equals(Material.LEAVES_2))) return; 
		
		int span = 0;
		// player.sendMessage("Tool: " + in_hand.getType().toString());
		if(in_hand.getType().equals(Material.IRON_HOE)) span = 1; // Total of 3x3 Area - 9 blocks | 251 possible breaks.
		else if(in_hand.getType().equals(Material.GOLD_HOE)) span = 2; // Total of 5x5 Area - 25 blocks - No extra durability on breaks | 825 total possible breaks.
		else if(in_hand.getType().equals(Material.DIAMOND_HOE)) span = 4; // Total of 9x9 area - 81 blocks | 1562 total possible breaks.
		else return; // Because we don't need to do anything else.
		// player.sendMessage("Span : " + span);
		
		if(!(in_hand.getDurability() < in_hand.getType().getMaxDurability())) return;
		
		// Start the block breaking:  This will do an area sweep and not a connected branch.  Sycthes don't work the other way.
		Random rand = new Random(); //  for durability.
		int unbreaking = 1;
		if(in_hand.getItemMeta().hasEnchant(Enchantment.DURABILITY))
		{
			unbreaking = 1 + in_hand.getEnchantmentLevel(Enchantment.DURABILITY);
		}
		if((rand.nextInt(100) + 1) < (100/unbreaking) && !player.getGameMode().equals(GameMode.CREATIVE))
		{
			in_hand.setDurability((short) (in_hand.getDurability() + 1)); //  durability setting.
			player.updateInventory();
		}
		
		for(int x = -span; x <= span; x++)
		{
			for(int y = -span; y <= span; y++)
			{
				for(int z = -span; z <= span; z++)
				{
					BlockState target = event.getBlock().getRelative(x, y, z).getState();
					if(target.getType().equals(Material.LEAVES) || target.getType().equals(Material.LEAVES_2)) // only breaking the blocks of sufficient level.
					{
						// Breaking the block.
						// I don't know if durability starts at 0 or max_durability.  if it is 0, then we'll chance this.
						if(in_hand.getDurability() < in_hand.getType().getMaxDurability()) // Checking for ample durability.  This deals with durability.
						{
							if(x == 0 && y == 0 && z == 0) continue; // block 0,0 is already broken.
							// Making a new event for the block we are about the break.
							BlockBreakEvent new_event = new BlockBreakEvent(target.getBlock(), event.getPlayer());
							no_do_break.add(new_event); // making sure this doesn't run a second time.
							Bukkit.getServer().getPluginManager().callEvent(new_event);
							no_do_break.remove(new_event); // cleaning up the list.
							if(new_event.isCancelled()) continue; // jump to test the new block.
							
							// If a random number between 1 and 100 is less than 100/unbreaking, then do durability.
							if((rand.nextInt(100) + 1) < (100/unbreaking) && span != 2 && !player.getGameMode().equals(GameMode.CREATIVE))
							{
								in_hand.setDurability((short) (in_hand.getDurability() + 1)); //  durability setting.
								player.updateInventory();
							}
							
							target.getBlock().breakNaturally();

						}
						else return;
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onSeedPlace(BlockPlaceEvent event)
	{
		if(event.isCancelled()) return;
		if(no_do_place.contains(event)) return;
		
		Player player = event.getPlayer();
		ItemStack item = event.getItemInHand(); // grabs the itemstack that the player had.
		Material place_mat = null;
		
		// check to see if the item we are placing if a possible crop.  We then set the material we will place to the block variant.
		if(item.getType().equals(Material.SEEDS)) place_mat = Material.CROPS;
		else if(item.getType().equals(Material.CARROT_ITEM)) place_mat = Material.CARROT;
		else if(item.getType().equals(Material.POTATO_ITEM)) place_mat = Material.POTATO;
		else return;
		
		ItemStack place_item = new ItemStack(place_mat);
		
		int distance = 4;
		Block center = event.getBlock().getRelative(BlockFace.DOWN);  // This should be farmland
		List<Block> soil_blocks = new ArrayList<Block>(); // 
		List<Block> holder_blocks = new ArrayList<Block>();
		List<Block> new_blocks = new ArrayList<Block>(); // these are the check blocks that are being added from the proximity of the holder-Blocks.
		holder_blocks.add(center);
		for(int i = 0; i < distance; i++)
		{
			for(int j = holder_blocks.size() - 1; j >= 0; j--)
			{
				new_blocks.add(holder_blocks.get(j).getRelative(BlockFace.NORTH));
				new_blocks.add(holder_blocks.get(j).getRelative(BlockFace.SOUTH));
				new_blocks.add(holder_blocks.get(j).getRelative(BlockFace.EAST));
				new_blocks.add(holder_blocks.get(j).getRelative(BlockFace.WEST));
				new_blocks.add(holder_blocks.get(j).getRelative(BlockFace.NORTH_EAST));
				new_blocks.add(holder_blocks.get(j).getRelative(BlockFace.NORTH_WEST));
				new_blocks.add(holder_blocks.get(j).getRelative(BlockFace.SOUTH_EAST));
				new_blocks.add(holder_blocks.get(j).getRelative(BlockFace.SOUTH_WEST));
				if(holder_blocks.get(j).getType().equals(Material.SOIL)) soil_blocks.add(holder_blocks.get(j)); // Add the block to the soil list.
				holder_blocks.remove(j); //  Remove the block.
			}
			holder_blocks.addAll(new_blocks);
			new_blocks.clear();
		}
		item.setAmount(item.getAmount() - 1);
		for(int i = 1; i < soil_blocks.size(); i++)
		{
			Block up_block = soil_blocks.get(i).getRelative(BlockFace.UP);
			if(!up_block.getType().equals(Material.AIR)) continue;
			
			// Inventory management
			int inv_slot = player.getInventory().first(item.getType());
			if(inv_slot < 0) return; // -1 signifies that there isn't an item, so we end the process.
			ItemStack dec_item = player.getInventory().getItem(inv_slot); // grab the item stack to decrement.
			
			// Breaking the block
			BlockState replaced = up_block.getRelative(BlockFace.UP).getState();
			Block against = up_block;
			ItemStack item_in_hand = dec_item;
			Block placed = up_block;
			placed.setType(place_mat);
			BlockState place_state = placed.getState();
			place_state.setData(place_item.getData());
			place_state.update(true);
			BlockPlaceEvent new_event = new BlockPlaceEvent(placed, replaced, against, item_in_hand, player, event.canBuild());
			no_do_place.add(new_event);
			Bukkit.getPluginManager().callEvent(new_event);
			no_do_place.remove(new_event);
			if(new_event.isCancelled())
			{
				replaced.update(true);
				continue;
			}
			
			// reducing the item
			if(player.getGameMode().equals(GameMode.CREATIVE)) continue;;
			dec_item.setAmount(dec_item.getAmount() - 1); // Hope this works and we aren't making a copy of the stack.
			if(dec_item.getAmount() == 0) player.getInventory().clear(inv_slot);
			else player.getInventory().setItem(inv_slot, dec_item);
			player.updateInventory();
		}
	}
}
