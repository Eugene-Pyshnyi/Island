package com.pyshnyi.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EntityType {
    BEAR("🐻"),
    BOAR("🐗"),
    BUFFALO("🐃"),
    CATERPILLAR("🐛"),
    DEER("🦌"),
    DUCK("🦆"),
    EAGLE("🦅"),
    FOX("🦊"),
    GOAT("🐐"),
    GRASS("🌿"),
    HORSE("🐎"),
    MOUSE("🐁"),
    RABBIT("🐇"),
    SHEEP("🐑"),
    SNAKE("🐍"),
    WOLF("🐺");
    private final String unicodeSymbol;
}
