package me.doodle.messagecolorconverter.listeners;

import me.doodle.messagecolorconverter.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatWithFormat implements Listener {

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        if(Main.formatYAML.getString(event.getPlayer().getUniqueId()+".format") != null) {
            String format = Main.formatYAML.getString(event.getPlayer().getUniqueId()+".format");
            event.setMessage(Main.messageHandler.convertMessage(format + event.getMessage()));
        }

    }

}
