public class Main {
    public static void main(String[] args) {
        // Parameters:

        // Grid:
        // w= "width", w only allows int and must be either 10, 20 and 40 only
        // h= "height", h only allows int and must be either 10, 20, 40 or 80 only
        int  widht = Integer.parseInt(args[0].split("=")[1]);
        int height = Integer.parseInt(args[1].split("=")[1]);

        // g= "generations", is the number of generations to reproduce, only int values >=0
        // Special value 0=> infinite, it'll stop only if the user does it
        int generations = Integer.parseInt(args[2].split("=")[1]);

        // s= "speed", int value, only 250 milliseconds or 1000 milliseconds allowed
        int speed = Integer.parseInt(args[3].split("=")[1]);

        // n= "neighborhood", int [1, 2, 3, 4, 5] default value = 3 which corresponds to a complete neighborhood
        int neighborhood = Integer.parseInt(args[4].split("=")[1]);

        // p= "population",
    }
}