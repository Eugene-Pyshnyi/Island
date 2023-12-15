package com.properties;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Props {
    private static final String SETTINGS_PROPERTIES = "src/properties/animal-chars.yaml";
    public static void main(String[] args) {
        ObjectMapper mapper = new YAMLMapper();
        try {
            Welcome animals = mapper.readValue(new FileReader(SETTINGS_PROPERTIES), Welcome.class);
            Arrays.stream(animals.getAnimals())
                    .forEach(el -> System.out.println(el));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
