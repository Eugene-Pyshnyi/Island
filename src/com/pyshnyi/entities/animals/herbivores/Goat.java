package com.pyshnyi.entities.animals.herbivores;


import com.pyshnyi.annotation.Entity;
import com.pyshnyi.entities.animals.Animal;
@Entity(className = "goat")
public class Goat extends Herbivore {
    public Goat(Double weight, Integer maxCount, Integer speed, Double kgToBeFull, String unicode) {
        super(weight, maxCount, speed, kgToBeFull, unicode);
    }
public Goat() {
    super(60, 140, 3, 15);
}

    @Override
    public Animal reproduce() {
        return new Goat();
    }
}
