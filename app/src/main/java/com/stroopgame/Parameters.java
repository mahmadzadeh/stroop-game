package com.stroopgame;

import static com.stroopgame.Parameters.Colour.BLUE;
import static com.stroopgame.Parameters.Colour.RED;

class Parameters {

    private final Text text;
    private final Colour colour;

    Parameters(Text text, Colour colour) {
        this.text = text;
        this.colour = colour;
    }

    public Text getText() {
        return text;
    }

    public Colour getColour() {
        return colour;
    }

    public boolean textAndColourMatch() {

        return (this.text == Text.BLUE && colour == BLUE) || (this.text == Text.RED && colour == RED);
    }

    public Parameters ofOppositeColour() {
        return new Parameters(this.getText(),
                this.getColour() == BLUE ? RED : BLUE);
    }

    public Parameters ofOppositeText() {
        return new Parameters(this.getText() == Text.BLUE ? Text.RED : Text.BLUE, this.getColour());
    }

    public Parameters ofOppositeTextWithRandomColour() {
        return new Parameters(this.getText() == Text.BLUE ? Text.RED : Text.BLUE, getRandomColour());
    }

    private Parameters.Colour getRandomColour() {
        return RandomBoolean.nextRandomTrue() ? Parameters.Colour.BLUE : Parameters.Colour.RED;
    }

    @Override
    public String toString() {
        return "Parameters{" +
                "text=" + text +
                ", color=" + colour +
                '}';
    }

    enum Text {
        RED, BLUE;
    }

    enum Colour {
        RED(R.color.textRed),
        BLUE(R.color.textBlue);

        int colour;

        Colour(int i) {
            colour = i;
        }

    }
}
