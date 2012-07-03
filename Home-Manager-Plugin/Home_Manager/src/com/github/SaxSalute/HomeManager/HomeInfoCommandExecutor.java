package com.github.SaxSalute.HomeManager;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class HomeInfoCommandExecutor implements CommandExecutor
{
	private HomeManager plugin;
	
	public HomeInfoCommandExecutor(HomeManager plugin)
	{
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		/*
		 * homeinfo
		 */
		if (command.getName().equalsIgnoreCase("homeinfo"))
		{
			//If there are no homes
			if (plugin.regions == null || plugin.regions.size() == 0)
			{
				sender.sendMessage(ChatColor.YELLOW + "No homes have been created");
				return true;
			}
			
			//If either one or zero arguments have been supplied
			if (args.length <= 1)
			{
				//If no argument has been supplied or the argument supplied was "all"
				if (args.length == 0 || args[0].equalsIgnoreCase("all"))
				{
					sender.sendMessage(ChatColor.YELLOW + "Existing Homes: " + plugin.regions.size());
		
					//If there are homes
					for (Region r : plugin.regions)
					{
						sender.sendMessage(ChatColor.YELLOW + r.getName() + " : owned by " + r.getOwner().getName());
					}
					return true;
				}
			}
			
			else
			{
				sender.sendMessage(ChatColor.RED + "/homeinfo takes one of the following modifiers:\nall - List all existing homes");
			}
		}
		return false;
	}
	
}
