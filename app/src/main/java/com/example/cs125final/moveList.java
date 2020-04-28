package com.example.cs125final;

/**
 * We can a 2 dimensional array to store the values for the various opponents and each
 * of their 3 move images. Later we can retrieve the appropriate image by using the round/move pair
 * as the indexes in the "getMove" function below.
 *
 * Dimension 1 is which round the player is currently in (0-5 where 5 is the bonus round),
 * dimension 2 is the move the opponent is using.
 *
 * I'm currently using empty strings as placeholders. I think they may ultimately end up being
 * references to the resources themselves, or maybe we let the strings be the img names.
 * I haven't quite got that far yet.
 */

public class moveList {
    private String[][] moves = new String[6][3];;

    /**
     * I'm using he constructor to populate the array since it should be the same every time.
     */
    moveList() {
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

    /**
     * This function will get the graphic resource needed for a round/move.
     * @param round the current game round. Determines appropriate graphics for the opponent.
     * @param move the move being used (index 0-2).
     * @return a reference (string or resource tbd) to the needed move image.
     */
    public String getMove(int round, int move) {
        return moves[round][move];
    }
}
