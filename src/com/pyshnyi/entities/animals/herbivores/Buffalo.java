package com.pyshnyi.entities.animals.herbivores;

import com.pyshnyi.annotation.Entity;
import com.pyshnyi.entities.animals.Animal;
@Entity(className = "buffalo")
public class Buffalo extends Herbivore {
    public Buffalo(Double weight, Integer maxCount, Integer speed, Double kgToBeFull, String unicode) {
        super(weight, maxCount, speed, kgToBeFull, unicode);
    }

    public Buffalo() {
        super(700, 10, 3, 100);
    }

    @Override
    public Animal reproduce() {
        return new Buffalo();
    }
}
