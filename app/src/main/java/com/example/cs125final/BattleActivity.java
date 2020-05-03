package com.example.cs125final;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import pl.droidsonroids.gif.GifImageView;


public class BattleActivity extends AppCompatActivity {
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
    protected View teamPip1;
    protected View teamPip2;
    protected View teamPip3;
    protected View enemyPip1;
    protected View enemyPip2;
    protected View enemyPip3;
    protected ImageView victory;
    protected ImageView defeat;
//    protected GifImageView background;

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
//        background = findViewById(R.id.backdrop);

//        switch(currentGame.getCurrentRound()) {
//            case 6:
//                background.setImageResource(R.drawable.redbattle);
//            default: background.setImageResource(R.drawable.battlegif);
//        }
//        final MediaPlayer hit = MediaPlayer.create(this, R.raw.right);
//        final MediaPlayer miss = MediaPlayer.create(this, R.raw.wrong);

        final Intent endGame = new Intent(BattleActivity.this,
                GameOverActivity.class);

        final Intent fightTransition = new Intent(BattleActivity.this,
                TransitionActivity.class);

        final Intent newChallenger = new Intent(BattleActivity.this,
                NewChallenger.class);

        currentGame = new Game();
        //currentGame.gameReset();
        moves = new MoveList();
        currentGame.setTell();
        enemyAvatar.setImageResource(moves.getMove(currentGame.getCurrentRound(),
                currentGame.getTell()));

        startMusic();

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
                System.out.println("Round: " + currentGame.getCurrentRound());
                System.out.println("Score: " + currentGame.getTotalScore());
                System.out.println("Game: " + Game.gameCount);
                switch(currentGame.getCurrentRound()) {

                    case 6:
                        startActivity(endGame);
                        break;
                    case 5:
                        if (currentGame.getTotalScore() != Constant.PERFECT_SCORE) {
                            startActivity(endGame);
                        } else if (currentGame.getTotalScore() == Constant.PERFECT_SCORE) {
                            startActivity(newChallenger);
                        }
                        break;
                    default: startActivity(fightTransition);
                }
            }
        });
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toMenu = new Intent(BattleActivity.this, StartScreen.class);
                Game.gameReset();
                currentGame = new Game();
                stopMusic();
                finish();
                startActivity(toMenu);
            }
        });
        startOverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Game.gameReset();
                currentGame = new Game();
                stopMusic();
                finish();
                startActivity(fightTransition);
            }
        });
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
            victory.setVisibility(View.VISIBLE);
            currentGame.updateTotalScore();
            currentGame.newBattle();
            //currentRound = currentGame.getCurrentRound();
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
            startOverButton.setVisibility(View.VISIBLE);
            menuButton.setVisibility(View.VISIBLE);
        }
    }

    /**
     * Instantiates a music player instance if one does not exist, begins playback.
     */
    public void startMusic() {
        if (music == null) {
            switch (Game.round) {
                case 4:
                    music = MediaPlayer.create(this, R.raw.subboss);
                    music.setLooping(true);
                    break;
                case 5:
                    music = MediaPlayer.create(this, R.raw.boss);
                    music.setLooping(true);
                    break;
                default:
                    music = MediaPlayer.create(this, R.raw.battle);
                    music.setLooping(true);
            }
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
