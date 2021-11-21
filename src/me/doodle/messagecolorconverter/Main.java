package me.doodle.messagecolorconverter;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static MessageHandler messageHandler;
    public void onEnable() {
        System.out.println("MessageColorConverter has been loaded..");
        messageHandler = new MessageHandler();
    }

    public void onDisable() {

    }

}
