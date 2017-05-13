package com.stroopgame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class GameScreenActivity extends AppCompatActivity {

    private StroopGame stroopGame = new StroopGame();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game_screen);
    }

}
