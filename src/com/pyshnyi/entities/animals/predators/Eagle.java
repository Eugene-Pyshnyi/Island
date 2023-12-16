package com.pyshnyi.entities.animals.predators;

import com.pyshnyi.entities.animals.Animal;

public class Eagle extends Predator {
    public Eagle() {
        super(1,1,1,1);
    }

    @Override
    public Animal reproduce() {
        return new Eagle();
    }
}
