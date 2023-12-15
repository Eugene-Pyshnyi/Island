package com.entities.animals.herbivores;

import com.entities.animals.Animal;

public class Mouse extends Herbivore {
    public Mouse() {
        super(1,1,1,1);
    }

    @Override
    public Animal reproduce() {
        return new Mouse();
    }
}
