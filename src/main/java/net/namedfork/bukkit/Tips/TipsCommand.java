package net.namedfork.bukkit.Tips;

import net.stealthii.tipsex.TipsEx;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class TipsCommand implements CommandExecutor {
    protected TipsEx plugin;
    
    public TipsCommand(TipsEx plugin) {
        this.plugin = plugin;
    }

   
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if ((sender instanceof ConsoleCommandSender) || (sender instanceof Player && plugin.hasPermission((Player)sender, "tips.reload", sender.isOp()))) {
            if (args.length == 1 && "reload".equalsIgnoreCase(args[0])) {
                // reload
                plugin.loadConfig(sender);
                return true;
            } else return false;
        } else {
            sender.sendMessage(ChatColor.RED + "You don't have permission to use that command");
            return true;
        }
    }
}
