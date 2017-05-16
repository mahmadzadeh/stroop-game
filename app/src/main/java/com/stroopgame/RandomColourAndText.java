package com.stroopgame;


import com.stroopgame.Parameters.Colour;
import com.stroopgame.Parameters.Text;

import static com.stroopgame.Parameters.Colour.BLUE;
import static com.stroopgame.Parameters.Colour.RED;
import static com.stroopgame.RandomNumberGenerator.next;

public class RandomColourAndText {

    public static Parameters nextRandom() {

        Text text = next(new IntegerRange(1, 100)) >= 50 ? Text.BLUE : Text.RED;

        Colour colour = next(new IntegerRange(1, 100)) >= 50 ? BLUE : RED;

        return new Parameters(text, colour);
    }

}
