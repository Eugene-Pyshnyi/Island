package com.pyshnyi;

import com.pyshnyi.island.service.YamlReader;
import com.pyshnyi.simulation.SimulationStarter;

public class Play {
    public static void main(String[] args) throws Exception {
        YamlReader yamlReader = new YamlReader();
        yamlReader.read(yamlReader.getYamlFilePath());
        SimulationStarter simulationStarter = new SimulationStarter();
        simulationStarter.start();
    }
}