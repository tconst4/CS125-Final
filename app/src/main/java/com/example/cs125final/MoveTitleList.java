package com.example.cs125final;


/**
 * A class that stores a list of strings in R variables that tell the user what move the
 * opponent used.
 */
public class MoveTitleList {
    private int[][] moves = new int[6][3];
    private int[] numbers = new int[16];

    MoveTitleList() {
        moves[0][0] = R.string.martinCode;
        moves[0][1] = R.string.martinDebug;
        moves[0][2] = R.string.martinRefactor;
        moves[1][0] = R.string.davidCode;
        moves[1][1] = R.string.davidDebug;
        moves[1][2] = R.string.davidRefactor;
        moves[2][0] = R.string.louCode;
        moves[2][1] = R.string.louDebug;
        moves[2][2] = R.string.louRefactor;
        moves[3][0] = R.string.danielCode;
        moves[3][1] = R.string.danielDebug;
        moves[3][2] = R.string.danielRefactor;
        moves[4][0] = R.string.benCode;
        moves[4][1] = R.string.benDebug;
        moves[4][2] = R.string.benRefactor;
        moves[5][0] = R.string.geoffCode;
        moves[5][1] = R.string.geoffDebug;
        moves[5][2] = R.string.geoffRefactor;
        numbers[1] = R.string.one;
        numbers[2] = R.string.two;
        numbers[3] = R.string.three;
        numbers[4] = R.string.four;
        numbers[5] = R.string.five;
        numbers[6] = R.string.six;
        numbers[7] = R.string.seven;
        numbers[8] = R.string.eight;
        numbers[9] = R.string.nine;
        numbers[10] = R.string.ten;
        numbers[11] = R.string.eleven;
        numbers[12] = R.string.twelve;
        numbers[13] = R.string.thirteen;
        numbers[14] = R.string.fourteen;
        numbers[15] = R.string.fifteen;
    }

    public int getMoveText(int roundNumber, int pose) {
        return moves[roundNumber][pose];
    }

    public int getNumberString(int  number) { return numbers[number]; }
}
