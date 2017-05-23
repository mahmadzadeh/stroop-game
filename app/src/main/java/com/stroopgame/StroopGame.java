package com.stroopgame;

import static com.stroopgame.Parameters.Text.BLUE;
import static com.stroopgame.Parameters.Text.RED;

public class StroopGame {

    private int score;

    private GameParameterObjects currentState;

    public GameParameterObjects getCurrentState() {
        return currentState;
    }

    public void setCurrentState(boolean shouldRightButtonMatchMainColour) {
        currentState = generateNextGameState(getNextRandomMainTextParameters(), shouldRightButtonMatchMainColour);
    }

    public Parameters getNextRandomMainTextParameters() {

        return RandomColourAndText.nextRandom();
    }

    public GameParameterObjects generateNextGameState(Parameters mainTextParameters, boolean shouldRightButtonMatchMainColour) {

        Parameters rightButton;
        Parameters leftButton;

        if (shouldRightButtonMatchMainColour) {
            if (mainTextParameters.getColour() == Parameters.Colour.RED) {
                rightButton = new Parameters(RED, getRandomColour());
                leftButton = rightButton.ofOppositeTextWithRandomColour();
            } else {
                rightButton = new Parameters(BLUE, getRandomColour());
                leftButton = rightButton.ofOppositeTextWithRandomColour();
            }
        } else {
            if (mainTextParameters.getColour() == Parameters.Colour.BLUE) {
                leftButton = new Parameters(BLUE, getRandomColour());
                rightButton = leftButton.ofOppositeTextWithRandomColour();
            } else {
                leftButton = new Parameters(RED, getRandomColour());
                rightButton = leftButton.ofOppositeTextWithRandomColour();
            }
        }

        return new GameParameterObjects(mainTextParameters, leftButton, rightButton);
    }

    public boolean evaluateAnswer(Parameters mainTextParameters, Parameters usersAnswer) {
        return (mainTextParameters.getColour() == Parameters.Colour.BLUE && usersAnswer.getText() == Parameters.Text.BLUE) ||
                (mainTextParameters.getColour() == Parameters.Colour.RED && usersAnswer.getText() == Parameters.Text.RED);
    }

    public boolean isCorrectAnswerBasedOnInternalState(Parameters usersAnswer) {
        return evaluateAnswer(getCurrentState().getMainText(), usersAnswer);
    }

    public void setScoreBasedOnAnswer(Parameters usersAnswer) {
        if (isCorrectAnswerBasedOnInternalState(usersAnswer)) {
            score++;
        } else {
            score--;
        }
    }

    public Integer getScore() {
        return score;
    }

    private Parameters.Colour getRandomColour() {
        return RandomBoolean.nextRandomTrue() ? Parameters.Colour.BLUE : Parameters.Colour.RED;
    }

    private Parameters getParameters(Parameters mainTextParam, boolean shouldMatchMainTextColour, Parameters parameters) {
        return shouldMatchMainTextColour
                ? new Parameters(parameters.getText(), mainTextParam.getColour())
                : new Parameters(parameters.getText(), mainTextParam.ofOppositeColour().getColour());
    }
}
