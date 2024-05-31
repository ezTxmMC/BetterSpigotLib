package eu.moonwriters.betterspigotlib.scheduler;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

public class BetterScheduler {
    private final Plugin plugin;
    private BukkitTask bukkitTask;

    public BetterScheduler(Plugin plugin) {
        this.plugin = plugin;
    }

    public BukkitTask timer(Runnable runnable, int delay, int period) {
        bukkitTask = Bukkit.getScheduler().runTaskTimer(plugin, runnable, delay, period);
        return bukkitTask;
    }

    public BukkitTask timerAsync(Runnable runnable, int delay, int period) {
        bukkitTask = Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, runnable, delay, period);
        return bukkitTask;
    }

    public BukkitTask later(Runnable runnable, int delay) {
        bukkitTask = Bukkit.getScheduler().runTaskLater(plugin, runnable, delay);
        return bukkitTask;
    }

    public BukkitTask laterAsync(Runnable runnable, int delay) {
        bukkitTask = Bukkit.getScheduler().runTaskLaterAsynchronously(plugin, runnable, delay);
        return bukkitTask;
    }

    public void cancel() {
        bukkitTask.cancel();
    }
}
