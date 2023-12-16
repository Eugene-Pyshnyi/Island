package com.pyshnyi.entities.animals.herbivores;

import com.pyshnyi.entities.animals.Animal;

public class Deer extends Herbivore {
    public Deer() {
        super(1, 1, 1, 1);
    }

    @Override
    public Animal reproduce() {
        return new Deer();
    }
}
