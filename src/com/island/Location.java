package com.island;

import com.entities.Entity;
import com.entities.animals.Animal;
import com.entities.plants.Plant;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Getter
public class Location {
    private int x;
    private int y;
    private List<Entity> entities;
    private Map<String, Integer> entitiesCount;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
        this.entities = new ArrayList<>();
        this.entitiesCount = new HashMap<>();
    }
    public void addEntity(Entity entity) {
        entities.add(entity);
        addToStatistic(entity);
    }
    public void removeEntity(Entity entity) {
        entities.remove(entity);
        removeFromStatistic(entity);
    }
    public List<Animal> getAnimals() {
        return entities.stream()
                .filter(entity -> entity instanceof Animal)
                .map(entity -> (Animal) entity)
                .toList();
    }
    public List<Plant> getPlants() {
        return entities.stream()
                .filter(entity -> entity instanceof Plant)
                .map(entity -> (Plant) entity)
                .toList();
    }
    private void addToStatistic(Entity entity) {
        var entityAsString = getEntityName(entity);
        entitiesCount.merge(entityAsString, 1, (oldValue, newValue) -> oldValue + 1);
    }
    private void removeFromStatistic(Entity entity) {
        var entityAsString = getEntityName(entity);
        entitiesCount.merge(entityAsString, 1, (oldValue, newValue) -> {
            int newCount = oldValue - 1;
            if (newCount <= 0) {
                return null;
            }
            return newCount;
        });
    }
    private String getEntityName(Entity entity) {
        return entity.getClass().getSimpleName();
    }
}
