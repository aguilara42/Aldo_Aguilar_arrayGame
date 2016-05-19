/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;


import static battleship.Battleship.direction;

/**
 *
 * @author aguilara42
 */
public class Player {

    public static Battleship level1;

    private static int x;
    private static int y;
    private static int HP;
    private static String symbol;
    private static int score;
    private static int level;

    Player(int a, int b) {
        this.x = a;
        this.y = b;
        this.HP = 10;
        symbol = "@ ";
        score = 0;
        level = 1;
        

    }

    public  void movePlayer() {
        if (direction.contains("n") && direction.contains("e") && x > 0 && y < 28) {
            x--;
            y++;
        } else if (direction.contains("s") && direction.contains("e") && x < 28 && y < 28) {
            x++;
            y++;
        } else if (direction.contains("s") && direction.contains("w") && x < 28 && y > 0) {
            x++;
            y--;
        } else if (direction.contains("n") && direction.contains("w") && x > 0 && y > 0) {
            x--;
            y--;
        } else if (direction.contains("n") && x > 0) {
            x--;
        } else if (direction.contains("e") && y < 28) {
            y++;
        } else if (direction.contains("s") && x < 28) {
            x++;
        } else if (direction.contains("w") && y > 0) {
            y--;
        }
        level1.update();

    }

    public  void levelUp(int a) {
        if (a < 25) {
        }
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getX() {
        return x;
    }

    public  int getY() {
        return y;
    }

    public  void setX(int x) {
        Player.x = x;
    }

    public  void setY(int y) {
        Player.y = y;
    }

    public String getSymbol() {
        return symbol;
    }
    
    
}
