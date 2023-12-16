package com.pyshnyi;

import lombok.Getter;
import lombok.Setter;
import com.pyshnyi.simulation.SimulationStarter;

@Getter
@Setter
public class Play {
    public static void main(String[] args){
        SimulationStarter simulationStarter = new SimulationStarter();
        simulationStarter.start();
    }
}