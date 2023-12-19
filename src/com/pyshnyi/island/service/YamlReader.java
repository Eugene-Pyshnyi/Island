package com.pyshnyi.island.service;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

public class YamlReader {
    public static void main(String[] args) throws Exception {
        String yamlFilePath = "com/pyshnyi/resource/chance-to-eat.yaml";

        try (InputStream input = new FileInputStream(yamlFilePath)) {
            Yaml yaml = new Yaml();
            Map<String, Map<String, Map<String, Double>>> data = yaml.load(input);

            data.forEach((animalType, animalData) -> {
                System.out.println("Animal type: " + animalType);
                animalData.forEach((animal, preyData) -> {
                    System.out.println("  Can eat " + animal + " with probabilities:");
                    preyData.forEach((prey, probability) -> {
                        System.out.println("    - " + prey + ": " + probability);
                    });
                });
            });
        }
    }
}