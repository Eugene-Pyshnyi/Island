package com.pyshnyi.entities.animals.predators;

import com.pyshnyi.annotation.Entity;
import com.pyshnyi.entities.animals.Animal;
@Entity(className = "eagle")
public class Eagle extends Predator {
    public Eagle(Double weight, Integer maxCount, Integer speed, Double kgToBeFull, String unicode) {
        super(weight, maxCount, speed, kgToBeFull, unicode);
    }

    @Override
    public Animal reproduce() {
        return null;
    }
}
