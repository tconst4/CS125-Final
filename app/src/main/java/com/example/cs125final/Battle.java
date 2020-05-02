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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        currentRound = getIntent().getIntExtra("round", 1);
        switch (currentRound) {
            case 1:
                setContentView(R.layout.activity_round1_martin);
                teamPip1 = findViewById(R.id.teamPip11);
                teamPip2 = findViewById(R.id.teamPip12);
                teamPip3 = findViewById(R.id.teamPip13);
                enemyPip1 = findViewById(R.id.enemyPip11);
                enemyPip2 = findViewById(R.id.enemyPip12);
                enemyPip3 = findViewById(R.id.enemyPip13);
                advanceButton = findViewById(R.id.advanceButton1);
                codeButton = findViewById(R.id.codeAttack1);
                debugButton = findViewById(R.id.debugAttack1);
                refactorButton = findViewById(R.id.refactorAttack1);
                debugPose = findViewById(R.id.debugPoseMartin);
                codePose = findViewById(R.id.codePoseMartin);
                refactorPose = findViewById(R.id.refactorPoseMartin);
                defeatPose = findViewById(R.id.defeatPoseMartin);
                victoryPose = findViewById(R.id.victoryPoseMartin);
                victory = findViewById(R.id.victory1);
                defeat = findViewById(R.id.defeat1);
                startOverButton = findViewById(R.id.startOverButton1);
                menuButton = findViewById(R.id.menuButton1);
                break;
            case 2:
                setContentView(R.layout.activity_round2);
                teamPip1 = findViewById(R.id.teamPip21);
                teamPip2 = findViewById(R.id.teamPip22);
                teamPip3 = findViewById(R.id.teamPip23);
                enemyPip1 = findViewById(R.id.enemyPip21);
                enemyPip2 = findViewById(R.id.enemyPip22);
                enemyPip3 = findViewById(R.id.enemyPip23);
                advanceButton = findViewById(R.id.advanceButton2);
                codeButton = findViewById(R.id.codeAttack2);
                debugButton = findViewById(R.id.debugAttack2);
                refactorButton = findViewById(R.id.refactorAttack2);
                victory = findViewById(R.id.victory2);
                defeat = findViewById(R.id.defeat2);
                startOverButton = findViewById(R.id.startOverButton2);
                menuButton = findViewById(R.id.menuButton2);
                break;
            case 3:
                setContentView(R.layout.activity_round3_david);
                teamPip1 = findViewById(R.id.teamPip31);
                teamPip2 = findViewById(R.id.teamPip32);
                teamPip3 = findViewById(R.id.teamPip33);
                enemyPip1 = findViewById(R.id.enemyPip31);
                enemyPip2 = findViewById(R.id.enemyPip32);
                enemyPip3 = findViewById(R.id.enemyPip33);
                advanceButton = findViewById(R.id.advanceButton3);
                codeButton = findViewById(R.id.codeAttack3);
                debugButton = findViewById(R.id.debugAttack3);
                refactorButton = findViewById(R.id.refactorAttack3);
                victory = findViewById(R.id.victory3);
                defeat = findViewById(R.id.defeat3);
                startOverButton = findViewById(R.id.startOverButton3);
                menuButton = findViewById(R.id.menuButton3);
                break;
            case 4:
                setContentView(R.layout.activity_round4_lou);
                teamPip1 = findViewById(R.id.teamPip41);
                teamPip2 = findViewById(R.id.teamPip42);
                teamPip3 = findViewById(R.id.teamPip43);
                enemyPip1 = findViewById(R.id.enemyPip41);
                enemyPip2 = findViewById(R.id.enemyPip42);
                enemyPip3 = findViewById(R.id.enemyPip43);
                advanceButton = findViewById(R.id.advanceButton4);
                codeButton = findViewById(R.id.codeAttack4);
                debugButton = findViewById(R.id.debugAttack4);
                refactorButton = findViewById(R.id.refactorAttack4);
                debugPose = findViewById(R.id.debugPoseLou);
                codePose = findViewById(R.id.codePoseLou);
                refactorPose = findViewById(R.id.refactorPoseLou);
                defeatPose = findViewById(R.id.defeatPoseLou);
                victoryPose = findViewById(R.id.victoryPoseLou);
                victory = findViewById(R.id.victory4);
                defeat = findViewById(R.id.defeat4);
                startOverButton = findViewById(R.id.startOverButton4);
                menuButton = findViewById(R.id.menuButton4);
                break;
            case 5:
                setContentView(R.layout.activity_round5_ben);
                teamPip1 = findViewById(R.id.teamPip51);
                teamPip2 = findViewById(R.id.teamPip52);
                teamPip3 = findViewById(R.id.teamPip53);
                enemyPip1 = findViewById(R.id.enemyPip51);
                enemyPip2 = findViewById(R.id.enemyPip52);
                enemyPip3 = findViewById(R.id.enemyPip53);
                advanceButton = findViewById(R.id.advanceButton5);
                codeButton = findViewById(R.id.codeAttack5);
                debugButton = findViewById(R.id.debugAttack5);
                refactorButton = findViewById(R.id.refactorAttack5);
                debugPose = findViewById(R.id.debugPoseBen);
                codePose = findViewById(R.id.codePoseBen);
                refactorPose = findViewById(R.id.refactorPoseBen);
                defeatPose = findViewById(R.id.defeatPoseBen);
                victoryPose = findViewById(R.id.victoryPoseBen);
                victory = findViewById(R.id.victory5);
                defeat = findViewById(R.id.defeat5);
                startOverButton = findViewById(R.id.startOverButton5);
                menuButton = findViewById(R.id.menuButton5);
                break;
            default:
                break;
        }
//        final MediaPlayer hit = MediaPlayer.create(this, R.raw.right);
//        final MediaPlayer miss = MediaPlayer.create(this, R.raw.wrong);
         Intent fightTransition = new Intent(Battle.this,
                TransitionActivity.class);
        fightTransition.putExtra("round", currentRound + 1);
        final Intent toMenu = new Intent(Battle.this, StartScreen.class);
        final Intent startOver = new Intent(Battle.this, TransitionActivity.class);
        currentGame = new Game();
        moves = new MoveList();
        currentGame.setTell();
        enemyAvatar.setImageResource(moves.getMove(currentGame.getCurrentRound(),
                currentGame.getTell()));

        startMusic();
        System.out.println(currentGame.getCurrentRound());

        codeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputHandler(Constant.CODE_INPUT);
            }
        });
        refactorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                inputHandler(Constant.REFACTOR_INPUT);
            }
        });
        debugButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                inputHandler(Constant.DEBUG_INPUT);
            }
        });
        advanceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(fightTransition);
            }
        });
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(toMenu);
            }
        });
        startOverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(startOver);
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
