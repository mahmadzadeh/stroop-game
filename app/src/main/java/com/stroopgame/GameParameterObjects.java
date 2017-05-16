package com.stroopgame;

public class GameParameterObjects {

    private final Parameters mainText;
    private final Parameters leftButton;
    private final Parameters rightButton;

    public GameParameterObjects(Parameters mainText, Parameters leftButton, Parameters rightButton) {
        this.mainText = mainText;
        this.leftButton = leftButton;
        this.rightButton = rightButton;
    }

    public Parameters getMainText() {
        return mainText;
    }

    public Parameters getLeftButton() {
        return leftButton;
    }

    public Parameters getRightButton() {
        return rightButton;
    }


    @Override
    public String toString() {
        return "GameParameterObjects{" +
                "mainText=" + mainText +
                ", leftButton=" + leftButton +
                ", rightButton=" + rightButton +
                '}';
    }
}
