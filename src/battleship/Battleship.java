package battleship;

import java.util.Random;
import java.util.Scanner;

public class Battleship {

    static Scanner sc = new Scanner(System.in);
    public static String direction;
    public static String[][] map = new String[30][30];
    public static int[] player = new int[2];
    public static int[][] enemy = new int[2][2];
    public static int[][] chest = new int[2][2];
    public static Random rand = new Random();
    public static int health = 10;
    public static int score = 0;

    public static void main(String[] args) {
        startUp();
    }

    public static void startUp() {
        player[0] = 14;
        player[1] = 14;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 1; j++) {
                int x = rand.nextInt(29);
                enemy[i][j] = x;
            }
        }

        while (1 < 2) {
            generateMap();
            update();
            //updateEnemy();
            drawMap();
            userInput();
            enemyMove();
            if (health <= 0) {
                health = 0;
                lose();
            }
        }
    }

    public static void userInput() {
        System.out.println("Health: " + health);
        System.out.println("Score: " + score);
        System.out.println("What diection would you like to move?");
        direction = sc.nextLine().toLowerCase();
        movePlayer();

    }

    public static void update() {

        map[player[0]][player[1]] = "@ ";

        for (int i = 0; i < 2; i++) {
            map[enemy[i][0]][enemy[i][1]] = "E ";
            map[chest[i][0]][chest[i][1]] = "| | ";
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
        if (chest[0][0] == player[0] && chest[0][1] == player[1]) {
            score++;

        }
        for (int i = 0; i < 2; i++) {
            if (enemy[i][0] == player[0] && enemy[i][1] == player[1]) {
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

    public static void movePlayer() {
        if (direction.contains("n") && direction.contains("e") && player[0] > 0 && player[1] < 28) {
            player[0]--;
            player[1]++;
        } else if (direction.contains("s") && direction.contains("e") && player[0] < 28 && player[1] < 28) {
            player[0]++;
            player[1]++;
        } else if (direction.contains("s") && direction.contains("w") && player[0] < 28 && player[1] > 0) {
            player[0]++;
            player[1]--;
        } else if (direction.contains("n") && direction.contains("w") && player[0] > 0 && player[1] > 0) {
            player[0]--;
            player[1]--;
        } else if (direction.contains("n") && player[0] > 0) {
            player[0]--;
        } else if (direction.contains("e") && player[1] < 28) {
            player[1]++;
        } else if (direction.contains("s") && player[0] < 28) {
            player[0]++;
        } else if (direction.contains("w") && player[1] > 0) {
            player[1]--;
        }
        update();

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
        } else if (enemy[i][0] > player[0] && enemy[i][0] > 0) {
            enemy[i][0]--;
        } else if (enemy[i][1] < player[1] && enemy[i][1] < 28) {
            enemy[i][1]++;
        } else if (enemy[i][0] < player[0] && enemy[i][0] < 28) {
            enemy[i][0]++;
        } else if (enemy[i][1] > player[1] && enemy[i][1] > 0) {
            enemy[i][1]--;
        }
        update();

    }

    public static void lose() {
        while (1 < 2) {
            System.out.println("You have lost play again y/n?");
            String lost = sc.nextLine().toLowerCase();
            if (lost.contains("y")) {
                health = 10;
                startUp();
            } else {

            }
        }
    }
}
