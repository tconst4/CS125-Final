package com.example.cs125final;

import java.util.Random;

public class battle {
    private int  move;
    private static int battleCounter = 0;

    public void setMove() {
        Random rand = new Random();
        int newInt = rand.nextInt(3);
        move = newInt;
    }

    public int getMove() {
        return move;
    }

    public int getEnemy() {
        return (battleCounter);
    }

    public void advanceRound() {
        battleCounter++;
    }
}
