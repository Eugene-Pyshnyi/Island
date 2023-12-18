package com.pyshnyi.entities.animals.herbivores;

import com.pyshnyi.annotation.Entity;
import com.pyshnyi.entities.animals.Animal;
@Entity(className = "deer")
public class Deer extends Herbivore {
    public Deer(Double weight, Integer maxCount, Integer speed, Double kgToBeFull, String unicode) {
        super(weight, maxCount, speed, kgToBeFull, unicode);
    }
    public Deer() {
        super(6, 20, 4, 50);
    }

    @Override
    public Animal reproduce() {
        return new Deer();
    }
}
