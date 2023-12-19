package com.pyshnyi.simulation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimulationSettings {

    private int widthMap = 100;

    private int heightMap = 20;

    private int maxCountOnCell = 50;

    private int lifeCycles = 15;

    private double reduceHealthPercent = 1;
}
