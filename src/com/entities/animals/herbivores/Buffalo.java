package com.entities.animals.herbivores;

import com.entities.animals.Animal;

public class Buffalo extends Herbivore {
    public Buffalo() {
        super(1, 1, 1, 1);
    }

    @Override
    public Animal reproduce() {
        return new Buffalo();
    }
}
