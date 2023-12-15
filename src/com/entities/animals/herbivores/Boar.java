package com.entities.animals.herbivores;

import annotation.Entity;
import com.entities.animals.Animal;

@Entity(className = "Boar")
public class Boar extends Herbivore {

    public Boar() {
        super(1, 1, 1, 1);
    }

    @Override
    public Animal reproduce() {
        return new Boar();
    }

}
