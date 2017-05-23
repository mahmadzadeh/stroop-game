package com.stroopgame;


public class RightButton extends StatefulButton {

    public RightButton(TextState textState, ColourState colourState) {
        super(textState, colourState);
    }

    public LeftButton ofOppositeTextWithRandomColour() {
        return new LeftButton( getOppositeTextState(), getRandomColour());
    }
}
