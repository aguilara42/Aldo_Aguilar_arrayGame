package battleship;

import java.util.Scanner;

public class Battleship {

    static Scanner sc = new Scanner(System.in);
    public static String direction;
    public static String[][] map = new String[30][30];
    public static int[] coordinet = new int[2];

    public static void main(String[] args) {
        coordinet[0] = 14;
        coordinet[1] = 14;
        while (1 < 2) {
            generateMap();
            updatePlayer();
            drawMap();
            userInput();
        }

    }

    public static void userInput() {
        System.out.println("What diection would you like to move?");
        direction = sc.nextLine().toLowerCase();
        movePlayer();

    }

    public static void updatePlayer() {
        map[coordinet[0]][coordinet[1]] = "@ ";
    }

    public static void generateMap() {
        for (int i = 0; i < 29; i++) {
            for (int j = 0; j < 29; j++) {
                map[i][j] = "- ";
            }
        }
    }

    public static void drawMap() {
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
        if (direction.contains("n") && direction.contains("e") && coordinet[0] > 0 && coordinet[1] < 28) {
            coordinet[0]--;
            coordinet[1]++;
        } else if (direction.contains("s")&& direction.contains("e") && coordinet[0] < 28 && coordinet[1] < 28) {
            coordinet[0]++;
            coordinet[1]++;
        } else if (direction.contains("s") && direction.contains("w") && coordinet[0] < 28 && coordinet[1] > 0) {
            coordinet[0]++;
            coordinet[1]--;
        } else if (direction.contains("n") && direction.contains("w") && coordinet[0] > 0 && coordinet[1] > 0) {
            coordinet[0]--;
            coordinet[1]--;
        } else if (direction.contains("n") && coordinet[0] > 0) {
            coordinet[0]--;
        } else if (direction.contains("e") && coordinet[1] < 28) {
            coordinet[1]++;
        } else if (direction.contains("s") && coordinet[0] < 28) {
            coordinet[0]++;
        } else if (direction.contains("w") && coordinet[1] > 0) {
            coordinet[1]--;
        }
        updatePlayer();

    }
}
