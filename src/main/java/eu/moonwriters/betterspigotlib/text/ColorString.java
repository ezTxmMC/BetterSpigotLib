package eu.moonwriters.betterspigotlib.text;

import org.bukkit.ChatColor;
import org.bukkit.Color;

public class ColorString {
    private String string;

    public ColorString() {
        this.string = "";
    }

    public ColorString(String string) {
        this.string = string;
    }

    public ColorString append(String string) {
        this.string = this.string + string;
        return this;
    }

    public ColorString nextLine() {
        append("\n");
        return this;
    }

    public String bukkitColor() {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public String hexColor(String hex) {
        int parsedHex = Integer.parseInt(hex.replace("#", "0x"));
        int r = (parsedHex & 0xFF0000) >> 16;
        int g = (parsedHex & 0xFF00) >> 8;
        int b = (parsedHex & 0xFF);
        return Color.fromRGB(r, g, b) + string;
    }
}
