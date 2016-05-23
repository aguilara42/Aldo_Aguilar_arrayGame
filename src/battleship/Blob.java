/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import static battleship.Battleship.direction;
import static battleship.Battleship.rand;
import static battleship.Battleship.update;

/**
 *
 * @author aguilara42
 */
public class Blob {

    private int x;
    private int y;
    private static int HP;
    private static String symbol;
    private static int score;
    private static int level;

    Blob(int a, int b) {
        this.x = a;
        this.y = b;
        this.HP = 10;
        symbol = "BB ";
        score = 0;
        level = 1;
        //player = Battleship.player;

    }

    public void enemyMove() {
        int m = rand.nextInt(101);
        if (m > 10) {
            if (direction.contains("n") && direction.contains("e") && x > 0 && y < 28) {
                setX(x--);
                setY(y++);

            } else if (direction.contains("s") && direction.contains("e") && x < 28 && y < 28) {
                setX(x++);
                setY(y++);

            } else if (direction.contains("s") && direction.contains("w") && x < 28 && y > 0) {
                setX(x++);
                setY(y--);
                System.out.println("move");
            } else if (direction.contains("n") && direction.contains("w") && x > 0 && y > 0) {
                setX(x--);
                setY(y--);
                System.out.println("move");
            } else if (Battleship.player.getX() > x && x > 0) {
                this.x++;
            } else if (Battleship.player.getY() < y && y < 28) {
                this.y--;
            } else if (Battleship.player.getX() < x && x < 28) {
                this.x--;
            } else if (Battleship.player.getY() > y && y > 0) {
                this.y++;
            }
            update();
        }

    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public String getSymbol() {
        return symbol;
    }

}
