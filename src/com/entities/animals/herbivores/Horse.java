package com.entities.animals.herbivores;

import com.entities.animals.Animal;

public class Horse extends Herbivore {
    public Horse() {
        super(1,1,1,1);
    }

    @Override
    public Animal reproduce() {
        return new Horse();
    }
}
