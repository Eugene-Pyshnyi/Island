package com.pyshnyi.entities.animals.predators;

import com.pyshnyi.annotation.Entity;
import com.pyshnyi.entities.animals.Animal;
@Entity(className = "snake")
public class Snake extends Predator {
    public Snake(Double weight, Integer maxCount, Integer speed, Double kgToBeFull, String unicode) {
        super(weight, maxCount, speed, kgToBeFull, unicode);
    }
public Snake() {
    super(15, 40, 1, 3);
}

    @Override
    public Animal reproduce() {
        return new Snake();
    }
}
