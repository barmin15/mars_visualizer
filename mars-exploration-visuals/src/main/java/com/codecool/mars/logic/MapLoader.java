package com.codecool.mars.logic;

import com.codecool.mars.logic.actor.Player;
import com.codecool.mars.logic.cell.Cell;
import com.codecool.mars.logic.cell.CellType;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class MapLoader {
    public static GameMap loadMap(String filePath) throws FileNotFoundException {
        InputStream is = readFile(filePath);
        Scanner scanner = new Scanner(is);
        int width = 32; //TODO: set based on file properties
        int height = 30; //TODO: set based on file properties

        scanner.nextLine(); // empty line

        GameMap map = new GameMap(width, height, CellType.EMPTY);
        for (int y = 0; y < height; y++) {
            String line = scanner.nextLine();
            for (int x = 0; x < width; x++) {
                if (x < line.length()) {
                    Cell cell = map.getCell(x, y);
                    switch (line.charAt(x)) {
                        case ' ':
                            cell.setType(CellType.EMPTY);
                            break;
                        case '^':
                            cell.setType(CellType.MOUNTAIN);
                            break;
                        case '#':
                            cell.setType(CellType.FLOOR);
                            break;
                        case '~':
                            cell.setType(CellType.WATER);
                            break;
                        case '*':
                            cell.setType(CellType.MINERAL);
                            break;
                        case 'p':
                            cell.setType(CellType.EMPTY);
                            map.setPlayer(new Player(cell));
                            break;
                        default:
                            throw new RuntimeException("Unrecognized character: '" + line.charAt(x) + "'");
                    }
                }
            }
        }
        return map;
    }

    private static InputStream readFile(String filePath) throws FileNotFoundException {
        File initialFile = new File(filePath);
        InputStream is = null;
        try {
            is = new FileInputStream(initialFile);
        } catch (FileNotFoundException e) {
            System.out.println("Could not load map file. Try placing it in the App's folder or pass the filename as args.");
            throw new FileNotFoundException("Map file not found.");
        }
        return is;
    }
}
