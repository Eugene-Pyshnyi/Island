package com.entities.animals.predators;

import com.entities.animals.Animal;

public class Snake extends Predator {
    public Snake() {
        super(1,1,1,1);
    }

    @Override
    public Animal reproduce() {
        return new Snake();
    }
}
