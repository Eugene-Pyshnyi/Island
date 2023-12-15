package com.entities.animals.predators;


import annotation.Entity;
import com.entities.animals.Animal;
@Entity(className = "Bear")
public class Bear extends Predator {
    public Bear(Double weight, Integer maxCountOnCell, Integer speed, Double kgToBeFull) {
        super(weight, maxCountOnCell, speed, kgToBeFull);
    }

    @Override
    public Animal reproduce() {
        return null;
    }
}
