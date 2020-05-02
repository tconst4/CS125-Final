package com.example.cs125final;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

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
     * @return an int representing the player's current score.
     */
    public int getPlayerScore() {
        return playerScore;
    }

    /**
     * Gets the enemy score, if ever = 3 the player loses the game and has to start over.
     * @return an int representing the enemy's current score.
     */
    public int getEnemyScore() {
        return enemyScore;
    }

    protected Game currentGame;
    protected MoveList moves;
    protected Button codeButton;
    protected Button refactorButton;
    protected Button debugButton;
    protected Button advanceButton;
    protected Button menuButton;
    protected Button startOverButton;
    protected MediaPlayer music;
    protected MediaPlayer hit;
    protected MediaPlayer miss;
    protected ImageView enemyAvatar;
    protected ImageView debugPose;
    protected ImageView codePose;
    protected ImageView refactorPose;
    protected ImageView victoryPose;
    protected ImageView defeatPose;
    protected ImageView victory;
    protected ImageView defeat;
    protected View teamPip1;
    protected View teamPip2;
    protected View teamPip3;
    protected View enemyPip1;
    protected View enemyPip2;
    protected View enemyPip3;
    protected int currentRound;



    public void onResume() {
        super.onResume();
        System.out.println(currentGame.getCurrentRound());
        enemyAvatar.setImageResource(moves.getMove(currentGame.getCurrentRound(),
                currentGame.getTell()));
    }
    /**
     * Handles all inputs from the 3 player buttons.
     * @param playerInput int, represents the move being input by the player.
     */
    public void inputHandler(int playerInput) {
        if (currentGame.checkPlayerInput(playerInput)) {
            playerPipControl();
        } else {
            enemyPipControl();
        };
        if (scoreCheck() < 0) {
            currentGame.setTell();
            enemyAvatar.setImageResource(moves.getMove(currentGame.getCurrentRound(),
                    currentGame.getTell()));
        } else {
            roundOver();
        }

    }

    protected void playerPipControl() {
        if (currentGame.currentPlayerScore() == Constant.FIRST_POINT) {
            teamPip1.setVisibility(View.VISIBLE);
        } else if (currentGame.currentPlayerScore() == Constant.SECOND_POINT) {
            teamPip2.setVisibility(View.VISIBLE);
        } else if (currentGame.currentPlayerScore() == Constant.THIRD_POINT) {
            teamPip3.setVisibility(View.VISIBLE);
        }
    }

    protected void enemyPipControl() {
        if (currentGame.currentEnemyScore() == Constant.FIRST_POINT) {
            enemyPip1.setVisibility(View.VISIBLE);
        } else if (currentGame.currentEnemyScore() == Constant.SECOND_POINT) {
            enemyPip2.setVisibility(View.VISIBLE);
        } else if (currentGame.currentEnemyScore() == Constant.THIRD_POINT) {
            enemyPip3.setVisibility(View.VISIBLE);
        }
    }

    protected void boardReset() {
        advanceButton.setVisibility(View.GONE);
        codeButton.setVisibility(View.VISIBLE);
        refactorButton.setVisibility(View.VISIBLE);
        debugButton.setVisibility(View.VISIBLE);
        teamPip1.setVisibility(View.INVISIBLE);
        teamPip2.setVisibility(View.INVISIBLE);
        teamPip3.setVisibility(View.INVISIBLE);
        enemyPip1.setVisibility(View.INVISIBLE);
        enemyPip2.setVisibility(View.INVISIBLE);
        enemyPip3.setVisibility(View.INVISIBLE);
    }

    protected int scoreCheck() {
        if(currentGame.currentPlayerScore() == Constant.THIRD_POINT) {
            return 1;
        } else if (currentGame.currentEnemyScore() == Constant.THIRD_POINT) {
            return 0;
        } else {
            return -1;
        }
    }

    protected void roundOver() {
        if(currentGame.currentPlayerScore() == Constant.THIRD_POINT) {
            stopMusic();
            /* play fanfare*/
            enemyAvatar.setImageResource(moves.getMove(currentGame.getCurrentRound(),
                    Constant.DEFEAT_POSE));
            codeButton.setVisibility(View.INVISIBLE);
            refactorButton.setVisibility(View.INVISIBLE);
            debugButton.setVisibility(View.INVISIBLE);
            advanceButton.setVisibility(View.VISIBLE);
            currentGame.updateTotalScore();
            currentGame.newBattle();
        }
        if (currentGame.currentEnemyScore() == Constant.THIRD_POINT) {
            stopMusic();
            /*Play defeat noise*/
            enemyAvatar.setImageResource(moves.getMove(currentGame.getCurrentRound(),
                    Constant.VICTORY_POSE));
        }
    }

    /**
     * Instantiates a music player instance if one does not exist, begins playback.
     */
    public void startMusic() {
        if (music == null) {
            music = MediaPlayer.create(this, R.raw.battle);
            music.setLooping(true);
            //music = MediaPlayer.create(this, R.raw.boss);
        }
        music.start();
    }

    /**
     * calls a method to stop and release the music player resources.
     */
    public void stopMusic() {
        stopPlaying();
    }

    /**
     * Checks if player exists and releases it, also sets music = null so we can create a new one
     * next time the startMusic function is called.
     */
    protected void stopPlaying() {
        if (music != null) {
            music.stop();
            music.release();
            music = null;
        }
    }

    /**
     * Override the onStop method to ensure the player is released when the app closes.
     */
    @Override
    protected void onStop() {
        super.onStop();
        stopPlaying();
    }
}
