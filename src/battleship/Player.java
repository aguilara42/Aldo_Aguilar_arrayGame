/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import static battleship.Battleship.chest;
import static battleship.Battleship.coordinets;
import static battleship.Battleship.direction;
import static battleship.Battleship.enemy;
import static battleship.Battleship.rand;

/**
 *
 * @author aguilara42
 */
public class Player {

    public static Battleship level1;

    int x;
    int y;
    int HP;
    String symbol = "@ ";
    int score = 0;
    int level = 1;

    Player(int a, int b) {
        this.x = a;
        this.y = b;
        this.HP = 10;
        coordinets[0] = x;
        coordinets[1] = y;

    }

    public static void movePlayer() {
        if (direction.contains("n") && direction.contains("e") && coordinets[0] > 0 && coordinets[1] < 28) {
            coordinets[0]--;
            coordinets[1]++;
        } else if (direction.contains("s") && direction.contains("e") && coordinets[0] < 28 && coordinets[1] < 28) {
            coordinets[0]++;
            coordinets[1]++;
        } else if (direction.contains("s") && direction.contains("w") && coordinets[0] < 28 && coordinets[1] > 0) {
            coordinets[0]++;
            coordinets[1]--;
        } else if (direction.contains("n") && direction.contains("w") && coordinets[0] > 0 && coordinets[1] > 0) {
            coordinets[0]--;
            coordinets[1]--;
        } else if (direction.contains("n") && coordinets[0] > 0) {
            coordinets[0]--;
        } else if (direction.contains("e") && coordinets[1] < 28) {
            coordinets[1]++;
        } else if (direction.contains("s") && coordinets[0] < 28) {
            coordinets[0]++;
        } else if (direction.contains("w") && coordinets[1] > 0) {
            coordinets[1]--;
        }
        level1.update();

    }

    public static void levelUp(int a) { 
        if (a < 25) {
        }
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    

}
