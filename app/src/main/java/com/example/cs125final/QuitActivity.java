package com.example.cs125final;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class QuitActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quit);
        Handler waitAndQuit = new Handler();
        waitAndQuit.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
                System.exit(0);
            }
        }, 5000);
    }

}
