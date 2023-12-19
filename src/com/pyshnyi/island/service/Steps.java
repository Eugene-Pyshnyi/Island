package com.pyshnyi.island.service;

import com.pyshnyi.entities.animals.Animal;
import com.pyshnyi.island.IslandMap;
import com.pyshnyi.island.Location;

public interface Steps {
    Location stepUp(Animal animal, Location location, IslandMap map);
    Location stepLeft(Animal animal, Location location, IslandMap map);
    Location stepRight(Animal animal, Location location, IslandMap map);
    Location stepDown(Animal animal, Location location, IslandMap map);
}
