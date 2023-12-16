package com.pyshnyi.entities.plants;

import com.pyshnyi.annotation.Prop;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.pyshnyi.entities.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Plant extends Entity {
    @Prop(title = "weight", priority = 4)
    private double weight;
    @Prop(title = "maxCount", priority = 1)
    private int maxCount;
    @Prop(title = "speed", defaultValue = "1", priority = 2)
    private int speed;
    @Prop(title = "kgToBeFull", priority = 0)
    private double kgToBeFull;
    @Prop(title = "unicode", priority = 3)
    private String unicode;
    private double health;

    protected Plant(double weight, int maxCount, int speed, double kgToBeFull) {
        this.weight = weight;
        this.maxCount = maxCount;
        this.speed = speed;
        this.health = kgToBeFull;
        this.kgToBeFull = kgToBeFull;
        this.unicode = "Hello";
    }
    protected Plant(double weight, int maxCount, int speed, double kgToBeFull, String unicode) {
        this.weight = weight;
        this.maxCount = maxCount;
        this.speed = speed;
        this.health = kgToBeFull;
        this.kgToBeFull = kgToBeFull;
        this.unicode = unicode;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public int getMaxCount() {
        return maxCount;
    }
    public abstract Plant reproduce();
}
