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
        RedText("RED"), BlueText("BLUE");

        private String s;

        TextState(String s) {

            this.s = s;
        }

        @Override
        public String toString() {
            return s;
        }
    }

    enum ColourState {
        RedColour("RED"), BlueColour("BLUE");

        private String colour;

        ColourState(String colour) {

            this.colour = colour;
        }

        @Override
        public String toString() {
            return colour;
        }
    }


}
