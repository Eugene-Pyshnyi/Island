package com.pyshnyi.entities.animals.predators;

import com.pyshnyi.annotation.Entity;
import com.pyshnyi.entities.animals.Animal;

@Entity(className = "wolf")
public class Wolf extends Predator{
    public Wolf(Double weight, Integer maxCount, Integer speed, Double kgToBeFull, String unicode) {
        super(weight, maxCount, speed, kgToBeFull, unicode);
    }
public Wolf() {
    super(50, 30, 3, 8);
}

    @Override
    public Animal reproduce() {
        return new Wolf();
    }
}
