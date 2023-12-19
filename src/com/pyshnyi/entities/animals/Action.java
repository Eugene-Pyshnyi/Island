package com.pyshnyi.entities.animals;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Action {
    MOVE(70),
    EAT(90),
    REPRODUCE(30),
    SLEEP(100);
    private final int actionChance;
}
