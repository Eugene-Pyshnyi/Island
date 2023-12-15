package com;

import com.simulation.SimulationStarter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Play {
    public static void main(String[] args){
        SimulationStarter simulationStarter = new SimulationStarter();
        simulationStarter.start();
    }
}