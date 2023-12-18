package com.pyshnyi.entities.animals.herbivores;

import com.pyshnyi.annotation.Entity;
import com.pyshnyi.entities.animals.Animal;
@Entity(className = "caterpillar")
public class Caterpillar extends Herbivore {
    public Caterpillar(Double weight, Integer maxCount, Integer speed, Double kgToBeFull, String unicode) {
        super(weight, maxCount, speed, kgToBeFull, unicode);
    }
    public Caterpillar() {
        super(0.01, 1000, 0, 0);
    }
    @Override
    public Animal reproduce() {
        return new Caterpillar();
    }
}
