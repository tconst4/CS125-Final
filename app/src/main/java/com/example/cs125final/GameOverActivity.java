package com.example.cs125final;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameOverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover);

        View topTextGeoff = findViewById(R.id.gOverTopGeoff);
        View botTextGeoff = findViewById(R.id.gOverBotGeoff);
        View geoffImage = findViewById(R.id.gameOverGeoff);
        View topTextWin = findViewById(R.id.gameVitoryTop);
        View botTextWin = findViewById(R.id.gameVitoryBot);
        View winImage = findViewById(R.id.cs125Logo);

        if (Game.round == 6) {
            topTextGeoff.setVisibility(View.VISIBLE);
            botTextGeoff.setVisibility(View.VISIBLE);
            geoffImage.setVisibility(View.VISIBLE);
        } else {
            topTextWin.setVisibility(View.VISIBLE);
            botTextWin.setVisibility(View.VISIBLE);
            winImage.setVisibility(View.VISIBLE);
        }

        Intent toStart = new Intent(GameOverActivity.this, StartScreen.class);
        Button toMenu = findViewById(R.id.toMenu);
        toMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Game.gameReset();
                startActivity(toStart);
            }
        });
    }
}



