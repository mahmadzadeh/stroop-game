package com.stroopgame.ui.element;

import com.stroopgame.util.RandomBoolean;

import static com.stroopgame.ui.element.StatefulGameObject.ColourState.BlueColour;
import static com.stroopgame.ui.element.StatefulGameObject.ColourState.RedColour;
import static com.stroopgame.ui.element.StatefulGameObject.TextState.BlueText;
import static com.stroopgame.ui.element.StatefulGameObject.TextState.RedText;

public class StatefulGameObject {

    private final ColourState colourState;
    private final TextState textState;

    public StatefulGameObject( TextState textState, ColourState colourState ) {
        this.textState = textState;
        this.colourState = colourState;
    }

    public ColourState getRandomColour( ) {
        return RandomBoolean.nextRandomTrue() ? BlueColour : RedColour;
    }

    public TextState getOppositeTextState( ) {
        return getTextState() == BlueText ? TextState.RedText : BlueText;
    }

    public TextState getTextState( ) {
        return textState;
    }

    public ColourState getColourState( ) {
        return colourState;
    }

    public boolean textAndColourMatch( ) {
        return ( colourState == RedColour && textState == RedText ) ||
                ( colourState == BlueColour && textState == BlueText );
    }

    public enum TextState {
        RedText( "RED" ), BlueText( "BLUE" );

        private String s;

        TextState( String s ) {

            this.s = s;
        }

        @Override
        public String toString( ) {
            return s;
        }
    }

    public enum ColourState {
        RedColour( "RED" ), BlueColour( "BLUE" );

        private String colour;

        ColourState( String colour ) {

            this.colour = colour;
        }

        @Override
        public String toString( ) {
            return colour;
        }
    }


}
