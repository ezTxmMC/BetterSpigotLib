package eu.moonwriters.betterspigotlib.scoreboard;

import eu.moonwriters.betterspigotlib.text.ColorString;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class BetterTeam {
    private Scoreboard scoreboard;
    private Team team;

    public BetterTeam(Player player) {
        this.scoreboard = player.getScoreboard();
    }

    public BetterTeam displayName(String displayName) {
        team.setDisplayName(new ColorString(displayName).bukkitColor());
        return this;
    }

    public BetterTeam prefix(String prefix) {
        team.setPrefix(new ColorString(prefix).bukkitColor());
        return this;
    }

    public BetterTeam suffix(String suffix) {
        team.setPrefix(new ColorString(suffix).bukkitColor());
        return this;
    }

    public BetterTeam color(ChatColor color) {
        team.setColor(color);
        return this;
    }

    public BetterTeam friendlyFire(boolean friendlyFire) {
        team.setAllowFriendlyFire(friendlyFire);
        return this;
    }

    public BetterTeam seeFriendlyInvisibles(boolean seeFriendlyInvisibles) {
        team.setCanSeeFriendlyInvisibles(seeFriendlyInvisibles);
        return this;
    }

    public BetterTeam option(Team.Option option, Team.OptionStatus optionStatus) {
        team.setOption(option, optionStatus);
        return this;
    }

    public void remove() {
        team.unregister();
        team = null;
        scoreboard = null;
    }
}
