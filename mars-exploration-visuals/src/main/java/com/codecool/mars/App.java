package com.codecool.mars;

public class App {
    public static String FILE_PATH = "exploration.map";

    public static void main(String[] args) {
        if (args.length > 0) {
            FILE_PATH = args[0];
            System.out.println("Running with map file: " + args[0]);
        } else {
            System.out.println("Args not found. Running with default file path: " + FILE_PATH);
        }
        Main.main(args);
    }
}
