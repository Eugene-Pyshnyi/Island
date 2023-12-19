package com.pyshnyi.entities.animals.predators;

import com.pyshnyi.entities.animals.Animal;

public abstract class Predator extends Animal {
    public boolean canEatPlants = false;
    protected Predator(double weight, int maxCount, int speed, int kgToBeFull) {
        super(weight, maxCount, speed, kgToBeFull);
    }

    protected Predator(double weight, int maxCount, int speed, double kgToBeFull, String unicode) {
        super(weight, maxCount, speed, kgToBeFull, unicode);
    }
}
