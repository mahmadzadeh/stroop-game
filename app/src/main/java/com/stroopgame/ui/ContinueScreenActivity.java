package com.stroopgame.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.stroopgame.R;
import com.stroopgame.util.StartScreenActivityIntentUtil;

import java.util.Date;

import static com.stroopgame.util.DateUtil.format;

public class ContinueScreenActivity extends AppCompatActivity {

    public static final String DATE = "GAME_DATE";
    public static final String SCORE_TEXT = "Score ";

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );

        setContentView( R.layout.continue_screen );

        final Button continueButton = ( Button ) findViewById( R.id.continueButton );
        final Button quitButton = ( Button ) findViewById( R.id.quitButton );
        final Button saveButton = ( Button ) findViewById( R.id.saveScoreButton );
        final TextView score = ( TextView ) findViewById( R.id.score );

        final String actualScore = extractScoreFromIntentExtras();
        score.setText( SCORE_TEXT + actualScore );

        continueButton.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick( View v ) {
                        StartScreenActivityIntentUtil.backToStartScreen( v, ContinueScreenActivity.this );
                    }
                } );

        quitButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick( View v ) {
                        StartScreenActivityIntentUtil.backToStartScreen( v, ContinueScreenActivity.this );
                    }
                }
        );

        saveButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick( View v ) {
                        Intent chartActivityIntent = new Intent( v.getContext(), ChartActivity.class );
                        chartActivityIntent.putExtra( GameScreenActivity.FINAL_SCORE, actualScore );
                        chartActivityIntent.putExtra( ContinueScreenActivity.DATE, format( new Date() ) );
                        startActivity( chartActivityIntent );
                    }
                }
        );
    }

    private String extractScoreFromIntentExtras( ) {
        Bundle extras = getIntent().getExtras();

        String value = "";

        if ( extras != null ) {
            value = extras.getInt( GameScreenActivity.FINAL_SCORE ) + "";
        }
        return value;
    }
}
