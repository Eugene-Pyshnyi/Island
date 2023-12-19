package com.pyshnyi.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Entity {
    private double weight;
    private int maxCount;
    private String unicode;
}
