package com.example.cs125final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StoryActivity extends AppCompatActivity {
    private Button startGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        startGame = findViewById(R.id.nextButton);
        Intent toRules = new Intent(StoryActivity.this, Rules.class);
        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(toRules);
            }
        });
    }
}

