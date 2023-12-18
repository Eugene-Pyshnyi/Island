package com.pyshnyi.entities.plants;

import com.pyshnyi.annotation.Entity;
import com.pyshnyi.entities.animals.Animal;
import com.pyshnyi.entities.animals.herbivores.Herbivore;
import com.pyshnyi.entities.animals.predators.Snake;

@Entity(className = "regular_grass")
public class RegularGrass extends Grass {
    public RegularGrass(Double weight, Integer maxCount, Integer speed, Double kgToBeFull, String unicode) {
        super(weight, maxCount, speed, kgToBeFull, unicode);
    }

    public RegularGrass() {
        super(1, 200, 0, 0);
    }
}
