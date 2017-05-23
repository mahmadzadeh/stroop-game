package com.stroopgame;


public class LeftButton extends StatefulButton {

    public LeftButton(TextState textState, ColourState colourState) {
        super(textState, colourState);
    }

    public RightButton ofOppositeTextWithRandomColour() {
        return new RightButton(getOppositeTextState(), getRandomColour());
    }
}
