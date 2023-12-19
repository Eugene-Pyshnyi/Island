package com.pyshnyi.island.service;

import com.pyshnyi.entities.animals.Animal;
import com.pyshnyi.entities.plants.Plant;
import com.pyshnyi.island.IslandMap;
import com.pyshnyi.island.Location;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StatisticsPrinter {
    public void printAnimalStatistics(IslandMap islandMap) {
        System.out.println("Статистика при текущей итерации:");
        Map<String, Integer> animalCount = countAnimals(islandMap);
        for (Map.Entry<String, Integer> entry : animalCount.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    public void printPlantStatistics(IslandMap islandMap) {
        System.out.println("Plant Statistics:");
        Map<String, Integer> plantCount = countPlants(islandMap);
        for (Map.Entry<String, Integer> entry : plantCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private Map<String, Integer> countAnimals(IslandMap islandMap) {
        Map<String, Integer> animalCount = new HashMap<>();
        for (int y = 0; y < islandMap.getHeight(); y++) {
            for (int x = 0; x < islandMap.getWidth(); x++) {
                Location location = islandMap.getLocation()[y][x];
                List<Animal> animals = location.getEntities().stream()
                        .filter(entity -> entity instanceof Animal)
                        .map(entity -> (Animal) entity)
                        .collect(Collectors.toList());

                for (Animal animal : animals) {
                    String animalType = animal.getClass().getSimpleName();
                    animalCount.put(animalType, animalCount.getOrDefault(animalType, 0) + 1);
                }
            }
        }
        return animalCount;
    }

    private Map<String, Integer> countPlants(IslandMap islandMap) {
        Map<String, Integer> plantCount = new HashMap<>();
        for (int y = 0; y < islandMap.getHeight(); y++) {
            for (int x = 0; x < islandMap.getWidth(); x++) {
                Location location = islandMap.getLocation()[y][x];
                int plantsOnLocation = location.getPlants().size();
                plantCount.put("Total Plants", plantCount.getOrDefault("Total Plants", 0) + plantsOnLocation);

                List<Plant> plants = location.getPlants();
                for (Plant plant : plants) {
                    String plantType = plant.getClass().getSimpleName();
                    plantCount.put(plantType, plantCount.getOrDefault(plantType, 0) + 1);
                }
            }
        }
        return plantCount;
    }
}