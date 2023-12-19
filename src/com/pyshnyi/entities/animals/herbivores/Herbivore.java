package com.pyshnyi.entities.animals.herbivores;

import com.pyshnyi.entities.animals.Animal;

public abstract class Herbivore extends Animal {
    protected Herbivore(double weight, int maxCount, int speed, double kgToBeFull) {
        super(weight, maxCount, speed, kgToBeFull);
    }

    protected Herbivore(double weight, int maxCount, int speed, double kgToBeFull, String unicode) {
        super(weight, maxCount, speed, kgToBeFull, unicode);
    }
}
