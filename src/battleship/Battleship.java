package battleship;

import java.util.Random;
import java.util.Scanner;

public class Battleship {

    public static Player player;
    public static Enemy[] enemies = new Enemy[8];
    public static Treasure[] chest = new Treasure[8];
    
    static Scanner sc = new Scanner(System.in);
    public static String direction;
    public static int traps;
    public static String[][] map = new String[30][30];
    public static int[][] trap = new int[50][2];
    public static Random rand = new Random();
    public static int health = 10;
    public static int score = 0;
    public static String line;

    public static void main(String[] args) {
        startUp();
    }

    public static void startUp() {
        player = new Player(14, 14);
        traps = rand.nextInt(40 - 10);

        for (int i = 0; i < traps; i++) {
            for (int j = 0; j < 2; j++) {
                int b = rand.nextInt(29);
                int a = rand.nextInt(29);
                trap[i][j] = a;
                trap[i][j] = b;
            }
        }
        intro();
        
        generateEnemies(2);
       
        while (1 < 2) {
            generateMap();
            update();
            drawMap();
            userInput();

            if (health <= 0) {
                health = 0;
                lose();

            }

            if (score == 10) {
                win();
            }

            for (int j = 0; j < 2; j++) {
                if (chest[j].getX() == player.getX() && chest[j].getY() == player.getY()) {
                    score += 1;
                    //generate(j + 1, j);
                }
            }
        }
    }

    public static void userInput() {
        System.out.println("Health: " + health);
        System.out.println("Score: " + score);
        System.out.println("What diection would you like to move?");
        direction = sc.nextLine().toLowerCase();
        player.movePlayer();

    }

    public static void generateEnemies(int a) {
        for (int i = 0; i < a; i++) {
            
                int x = rand.nextInt(29);
                int y = rand.nextInt(29);
                enemies[i] = new Enemy(x,y);
                chest[i] = new Treasure(x,y);
            }
        
    }

    public static void intro() {
        System.out.println("You Wake up alone lost in a desert");
        line = sc.nextLine();
        System.out.println("Surrounded by the beating sun, you see treaures in the distance, do you dare chase these dreams?");
        line = sc.nextLine();
        System.out.println("As you get up your fears begin to chase you");
        line = sc.nextLine();
        System.out.println("Can you make it to your dreams before you drown in your fears?");
        line = sc.nextLine();

    }

    public static void update() {
        map[player.getX()][player.getY()] = player.getSymbol();

        for (int i = 0; i < traps; i++) {

            map[trap[i][0]][trap[i][1]] = "# ";

        }

        for (int i = 0; i < 2; i++) {
            map[enemies[i].getX()][enemies[i].getY()] = "E ";
            map[chest[i].getX()][chest[i].getY()] = "T ";
        }

    }

    public static void generateMap() {
        for (int i = 0; i < 29; i++) {
            for (int j = 0; j < 29; j++) {
                map[i][j] = "- ";
            }
        }
    }

    public static void drawMap() {

        for (int i = 0; i < traps; i++) {
            if (trap[i][0] == player.getX() && trap[i][1] == player.getY()) {
                health--;
            }
        }

        for (int i = 0; i < 2; i++) {
            if (enemies[i].getX() == player.getX() && enemies[i].getX() == player.getY()) {
                health--;
            }

        }
        for (int i = 0; i < 29; i++) {
            for (int j = 0; j < 29; j++) {
                if (j < 28) {
                    System.out.print(map[i][j]);
                } else {
                    System.out.println(map[i][j]);
                }
            }
        }
    }



    public static void lose() {
        score = 0;
        while (1 < 2) {
            score = 0;
            System.out.println("__   __            _              _   \n"
                    + "\\ \\ / /__  _   _  | |    ___  ___| |_ \n"
                    + " \\ V / _ \\| | | | | |   / _ \\/ __| __|\n"
                    + "  | | (_) | |_| | | |__| (_) \\__ \\ |_ \n"
                    + "  |_|\\___/ \\__,_| |_____\\___/|___/\\__|");
            System.out.println("Play again y/n?");
            String lost = sc.nextLine().toLowerCase();
            if (lost.contains("y")) {
                health = 10;
                score = 0;
                startUp();
            } else {

            }
        }
    }

    public static void win() {
        score = 0;
        while (1 < 2) {

            System.out.println("\\ \\ / /__  _   _  \\ \\      / /__  _ __  \n"
                    + " \\ V / _ \\| | | |  \\ \\ /\\ / / _ \\| '_ \\ \n"
                    + "  | | (_) | |_| |   \\ V  V / (_) | | | |\n"
                    + "  |_|\\___/ \\__,_|    \\_/\\_/ \\___/|_| |_|\n"
                    + "                                        ");
            System.out.println("Play again y/n?");
            String lost = sc.nextLine().toLowerCase();
            if (lost.contains("y")) {
                health = 10;
                score = 0;
                startUp();
            } else {

            }
        }
    }
}
