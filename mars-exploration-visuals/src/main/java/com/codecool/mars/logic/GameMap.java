package com.codecool.mars.logic;

import com.codecool.mars.logic.actor.Player;
import com.codecool.mars.logic.cell.Cell;
import com.codecool.mars.logic.cell.CellType;

public class GameMap {
    private final int width;
    private final int height;
    private final Cell[][] cells;

    private Player player;

    public GameMap(int width, int height, CellType defaultCellType) {
        this.width = width;
        this.height = height;
        cells = new Cell[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells[x][y] = new Cell(this, x, y, defaultCellType);
            }
        }
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void movePlayer(int dx, int dy) {
        player.move(dx, dy);
    }
}
