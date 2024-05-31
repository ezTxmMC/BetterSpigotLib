package eu.moonwriters.betterspigotlib.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class BetterScoreboard {
    private Scoreboard scoreboard;
    private String scoreboardId;
    private Objective objective;
    private Map<Integer, Team> lines;
    private List<Team> teams;

    public BetterScoreboard(Player player, String scoreboardId, String displayName) {
        this.scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        this.scoreboardId = scoreboardId;
        this.objective = getOrCreateObjective(scoreboardId, displayName);
        this.lines = new HashMap<>();
        this.teams = new ArrayList<>();
        this.objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        player.setScoreboard(this.scoreboard);
    }

    public void setLine(int line, String content, boolean updatable) {
        if (updatable) {
            ColorPicker picker = new ColorPicker(teams.size());
            Team team = scoreboard.getTeam(String.valueOf(line));
            if (team == null) {
                team = scoreboard.registerNewTeam(String.valueOf(line));
            }
            team.setPrefix(content);
            team.addEntry(picker.chooseColor().toString());
            objective.getScore(UUID.randomUUID().toString()).setScore(line);
            lines.put(line, team);
            teams.add(team);
            return;
        }
        objective.getScore(content).setScore(line);
    }

    public void updateLine(int line, String newContent) {
        if (!lines.containsKey(line)) {
            return;
        }
        lines.get(line).setPrefix(newContent);
    }

    public void remove() {
        objective.unregister();
        objective = null;
        scoreboard = null;
        scoreboardId = null;
        lines = null;
        teams = null;
    }

    private Objective getOrCreateObjective(String id, String display) {
        AtomicReference<Objective> currentObjective = new AtomicReference<>(scoreboard.getObjective(id));
        if (currentObjective.get() == null) {
            currentObjective.set(scoreboard.registerNewObjective(id, Criteria.DUMMY, display));
        }
        return currentObjective.get();
    }
}
