package com.pyshnyi.island;

import com.pyshnyi.entities.Entity;
import com.pyshnyi.entities.EntityType;
import com.pyshnyi.entities.Factory;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.ThreadLocalRandom;
@Getter
@Setter
public class IslandMap {
    private final Factory factory;
    private final int height;
    private final int width;
    private final Location[][] location;

    public IslandMap(int height, int width) {
        this.height = height;
        this.width = width;
        this.location = new Location[height][width];
        this.factory = new Factory();
    }
    public void initialize() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                location[y][x] = new Location(x, y);
            }
        }
    }
    public void fulfill(int maxEntityCount) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                for (int i = 0; i <= maxEntityCount; i++) {
                    Entity entity = getRandomEntity();

                    var entityAsString = entity.getClass().getSimpleName();
                    var entityCountOnLocation = location[y][x].getEntitiesCount().getOrDefault(entityAsString, 0);
                    if (entityCountOnLocation >= entity.getMaxCount()) {
                        continue;
                    }
                    location[y][x].addEntity(entity);
                }
            }
        }
    }

    private Entity getRandomEntity() {
        var entityTypes = EntityType.values();
        var entityType = entityTypes[ThreadLocalRandom.current().nextInt(entityTypes.length)];
        return factory.createEntity(entityType);
    }
}
