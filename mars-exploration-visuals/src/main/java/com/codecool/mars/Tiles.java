package com.codecool.mars;

import com.codecool.mars.logic.cell.Drawable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

public class Tiles {
    public static final int BLOCK_HEIGHT = 25;
    public static int TILE_WIDTH = 32;

    private static Image tileset = new Image("/tiles.png", 543 * 2, 543 * 2, true, false);
    private static Map<String, Tile> tileMap = new HashMap<>();
    public static class Tile {
        public final int x, y, w, h;
        Tile(int col, int row) {
            x = col * (TILE_WIDTH + 2);
            y = row * (TILE_WIDTH + 2);
            w = TILE_WIDTH;
            h = TILE_WIDTH;
        }
    }

    static {
        tileMap.put("empty", new Tile(2, 0));
        tileMap.put("mountain", new Tile(4, 18));
        tileMap.put("floor", new Tile(13, 17));
        tileMap.put("player", new Tile(14, 20));
        tileMap.put("water", new Tile(14, 18));
        tileMap.put("mineral", new Tile(23, 4));
    }

    public static void drawTile(GraphicsContext context, Drawable d, int x, int y) {
        Tile tile = tileMap.get(d.getTileName());
        context.drawImage(tileset, tile.x, tile.y, tile.w, tile.h,
                x * BLOCK_HEIGHT, y * BLOCK_HEIGHT, BLOCK_HEIGHT,BLOCK_HEIGHT );
    }
}
