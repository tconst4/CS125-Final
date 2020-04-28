package com.example.cs125final;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class BattleActivity extends AppCompatActivity {
    private Button codeButton;
    private Button refactorButton;
    private Button debugButton;
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

        codeButton = (Button) findViewById(R.id.codeAttack2);
        codeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //View greenOrb = findViewById(R.id.teamPip1);
                teamPip1.setVisibility(View.VISIBLE);
            }
        });

        refactorButton = (Button) findViewById(R.id.refactorAttack2);
        refactorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                //View redOrb = findViewById(R.id.enemyPip1);
                enemyPip1.setVisibility(View.VISIBLE);
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
            }
        });
    }
}
