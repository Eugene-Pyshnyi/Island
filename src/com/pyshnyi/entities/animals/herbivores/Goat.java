package com.pyshnyi.entities.animals.herbivores;


import com.pyshnyi.entities.animals.Animal;

public class Goat extends Herbivore {
    public Goat() {
        super(1,1,1,1);
    }

    @Override
    public Animal reproduce() {
        return new Goat();
    }
}
