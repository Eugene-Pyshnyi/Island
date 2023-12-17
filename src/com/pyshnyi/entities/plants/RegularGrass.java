package com.pyshnyi.entities.plants;

import com.pyshnyi.annotation.Entity;

@Entity(className = "regular_grass")
public class RegularGrass extends Grass {
    public RegularGrass(Double weight, Integer maxCount, Integer speed, Double kgToBeFull, String unicode) {
        super(weight, maxCount, speed, kgToBeFull, unicode);
    }

    @Override
    public Plant reproduce() {
        return null;
    }
}
