package com.stroopgame;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ParametersTest {


    @Test
    public void testColourAndTextMatching() {
        Parameters matchingBlue = new Parameters(Parameters.Text.BLUE, Parameters.Colour.BLUE);
        Parameters matchingRed = new Parameters(Parameters.Text.RED, Parameters.Colour.RED);
        Parameters mismatchingBlue = new Parameters(Parameters.Text.BLUE, Parameters.Colour.RED);
        Parameters mismatchingRed = new Parameters(Parameters.Text.RED, Parameters.Colour.BLUE);

        assertTrue(matchingBlue.textAndColourMatch());
        assertTrue(matchingRed.textAndColourMatch());
        assertFalse(mismatchingBlue.textAndColourMatch());
        assertFalse(mismatchingRed.textAndColourMatch());
    }

}