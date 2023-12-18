package com.pyshnyi.entities.animals.herbivores;

import com.pyshnyi.annotation.Entity;
import com.pyshnyi.entities.animals.Animal;
@Entity(className = "rabbit")
public class Rabbit extends Herbivore {
    public Rabbit(Double weight, Integer maxCount, Integer speed, Double kgToBeFull, String unicode) {
        super(weight, maxCount, speed, kgToBeFull, unicode);
    }
public Rabbit() {
    super(2, 150, 2, 0.45);
}
    @Override
    public Animal reproduce() {
        return new Rabbit();
    }
}
