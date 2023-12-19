package com.pyshnyi.entities.animals.herbivores;

import com.pyshnyi.annotation.Entity;
import com.pyshnyi.entities.animals.Animal;
@Entity(className = "duck")
public class Duck extends Herbivore {
    public Duck(Double weight, Integer maxCount, Integer speed, Double kgToBeFull, String unicode) {
        super(weight, maxCount, speed, kgToBeFull, unicode);
    }
    public Duck() {
        super(1, 200, 4, 0.15);
    }

    @Override
    public Animal reproduce() {
        return new Duck();
    }
}
