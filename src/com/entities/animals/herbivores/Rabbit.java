package com.entities.animals.herbivores;

import com.entities.animals.Animal;

public class Rabbit extends Herbivore {
    public Rabbit() {
        super(1,1,1,1);
    }

    @Override
    public Animal reproduce() {
        return new Rabbit();
    }
}