package com.example.cs125final;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;



public class BattleActivity extends AppCompatActivity {
    private Game currentGame;
    private MoveList moves;
    private Button codeButton;
    private Button refactorButton;
    private Button debugButton;
    private MediaPlayer music;
    private ImageView enemyAvatar;
    private View teamPip1 = findViewById(R.id.teamPip1);
    private View teamPip2 = findViewById(R.id.teamPip2);
    private View teamPip3 = findViewById(R.id.teamPip3);
    private View enemyPip1 = findViewById(R.id.enemyPip1);
    private View enemyPip2 = findViewById(R.id.enemyPip2);
    private View enemyPip3 = findViewById(R.id.enemyPip3);
    private MediaPlayer hit = MediaPlayer.create(this, R.raw.right);
    private MediaPlayer miss = MediaPlayer.create(this, R.raw.wrong);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
        currentGame = new Game();
        moves = new MoveList();
        currentGame.setTell();
        enemyAvatar.setImageResource(moves.getMove(currentGame.getCurrentRound(),
                currentGame.getTell()));

        startMusic();

        codeButton = (Button) findViewById(R.id.codeAttack2);
        codeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputHandler(Constant.CODE_INPUT);
            }
        });

        refactorButton = (Button) findViewById(R.id.refactorAttack2);
        refactorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                inputHandler(Constant.REFACTOR_INPUT);
            }
        });

        debugButton = (Button) findViewById(R.id.debugAttack2);
        debugButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                inputHandler(Constant.DEBUG_INPUT);
            }
        });
    }

    /**
     * Handles all inputs from the 3 player buttons.
     * @param playerInput int, represents the move being input by the player.
     */
    public void inputHandler(int playerInput) {
        if (currentGame.checkPlayerInput(playerInput)) {
            hit.start();
        } else {
            miss.start();
        };
        playerPipControl();
        enemyPipControl();
        currentGame.setTell();
        enemyAvatar.setImageResource(moves.getMove(currentGame.getCurrentRound(),
                currentGame.getTell()));

    }

    private void playerPipControl() {
        if (currentGame.currentPlayerScore() == Constant.FIRST_POINT) {
            teamPip1.setVisibility(View.VISIBLE);
        } else if (currentGame.currentPlayerScore() == Constant.SECOND_POINT) {
            teamPip2.setVisibility(View.VISIBLE);
        } else if (currentGame.currentPlayerScore() == Constant.THIRD_POINT) {
            teamPip3.setVisibility(View.VISIBLE);
        }
    }

    private void enemyPipControl() {
        if (currentGame.currentEnemyScore() == Constant.FIRST_POINT) {
            enemyPip1.setVisibility(View.VISIBLE);
        } else if (currentGame.currentEnemyScore() == Constant.SECOND_POINT) {
            enemyPip2.setVisibility(View.VISIBLE);
        } else if (currentGame.currentEnemyScore() == Constant.THIRD_POINT) {
            enemyPip3.setVisibility(View.VISIBLE);
        }
    }

    /**
     * Instantiates a music player instance if one does not exist, begins playback.
     */
    public void startMusic() {
        if (music == null) {
            music = MediaPlayer.create(this, R.raw.battle);
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
    private void stopPlaying() {
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
