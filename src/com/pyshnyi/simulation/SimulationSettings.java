package com.pyshnyi.simulation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimulationSettings {

    private int widthMap = 100;

    private int heightMap = 20;

    private int maxCountOnCell = 100;

    private int lifeCycles = 100;

    private double reduceHealthPercent = 40;
}
