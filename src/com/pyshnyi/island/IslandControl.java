package com.pyshnyi.island;

import com.pyshnyi.entities.animals.Action;
import com.pyshnyi.entities.animals.Animal;
import com.pyshnyi.entities.animals.Direction;
import com.pyshnyi.entities.animals.Eating;
import lombok.Getter;
import lombok.Setter;
import com.pyshnyi.simulation.SimulationSettings;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
public class IslandControl {
    private final IslandMap map;
    private final Eating eating;
    private final SimulationSettings simulationSettings;
    private Location location;

    public IslandControl(IslandMap map, Eating eating, SimulationSettings simulationSettings) {
        this.map = map;
        this.eating = eating;
        this.simulationSettings = simulationSettings;
    }
    private boolean isDead(Animal animal) {
        return animal.getHealth() < 0;
    }

    private void reduceHealth(Animal animal) {
        double health = animal.getHealth() - ((animal.getKgToBeFull() * simulationSettings.getReduceHealthPercent()) / 100);
        if (health > animal.getHealth()) {
            health = animal.getKgToBeFull();
        }
        animal.setHealth(health);
    }
}
