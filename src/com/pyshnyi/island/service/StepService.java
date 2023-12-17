package com.pyshnyi.island.service;

import com.pyshnyi.entities.animals.Animal;
import com.pyshnyi.island.IslandMap;
import com.pyshnyi.island.Location;

public class StepService {
    public Location stepUp(Animal animal, Location location, IslandMap map) {
        if (location.getY() < map.getHeight() - 1) {
            Location newLocation = map.getLocation()[location.getY()-1][location.getX()];
            if (canStep(animal, newLocation)) {
                return location;
            }
            newLocation.addEntity(animal);
            location.removeEntity(animal);
            return newLocation;
        }
        return location;
    }
    public Location stepLeft(Animal animal, Location location, IslandMap map) {
        if (location.getX() < map.getHeight() - 1) {
            Location newLocation = map.getLocation()[location.getY()][location.getX()-1];
            if (canStep(animal, newLocation)) {
                return location;
            }
            newLocation.addEntity(animal);
            location.removeEntity(animal);
            return newLocation;
        }
        return location;
    }
    public Location stepRight(Animal animal, Location location, IslandMap map) {
        if (location.getX() < map.getHeight() - 1) {
            Location newLocation = map.getLocation()[location.getY()][location.getX()+1];
            if (canStep(animal, newLocation)) {
                return location;
            }
            newLocation.addEntity(animal);
            location.removeEntity(animal);
            return newLocation;
        }
        return location;
    }
    public Location stepDown(Animal animal, Location location, IslandMap map) {
        if (location.getY() < map.getHeight() - 1) {
            Location newLocation = map.getLocation()[location.getY()+1][location.getX()];
            if (canStep(animal, newLocation)) {
                return location;
            }
            newLocation.addEntity(animal);
            location.removeEntity(animal);
            return newLocation;
        }
        return location;
    }
    private boolean canStep(Animal animal, Location location) {
        String animalAsString = animal.getClass().getSimpleName();
        return location.getEntitiesCount().get(animalAsString) >= animal.getMaxCount();
    }
}
