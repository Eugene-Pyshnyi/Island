package com.pyshnyi.entities.animals.herbivores;

import com.pyshnyi.annotation.Entity;
import com.pyshnyi.entities.animals.Animal;

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
