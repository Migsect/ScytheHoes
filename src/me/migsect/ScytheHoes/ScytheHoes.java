package me.migsect.ScytheHoes;

import java.util.logging.Logger;

import me.migsect.ScytheHoes.Events.EventsListener;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class ScytheHoes extends JavaPlugin
{
	Logger logger = Logger.getLogger("Minecraft");
	
	
	@Override
	public void onEnable()
	{
		// Logging
		PluginDescriptionFile pdf = this.getDescription();
		this.logger.info(pdf.getName() + " Version " + pdf.getVersion() + " has been enabled.");
		
		// Listeners
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new EventsListener(), this);
	}
	@Override
	public void onDisable()
	{

		// Logging
		PluginDescriptionFile pdf = this.getDescription();
		this.logger.info(pdf.getName() + " has been disabled.");
	}
}
