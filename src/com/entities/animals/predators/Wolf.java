package com.entities.animals.predators;

import com.entities.animals.Animal;

public class Wolf extends Predator {
    public Wolf() {
        super(1,1,1,1);
    }

    @Override
    public Animal reproduce() {
        return new Wolf();
    }
}
