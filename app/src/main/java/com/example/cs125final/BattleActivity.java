package com.example.cs125final;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;


public class BattleActivity extends AppCompatActivity {
    private Button codeButton;
    private Button refactorButton;
    private Button debugButton;
    private MediaPlayer music;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
        View teamPip1 = findViewById(R.id.teamPip1);
        View teamPip2 = findViewById(R.id.teamPip2);
        View teamPip3 = findViewById(R.id.teamPip3);
        View enemyPip1 = findViewById(R.id.enemyPip1);
        View enemyPip2 = findViewById(R.id.enemyPip2);
        View enemyPip3 = findViewById(R.id.enemyPip3);

        final MediaPlayer hit = MediaPlayer.create(this, R.raw.right);
        final MediaPlayer miss = MediaPlayer.create(this, R.raw.wrong);

        startMusic();

        codeButton = (Button) findViewById(R.id.codeAttack2);
        codeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //View greenOrb = findViewById(R.id.teamPip1);
                teamPip1.setVisibility(View.VISIBLE);
                hit.start();
            }
        });

        refactorButton = (Button) findViewById(R.id.refactorAttack2);
        refactorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                //View redOrb = findViewById(R.id.enemyPip1);
                enemyPip1.setVisibility(View.VISIBLE);
                miss.start();
            }
        });

        debugButton = (Button) findViewById(R.id.debugAttack2);
        debugButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                //View greenOrb = findViewById(R.id.teamPip1);
                teamPip1.setVisibility(View.INVISIBLE);
                teamPip2.setVisibility(View.INVISIBLE);
                teamPip3.setVisibility(View.INVISIBLE);
                enemyPip1.setVisibility(View.INVISIBLE);
                enemyPip2.setVisibility(View.INVISIBLE);
                enemyPip3.setVisibility(View.INVISIBLE);
                if (music.isPlaying()) {
                    music.pause();
                } else {
                    startMusic();
                }
            }
        });
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
