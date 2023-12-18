package com.pyshnyi.entities.plants;


public abstract class Grass extends Plant {
    protected Grass(double weight, int maxCount, int speed, int kgToBeFull) {
        super(weight, maxCount, speed, kgToBeFull);
    }

    protected Grass(double weight, int maxCount, int speed, double kgToBeFull, String unicode) {
        super(weight, maxCount, speed, kgToBeFull, unicode);
    }
}
