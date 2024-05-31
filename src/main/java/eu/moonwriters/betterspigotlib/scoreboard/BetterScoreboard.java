package eu.moonwriters.betterspigotlib.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Criteria;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

public class BetterScoreboard {
    private Scoreboard scoreboard;
    private String scoreboardId;
    private Objective objective;
    private Map<Integer, Team> lines;

    public BetterScoreboard(Player player, String scoreboardId, String displayName) {
        this.scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        this.scoreboardId = scoreboardId;
        this.objective = getOrCreateObjective(scoreboardId, displayName);
        this.lines = new HashMap<>();
        player.setScoreboard(this.scoreboard);
    }

    public void setLine(int line, String content, boolean updatable) {
        if (updatable) {
            Team team = scoreboard.getTeam(String.valueOf(line));
            if (team == null) {
                team = scoreboard.registerNewTeam(String.valueOf(line));
            }
            team.setPrefix(content);
            team.addEntry(UUID.randomUUID().toString());
            objective.getScore(UUID.randomUUID().toString()).setScore(line);
            lines.put(line, team);
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
    }

    private Objective getOrCreateObjective(String id, String display) {
        AtomicReference<Objective> currentObjective = new AtomicReference<>(scoreboard.getObjective(id));
        if (currentObjective.get() == null) {
            currentObjective.set(scoreboard.registerNewObjective(id, Criteria.DUMMY, display));
        }
        return currentObjective.get();
    }
}
