import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Parameters:

        // Grid:

        // w= "width", w only allows int and must be either 10, 20 and 40 only
        // h= "height", h only allows int and must be either 10, 20, 40 or 80 only
        int  widht = 0;
        int height = 0;

        // g= "generations", is the number of generations to reproduce, only int values >=0
        // Special value 0=> infinite, it'll stop only if the user does it
        int generations = 0;

        // s= "speed", int value, only 250 milliseconds or 1000 milliseconds allowed
        int speed = 0;

        // n= "neighborhood", int [1, 2, 3, 4, 5] default value = 3 which corresponds to a complete neighborhood
        int neighborhood = 0;

        // p= "population", String parameter, 000#111#101#010 where 1 is the live cells, 0 is the dead cells and # indicates the separation between them
        String population = "";


        try {
            if (args.length < 6) {
                System.out.println("Incomplete arguments!");
            }

            for (int i = 0; i < args.length; i++) {
                if (args[i].split("=")[0].toLowerCase().equals("w")) {
                    widht = Integer.parseInt(args[i].split("=")[1]);
                    // System.out.println("widht: " + widht);
                }
                else if (args[i].split("=")[0].toLowerCase().equals("h")) {
                    height = Integer.parseInt(args[i].split("=")[1]);
                    // System.out.println("height: " + height);
                }
                else if (args[i].split("=")[0].toLowerCase().equals("s")) {
                    speed = Integer.parseInt(args[i].split("=")[1]);
                    // System.out.println("speed: " + speed);
                }
                else if (args[i].split("=")[0].toLowerCase().equals("p")) {
                    population = args[i].split("=")[1];
                    // System.out.println("population: " + population);
                }
                else if (args[i].split("=")[0].toLowerCase().equals("g")) {
                    generations = Integer.parseInt(args[i].split("=")[1]);
                    // System.out.println("generations: " + generations);
                }
                else if (args[i].split("=")[0].toLowerCase().equals("n")) {
                    neighborhood = Integer.parseInt(args[i].split("=")[1]);
                    // System.out.println("neighborhood: " + neighborhood);
                }
                else {
                    System.out.println("Invalid argument!");
                }
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        // Grid
        String[][] grid = new String[widht][height];

        // Need to think a way to find the largest row, so if the others row are shorter the rest of the characters is a dead cell, for example: 110#1110#10111
        int populationRowLength = population.split("#")[0].length();

        int[][] populationGrid;

        for (int i = 0; i < population.split("#")[0].length(); i++) {
            for (int j = 0; j < population.split("#")[0].length(); j++) {
                grid[i][j] = population.split("#")[0];
                System.out.println(grid[i][j]);
            }
            System.out.println();
        }


        try {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < widht; j++) {
                    grid[j][i] = "0";
                    System.out.print(grid[j][i]);
                }
                System.out.println();
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}