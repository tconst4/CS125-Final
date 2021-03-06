package com.example.cs125final;

import java.util.Random;

/**
 * Whenever a player starts, wins, or loses a game BattleActivity will need to set its internal
 * game object to a new instance of "game". This way we start with a guaranteed fresh game state.
 */
public class Game {
    private static int lastTell = -1;
    public static int round = 0;
    public static int gameCount = 0;
    public static int playerTotal = 0;
    public static int enemyTotal = 0;
    private Battle currentBattle;
    /**
     * When a new game is created there should be a new (first) battle created to go along with it.
     */
    Game() {

        currentBattle = new Battle();
        gameCount = gameCount + 1;
    }

    /**
     * This is the move the opponent is currently using. Get and Set methods are provided below.
     * move will be used to help retrieve the appropriate graphics resources.
     */
    private int tell;

    /**
     * This will only be used to test if the player gets to proceed to the bonus round by getting a
     * perfect score in all subsequent rounds.
     */
    private static int totalScore = 0;

    /**
     * When a round ends we set the currentBattle to a new instance of battle. This way the scores
     * are reset to 0 and we don't need to add functions to handle that.
     */
    public void newBattle() {
        currentBattle = new Battle();
        round++;

    }

    public int getTotalScore() {
        return totalScore;
    }
    public int getCurrentRound() {
        return round;
    }

    public static void gameReset() {
        round = 0;
        totalScore = 0;
        playerTotal = 0;
        enemyTotal = 0;
    }

    /**
     * Generates an int (0-2) to be checked against user inputs. Will need to be called each time a
     * player gives an input to set up the next move state.
     */
    public void setTell() {
        Random rand = new Random();
        int newInt = rand.nextInt(Constant.TELL_LIMIT);

        while (newInt == lastTell) {
            newInt = rand.nextInt(Constant.TELL_LIMIT);
        }
        lastTell = newInt;
        tell = newInt;
    }

    /**
     * Gets the current move value.
     * @return the int representing which of 3 options the opponent is using.
     */
    public int getTell() {
        return tell;
    }

    /**
     * Checks the player input vs expect and updates the battle values for success/failure
     * @param inputValue the int from a user's button input.
     */
    public boolean checkPlayerInput(int inputValue) {
        if (inputValue == tell) {
            currentBattle.playerSuccess();
            //playerTotal++;
            return true;
        } else {
            currentBattle.playerFail();
            //playerTotal++;
            return false;
        }
    }
    /**
     * Gets the current player score from the active battle.
     * @return an int representing the player's current score.
     */
    public int currentPlayerScore() {
        return currentBattle.getPlayerScore();
    }

    /**
     * Gets the current enemy score from the active battle.
     * @return an int representing the enemy's current score.
     */
    public int currentEnemyScore() {
        return currentBattle.getEnemyScore();
    }
    /**
     * Add the players current score to the total. If the player achieves a score of 3 over 4 rounds
     * this will end up being 12, which is the score we will check to access the bonus round.
     */
    public void updateTotalScore() {
        totalScore += (currentBattle.getPlayerScore() - currentBattle.getEnemyScore());
    }

//    public void updateScores() {
//        playerTotal += currentBattle.getPlayerScore();
//        enemyTotal += currentBattle.getEnemyScore();
//    }

}
