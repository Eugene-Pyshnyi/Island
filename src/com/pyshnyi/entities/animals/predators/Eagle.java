package com.pyshnyi.entities.animals.predators;

import com.pyshnyi.annotation.Entity;
import com.pyshnyi.entities.animals.Animal;
@Entity(className = "eagle")
public class Eagle extends Predator {
    public Eagle(Double weight, Integer maxCount, Integer speed, Double kgToBeFull, String unicode) {
        super(weight, maxCount, speed, kgToBeFull, unicode);
    }
public Eagle() {
    super(6, 20, 3, 1);
}

    @Override
    public Animal reproduce() {
        return new Eagle();
    }
}
