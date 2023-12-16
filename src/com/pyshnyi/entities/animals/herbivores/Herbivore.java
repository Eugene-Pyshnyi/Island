package com.pyshnyi.entities.animals.herbivores;

import com.pyshnyi.entities.animals.Animal;

public abstract class Herbivore extends Animal {
    public Herbivore(double weight, int maxCountOnCell, int speed, double kgToBeFull) {
        super(weight, maxCountOnCell, speed, kgToBeFull);
    }

}
