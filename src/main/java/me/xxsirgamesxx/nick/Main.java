package me.xxsirgamesxx.nick;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.entity.Entity;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerTeleportEvent;
import cn.nukkit.level.Level;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import cn.nukkit.level.Location;
import cn.nukkit.command.PluginIdentifiableCommand;
import cn.nukkit.plugin.Plugin;
import java.io.File;

import cn.nukkit.command.Command;


import java.util.Map;


public class Main extends PluginBase implements Listener {

    private static final int configVersion = 3;
    private Config config;
    private static Main instance;

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {

        this.getServer().getPluginManager().registerEvents(this, this);
					
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		 Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("nick")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("Run command as player.");
				return true;
			}	
			if (!(sender.hasPermission("nick.cmd"))){
				sender.sendMessage("§cYou do not have permission to use §6/Nick§c!");
				return true;
			}
			player.setDisplayName("`" + args[0]);
			sender.sendMessage("§7You Set Your Nickname to§6 " + args[0] + "§7!");
			return true;
		} else if (cmd.getName().equalsIgnoreCase("rmnick")){
			if (!(sender instanceof Player)) {
				sender.sendMessage("Run command as player.");
				return true;
			}	
			player.setDisplayName(player.getName());
			return true;
		}
		
		return true;		
    }
}
