package com.entities.plants;

import com.entities.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
