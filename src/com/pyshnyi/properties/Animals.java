package com.pyshnyi.properties;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Animals {

    private String name;
    private String emoji;
    private double weight;
    private int maxCount;
    private double cellSpeed;
    private double kgToBeFull;
}