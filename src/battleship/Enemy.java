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
public class Enemy {


    private static int x;
    private static int y;
    private static int HP;
    private static String symbol;
    private static int score;
    private static int level;

    Enemy(int a, int b) {
        this.x = a;
        this.y = b;
        this.HP = 10;
        symbol = "E ";
        score = 0;
        level = 1;
        //player = Battleship.player;

    }

    public static void enemyMove() {
        int m = rand.nextInt(101);
        int i = rand.nextInt(2);
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
        } else if (x > Battleship.player.getX() && x > 0) {
            x--;
        } else if (y < Battleship.player.getY() && y < 28) {
            y++;
        } else if (x < Battleship.player.getX() && x < 28) {
            x++;
        } else if (y > Battleship.player.getY() && y > 0) {
            y--;
        }
        update();

        
        
    }

    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }
    
    
}
