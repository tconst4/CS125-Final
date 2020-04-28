package com.example.cs125final;

import java.util.Random;

/**
 * Whenever a player starts, wins, or loses a game BattleActivity will need to set its internal
 * game object to a new instance of "game". This way we start with a guaranteed fresh game state.
 */
public class game {
    private battle currentBattle;

    /**
     * When a new game is created there should be a new (first) battle created to go along with it.
     */
    game() {
        currentBattle = new battle();
    }
    /**
     * This is the move the opponent is currently using. Get and Set methods are provided below.
     * move will be used to help retrieve the appropriate graphics resources.
     */
    private int move;

    /**
     * This will only be used to test if the player gets to proceed to the bonus round by getting a
     * perfect score in all subsequent rounds.
     */
    private int totalScore = 0;

    /**
     * When a round ends we set the currentBattle to a new instance of battle. This way the scores
     * are reset to 0 and we don't need to add functions to handle that.
     */
    public void newBattle() {
        currentBattle = new battle();
    }

    /**
     * Generates an int (0-2) to be checked against user inputs. Will need to be called each time a
     * player gives an input to set up the next move state.
     */
    public void setMove() {
        Random rand = new Random();
        int newInt = rand.nextInt(3);
        move = newInt;
    }

    /**
     * Gets the current move value.
     * @return the int representing which of 3 options the opponent is using.
     */
    public int getMove() {
        return move;
    }

    /**
     * Checks the player input vs expect and updates the battle values for success/failure
     * @param inputValue the int from a user's button input.
     */
    public void checkPlayerInput(int inputValue) {
        if (inputValue == move) {
            currentBattle.playerSuccess();
        } else {
            currentBattle.playerFail();
        }
    }

    /**
     * Add the players current score to the total. If the player achieves a score of 3 over 4 rounds
     * this will end up being 12, which is the score we will check to access the bonus round.
     */
    public void updateTotalScore() {
        totalScore = totalScore + currentBattle.getPlayerScore();
    }

}
