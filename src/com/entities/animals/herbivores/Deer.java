package com.entities.animals.herbivores;

import com.entities.animals.Animal;

public class Deer extends Herbivore {
    public Deer() {
        super(1, 1, 1, 1);
    }

    @Override
    public Animal reproduce() {
        return new Deer();
    }
}
