package com.pyshnyi.entities.plants;

import com.pyshnyi.annotation.Prop;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.pyshnyi.entities.Entity;

@Getter
@Setter
@NoArgsConstructor
public abstract class Plant extends Entity {
    @Prop(title = "weight", priority = 2)
    private double weight;
    @Prop(title = "maxCount", priority = 0)
    private int maxCount;
    @Prop(title = "unicode", priority = 1)
    private String unicode;
    protected Plant(double weight, int maxCount) {
        this.weight = weight;
        this.maxCount = maxCount;
    }
    protected Plant(double weight, int maxCount, String unicode) {
        this.weight = weight;;
        this.maxCount = maxCount;
        this.unicode = unicode;
    }

    @Override
    public double getWeight() {
        return weight;
    }
    public abstract Plant reproduce();
}
