package com.pyshnyi.entities.animals.predators;

import com.pyshnyi.entities.animals.Animal;

public class Fox extends Predator {
    public Fox() {
        super(1,1,1,1);
    }

    @Override
    public Animal reproduce() {
        return new Fox();
    }
}
