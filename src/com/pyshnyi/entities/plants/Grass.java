package com.pyshnyi.entities.plants;


public abstract class Grass extends Plant {
    protected Grass(double weight, int maxCount) {
        super(weight, maxCount);
    }

    protected Grass(double weight, int maxCount, String unicode) {
        super(weight, maxCount, unicode);
    }
}
