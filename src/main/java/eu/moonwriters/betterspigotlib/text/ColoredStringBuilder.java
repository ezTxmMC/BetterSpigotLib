package eu.moonwriters.betterspigotlib.text;

import org.bukkit.ChatColor;

public class ColoredStringBuilder {
    private String string;

    public ColoredStringBuilder() {
        this.string = "";
    }

    public ColoredStringBuilder(String string) {
        this.string = string;
    }

    public ColoredStringBuilder append(String string) {
        this.string = this.string + string;
        return this;
    }

    public ColoredStringBuilder nextLine() {
        append("\n");
        return this;
    }

    public String bukkitColor() {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public String javaColor() {
        return JavaColor.apply(string);
    }

    public String hexColor(String hex) {
        return JavaColor.colored(hex, string);
    }
}
