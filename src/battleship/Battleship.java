package battleship;

import java.util.Random;
import java.util.Scanner;

public class Battleship {

    public static Player player;

    static Scanner sc = new Scanner(System.in);
    public static String direction;
    public static int traps;
    public static String[][] map = new String[30][30];
    public static int[] coordinets = new int[2];
    public static int[][] enemy = new int[2][2];
    public static int[][] chest = new int[2][2];
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
        generate();
        while (1 < 2) {
            generateMap();
            update();
            drawMap();
            userInput();
            enemyMove();
            if (health <= 0) {
                health = 0;
                lose();

            }

            if (score == 2) {
                win();
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

    public static void generate() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                int x = rand.nextInt(29);
                int y = rand.nextInt(29);
                enemy[i][j] = x;
                chest[i][j] = y;
            }
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

        map[coordinets[0]][coordinets[1]] = "@ ";

        for (int i = 0; i < traps; i++) {

            map[trap[i][0]][trap[i][1]] = "# ";

        }

        for (int i = 0; i < 2; i++) {
            map[enemy[i][0]][enemy[i][1]] = "E ";
            map[chest[i][0]][chest[i][1]] = "T ";
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
            if (trap[i][0] == coordinets[0] && trap[i][1] == coordinets[1]) {
                health--;
            }
        }

        for (int i = 0; i < 2; i++) {
            if (enemy[i][0] == coordinets[0] && enemy[i][1] == coordinets[1]) {
                health--;
            }

            if (chest[i][0] == coordinets[0] && chest[0][1] == coordinets[1]) {
                score++;

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

    public static void enemyMove() {
        int m = rand.nextInt(101);
        int i = rand.nextInt(2);
        if (direction.contains("n") && direction.contains("e") && enemy[i][0] > 0 && enemy[i][1] < 28) {
            enemy[i][0]--;
            enemy[i][1]++;
        } else if (direction.contains("s") && direction.contains("e") && enemy[i][0] < 28 && enemy[i][1] < 28) {
            enemy[i][0]++;
            enemy[i][1]++;
        } else if (direction.contains("s") && direction.contains("w") && enemy[i][0] < 28 && enemy[i][1] > 0) {
            enemy[i][0]++;
            enemy[i][1]--;
        } else if (direction.contains("n") && direction.contains("w") && enemy[i][0] > 0 && enemy[i][1] > 0) {
            enemy[i][0]--;
            enemy[i][1]--;
        } else if (enemy[i][0] > coordinets[0] && enemy[i][0] > 0) {
            enemy[i][0]--;
        } else if (enemy[i][1] < coordinets[1] && enemy[i][1] < 28) {
            enemy[i][1]++;
        } else if (enemy[i][0] < coordinets[0] && enemy[i][0] < 28) {
            enemy[i][0]++;
        } else if (enemy[i][1] > coordinets[1] && enemy[i][1] > 0) {
            enemy[i][1]--;
        }
        update();

    }

    public static void lose() {
        score = 0;
        while (1 < 2) {
            score = 0;
            System.out.println("");
            System.out.println("Lost play again y/n?");
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

            System.out.println("");
            System.out.println("P"
                    + "lay again y/n?");
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
