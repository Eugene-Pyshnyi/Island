package com.entities;

import annotation.Prop;
import com.entities.animals.herbivores.*;
import com.entities.animals.predators.*;
import com.entities.plants.Grass;
import com.pyshnyi.entities.animals.herbivores.*;
import com.pyshnyi.entities.animals.predators.*;
import com.pyshnyi.entities.plants.*;
import lombok.SneakyThrows;
import org.reflections.Reflections;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
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
        try (FileReader reader = new FileReader("src/resouce/animal-chars.yaml")) {
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Set<Class<?>> allClassesFromMyPackage = findAllClassesUsingClassLoader();
        for (Class<?> aClass : allClassesFromMyPackage) {
            var entityAnnotation = aClass.getAnnotation(annotation.Entity.class);
            String entityName = entityAnnotation.className();
            System.out.println(entityName);
            Class parentClass = aClass.getSuperclass();
            Field[] parentClassField = parentClass.getDeclaredFields();
            List<String> propertiesValues = new ArrayList<>();
            for (Field field : parentClassField) {
                if (field.isAnnotationPresent(Prop.class)) {
                    Annotation propAnnotation = field.getAnnotation(Prop.class);
                    String propertyName = ((Prop) propAnnotation).title();
                    System.out.println(propertyName);
                    propertiesValues.add(entityName + "." + propertyName);
                }
            }
            Constructor constructor = aClass.getDeclaredConstructor(Double.class, Integer.class, Integer.class, Double.class);
            Double weight = Double.valueOf((String) properties.get(propertiesValues.get(0)));
            Integer maxCountOnCell = Integer.valueOf((String) properties.get(propertiesValues.get(1)));
            Integer speed = Integer.valueOf((String) properties.get(propertiesValues.get(2)));
            Double kgToBeFull = Double.valueOf((String) properties.get(propertiesValues.get(3)));
            entitiesMap.put(aClass.getClass(), constructor.newInstance(weight, maxCountOnCell, speed, kgToBeFull));
        }
    }
    public Entity createEntity(EntityType type) {
        return switch (type) {
            case BEAR -> (Bear) entitiesMap.get(Bear.class);
            case BOAR -> new Boar();
            case BUFFALO -> new Buffalo();
            case CATERPILLAR -> new Caterpillar();
            case DEER -> new Deer();
            case DUCK -> new Duck();
            case EAGLE -> new Eagle();
            case FOX -> new Fox();
            case GOAT -> new Goat();
            case GRASS -> new Grass();
            case HORSE -> new Horse();
            case MOUSE -> new Mouse();
            case RABBIT -> new Rabbit();
            case SHEEP -> new Sheep();
            case SNAKE -> new Snake();
            case WOLF -> new Wolf();
        };
    }
    @SneakyThrows
    private Set<Class<?>> findAllClassesUsingClassLoader() {
        Class<? extends Annotation> annotationClass = annotation.Entity.class;
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
