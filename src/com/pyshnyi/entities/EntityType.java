package com.pyshnyi.entities;

import com.pyshnyi.entities.animals.herbivores.*;
import com.pyshnyi.entities.animals.predators.*;
import com.pyshnyi.entities.plants.RegularGrass;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EntityType {
    BEAR(Bear.class),
    BOAR(Boar.class),
    BUFFALO(Buffalo.class),
    CATERPILLAR(Caterpillar.class),
    DEER(Deer.class),
    DUCK(Duck.class),
    EAGLE(Eagle.class),
    FOX(Fox.class),
    GOAT(Goat.class),
    REGULAR_GRASS(RegularGrass.class),
    HORSE(Horse.class),
    MOUSE(Mouse.class),
    RABBIT(Rabbit.class),
    SHEEP(Sheep.class),
    SNAKE(Snake.class),
    WOLF(Wolf.class);
    private final Class aClass;
}
