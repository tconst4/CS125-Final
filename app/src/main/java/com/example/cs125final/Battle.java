package com.example.cs125final;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Manages player and enemy scores for each individual battle. This way we can instantiate a new
 * instance of the battle class for each round, rather than have functions to
 * reset the score values.
 */
public class Battle extends AppCompatActivity {
    protected int playerScore;
    protected int enemyScore;

    /**
     * Called when the player input is correct to defeat the current move.
     */
    public void playerSuccess() {
        playerScore++;
    }

    /**
     * Called when the player input was incorrect to defeat the current move.
     */
    public void playerFail() {
        enemyScore++;
    }

    /**
     * Gets the player score, if ever = 3 the player wins the round.
     *
     * @return an int representing the player's current score.
     */
    public int getPlayerScore() {
        return playerScore;
    }

    /**
     * Gets the enemy score, if ever = 3 the player loses the game and has to start over.
     *
     * @return an int representing the enemy's current score.
     */
    public int getEnemyScore() {
        return enemyScore;
    }
}