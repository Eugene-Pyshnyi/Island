package com.island;

import com.entities.animals.Eating;
import com.simulation.SimulationSettings;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IslandControl {
    private final IslandMap map;
    private final Eating eating;
    private final SimulationSettings simulationSettings;

    public IslandControl(IslandMap map, Eating eating, SimulationSettings simulationSettings) {
        this.map = map;
        this.eating = eating;
        this.simulationSettings = simulationSettings;
    }
}
