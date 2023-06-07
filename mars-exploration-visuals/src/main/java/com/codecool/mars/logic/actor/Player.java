package com.codecool.mars.logic.actor;

import com.codecool.mars.logic.cell.Cell;

public class Player  extends Actor {

    public Player(Cell cell) {
        super(cell);
    }

    public String getTileName() {
        return "player";
    }
}
