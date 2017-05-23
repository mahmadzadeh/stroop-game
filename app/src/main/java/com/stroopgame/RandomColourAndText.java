package com.stroopgame;


import com.stroopgame.Parameters.Colour;
import com.stroopgame.Parameters.Text;
import com.stroopgame.StatefulGameObject.ColourState;
import com.stroopgame.StatefulGameObject.TextState;

import static com.stroopgame.Parameters.Colour.BLUE;
import static com.stroopgame.Parameters.Colour.RED;
import static com.stroopgame.RandomNumberGenerator.next;
import static com.stroopgame.StatefulGameObject.TextState.BlueText;
import static com.stroopgame.StatefulGameObject.TextState.RedText;

public class RandomColourAndText {

    public static Parameters nextRandom() {

        Text text = next(new IntegerRange(1, 100)) >= 50 ? Text.BLUE : Text.RED;

        Colour colour = next(new IntegerRange(1, 100)) >= 50 ? BLUE : RED;

        return new Parameters(text, colour);
    }

    public static MainText nextRandomMainText() {

        TextState textState = next(new IntegerRange(1, 100)) >= 50 ? BlueText : RedText;

        ColourState colour = next(new IntegerRange(1, 100)) >= 50 ? ColourState.BlueColour : ColourState.RedColour;

        return new MainText(textState, colour);
    }

}
