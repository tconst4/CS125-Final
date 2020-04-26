package com.example.cs125final;

public class moveList {

    private String[][] moves = new String[6][3];;

    public void create() {
        moves[0][0] = " ";
        moves[0][1] = " ";
        moves[0][2] = " ";
        moves[1][0] = " ";
        moves[1][1] = " ";
        moves[1][2] = " ";
        moves[2][0] = " ";
        moves[2][1] = " ";
        moves[2][2] = " ";
        moves[3][0] = " ";
        moves[3][1] = " ";
        moves[3][2] = " ";
        moves[4][0] = " ";
        moves[4][1] = " ";
        moves[4][2] = " ";
        moves[5][0] = " ";
        moves[5][1] = " ";
        moves[5][2] = " ";
    }

    public String getMove(int battle, int move) {
        return moves[battle][move];
    }
}
