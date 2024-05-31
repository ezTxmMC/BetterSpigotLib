package eu.moonwriters.betterspigotlib.scoreboard;

import org.bukkit.ChatColor;

public class ColorByIdForColorString {
    private final int slot;

    public ColorByIdForColorString(int slot) {
        this.slot = slot;
    }

    public ChatColor chooseColor() {
        return switch (slot) {
            case 0 -> ChatColor.DARK_RED;
            case 1 -> ChatColor.RED;
            case 2 -> ChatColor.GOLD;
            case 3 -> ChatColor.YELLOW;
            case 4 -> ChatColor.GREEN;
            case 5 -> ChatColor.DARK_GREEN;
            case 6 -> ChatColor.AQUA;
            case 7 -> ChatColor.DARK_AQUA;
            case 8 -> ChatColor.BLUE;
            case 9 -> ChatColor.DARK_BLUE;
            case 10 -> ChatColor.LIGHT_PURPLE;
            case 11 -> ChatColor.DARK_PURPLE;
            case 13 -> ChatColor.WHITE;
            case 14 -> ChatColor.GRAY;
            case 15 -> ChatColor.DARK_GRAY;
            case 16 -> ChatColor.BLACK;
            case 17 -> ChatColor.UNDERLINE;
            case 18 -> ChatColor.STRIKETHROUGH;
            case 19 -> ChatColor.BOLD;
            case 20 -> ChatColor.ITALIC;
            case 21 -> ChatColor.MAGIC;
            default -> ChatColor.RESET;
        };
    }
}
