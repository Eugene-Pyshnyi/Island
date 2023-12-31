package com.pyshnyi.entities.animals.herbivores;

import com.pyshnyi.annotation.Entity;
import com.pyshnyi.entities.animals.Animal;
@Entity(className = "mouse")
public class Mouse extends Herbivore {
    public Mouse(Double weight, Integer maxCount, Integer speed, Double kgToBeFull, String unicode) {
        super(weight, maxCount, speed, kgToBeFull, unicode);
    }
public Mouse() {
    super(0.05, 500, 1, 0.01);
}

    @Override
    public Animal reproduce() {
        return new Mouse();
    }
}
