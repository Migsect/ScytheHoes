package me.migsect.ScytheHoes;

import org.bukkit.Material;

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
	
	
}
