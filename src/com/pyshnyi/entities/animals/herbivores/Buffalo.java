package com.pyshnyi.entities.animals.herbivores;

import com.pyshnyi.entities.animals.Animal;

public class Buffalo extends Herbivore {
    public Buffalo() {
        super(1, 1, 1, 1);
    }

    @Override
    public Animal reproduce() {
        return new Buffalo();
    }
}
