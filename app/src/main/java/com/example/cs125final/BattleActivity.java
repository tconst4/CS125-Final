package com.example.cs125final;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class BattleActivity extends AppCompatActivity {
    protected Game currentGame;
    protected MoveTitleList data;
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
    protected View teamPip1;
    protected View teamPip2;
    protected View teamPip3;
    protected View enemyPip1;
    protected View enemyPip2;
    protected View enemyPip3;
    protected ImageView victory;
    protected ImageView defeat;
    protected TextView moveTitle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
        teamPip1 = findViewById(R.id.teamPip1);
        teamPip2 = findViewById(R.id.teamPip2);
        teamPip3 = findViewById(R.id.teamPip3);
        enemyPip1 = findViewById(R.id.enemyPip1);
        enemyPip2 = findViewById(R.id.enemyPip2);
        enemyPip3 = findViewById(R.id.enemyPip3);
        enemyAvatar = findViewById(R.id.opponentSprite4);
        startOverButton = findViewById(R.id.startOverButton);
        menuButton = findViewById(R.id.menuButton);
        victory = findViewById(R.id.victory);
        defeat = findViewById(R.id.defeat);
        moveTitle = findViewById(R.id.moveText);
        data = new MoveTitleList();
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
        fightTransition.putExtra("round", currentGame.getCurrentRound() + 1);
        System.out.println(currentGame.getCurrentRound());

        codeButton = findViewById(R.id.codeAttack);
        codeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputHandler(Constant.CODE_INPUT);
            }
        });

        refactorButton = findViewById(R.id.refactorAttack);
        refactorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                inputHandler(Constant.REFACTOR_INPUT);
            }
        });

        debugButton = findViewById(R.id.debugAttack);
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
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toMenu = new Intent(BattleActivity.this, StartScreen.class);
                startActivity(toMenu);
            }
        });
        startOverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toStart = new Intent(BattleActivity.this, StartScreen.class);
                startActivity(toStart);
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
            moveTitle.setText((data.getMoveText(currentGame.getCurrentRound(),
                    currentGame.getTell())));
            moveTitle.setVisibility(View.VISIBLE);
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
        moveTitle.setVisibility(View.INVISIBLE);
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
            moveTitle.setVisibility(View.INVISIBLE);
            victory.setVisibility(View.VISIBLE);
            currentGame.updateTotalScore();
            currentGame.newBattle();
        }
        if (currentGame.currentEnemyScore() == Constant.THIRD_POINT) {
            stopMusic();
            /*Play defeat noise*/
            enemyAvatar.setImageResource(moves.getMove(currentGame.getCurrentRound(),
                    Constant.VICTORY_POSE));
            codeButton.setVisibility(View.INVISIBLE);
            refactorButton.setVisibility(View.INVISIBLE);
            debugButton.setVisibility(View.INVISIBLE);
            defeat.setVisibility(View.VISIBLE);
            moveTitle.setVisibility(View.INVISIBLE);
            startOverButton.setVisibility(View.VISIBLE);
            menuButton.setVisibility(View.VISIBLE);
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
