package com.entities.animals.herbivores;

import com.entities.animals.Animal;

public abstract class Herbivore extends Animal {
    public Herbivore(double weight, int maxCountOnCell, int speed, double kgToBeFull) {
        super(weight, maxCountOnCell, speed, kgToBeFull);
    }

}
