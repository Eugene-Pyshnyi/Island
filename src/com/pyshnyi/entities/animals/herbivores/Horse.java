package com.pyshnyi.entities.animals.herbivores;

import com.pyshnyi.entities.animals.Animal;

public class Horse extends Herbivore {
    public Horse() {
        super(1,1,1,1);
    }

    @Override
    public Animal reproduce() {
        return new Horse();
    }
}
