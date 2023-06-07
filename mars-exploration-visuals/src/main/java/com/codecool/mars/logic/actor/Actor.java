package com.codecool.mars.logic.actor;

import com.codecool.mars.logic.cell.Cell;
import com.codecool.mars.logic.cell.Drawable;

public abstract class Actor implements Drawable {
    private Cell cell;
    public Actor(Cell cell) {
        this.cell = cell;
        this.cell.setActor(this);
    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        cell.setActor(null);
        nextCell.setActor(this);
        cell = nextCell;
    }
}
