package com.pyshnyi.island;

import com.pyshnyi.entities.animals.Eating;
import lombok.Getter;
import lombok.Setter;
import com.pyshnyi.simulation.SimulationSettings;

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
