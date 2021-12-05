package me.doodle.messagecolorconverter;

import me.doodle.messagecolorconverter.commands.FormatCommand;
import me.doodle.messagecolorconverter.listeners.ChatWithFormat;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.yaml.snakeyaml.Yaml;

import java.io.File;

public class Main extends JavaPlugin {

    public static MessageHandler messageHandler;
    public static File formatFile;
    public static FileConfiguration formatYAML;
    public void onEnable() {
        System.out.println("MessageColorConverter has been loaded..");
        messageHandler = new MessageHandler();

        loadFormatFile();
        registerCommands();
        registerListeners();
    }

    public void onDisable() {

    }

    public void loadFormatFile() {
        if(!this.getDataFolder().exists())
            this.getDataFolder().mkdir();

        formatFile = new File(this.getDataFolder() + "/formats.yml");
        if(!formatFile.exists())
            try {formatFile.createNewFile();} catch(Exception e) {e.printStackTrace();}

        formatYAML = YamlConfiguration.loadConfiguration(formatFile);
    }

    public static void saveFormat(String path, String format) {
        formatYAML.set(path, format);
        try {formatYAML.save(formatFile);} catch(Exception e){e.printStackTrace();}
    }

    public void registerCommands() {
        this.getCommand("format").setExecutor(new FormatCommand());
    }

    public void registerListeners() {
        Bukkit.getPluginManager().registerEvents(new ChatWithFormat(), this);
    }

}
