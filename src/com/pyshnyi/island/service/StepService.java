package com.pyshnyi.island.service;

import com.pyshnyi.entities.animals.Animal;
import com.pyshnyi.island.IslandMap;
import com.pyshnyi.island.Location;

public class StepService implements Steps {
    public Location stepUp(Animal animal, Location location, IslandMap map) {
        return location.getY() > 0 ?
                updateLocation(map, location.getY() - 1, location.getX(), animal, location)
                : location;
    }

    public Location stepLeft(Animal animal, Location location, IslandMap map) {
        return location.getX() > 0 ?
                updateLocation(map, location.getY(), location.getX() - 1, animal, location)
                : location;
    }

    public Location stepRight(Animal animal, Location location, IslandMap map) {
        return location.getX() < map.getWidth() - 1 ?
                updateLocation(map, location.getY(), location.getX() + 1, animal, location)
                : location;
    }

    public Location stepDown(Animal animal, Location location, IslandMap map) {
        return location.getY() < map.getHeight() - 1 ?
                updateLocation(map, location.getY() + 1, location.getX(), animal, location)
                : location;
    }

    private Location updateLocation(IslandMap map, int x, int y, Animal animal, Location location) {
        Location newLocation = map.getLocation()[x][y];
        if (canStep(animal, newLocation)) {
            return location;
        }
        newLocation.addEntity(animal);
        location.removeEntity(animal);
        return newLocation;
    }

    private boolean canStep(Animal animal, Location location) {
        String animalAsString = animal.getClass().getSimpleName();
        Integer entityCount = location.getEntitiesCount().get(animalAsString);
        return entityCount != null && entityCount >= animal.getMaxCount();
    }
}
