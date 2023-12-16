package com.pyshnyi.entities.animals.predators;

import com.pyshnyi.entities.animals.Animal;

public abstract class Predator extends Animal {
    public Predator(double weight, int maxCountOnCell, int speed, double kgToBeFull) {
        super(weight, maxCountOnCell, speed, kgToBeFull);
    }
}
