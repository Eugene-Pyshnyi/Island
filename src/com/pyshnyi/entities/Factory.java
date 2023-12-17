package com.pyshnyi.entities;

import com.pyshnyi.entities.plants.RegularGrass;
import lombok.SneakyThrows;
import org.reflections.Reflections;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;
import com.pyshnyi.annotation.Prop;
import com.pyshnyi.entities.animals.herbivores.*;
import com.pyshnyi.entities.animals.predators.*;

import java.io.FileReader;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;

public class Factory {
    public static final String CURRENT_PATH = "com.pyshnyi.entities";
    private Map<Class, Object> entitiesMap = new HashMap<>();
    public Factory() {
        initEntitiesMap();
    }
    @SneakyThrows
    public void initEntitiesMap() {
        Properties properties = new Properties();
        try (FileReader reader = new FileReader("src/com/pyshnyi/resource/entities-data.properties")) {
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Set<Class<?>> allClassesFromMyPackage = findAllClassesUsingClassLoader();
        for (Class<?> aClass : allClassesFromMyPackage) {
            var entityAnnotation = aClass.getAnnotation(com.pyshnyi.annotation.Entity.class);
            String entityName = entityAnnotation.className();
            System.out.println(entityName);
            List<String> propertiesValues = getStrings(aClass, entityName);
            var valuesToSearch = propertiesValues.stream()
                    .filter(el -> el.startsWith(entityName))
                    .sorted()
                    .toList();
            var constructor = aClass.getDeclaredConstructor(Double.class, Integer.class, Integer.class, Double.class, String.class);
            Double weight = Double.valueOf((String) properties.get(valuesToSearch.get(4)));
            Integer maxCount = Integer.valueOf((String) properties.get(valuesToSearch.get(1)));
            Integer speed = Integer.valueOf((String) properties.get(valuesToSearch.get(2)));
            Double kgToBeFull = Double.valueOf((String) properties.get(valuesToSearch.get(0)));
            String unicode = String.valueOf(properties.get(valuesToSearch.get(3)));
            entitiesMap.put(aClass, constructor.newInstance(weight, maxCount, speed, kgToBeFull, unicode));
        }
        System.out.println(entitiesMap);
    }

    private static List<String> getStrings(Class<?> aClass, String entityName) {
        Class childClass = aClass.getSuperclass();
        Class parentClass = childClass.getSuperclass();
        Field[] parentClassField = parentClass.getDeclaredFields();
        List<String> propertiesValues = new ArrayList<>();
        for (Field field : parentClassField) {
            if (field.isAnnotationPresent(Prop.class)) {
                Annotation propAnnotation = field.getAnnotation(Prop.class);
                String propertyName = ((Prop) propAnnotation).title();
                propertiesValues.add(entityName + "." + propertyName);
            }
        }
        return propertiesValues;
    }

    public Entity createEntity(EntityType type) {
        return switch (type) {
            case BEAR -> (Bear) entitiesMap.get(Bear.class);
            case BOAR -> (Boar) entitiesMap.get(Boar.class);
            case BUFFALO -> (Buffalo) entitiesMap.get(Buffalo.class);
            case CATERPILLAR -> (Caterpillar) entitiesMap.get(Caterpillar.class);
            case DEER -> (Deer) entitiesMap.get(Deer.class);
            case DUCK -> (Duck) entitiesMap.get(Duck.class);
            case EAGLE -> (Eagle) entitiesMap.get(Eagle.class);
            case FOX -> (Fox) entitiesMap.get(Fox.class);
            case GOAT -> (Goat) entitiesMap.get(Goat.class);
            case REGULAR_GRASS -> (RegularGrass) entitiesMap.get(RegularGrass.class);
            case HORSE -> (Horse) entitiesMap.get(Horse.class);
            case MOUSE -> (Mouse) entitiesMap.get(Mouse.class);
            case RABBIT -> (Rabbit) entitiesMap.get(Rabbit.class);
            case SHEEP -> (Sheep) entitiesMap.get(Sheep.class);
            case SNAKE -> (Snake) entitiesMap.get(Snake.class);
            case WOLF -> (Wolf) entitiesMap.get(Wolf.class);
        };
    }
    @SneakyThrows
    private Set<Class<?>> findAllClassesUsingClassLoader() {
        Class<? extends Annotation> annotationClass = com.pyshnyi.annotation.Entity.class;
        Reflections reflections = new Reflections(
                new ConfigurationBuilder()
                        .forPackage(CURRENT_PATH)
                        .filterInputsBy(new FilterBuilder().includePackage(CURRENT_PATH)));
        return reflections.getTypesAnnotatedWith(annotationClass);
    }
    private Class getClass(String className, String packageName) {
        try {
            return Class.forName(packageName + "/" + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException e) {

        }
        return null;
    }
}
