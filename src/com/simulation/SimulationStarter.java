package com.simulation;

import com.dialog.UserDialog;
import com.island.IslandControl;
import com.pyshnyi.island.IslandMap;

public class SimulationStarter {
    private IslandMap islandMap;
    private final SimulationSettings settings;
    private final UserDialog userDialog;
    private final IslandControl controller;

    public SimulationStarter() {
        this.settings = new SimulationSettings();
        this.userDialog = new UserDialog(settings);
        this.islandMap = new IslandMap(settings.getHeightMap(), settings.getWidthMap());
        this.controller = new IslandControl(islandMap, null, settings);
    }

    public void start() {
        controller.getMap().initialize();
        controller.getMap().fulfill(settings.getMaxCountOnCell());
        System.out.println();
    }

}
