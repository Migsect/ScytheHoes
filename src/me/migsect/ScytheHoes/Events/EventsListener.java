package me.migsect.ScytheHoes.Events;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class EventsListener implements Listener
{
	List<Event> no_do_break = new ArrayList<Event>();
	
	@EventHandler
	public void onFarmBreak(BlockBreakEvent event)
	{
		if(event.isCancelled()) return;
		if(no_do_break.contains(event)) return; // For when we call the event again below.
		Player player = event.getPlayer();
		ItemStack in_hand = player.getItemInHand();
		
		BlockState broken_block = event.getBlock().getState();
		Material crop_type = null;
		// player.sendMessage("Block Data: " + broken_block.getData().toItemStack().getDurability() + "");
		// player.sendMessage("Detected Tool: " + broken_block.getType().toString());
		if(broken_block.getType().equals(Material.CROPS) && broken_block.getData().toItemStack().getDurability() == 7)
		{
			crop_type = Material.CROPS;
		}
		else if(broken_block.getType().equals(Material.CARROT) && broken_block.getData().toItemStack().getDurability() == 7)
		{
			crop_type = Material.CARROT;
		}
		else if(broken_block.getType().equals(Material.POTATO) && broken_block.getData().toItemStack().getDurability() == 7)
		{
			crop_type = Material.POTATO;
		}
		else return; //  We only will act on blocks that are crops.
		// player.sendMessage("Crop Selected: " + crop_type.toString());
		
		int span = 0;
		// player.sendMessage("Tool: " + in_hand.getType().toString());
		if(in_hand.getType().equals(Material.IRON_HOE)) span = 1; // Total of 3x3 Area - 9 blocks | 251 possible breaks.
		else if(in_hand.getType().equals(Material.GOLD_HOE)) span = 2; // Total of 5x5 Area - 25 blocks - No extra durability on breaks | 825 total possible breaks.
		else if(in_hand.getType().equals(Material.DIAMOND_HOE)) span = 4; // Total of 9x9 area - 81 blocks | 1562 total possible breaks.
		else return; // Because we don't need to do anything else.
		// player.sendMessage("Span : " + span);
		
		// Start the block breaking:  This will do an area sweep and not a connected branch.  Sycthes don't work the other way.
		Random rand = new Random(); //  for durability.
		int unbreaking = 1;
		if(in_hand.getItemMeta().hasEnchant(Enchantment.DURABILITY))
		{
			unbreaking = 1 + in_hand.getEnchantmentLevel(Enchantment.DURABILITY);
		}
		// If a random number between 1 and 100 is less than 100/unbreaking, then do durability.
		if((rand.nextInt(100) + 1) < (100/unbreaking) && !player.getGameMode().equals(GameMode.CREATIVE))
		{
			in_hand.setDurability((short) (in_hand.getDurability() + 1)); //  durability setting.
			player.updateInventory();
		}
		for(int x = -span; x <= span; x++)
		{
			for(int z = -span; z <= span; z++)
			{
				// player.sendMessage(x + " , " + event.getBlock().getY() + " , " + z);
				BlockState target = event.getBlock().getRelative(x, 0, z).getState();
				// player.sendMessage(target.getLocation().getBlockX() + " , " + target.getLocation().getBlockY() + " , "+ target.getLocation().getBlockZ());
				// player.sendMessage("TarBlockTyp: " + target.getType());
				// player.sendMessage("TarBlockDur: " + target.getData().toItemStack().getDurability());
				if(target.getType().equals(crop_type) && target.getData().toItemStack().getDurability() == 7) // only breaking the blocks of sufficient level.
				{
					// Breaking the block.
					// I don't know if durability starts at 0 or max_durability.  if it is 0, then we'll chance this.
					// player.sendMessage(".getDurability(): " + in_hand.getDurability()); 
					if(in_hand.getDurability() >= 0) // Checking for ample durability.  This deals with durability.
					{
						if(x == 0 && z == 0) continue; // block 0,0 is already broken.
						// Making a new event for the block we are about the break.
						BlockBreakEvent new_event = new BlockBreakEvent(target.getBlock(), event.getPlayer());
						no_do_break.add(new_event); // making sure this doesn't run a second time.
						Bukkit.getServer().getPluginManager().callEvent(new_event);
						no_do_break.remove(new_event); // cleaning up the list.
						if(new_event.isCancelled()) continue; // jump to test the new block.
						
						// Durability per.
						if((rand.nextInt(100) + 1) < (100/unbreaking) && span != 2 && !player.getGameMode().equals(GameMode.CREATIVE))
						{
							in_hand.setDurability((short) (in_hand.getDurability() + 1)); //  durability setting.
							player.updateInventory();
						}
						
						target.getBlock().breakNaturally();
						
						
					}
					else break;
				}
			}
		}
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
					// player.sendMessage(x + " , " + event.getBlock().getY() + " , " + z);
					BlockState target = event.getBlock().getRelative(x, y, z).getState();
					// player.sendMessage(target.getLocation().getBlockX() + " , " + target.getLocation().getBlockY() + " , "+ target.getLocation().getBlockZ());
					// player.sendMessage("TarBlockTyp: " + target.getType());
					// player.sendMessage("TarBlockDur: " + target.getData().toItemStack().getDurability());
					if(target.getType().equals(Material.LEAVES) || target.getType().equals(Material.LEAVES_2)) // only breaking the blocks of sufficient level.
					{
						// Breaking the block.
						// I don't know if durability starts at 0 or max_durability.  if it is 0, then we'll chance this.
						// player.sendMessage(".getDurability(): " + in_hand.getDurability()); 
						if(in_hand.getDurability() >= 0) // Checking for ample durability.  This deals with durability.
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
						else break;
					}
				}
			}
		}
	}
}
