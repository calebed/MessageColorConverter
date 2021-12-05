package me.doodle.messagecolorconverter;

import org.bukkit.ChatColor;

import java.util.List;

public class MessageHandler {

    public MessageHandler() {
    }

    /**
     * @param colorCode
     * @return a ChatColor to use in the message
     */
    public ChatColor translateColorCode(String colorCode) {
        switch(colorCode) {
            case "0":
                return ChatColor.BLACK;
            case "1":
                return ChatColor.DARK_BLUE;
            case "2":
                return ChatColor.DARK_GREEN;
            case "3":
                return ChatColor.DARK_AQUA;
            case "4":
                return ChatColor.DARK_RED;
            case "5":
                return ChatColor.DARK_BLUE;
            case "6":
                return ChatColor.GOLD;
            case "7":
                return ChatColor.GRAY;
            case "8":
                return ChatColor.DARK_GRAY;
            case "9":
                return ChatColor.BLUE;
            case "a":
                return ChatColor.GREEN;
            case "b":
                return ChatColor.AQUA;
            case "c":
                return ChatColor.RED;
            case "d":
                return ChatColor.LIGHT_PURPLE;
            case "e":
                return ChatColor.YELLOW;
            case "f":
                return ChatColor.WHITE;
            case "k":
                return ChatColor.MAGIC;
            case "l":
                return ChatColor.BOLD;
            case "m":
                return ChatColor.STRIKETHROUGH;
            case "o":
                return ChatColor.ITALIC;
            case "n":
                return ChatColor.UNDERLINE;
            default:
                break;
        }

        return null;
    }

    public boolean isDigit(String c) {
        String digits[] = {"1","2","3","4","5","6","7","8","9","0"};

        for(String s : digits) {
            if(s.equals(c)) {
                return true;
            }
        }
        return false;
    }

    public boolean isColorCode(String c) {
        String codes[] = {"a", "b", "c", "d", "e", "f", "k", "l", "m", "n", "o", "r"};

        for(int i = 0; i < codes.length; i++) {
            if(codes[i].equals(c))
                return true;
        }
        return false;
    }

    /**
     * Method that takes the message and adds the appropriate color codes to it.
     * @return
     */
    public String convertMessage(String message) {
        String retMessage = "";
        String chars[] = message.split("");
        ChatColor color = ChatColor.WHITE;
        for(int i = 1; i < chars.length; i++) {
            if(chars[i-1].equals("&")) {
                if(isDigit(chars[i]) || isColorCode(chars[i])) {
                    color = translateColorCode(chars[i]);
                    retMessage += color;
                } else {
                    retMessage += chars[i];
                }
            } else if(chars[i].equals("&")) {
                if(isDigit(chars[i+1]) || isColorCode(chars[i+1])) {
                    continue;
                }
            } else {
                retMessage += chars[i];
            }
        }
        return retMessage;
    }
}
