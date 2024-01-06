package com.pyshnyi.island;

import com.pyshnyi.entities.animals.Animal;
import lombok.Getter;
import lombok.Setter;
import com.pyshnyi.simulation.SimulationSettings;


@Getter
@Setter
public class IslandControl {
    private final IslandMap map;
    private final SimulationSettings settings;
    private Location location;
    private IslandMap islandMap;

    public IslandControl(IslandMap map, SimulationSettings simulationSettings) {
        this.map = map;
        this.settings = simulationSettings;
    }

    private boolean isDead(Animal animal) {
        return animal.getHealth() < 0;
    }

    public void increaseHealth(Animal animal) {
        double health = animal.getHealth() + ((animal.getKgToBeFull()) * settings.getReduceHealthPercent()) / 100;
        if (health > animal.getHealth()) {
            health = animal.getKgToBeFull();
        }
        animal.setHealth(health);
    }

    private void reduceHealth(Animal animal) {
        double health = animal.getHealth() - ((animal.getKgToBeFull() * settings.getReduceHealthPercent()) / 100);
        animal.setHealth(health);
    }
}
