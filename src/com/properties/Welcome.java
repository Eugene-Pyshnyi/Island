package com.properties;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Welcome {
    private Animals[] animals;
    private long day;

    public Animals[] getAnimals() {
        return animals;
    }
    public void setAnimals(Animals[] value) {
        this.animals = value;
    }

}