package com.pyshnyi.entities.plants;

import com.pyshnyi.annotation.Entity;
import com.pyshnyi.entities.animals.Animal;
import com.pyshnyi.entities.animals.herbivores.Herbivore;


@Entity(className = "grass")
public class Grass extends Herbivore { //TODO the class mustn't extend Herbivore
    public Grass(Double weight, Integer maxCount, Integer speed, Double kgToBeFull, String unicode) {
        super(weight, maxCount, speed, kgToBeFull, unicode);
    }

    @Override
    public Animal reproduce() {
        return null;
    }
}
