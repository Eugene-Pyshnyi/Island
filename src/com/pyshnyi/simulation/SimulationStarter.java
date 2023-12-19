package com.pyshnyi.simulation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.pyshnyi.entities.Entity;
import com.pyshnyi.entities.animals.Action;
import com.pyshnyi.entities.animals.Animal;
import com.pyshnyi.entities.animals.Direction;
import com.pyshnyi.island.IslandControl;
import com.pyshnyi.island.IslandMap;
import com.pyshnyi.dialog.UserDialog;
import com.pyshnyi.island.Location;
import com.pyshnyi.island.service.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class SimulationStarter {
    private IslandMap islandMap;
    private EatingMap eatingMap;
    private final int MAX_EATABLE_INDEX = 100;
    private final Steps service;
    private final SimulationSettings settings;
    private final UserDialog userDialog;
    private final IslandControl controller;
    private final StatisticsPrinter statisticsPrinter;

    public SimulationStarter() {
        this.service = new StepService();
        this.settings = new SimulationSettings();
        this.userDialog = new UserDialog(settings);
        this.islandMap = new IslandMap(settings.getHeightMap(), settings.getWidthMap());
        this.controller = new IslandControl(islandMap, settings);
        this.statisticsPrinter = new StatisticsPrinter();
        this.eatingMap = initEatingChance();
    }

    public void start() {
        controller.getMap().initialize();
        controller.getMap().fulfill(settings.getMaxCountOnCell());

        for (int i = 0; i < 100; i++) {
            for (int y = 0; y < islandMap.getHeight(); y++) {
                for (int x = 0; x < islandMap.getWidth(); x++) {
                    Location location = islandMap.getLocation()[y][x];
                    List<Animal> animals = new ArrayList<>(location.getEntities());
                    for (Animal animal : animals) {
                        if (isDead(animal)) {
                            location.removeEntity(animal);
                            continue;
                        }
                        Action action = animal.actionChoice();
                        doAction(action, animal, location);
                    }
                }
            }
            statisticsPrinter.printAnimalStatistics(islandMap);
            statisticsPrinter.printPlantStatistics(islandMap);
        }
    }

    private boolean isDead(Animal animal) {
        return animal.getHealth() < 0;
    }

    private void doAction(Action action, Animal animal, Location location) {
        switch (action) {
            case EAT -> doEat(animal, location);
            case MOVE -> doMove(animal, location);
            case REPRODUCE -> doReproduce(animal, location);
            case SLEEP -> doSleep(animal);
        }
        reduceHealth(animal);
    }

    private void reduceHealth(Animal animal) {
        double health = animal.getHealth() - ((animal.getKgToBeFull() * settings.getReduceHealthPercent()) / 100);
        if (health > animal.getHealth()) {
            health = animal.getKgToBeFull();
        }
        animal.setHealth(health);
    }
    public void doMove(Animal animal, Location location) {
        int stepCount = ThreadLocalRandom.current().nextInt(animal.getSpeed() + 1);

        while (stepCount > 0) {
            Direction direction = animal.move();
            switch (direction) {
                case DOWN -> location = service.stepDown(animal, location, islandMap);
                case UP -> location = service.stepUp(animal, location, islandMap);
                case LEFT -> location = service.stepLeft(animal, location, islandMap);
                case RIGHT -> location = service.stepRight(animal, location, islandMap);
            }
            stepCount--;
        }
    }
    public void doReproduce(Animal animal, Location location) {
        String animalAsString = animal.getClass().getSimpleName();
        Integer count = location.getEntitiesCount().get(animalAsString);
        if (count == null || count >= animal.getMaxCount()) {
            return;
        }
        List<Animal> animals = location.getEntities();

        var sameAnimalType = animals.stream()
                .filter(animalType -> animalType.getClass().getSimpleName().equals(animal.getClass().getSimpleName()))
                .collect(Collectors.toList())
                .size();
        if (sameAnimalType > 1) {
            Animal newAnimal = animal.reproduce();
            location.addEntity(newAnimal);
        }
    }
    public void doEat(Animal animal, Location location) {
        List<Entity> food = location
                .getEntities()
                .stream()
                .filter(foodEntity -> !isSameEntity(animal, foodEntity))
                .collect(Collectors.toList());
        if (food.size() > 0) {
            Entity foodEntity = food.get(ThreadLocalRandom.current().nextInt(food.size()));
            if (isEaten(animal, foodEntity)) {
                animal.eat(foodEntity);
                location.removeEntity(foodEntity);
            }
        }
    }
    private boolean isSameEntity(Animal animal, Entity entity) {
        return entity.getClass().getSimpleName().equals(animal.getClass().getSimpleName());
    }
    public void doSleep(Animal animal) {
        controller.increaseHealth(animal);
    }
    private boolean isEaten(Animal hungryAnimal, Entity foodEntity) {
        int probabilityOfEating = getEatableChance(hungryAnimal, foodEntity);
        return ThreadLocalRandom.current().nextInt(MAX_EATABLE_INDEX) < probabilityOfEating;
    }
    private EatingMap initEatingChance() {
        ObjectMapper mapper = new YAMLMapper();
        EatingMap eatingMap = null;
        try (InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/pyshnyi/resource/chance-to-eat.yaml")) {
            eatingMap = mapper.readValue(inputStream, EatingMap.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return eatingMap;
    }
    private Integer getEatableChance(Animal hungryAnimal, Entity foodEntity) {
        Map<String, Integer> map = eatingMap.getEatableIndexes().get(hungryAnimal.getClass().getSimpleName());

        // Проверяем, что map не равен null и содержит ключ foodEntity.getClass().getSimpleName()
        if (map != null) {
            Integer value = map.get(foodEntity.getClass().getSimpleName());
            return value != null ? value : 0; // Если значение есть, возвращаем его, иначе 0
        } else {
            return 0; // Если ключ отсутствует, возвращаем значение по умолчанию (0)
        }
    }
}