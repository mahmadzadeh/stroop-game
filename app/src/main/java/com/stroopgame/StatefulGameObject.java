package com.stroopgame;

import static com.stroopgame.StatefulGameObject.ColourState.BlueColour;
import static com.stroopgame.StatefulGameObject.ColourState.RedColour;
import static com.stroopgame.StatefulGameObject.TextState.BlueText;

public class StatefulGameObject {

    private final ColourState colourState;
    private final TextState textState;

    public StatefulGameObject(TextState textState, ColourState colourState) {
        this.textState = textState;
        this.colourState = colourState;
    }

    protected ColourState getRandomColour() {
        return RandomBoolean.nextRandomTrue() ? BlueColour : RedColour;
    }

    protected TextState getOppositeTextState() {
        return getTextState() == BlueText ? TextState.RedText : BlueText;
    }

    public TextState getTextState() {
        return textState;
    }

    public ColourState getColourState() {
        return colourState;
    }

    enum TextState {
        RedText, BlueText;
    }

    enum ColourState {
        RedColour, BlueColour;
    }


}
