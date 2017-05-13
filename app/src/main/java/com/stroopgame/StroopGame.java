package com.stroopgame;

public class StroopGame {

    public Parameters getNextRandomMainTextParameters() {

        return RandomColourAndText.nextRandom();
    }

    public Parameters getNextRandomLeftButtonParameters(Parameters mainTextParam, boolean shouldMatchMainTextColour) {
        return getParameters(mainTextParam, shouldMatchMainTextColour, RandomColourAndText.nextRandom());
    }

    public Parameters getNextRightButtonParameters(Parameters mainTextParam, boolean shouldMatchMainTextColour) {
        return getParameters(mainTextParam, shouldMatchMainTextColour, RandomColourAndText.nextRandom());
    }

    private Parameters getParameters(Parameters mainTextParam, boolean shouldMatchMainTextColour, Parameters parameters) {
        return shouldMatchMainTextColour
                ? new Parameters(parameters.getText(), mainTextParam.getColor())
                : new Parameters(parameters.getText(), mainTextParam.ofOppositeColour().getColor());
    }


    public boolean isCorrectAnswer(Parameters mainTextParameters, Parameters usersAnswer) {
        return mainTextParameters.getColor() == usersAnswer.getColor();
    }
}
