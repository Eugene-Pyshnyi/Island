package com.pyshnyi.entities.plants;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.pyshnyi.entities.Entity;

@Getter
@Setter
@NoArgsConstructor
public class Plant extends Entity {
    private double weight = 1;
    private int maxCountOnCell = 200;
    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public int getMaxCountOnCell() {
        return maxCountOnCell;
    }
}
