/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.util.Random;

/**
 *
 * @author Aldo
 */
public class Traps {

    public static Random rand = new Random();
    private int x;
    private int y;
    private String symbol;

    Traps(int a, int b) {
        int s = rand.nextInt(2);
        this.x = a;
        this.y = b;
        symbol = "# ";
        if( s == 1){
            symbol ="- ";
        }

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getSymbol() {
        return symbol;
    }
    
    
}
