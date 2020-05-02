package com.example.cs125final;

import android.content.Intent;
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
    private Button advanceButton;
    private MediaPlayer music;
    private MediaPlayer hit;
    private MediaPlayer miss;
    private ImageView enemyAvatar;
    private View teamPip1;
    private View teamPip2;
    private View teamPip3;
    private View enemyPip1;
    private View enemyPip2;
    private View enemyPip3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
        teamPip1 = findViewById(R.id.teamPip1);
        teamPip2 = findViewById(R.id.teamPip2);
        teamPip3 = findViewById(R.id.teamPip3);
        enemyPip1 = findViewById(R.id.enemyPip1);
        enemyPip2 = findViewById(R.id.enemyPip2);
        enemyPip3 = findViewById(R.id.enemyPip3);
        enemyAvatar = findViewById(R.id.opponentSprite4);
//        final MediaPlayer hit = MediaPlayer.create(this, R.raw.right);
//        final MediaPlayer miss = MediaPlayer.create(this, R.raw.wrong);
        final Intent fightTransition = new Intent(BattleActivity.this,
                TransitionActivity.class);

        currentGame = new Game();
        moves = new MoveList();
        currentGame.setTell();
        enemyAvatar.setImageResource(moves.getMove(currentGame.getCurrentRound(),
                currentGame.getTell()));

        startMusic();
        System.out.println(currentGame.getCurrentRound());

        codeButton = findViewById(R.id.codeAttack2);
        codeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputHandler(Constant.CODE_INPUT);
            }
        });

        refactorButton = findViewById(R.id.refactorAttack2);
        refactorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                inputHandler(Constant.REFACTOR_INPUT);
            }
        });

        debugButton = findViewById(R.id.debugAttack2);
        debugButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                inputHandler(Constant.DEBUG_INPUT);
            }
        });

        advanceButton = findViewById(R.id.advanceButton);
        advanceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   startActivity(fightTransition);
            }
        });
    }

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

    private void boardReset() {
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

    private int scoreCheck() {
        if(currentGame.currentPlayerScore() == Constant.THIRD_POINT) {
            return 1;
        } else if (currentGame.currentEnemyScore() == Constant.THIRD_POINT) {
            return 0;
        } else {
            return -1;
        }
    }

    private void roundOver() {
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
