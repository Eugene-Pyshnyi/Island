package com.entities.animals.herbivores;

import com.entities.animals.Animal;

public class Sheep extends Herbivore {
    public Sheep() {
        super(1,1,1,1);
    }

    @Override
    public Animal reproduce() {
        return new Sheep();
    }
}
