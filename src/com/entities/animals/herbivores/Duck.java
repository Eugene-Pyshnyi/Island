package com.entities.animals.herbivores;

import com.entities.animals.Animal;

public class Duck extends Herbivore {
    public Duck() {
        super(1,1,1,1);
    }

    @Override
    public Animal reproduce() {
        return new Duck();
    }
}
