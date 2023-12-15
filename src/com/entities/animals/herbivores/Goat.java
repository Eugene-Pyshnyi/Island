package com.entities.animals.herbivores;


import com.entities.animals.Animal;

public class Goat extends Herbivore {
    public Goat() {
        super(1,1,1,1);
    }

    @Override
    public Animal reproduce() {
        return new Goat();
    }
}
