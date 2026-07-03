public class Main {
    public static void main(String[] args) {
        // Parameters:

        // Grid:

        // w= "width", w only allows int and must be either 10, 20 and 40 only
        // h= "height", h only allows int and must be either 10, 20, 40 or 80 only
        int width = 0;
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
                    width = Integer.parseInt(args[i].split("=")[1]);
                    // System.out.println("width: " + width);
                } else if (args[i].split("=")[0].toLowerCase().equals("h")) {
                    height = Integer.parseInt(args[i].split("=")[1]);
                    // System.out.println("height: " + height);
                } else if (args[i].split("=")[0].toLowerCase().equals("s")) {
                    speed = Integer.parseInt(args[i].split("=")[1]);
                    // System.out.println("speed: " + speed);
                } else if (args[i].split("=")[0].toLowerCase().equals("p")) {
                    population = args[i].split("=")[1];
                    // System.out.println("population: " + population);
                } else if (args[i].split("=")[0].toLowerCase().equals("g")) {
                    generations = Integer.parseInt(args[i].split("=")[1]);
                    // System.out.println("generations: " + generations);
                } else if (args[i].split("=")[0].toLowerCase().equals("n")) {
                    neighborhood = Integer.parseInt(args[i].split("=")[1]);
                    // System.out.println("neighborhood: " + neighborhood);
                } else {
                    System.out.println("Invalid argument!");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        // Grid
        char[][] grid = new char[width][height];


        // Stores the max length of items in population
        int populationMaxLength = 0;
        // This will give us the max number of elements on each sub element of each array
        // So if one of the elements has white spaces we can replace it with a dead cell or "0"

        for (String populations : population.split("#")) {
            if (populations.length() > populationMaxLength) {
                populationMaxLength = populations.length();
            }
        }

        // This code block gives us the lenght of the longest population sub group
        String[] populationParts = population.split("#");
        String longestPopulationGroup = populationParts[0];
        for (String populationMember : population.split("#")) {
            if (populationMember.length() > longestPopulationGroup.length()) {
                longestPopulationGroup = populationMember;
            }
        }

        // I need to check if the the largest population part is greater than the grid rows to check if the populations will fit in the grid
        if (longestPopulationGroup.length() > width) {
            System.out.println("Invalid population size, doesn't fit in grid.");
        }

        // save the population characters in a 2d string to fill the grid
        char[][] populationGrid = new char[width][height];
        for (int i = 0; i < populationParts.length; i++) {
            for (int j = 0; j < populationParts[0].length(); j++) {
                populationGrid[i][j] = populationParts[i].charAt(j);
            }
        }

        // This block prints the grid with the input values
        try {
            System.out.println("Initial population: ");
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    grid[j][i] = '0';
                    for (int k = 0; k < longestPopulationGroup.length(); k++) {
                        for (int l = 0; l < populationParts.length; l++) {
                            if (k == i && l == j) {
                                grid[j][i] = populationGrid[l][k];
                            }
                        }
                    }
                    System.out.print(grid[j][i]);
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /*
        // Positions around the cel
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                // System.out.print(grid[i][j]);
                if (i == 2 && j == 2) {
                    grid[i][j+1] = "*";
                    grid[i+1][j] = "*";
                    grid[i][j-1] = "*";
                    grid[i-1][j] = "*";
                    grid[i+1][j-1] = "*";
                    grid[i-1][j+1] = "*";
                    grid[i+1][j-1] = "*";
                    grid[i+1][j+1] = "*";
                    grid[i-1][j-1] = "*";
                }
            }


        // Rule #1
        try {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (grid[j][i] == '1') {
                        if (grid[i][j+1] == '0' || grid[i][j-1] == '0' || grid[i+1][j] == '0' || grid[i+1][j+1] == '0' || grid[i-1][j] == '0' || grid[i+1][j-1] == '0') {
                            grid[j][i] = '0';

                        }
                    }
                    System.out.print(grid[j][i]);
                }
                System.out.println();
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        */
        int startingPoint = 1;
        try {
            while (startingPoint <= generations) {
                Thread.sleep(speed);
                System.out.println("Generation: " + startingPoint);
                // Grid
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        for (int di = 0; di <= 1; di++) {
                            for (int dj = 0; dj <= 1; dj++) {
                                if (di == 0 && dj == 0) {
                                    continue;
                                }
                                int ni = di + i;
                                int nj = dj + j;

                                if (ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[0].length) {
                                    if (grid[ni][nj] == '1') {
                                        grid[ni][nj] = '0';
                                    }
                                    else if (grid[ni][nj] == '0') {
                                        grid[ni][nj] = '1';
                                    }
                                }
                            }
                        }
                        System.out.print(grid[j][i]);
                    }
                    System.out.println();
                }
                System.out.println();
                startingPoint++;
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
