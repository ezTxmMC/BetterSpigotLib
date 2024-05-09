package eu.moonwriters.betterspigotlib.scoreboard;

import org.bukkit.scoreboard.Criteria;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

public class BetterScoreboard {
    private final Scoreboard scoreboard;
    private final Objective objective;
    private final Map<Integer, Team> lines;

    public BetterScoreboard(Scoreboard scoreboard, String scoreboardId, String displayName) {
        this.scoreboard = scoreboard;
        this.objective = getOrCreateObjective(scoreboardId, displayName);
        this.lines = new HashMap<>();
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

    private Objective getOrCreateObjective(String id, String display) {
        AtomicReference<Objective> currentObjective = new AtomicReference<>(scoreboard.getObjective(id));
        if (currentObjective.get() == null) {
            currentObjective.set(scoreboard.registerNewObjective(id, Criteria.DUMMY, display));
        }
        return currentObjective.get();
    }
}
