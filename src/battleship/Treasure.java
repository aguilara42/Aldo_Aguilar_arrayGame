/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 *
 * @author aguilara42
 */
public class Treasure {

    private static int x;
    private static int y;
    private static String symbol;
    private static int score;
    private static int loot;

    Treasure(int a, int b) {
        this.x = a;
        this.y = b;
        symbol = "E ";
        loot = 1;
        //player = Battleship.player;

    }

    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }
    
    
}
