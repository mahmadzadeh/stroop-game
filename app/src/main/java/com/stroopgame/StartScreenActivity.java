package com.stroopgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class StartScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_start_screen);

        final Button button = (Button) findViewById(R.id.continueButton);

        button.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent countDownIntent = new Intent(v.getContext(), CountDownScreenActivity.class);
                        startActivity(countDownIntent);
                    }
                });

    }
}
