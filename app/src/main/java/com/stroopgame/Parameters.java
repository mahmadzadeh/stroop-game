package com.stroopgame;

class Parameters {

    private final Text text;
    private final Colour color;

    Parameters(Text text, Colour color) {
        this.text = text;
        this.color = color;
    }

    public Text getText() {
        return text;
    }

    public Colour getColor() {
        return color;
    }

    public boolean textAndColourMatch() {

        return (this.text == Text.BLUE && color == Colour.BLUE) || (this.text == Text.RED && color == Colour.RED);
    }

    public Parameters ofOppositeColour() {
        return new Parameters(this.getText(),
                this.getColor() == Colour.BLUE ? Colour.RED : Colour.BLUE);
    }

    public Parameters ofOppositText() {
        return new Parameters(this.getText() == Text.BLUE ? Text.RED : Text.BLUE, this.getColor());
    }

    @Override
    public String toString() {
        return "Parameters{" +
                "text=" + text +
                ", color=" + color +
                '}';
    }

    enum Text {
        RED, BLUE;

    }

    enum Colour {
        RED, BLUE;
    }
}
