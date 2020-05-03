package com.example.cs125final;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameOverActivity extends AppCompatActivity {
    private ImageView icon;
    private TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);
    }

    public class gameOver {

        public void endState() {
            int gameOverCode = getIntent().getIntExtra("endCode", 0);
            switch (Game.round) {
                case 5:

                    break;


            }
        }
    }
}



