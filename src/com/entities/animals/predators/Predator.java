package com.entities.animals.predators;

import com.entities.animals.Animal;

public abstract class Predator extends Animal {
    public Predator(double weight, int maxCountOnCell, int speed, double kgToBeFull) {
        super(weight, maxCountOnCell, speed, kgToBeFull);
    }
}
