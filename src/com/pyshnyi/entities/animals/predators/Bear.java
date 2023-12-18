package com.pyshnyi.entities.animals.predators;


import com.pyshnyi.annotation.Entity;
import com.pyshnyi.entities.animals.Animal;

@Entity(className = "bear")
public class Bear extends Predator {
    public Bear(Double weight, Integer maxCount, Integer speed, Double kgToBeFull, String unicode) {
        super(weight, maxCount, speed, kgToBeFull, unicode);
    }
public Bear() {
    super(500, 5, 2, 80);
}

    @Override
    public Animal reproduce() {
        return new Bear();
    }
}
