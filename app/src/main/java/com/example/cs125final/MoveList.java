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
        moves[0][0] = R.drawable.martin1;
        moves[0][1] = R.drawable.martin3;
        moves[0][2] = R.drawable.martin2;
        moves[0][3] = R.drawable.martinvictory;
        moves[0][4] = R.drawable.martindefeat;
        moves[1][0] = R.drawable.ken1;
        moves[1][1] = R.drawable.ryu2;
        moves[1][2] = R.drawable.powerfist;
        moves[1][3] = R.drawable.victory;
        moves[1][4] = R.drawable.defeat;
        moves[2][0] = R.drawable.ken1;
        moves[2][1] = R.drawable.ryu2;
        moves[2][2] = R.drawable.powerfist;
        moves[2][3] = R.drawable.victory;
        moves[2][4] = R.drawable.defeat;
        moves[3][0] = R.drawable.lou1;
        moves[3][1] = R.drawable.lou2;
        moves[3][2] = R.drawable.lou3;
        moves[3][3] = R.drawable.louvictory;
        moves[3][4] = R.drawable.loudefeat;
        moves[4][0] = R.drawable.ben1;
        moves[4][1] = R.drawable.ben2;
        moves[4][2] = R.drawable.ben3;
        moves[4][3] = R.drawable.benvictory;
        moves[4][4] = R.drawable.bendefeat;
        moves[5][0] = R.drawable.geoff1;
        moves[5][1] = R.drawable.geoff2;
        moves[5][2] = R.drawable.geoff3;
        moves[5][3] = R.drawable.geoffvictory;
        moves[5][4] = R.drawable.geoffdefeat;

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
