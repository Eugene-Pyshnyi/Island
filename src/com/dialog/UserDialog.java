package com.dialog;

import com.simulation.SimulationSettings;

import java.util.Scanner;

public class UserDialog {
    private final SimulationSettings simulationSettings;

    public UserDialog(SimulationSettings simulationSettings) {
        this.simulationSettings = simulationSettings;

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Hey");
            System.out.println("Current settings:");
            System.out.println("Height = " + simulationSettings.getHeightMap());
            System.out.println("Weight = " + simulationSettings.getWidthMap());


        }
    }
}
