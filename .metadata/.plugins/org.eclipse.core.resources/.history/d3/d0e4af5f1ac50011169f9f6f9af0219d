package com.github.SaxSalute.HomeManager;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HomeManagerCommandExecutor implements CommandExecutor
{
	private HomeManager plugin;
	
	public HomeManagerCommandExecutor(HomeManager plugin)
	{
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		//plugin.saveload.saveData();
		
		//Stores the sender in the variable player if the sender is not the console
		Player player = null;
		if (sender instanceof Player)
			player = (Player) sender;
		
		/*
		 * The createhome command
		 */
		if (command.getName().equalsIgnoreCase("createhome"))
		{
			//If exactly one argument is supplied
			if (args.length == 1)
			{
				//If the command sender is a player, not the console
				if (player != null)
				{
					//If the player has already selected two locations
					if (plugin.selectedLocations.get(player) != null && plugin.selectedLocations.get(player)[0] != null && plugin.selectedLocations.get(player)[1] != null)
					{
						Region tempRegion = new Region(plugin.selectedLocations.get(player)[0], plugin.selectedLocations.get(player)[1], args[0], player);
						//If the home doesn't overlap another home or there are no other homes
						if (plugin.regions == null)
						{
							plugin.regions = new ArrayList<Region>();
						}
						
						if (plugin.regions.size() == 0 || !(tempRegion.overlap(plugin.regions)))
						{
							plugin.regions.add(tempRegion);
							sender.sendMessage(ChatColor.GREEN + "Region " + args[0] + " has been created successfully!");
							return true;
						}
						//If the home overlaps another home
						else
						{
							sender.sendMessage("Two homes can not overlap.");
							return true;
						}
					}
					//If the player has not selected two locations using the feather
					else
					{
						sender.sendMessage(ChatColor.RED + "You must select two locations using the feather before creating a home.");
						return true;
					}
				}
				//If the command sender is the console
				else
				{
					sender.sendMessage(ChatColor.RED + "Homes can only be created by players in game.");
					return true;
				}
			}
			//If a number of arguments other than 1 is supplied
			else
			{
				sender.sendMessage(ChatColor.RED + "/createhome takes exactly one argument.");
			}
		}
		
		/*
		 * listhomes
		 */
		if (command.getName().equalsIgnoreCase("listhomes"))
		{
			//If there are no homes
			if (plugin.regions == null || plugin.regions.size() == 0)
			{
				sender.sendMessage(ChatColor.YELLOW + "No homes have been created");
				return true;
			}
			
			sender.sendMessage(ChatColor.YELLOW + "Existing Homes: " + plugin.regions.size());

			//If there are homes
			for (Region r : plugin.regions)
			{
				sender.sendMessage(ChatColor.YELLOW + r.getName() + " : owned by " + r.getOwner().getName());
			}
			return true;
		}
		return false;
	}
	
}
