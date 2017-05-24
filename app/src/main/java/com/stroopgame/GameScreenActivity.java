package com.stroopgame;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import static com.stroopgame.StatefulGameObject.ColourState.RedColour;

public class GameScreenActivity extends AppCompatActivity {

    public final int ONE_ROUND_IN_MILLIS = 90000;
    public final int COUNT_DOWN_INTERVAL_IN_MILLIS = 1000;

    private StroopGame stroopGame = new StroopGame();

    private TextView coutdownTimerTxt;
    private TextView scoreTxt;
    private TextView gameText;
    private Button leftButton;
    private Button rightButton;
    private SoundPlayer soundPlayer;

    private GameCountDownTimer timer;

    private Handler handler;

    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game_screen);

        coutdownTimerTxt = (TextView) findViewById(R.id.textViewCountDownTImer);
        gameText = (TextView) findViewById(R.id.textViewGameText);
        scoreTxt = (TextView) findViewById(R.id.textViewScore);
        leftButton = (Button) findViewById(R.id.leftButton);
        rightButton = (Button) findViewById(R.id.rightButton);
        soundPlayer = new SoundPlayer(this);

        timer = new GameCountDownTimer(this, ONE_ROUND_IN_MILLIS, COUNT_DOWN_INTERVAL_IN_MILLIS);

        handler = new Handler() {
            public void handleMessage(Message m) {
                stroopGame.setCurrentState(RandomBoolean.nextRandomTrue());
                setGameState(stroopGame.getCurrentState());
            }
        };

        leftButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        stroopGame.setScoreBasedOnAnswer(stroopGame.getCurrentState().getLeftButton());
                        boolean isCorrectAnswer = stroopGame.isCorrectAnswerBasedOnInternalState(stroopGame.getCurrentState().getLeftButton());
                        soundPlayer.soundFeedbackForUserInput(isCorrectAnswer);
                        updateUI();
                    }
                }
        );

        rightButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        stroopGame.setScoreBasedOnAnswer(stroopGame.getCurrentState().getRightButton());
                        boolean isCorrectAnswer = stroopGame.isCorrectAnswerBasedOnInternalState(stroopGame.getCurrentState().getRightButton());
                        soundPlayer.soundFeedbackForUserInput(isCorrectAnswer);
                        updateUI();
                    }
                }
        );

        timer.start();

        updateUI();
    }

    @Override
    public void onPause() {
        super.onPause();
        timer.cancel();
    }

    @Override
    public void onStop() {
        super.onStop();
        timer.cancel();
    }

    public void setCountDownText(String text) {
        coutdownTimerTxt.setText(text);
    }

    public void setGameState(GameObjects gameState) {
        this.gameText.setText(gameState.getMainText().getTextState().toString());
        this.gameText.setTextColor(gameState.getMainText().getColourState() == RedColour
                ? getResources().getColor(R.color.textRed)
                : getResources().getColor(R.color.textBlue));

        this.leftButton.setText(gameState.getLeftButton().getTextState().toString());
        this.leftButton.setTextColor(gameState.getLeftButton().getColourState() == RedColour
                ? getResources().getColor(R.color.textRed)
                : getResources().getColor(R.color.textBlue));

        this.rightButton.setText(gameState.getRightButton().getTextState().toString());
        this.rightButton.setTextColor(gameState.getRightButton().getColourState() == RedColour
                ? getResources().getColor(R.color.textRed)
                : getResources().getColor(R.color.textBlue));

        this.scoreTxt.setText(stroopGame.getScore().toString());
    }

    private void updateUI() {
        long TIMER_DELAY = 100;
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                handler.obtainMessage(1).sendToTarget();
            }
        }, TIMER_DELAY);
    }
}
