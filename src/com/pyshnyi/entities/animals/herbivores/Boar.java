package com.pyshnyi.entities.animals.herbivores;

import com.pyshnyi.annotation.Entity;
import com.pyshnyi.entities.animals.Animal;

@Entity(className = "boar")
public class Boar extends Herbivore {

    public Boar(Double weight, Integer maxCount, Integer speed, Double kgToBeFull, String unicode) {
        super(weight, maxCount, speed, kgToBeFull, unicode);
    }

    public Boar() {
        super(400, 50, 2, 50);
    }

    @Override
    public Animal reproduce() {
        return new Boar();
    }
}
