package battleship;

import java.util.Random;
import java.util.Scanner;

public class Battleship {

    public static Player player;
    public static Enemy[] enemies = new Enemy[8];
    public static Treasure[] chest = new Treasure[8];
    public static Traps[] spikes = new Traps[50];
    public static Blob[] blobs = new Blob[8];

    static Scanner sc = new Scanner(System.in);
    public static String direction;

    public static String[][] map = new String[30][30];

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static Random rand = new Random();
    public static int health;
    public static int traps;
    public static int enemyNumber;
    public static int gameMode;
    public static int chestNumber;
    public static int theChest;
    public static int hard = 1;
    public static int score = 0;
    public static String line;
    public static int turn;

    public static void main(String[] args) {
        startUp();
    }

    public static void startUp() {
        intro();
        player = new Player(14, 14);

        generateTraps(traps);
        generateChest(chestNumber, 0);
        generateEnemies(enemyNumber);
        generateBlob(hard);
        while (1 < 2) {
            generateMap();
            update();
            drawMap();
            userInput();
            move();

            if (health <= 0) {
                health = 0;
                lose();

            }

            if (score >= 10) {
                win();
            }

            for (int i = 0; i < chestNumber; i++) {
                if (chest[i].getX() == player.getX() && chest[i].getY() == player.getY()) {
                    score += chest[i].getLoot();

                    generateChest(i++, i--);
                }
                turn++;
                event();
            }

        }
    }

    public static void userInput() {
        System.out.println(ANSI_RED + "Health: " + health + ANSI_RESET);
        System.out.println("Score: " + score);
        System.out.println("What diection would you like to move?");
        direction = sc.nextLine().toLowerCase();
        player.movePlayer();

    }

    public static void move() {
        for (int i = 0; i < enemyNumber; i++) {
            enemies[i].enemyMove();

        }
    }

    public static void moveB() {
        for (int i = 0; i < enemyNumber; i++) {
            blobs[i].enemyMove();

        }
    }

    public static void generateEnemies(int a) {
        for (int i = 0; i < a; i++) {
            int x = rand.nextInt(29);
            int y = rand.nextInt(29);
            enemies[i] = new Enemy(x, y);
        }

    }

    public static void generateTraps(int a) {
        for (int i = 0; i < a; i++) {
            int x = rand.nextInt(29);
            int y = rand.nextInt(29);
            spikes[i] = new Traps(x, y);
        }

    }

    public static void generateBlob(int a) {
        for (int i = 0; i < a; i++) {
            int x = rand.nextInt(29);
            int y = rand.nextInt(29);
            blobs[i] = new Blob(x, y);
        }

    }

    public static void generateChest(int a, int b) {
        for (int i = b; i < a; i++) {
            int x = rand.nextInt(29);
            int y = rand.nextInt(29);
            chest[i] = new Treasure(x, y);
        }

    }

    public static void intro() {
        int a = 1;
        while (a == 1) {
            System.out.println("Selcet your game mode");
            System.out.println("1.Easy");
            System.out.println("2.Medium");
            System.out.println("3.Hard");
            gameMode = sc.nextInt();
            if (gameMode == 1) {
                health = 20;
                traps = rand.nextInt(25);
                score = 0;
                enemyNumber = 2;
                chestNumber = 5;
                a++;
            }
            if (gameMode == 2) {
                health = 15;
                traps = rand.nextInt(30);
                score = 0;
                enemyNumber = 4;
                chestNumber = 4;
                a++;
            }
            if (gameMode == 3) {
                health = 10;
                traps = rand.nextInt(50 - 30);
                score = 0;
                enemyNumber = 7;
                chestNumber = 1;
                hard = 4;
                a++;
            }
        }
        System.out.println("                                                      /'     `\\\n"
                + "  __                                            ___/'         `\\\n"
                + "/'  `\\_                          _            /'                \\\n"
                + "       \\________________________( )_________/'                   `\\_______\n"
                + "                             _  | |                _\n"
                + "          _                 ( \\ |  )  _           ( ) _\n"
                + "       _ ( )                 \\ `|  | ( )         _| |/ )\n"
                + "      ( \\| | _                `\\,  |/'/'        ( \\  /'\n"
                + "       \\,. |/ )                 |   /'           \\  |\n"
                + "         |  /'                  |  |              | |\n"
                + "         | |                                      | |");
        line = sc.nextLine();
        System.out.println("You Wake up alone lost in a desert");
        line = sc.nextLine();
        System.out.println("Surrounded by the beating sun, you see treaures in the distance, do you dare chase these dreams?");
        line = sc.nextLine();
        System.out.println("As you get up your fears begin to chase you");
        line = sc.nextLine();
        System.out.println("Can you make it to your dreams before you drown in your fears?");
        line = sc.nextLine();

    }

    public static void event() {
        int chance = rand.nextInt(15);
        if (turn == 5) {
            turn = 0;
        }
        if (chance == turn) {
            System.out.println(" o)__\n"
                    + "(_  _`\\\n"
                    + " z/z\\__)");
            System.out.println("A dessert frog has blessed you + 1 point");
            score++;
            turn = 0;
        }
        if (chance == turn--) {
            System.out.println("  ,*-.\n"
                    + "    |  |\n"
                    + ",.  |  |\n"
                    + "| |_|  | ,.\n"
                    + "`---.  |_| |\n"
                    + "    |  .--`\n"
                    + "    |  |\n"
                    + "    |  | ");
            System.out.println("You hugged a sticky cactus health -2");
            health -= 2;
            turn = 0;
        }
    }

    public static void update() {
        map[player.getX()][player.getY()] = player.getSymbol();

        for (int i = 0; i < traps; i++) {
            map[spikes[i].getX()][spikes[i].getY()] = spikes[i].getSymbol();
        }

        for (int i = 0; i < chestNumber; i++) {
            map[chest[i].getX()][chest[i].getY()] = chest[i].getSymbol();
        }
        for (int i = 0; i < enemyNumber; i++) {
            map[enemies[i].getX()][enemies[i].getY()] = enemies[i].getSymbol();
        }
        for (int i = 0; i < hard; i++) {
            map[blobs[i].getX()][blobs[i].getY()] = blobs[i].getSymbol();
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
            if (spikes[i].getX() == player.getX() && spikes[i].getY() == player.getY()) {
                health--;
                map[spikes[i].getX()][spikes[i].getY()] = "# ";
            }
        }

        for (int i = 0; i < enemyNumber; i++) {
            if (enemies[i].getX() == player.getX() && enemies[i].getX() == player.getY()) {
                health--;
            }
        }
        for (int i = 0; i < hard; i++) {
            if (blobs[i].getX() == player.getX() && blobs[i].getX() == player.getY()) {
                health -= 2;
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
                startUp();
            } else {

            }
        }
    }
}
