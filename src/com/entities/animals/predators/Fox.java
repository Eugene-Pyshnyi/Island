package com.entities.animals.predators;

import com.entities.animals.Animal;

public class Fox extends Predator {
    public Fox() {
        super(1,1,1,1);
    }

    @Override
    public Animal reproduce() {
        return new Fox();
    }
}
