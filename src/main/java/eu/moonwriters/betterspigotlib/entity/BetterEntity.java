package eu.moonwriters.betterspigotlib.entity;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public class BetterEntity {
    private final Entity entity;

    public BetterEntity(Location location, EntityType type) {
        this.entity = location.getWorld().spawnEntity(location, type);
    }

    public BetterEntity displayName(String displayName) {
        entity.setCustomName(displayName);
        entity.setCustomNameVisible(true);
        return this;
    }

    public BetterEntity addPassenger(Entity passenger) {
        entity.addPassenger(passenger);
        return this;
    }

    public BetterEntity removePassenger(Entity passenger) {
        entity.removePassenger(passenger);
        return this;
    }

    public void remove() {
        entity.remove();
    }

    public Entity getEntity() {
        return entity;
    }
}
