package com.example.cs125final;


/**
 * A dimensional array will store the drawable resource ID for the various opponents and each
 * of their 3 tell images. Retrieve the appropriate image by using the round/move pair
 * as the indexes in the getMove function.
 *
 * Dimension 1 is which round the player is currently in (0-5 where 5 is the bonus round),
 * dimension 2 is the move the opponent is using (0-2 are tells, 3 = victory, 4 = defeat,
 * 5 = profile.
 */

public class MoveList {
    private int[][] moves = new int[6][6];

    /**
     * I'm using he constructor to populate the array since it should be the same every time.
     */
    MoveList() {
        moves[0][0] = R.drawable.lou1;
        moves[0][1] = R.drawable.lou2;
        moves[0][2] = R.drawable.lou3;
        moves[0][3] = R.drawable.louvictory;
        moves[0][4] = R.drawable.loudefeat;
        moves[0][5] = R.drawable.louprofile;
        moves[1][0] = 0;
        moves[1][1] = 0;
        moves[1][2] = 0;
        moves[1][3] = 0;
        moves[1][4] = 0;
        moves[1][5] = 0;
        moves[2][0] = 0;
        moves[2][1] = 0;
        moves[2][2] = 0;
        moves[2][3] = 0;
        moves[2][4] = 0;
        moves[2][5] = 0;
        moves[3][0] = 0;
        moves[3][1] = 0;
        moves[3][2] = 0;
        moves[3][3] = 0;
        moves[3][4] = 0;
        moves[3][5] = 0;
        moves[4][0] = 0;
        moves[4][1] = 0;
        moves[4][2] = 0;
        moves[4][3] = 0;
        moves[4][4] = 0;
        moves[4][5] = 0;
        moves[5][0] = 0;
        moves[5][1] = 0;
        moves[5][2] = 0;
        moves[5][3] = 0;
        moves[5][4] = 0;
        moves[5][5] = 0;
    }

    /**
     * This function will get the graphic resource needed for a round/move.
     * @param round the current game round. Determines appropriate graphics for the opponent.
     * @param move the move being used (index 0-2).
     * @return a reference (string or resource tbd) to the needed move image.
     */
    public int getMove(int round, int move) {
        return moves[round][move];
    }
}
