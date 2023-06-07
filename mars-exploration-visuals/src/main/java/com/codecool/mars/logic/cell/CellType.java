package com.codecool.mars.logic.cell;

public enum CellType {
    EMPTY("empty"),
    FLOOR("floor"),
    MINERAL("mineral"),

    WATER("water"),
    MOUNTAIN("mountain");

    private final String tileName;

    CellType(String tileName) {
        this.tileName = tileName;
    }

    public String getTileName() {
        return tileName;
    }
}
