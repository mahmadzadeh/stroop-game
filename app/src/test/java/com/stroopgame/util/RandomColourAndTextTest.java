package com.stroopgame.util;

import com.stroopgame.ui.element.MainText;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RandomColourAndTextTest {

    @Test
    public void nextRandom( ) {
        List<MainText> parametersList = new ArrayList<>();

        for ( int i = 0; i < 100; ++i ) {

            parametersList.add( RandomColourAndText.nextRandomMainText() );
        }

        outputPercentMatching( parametersList );

    }

    private void outputPercentMatching( List<MainText> parametersList ) {

        int countMatching = 0;

        for ( MainText parameters : parametersList ) {
            if ( parameters.textAndColourMatch() ) {
                countMatching++;
            }
        }

        System.out.println( "out of " + parametersList.size() + " there are: " + countMatching + " matching text/colour" );
    }


}