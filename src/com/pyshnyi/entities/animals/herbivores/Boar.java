package com.pyshnyi.entities.animals.herbivores;

import com.pyshnyi.annotation.Entity;
import com.pyshnyi.entities.animals.Animal;

@Entity(className = "boar")
public class Boar extends Herbivore {

    public Boar(Double weight, Integer maxCount, Integer speed, Double kgToBeFull, String unicode) {
        super(weight, maxCount, speed, kgToBeFull, unicode);
    }

    @Override
    public Animal reproduce() {
        return null;
    }

}