package com.example.cs125final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TransitionActivity extends AppCompatActivity {
    private ImageView icon;
    private TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);
        //int currentRound = getIntent().getIntExtra("round", 0);
//        name = findViewById(R.id.nameLabel);
//        switch (Game.round) {
//            case 0:
//                icon = findViewById(R.id.martinProfile);
//                icon.setVisibility(View.VISIBLE);
//                name.setText(R.string.martinName);
//                break;
//            case 1:
//                name.setText("Fight 2");
//                break;
//            case 2:
//                icon = findViewById(R.id.davidProfile);
//                icon.setVisibility(View.VISIBLE);
//                name.setText(R.string.davidName);
//                break;
//            case 3:
//                icon = findViewById(R.id.louProfile);
//                icon.setVisibility(View.VISIBLE);
//                name.setText(R.string.louName);
//                break;
//            case 4:
//                icon = findViewById(R.id.benProfile);
//                icon.setVisibility(View.VISIBLE);
//                name.setText(R.string.benName);
//        }

        final Intent battleActivity = new Intent(TransitionActivity.this,
                BattleActivity.class);
        Button nextFight = findViewById(R.id.fightButton);
        nextFight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // icon.setVisibility(View.INVISIBLE);
                startActivity(battleActivity);
            }
        });

    }
}
