package com.stroopgame;


import static com.stroopgame.RandomNumberGenerator.next;

public class RandomColourAndText {

    public static Parameters nextRandom() {

        Parameters.Colour colour = next(new IntegerRange(1, 100)) >= 50
                ? Parameters.Colour.BLUE
                : Parameters.Colour.RED;

        Parameters.Text text = next( new IntegerRange( 1, 100)) >= 50
                ? Parameters.Text.BLUE
                : Parameters.Text.RED;

        return new Parameters( text, colour);
    }

}
