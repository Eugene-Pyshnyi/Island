package com.pyshnyi.entities.plants;

import com.pyshnyi.annotation.Entity;

@Entity(className = "regular_grass")
public class RegularGrass extends Grass {
    public RegularGrass(Double weight, Integer maxCount, String unicode) {
        super(weight, maxCount, unicode);
    }

    public RegularGrass() {
        super(1, 200);
    }
    @Override
    public Plant reproduce() {
        return new RegularGrass();
    }
}
