package com.pyshnyi.entities.animals.herbivores;

import com.pyshnyi.annotation.Entity;
import com.pyshnyi.entities.animals.Animal;
@Entity(className = "sheep")
public class Sheep extends Herbivore {
    public Sheep(Double weight, Integer maxCount, Integer speed, Double kgToBeFull, String unicode) {
        super(weight, maxCount, speed, kgToBeFull, unicode);
    }
public Sheep() {
    super(70, 140, 3, 15);
}
    @Override
    public Animal reproduce() {
        return new Sheep();
    }
}
