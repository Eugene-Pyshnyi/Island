package com.entities.animals.predators;

import com.entities.animals.Animal;

public class Eagle extends Predator {
    public Eagle() {
        super(1,1,1,1);
    }

    @Override
    public Animal reproduce() {
        return new Eagle();
    }
}
