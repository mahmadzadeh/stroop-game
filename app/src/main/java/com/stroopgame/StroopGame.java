package com.stroopgame;

import com.stroopgame.ui.element.LeftButton;
import com.stroopgame.ui.element.MainText;
import com.stroopgame.ui.element.RightButton;
import com.stroopgame.ui.element.StatefulButton;
import com.stroopgame.ui.element.StatefulGameObject;
import com.stroopgame.util.RandomBoolean;
import com.stroopgame.util.RandomColourAndText;

import static com.stroopgame.ui.element.StatefulGameObject.ColourState.BlueColour;
import static com.stroopgame.ui.element.StatefulGameObject.ColourState.RedColour;
import static com.stroopgame.ui.element.StatefulGameObject.TextState.BlueText;
import static com.stroopgame.ui.element.StatefulGameObject.TextState.RedText;

public class StroopGame {

    private int score;

    private GameObjects currentState;

    public GameObjects getCurrentState() {
        return currentState;
    }

    public void setCurrentState(boolean shouldRightButtonMatchMainColour) {
        currentState = generateNextGameState(getNextRandomMainText(), shouldRightButtonMatchMainColour);
    }

    public MainText getNextRandomMainText() {
        return RandomColourAndText.nextRandomMainText();
    }

    public GameObjects generateNextGameState(MainText mainText, boolean shouldRightButtonMatchMainColour) {

        RightButton rightButton;
        LeftButton leftButton;

        if (shouldRightButtonMatchMainColour) {
            if (mainText.getColourState() == RedColour) {
                rightButton = new RightButton(RedText, getRandomColourState());
                leftButton = rightButton.ofOppositeTextWithRandomColour();
            } else {
                rightButton = new RightButton(BlueText, getRandomColourState());
                leftButton = rightButton.ofOppositeTextWithRandomColour();
            }
        } else {
            if (mainText.getColourState() == BlueColour) {
                leftButton = new LeftButton(BlueText, getRandomColourState());
                rightButton = leftButton.ofOppositeTextWithRandomColour();
            } else {
                leftButton = new LeftButton(RedText, getRandomColourState());
                rightButton = leftButton.ofOppositeTextWithRandomColour();
            }
        }

        return new GameObjects(leftButton, rightButton, mainText);
    }

    public boolean evaluateAnswer(MainText mainText, StatefulButton usersAnswer) {
        return (mainText.getColourState() == BlueColour && usersAnswer.getTextState() == BlueText) ||
                (mainText.getColourState() == RedColour && usersAnswer.getTextState() == RedText);
    }

    public boolean isCorrectAnswerBasedOnInternalState(StatefulButton usersAnswer) {
        return evaluateAnswer(getCurrentState().getMainText(), usersAnswer);
    }

    public void setScoreBasedOnAnswer(StatefulButton usersAnswer) {
        if (isCorrectAnswerBasedOnInternalState(usersAnswer)) {
            score++;
        } else {
            score--;
        }
    }

    public Integer getScore() {
        return score;
    }

    private StatefulGameObject.ColourState getRandomColourState() {
        return RandomBoolean.nextRandomTrue() ? BlueColour : RedColour;
    }
}
