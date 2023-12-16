package com.pyshnyi.entities.animals.predators;

import com.pyshnyi.entities.animals.Animal;

public class Snake extends Predator {
    public Snake() {
        super(1,1,1,1);
    }

    @Override
    public Animal reproduce() {
        return new Snake();
    }
}
