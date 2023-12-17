package com.pyshnyi.simulation;

import com.pyshnyi.entities.animals.Action;
import com.pyshnyi.entities.animals.Animal;
import com.pyshnyi.entities.animals.Direction;
import com.pyshnyi.island.IslandControl;
import com.pyshnyi.island.IslandMap;
import com.pyshnyi.dialog.UserDialog;
import com.pyshnyi.island.Location;
import com.pyshnyi.island.service.StepService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SimulationStarter {
    private Location location;
    private IslandMap islandMap;
    private final StepService service;
    private final SimulationSettings settings;
    private final UserDialog userDialog;
    private final IslandControl controller;

    public SimulationStarter() {
        this.service = new StepService();
        this.settings = new SimulationSettings();
        this.userDialog = new UserDialog(settings);
        this.islandMap = new IslandMap(settings.getHeightMap(), settings.getWidthMap());
        this.controller = new IslandControl(islandMap, null, settings);
    }

    public void start() {
        controller.getMap().initialize();
        controller.getMap().fulfill(settings.getMaxCountOnCell());
        for (int i = 0; i < 100; i++) {
            for (int y = 0; y < islandMap.getHeight(); y++) {
                for (int x = 0; x < islandMap.getWidth(); x++) {
                    Location location = islandMap.getLocation()[y][x];
                    List<Animal> animals = new ArrayList<>(location.getAnimals());
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
        }
    }

    private boolean isDead(Animal animal) {
        return animal.getHealth() < 0;
    }

    private void doAction(Action action, Animal animal, Location location) {
        switch (action) {
//            case EAT -> doEat(animal, location);
            case MOVE -> doMove(animal, location);
//            case REPRODUCE -> doReproduce(animal, location);
//            case SLEEP -> doSleep(animal, location);
        }
        reduceHealth(animal);
    }

    private void doMove(Animal animal, Location location) {
        Direction direction = animal.move();
    }

    private void reduceHealth(Animal animal) {
        double health = animal.getHealth() - ((animal.getKgToBeFull() * settings.getReduceHealthPercent()) / 100);
        if (health > animal.getHealth()) {
            health = animal.getKgToBeFull();
        }
        animal.setHealth(health);
    }

    public void doMove(Animal animal) {
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
}
