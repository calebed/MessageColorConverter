package me.doodle.messagecolorconverter.commands;

import me.doodle.messagecolorconverter.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FormatCommand implements CommandExecutor {



    public FormatCommand() {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(label.equalsIgnoreCase("format")) {
                if(args.length > 0) {
                    String codeWithSymbol = args[0];
                    String[] splitted = codeWithSymbol.split("&");
                    String format = "";
                    for(String s : splitted) {
                        ChatColor color = Main.messageHandler.translateColorCode(s);
                        if(color != null) {
                            if(p.hasPermission("messagecolorconverter.format."+"&"+s) || p.isOp()) {
                                format += "&" + s;
                            } else {
                                p.sendMessage(ChatColor.GRAY + "You do not have permission for that format!");
                                return true;
                            }
                        }
                    }
                    p.sendMessage(Main.messageHandler.convertMessage(format + "This is now your chat format! You can change with /format"));
                    Main.saveFormat(p.getUniqueId()+".format", format);
                } else {
                    p.sendMessage(ChatColor.GRAY + "Enter the format you would like to use!");
                }
            }
        } else {
            System.out.println("You must be a player to do that!");
            return false;
        }

        return true;
    }
}
