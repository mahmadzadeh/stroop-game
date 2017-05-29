package com.stroopgame.util;


import com.stroopgame.ui.element.MainText;
import com.stroopgame.ui.element.StatefulGameObject.ColourState;
import com.stroopgame.ui.element.StatefulGameObject.TextState;

import static com.stroopgame.ui.element.StatefulGameObject.TextState.BlueText;
import static com.stroopgame.ui.element.StatefulGameObject.TextState.RedText;

public class RandomColourAndText {

    public static MainText nextRandomMainText() {

        TextState textState = RandomNumberGenerator.next(new IntegerRange(1, 100)) >= 50 ? BlueText : RedText;

        ColourState colour = RandomNumberGenerator.next(new IntegerRange(1, 100)) >= 50 ? ColourState.BlueColour : ColourState.RedColour;

        return new MainText(textState, colour);
    }

}
