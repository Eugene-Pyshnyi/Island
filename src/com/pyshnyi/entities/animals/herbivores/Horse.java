package com.pyshnyi.entities.animals.herbivores;

import com.pyshnyi.annotation.Entity;
import com.pyshnyi.entities.animals.Animal;
@Entity(className = "horse")
public class Horse extends Herbivore {
    public Horse(Double weight, Integer maxCount, Integer speed, Double kgToBeFull, String unicode) {
        super(weight, maxCount, speed, kgToBeFull, unicode);
    }
    public Horse() {
        super(400, 20, 4, 50);
    }

    @Override
    public Animal reproduce() {
        return new Horse();
    }
}
