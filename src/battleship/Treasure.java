/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.util.Random;

/**
 *
 * @author aguilara42
 */
public class Treasure {

    public static Random rand = new Random();
    private int x;
    private int y;
    private String symbol;
    private int loot;

    Treasure(int a, int b) {

        this.x = a;
        this.y = b;
        symbol = "T ";
        loot = rand.nextInt(5);
        //player = Battleship.player;

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

    public int getLoot() {
        return loot;
    }

}
