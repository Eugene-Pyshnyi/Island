package com.pyshnyi.island.service;

import lombok.Getter;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;
@Getter
public class YamlReader {
    private final String yamlFilePath = "com/pyshnyi/resource/chance-to-eat.yaml";
    public static void read(String yamlFilePath) throws Exception {

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