package me.migsect.ScytheHoes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.inventory.ItemStack;

// For helping
public class Helper
{
	
	public static boolean isHoe(Material mat)
	{
		if(mat.equals(Material.WOOD_HOE)) return true;
		if(mat.equals(Material.STONE_HOE)) return true;
		if(mat.equals(Material.IRON_HOE)) return true;
		if(mat.equals(Material.GOLD_HOE)) return true;
		if(mat.equals(Material.DIAMOND_HOE)) return true;
		return false;
	}
	public static boolean isSword(Material mat)
	{
		if(mat.equals(Material.WOOD_SWORD)) return true;
		if(mat.equals(Material.STONE_SWORD)) return true;
		if(mat.equals(Material.IRON_SWORD)) return true;
		if(mat.equals(Material.GOLD_SWORD)) return true;
		if(mat.equals(Material.DIAMOND_SWORD)) return true;
		return false;
	}
	public static Material getRawMaterial(Material tool)
	{
		if(tool.equals(Material.WOOD_HOE)) return Material.WOOD;
		if(tool.equals(Material.WOOD_SWORD)) return Material.WOOD;
		if(tool.equals(Material.WOOD_PICKAXE)) return Material.WOOD;
		if(tool.equals(Material.WOOD_AXE)) return Material.WOOD;
		if(tool.equals(Material.WOOD_SPADE)) return Material.WOOD;
		
		if(tool.equals(Material.STONE_HOE)) return Material.COBBLESTONE;
		if(tool.equals(Material.STONE_SWORD)) return Material.COBBLESTONE;
		if(tool.equals(Material.STONE_PICKAXE)) return Material.COBBLESTONE;
		if(tool.equals(Material.STONE_AXE)) return Material.COBBLESTONE;
		if(tool.equals(Material.STONE_SPADE)) return Material.COBBLESTONE;
		
		if(tool.equals(Material.IRON_HOE)) return Material.IRON_INGOT;
		if(tool.equals(Material.IRON_SWORD)) return Material.IRON_INGOT;
		if(tool.equals(Material.IRON_PICKAXE)) return Material.IRON_INGOT;
		if(tool.equals(Material.IRON_AXE)) return Material.IRON_INGOT;
		if(tool.equals(Material.IRON_SPADE)) return Material.IRON_INGOT;
		
		if(tool.equals(Material.GOLD_HOE)) return Material.GOLD_INGOT;
		if(tool.equals(Material.GOLD_SWORD)) return Material.GOLD_INGOT;
		if(tool.equals(Material.GOLD_PICKAXE)) return Material.GOLD_INGOT;
		if(tool.equals(Material.GOLD_AXE)) return Material.GOLD_INGOT;
		if(tool.equals(Material.GOLD_SPADE)) return Material.GOLD_INGOT;
		
		if(tool.equals(Material.DIAMOND_HOE)) return Material.DIAMOND;
		if(tool.equals(Material.DIAMOND_SWORD)) return Material.DIAMOND;
		if(tool.equals(Material.DIAMOND_PICKAXE)) return Material.DIAMOND;
		if(tool.equals(Material.DIAMOND_AXE)) return Material.DIAMOND;
		if(tool.equals(Material.DIAMOND_SPADE)) return Material.DIAMOND;
		
		return null;
	}
	public static short getMaturityAge(Material mat)
	{
		if(mat.equals(Material.CARROT)) return 7; 			// 0-7
		if(mat.equals(Material.POTATO)) return 7; 			// 0-7
		if(mat.equals(Material.CROPS)) return 7; 				// 0-7
		if(mat.equals(Material.NETHER_WARTS)) return 3; // 0-3
		return 0;
	}
	public static boolean hasDurability(Material mat)
	{
		if(mat.equals(Material.BOW)) return true;
		if(mat.equals(Material.FLINT_AND_STEEL)) return true;
		if(mat.equals(Material.SHEARS)) return true;
		if(mat.equals(Material.CARROT_STICK)) return true;
		
		if(mat.equals(Material.WOOD_AXE)) return true;
		if(mat.equals(Material.WOOD_SWORD)) return true;
		if(mat.equals(Material.WOOD_SPADE)) return true;
		if(mat.equals(Material.WOOD_PICKAXE)) return true;
		if(mat.equals(Material.WOOD_HOE)) return true;
		
		if(mat.equals(Material.STONE_AXE)) return true;
		if(mat.equals(Material.STONE_SWORD)) return true;
		if(mat.equals(Material.STONE_SPADE)) return true;
		if(mat.equals(Material.STONE_PICKAXE)) return true;
		if(mat.equals(Material.STONE_HOE)) return true;
		
		if(mat.equals(Material.IRON_AXE)) return true;
		if(mat.equals(Material.IRON_SWORD)) return true;
		if(mat.equals(Material.IRON_SPADE)) return true;
		if(mat.equals(Material.IRON_PICKAXE)) return true;
		if(mat.equals(Material.IRON_HOE)) return true;
		
		if(mat.equals(Material.GOLD_AXE)) return true;
		if(mat.equals(Material.GOLD_SWORD)) return true;
		if(mat.equals(Material.GOLD_SPADE)) return true;
		if(mat.equals(Material.GOLD_PICKAXE)) return true;
		if(mat.equals(Material.GOLD_HOE)) return true;
		
		if(mat.equals(Material.DIAMOND_AXE)) return true;
		if(mat.equals(Material.DIAMOND_SWORD)) return true;
		if(mat.equals(Material.DIAMOND_SPADE)) return true;
		if(mat.equals(Material.DIAMOND_PICKAXE)) return true;
		if(mat.equals(Material.DIAMOND_HOE)) return true;
		return false;
	}
	public static boolean hasDurability(ItemStack item)
	{
		return hasDurability(item.getType());
	}
	public static boolean isTool(Material mat)
	{
		if(mat.equals(Material.FLINT_AND_STEEL)) return true;
		if(mat.equals(Material.SHEARS)) return true;
		if(mat.equals(Material.CARROT_STICK)) return true;
		
		if(mat.equals(Material.WOOD_AXE)) return true;
		if(mat.equals(Material.WOOD_SPADE)) return true;
		if(mat.equals(Material.WOOD_PICKAXE)) return true;
		if(mat.equals(Material.WOOD_HOE)) return true;
		
		if(mat.equals(Material.STONE_AXE)) return true;
		if(mat.equals(Material.STONE_SPADE)) return true;
		if(mat.equals(Material.STONE_PICKAXE)) return true;
		if(mat.equals(Material.STONE_HOE)) return true;
		
		if(mat.equals(Material.IRON_AXE)) return true;
		if(mat.equals(Material.IRON_SPADE)) return true;
		if(mat.equals(Material.IRON_PICKAXE)) return true;
		if(mat.equals(Material.IRON_HOE)) return true;
		
		if(mat.equals(Material.GOLD_AXE)) return true;
		if(mat.equals(Material.GOLD_SPADE)) return true;
		if(mat.equals(Material.GOLD_PICKAXE)) return true;
		if(mat.equals(Material.GOLD_HOE)) return true;
		
		if(mat.equals(Material.DIAMOND_AXE)) return true;
		if(mat.equals(Material.DIAMOND_SPADE)) return true;
		if(mat.equals(Material.DIAMOND_PICKAXE)) return true;
		if(mat.equals(Material.DIAMOND_HOE)) return true;
		
		return false;
	}
	public static boolean isTool(ItemStack item)
	{
		return isTool(item.getType());
	}
	public static boolean isWeapon(Material mat)
	{
		if(mat.equals(Material.WOOD_SWORD)) return true;
		if(mat.equals(Material.STONE_SWORD)) return true;
		if(mat.equals(Material.IRON_SWORD)) return true;
		if(mat.equals(Material.GOLD_SWORD)) return true;
		if(mat.equals(Material.DIAMOND_SWORD)) return true;
		
		if(mat.equals(Material.BOW)) return true;
		
		return false;
	}
	public static boolean isWeapon(ItemStack item)
	{
		return isWeapon(item.getType());
	}
	
	// returns a list of all Materials that can be derived from the string list.  Will return
	//   an empty list if there are no tools.
	public static List<Material> stringToMaterial(List<String> list)
	{
		List<Material> new_list = new ArrayList<Material>();
		for(int i = 0; i < list.size(); i++)
		{
			Material added_mat = Material.getMaterial(list.get(i));
			if(added_mat != null) new_list.add(added_mat);
		}
		return new_list;
	}
	
	// probability roll depicts the chance of success as p;
	//   as such we will compare this p to a random double uniformily distribute from 0-1;
	//   if that random number x is less than our p, then we succeed.
	// returns true if the roll was a sucess;
	public static boolean probRoll(double p)
	{
		if(p < 0)
		{
			p = -p;
		}
		while(p > 1)
		{
			p = p/10;
		}
		Random rand = new Random();
		if(rand.nextDouble() < p) return true;
		return false;
	}
	
	// simulateBlockBreak will attempt to simulate the block break (of course) as if it was broken by the tool given.
	public static boolean simulateBlockBreak(Block block, Player player, List<Event> event_tracker, double damage_prob)
	{
		ItemStack tool = player.getItemInHand();
		BlockBreakEvent new_event = new BlockBreakEvent(block, player);

		if(tool.getType().equals(Material.AIR)) return false;
		if(damage_prob >= 0) simulateItemDamage(player, tool, damage_prob);
		
		event_tracker.add(new_event); // making sure this doesn't run a second time.
		Bukkit.getServer().getPluginManager().callEvent(new_event);
		event_tracker.remove(new_event); // cleaning up the list.
		
		if(new_event.isCancelled()) return false; // jump to test the new block.
		block.breakNaturally(tool);
		return true;
	}
	// this one doesn't do the event_tracker
	public static boolean simulateBlockBreak(Block block, Player player)
	{
		ItemStack tool = player.getItemInHand();
		BlockBreakEvent new_event = new BlockBreakEvent(block, player);
		
		Bukkit.getServer().getPluginManager().callEvent(new_event);
		
		if(new_event.isCancelled()) return false; // jump to test the new block.
		block.breakNaturally(tool);
		simulateItemDamage(player, tool, 1);
		return true;
	}
	
	// sumulateDamage will attempt to sumulate the tool getting damaged.  It will break the tool if the tool has 0 durability and will then return false;
	//   probability is multiplicative with unbreaking.
	//   ONLY SIMULATES DAMAGE FOR TOOLS NOT FOR ARMOR.
	public static boolean simulateItemDamage(Player player, ItemStack item, double probability, boolean ignore_ench)
	{
		double break_prob = 1;
		if(item.getItemMeta().hasEnchant(Enchantment.DURABILITY) && !ignore_ench) break_prob = 1 / (1 + item.getItemMeta().getEnchantLevel(Enchantment.DURABILITY));
		break_prob *= probability;
		if(probRoll(break_prob))
		{
			if(!testBreak(player, item)) item.setDurability((short) (item.getDurability() - 1));;
		}
		return true;
	}
	public static boolean simulateItemDamage(Player player, ItemStack item, double probability)
	{
		return simulateItemDamage(player, item, probability, false);
	}
	public static boolean simulateItemDamage(Player player, ItemStack item)
	{
		return simulateItemDamage(player, item, 1);
	}
	
	// will break the tool if it is at durability 0;
	//   returns true if the tool is broken.
	private static boolean testBreak(Player player, ItemStack item)
	{
		if(item.getDurability() <= item.getType().getMaxDurability()) return false;
		item.setAmount(0);
		PlayerItemBreakEvent event = new PlayerItemBreakEvent(player, item);
		Bukkit.getServer().getPluginManager().callEvent(event);
		item.setDurability((short) 0);
		item.setType(Material.AIR);
		return true;
	}
	
	
	
	
	
	
	
}
