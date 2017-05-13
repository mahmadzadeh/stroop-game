package com.stroopgame;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class StroopGameTest {

    StroopGame stroopGame = new StroopGame();

    @Test
    public void givenStroopGameThenGetMainTextAndColorReturnsValue() {
        Parameters parameters = stroopGame.getNextRandomMainTextParameters();

        assertNotNull(parameters);
    }

    @Test
    public void givenMainTextWhenLeftButtonShouldMatchColorThenLeftButtonHasMatchingColour() {

        Parameters mainTextParams = stroopGame.getNextRandomMainTextParameters();

        Parameters leftButtonParam = stroopGame.getNextRandomLeftButtonParameters(mainTextParams, true);

        assertEquals(mainTextParams.getColor(), leftButtonParam.getColor());
    }

    @Test
    public void givenMainTextWhenLeftButtonShouldNotMatchColorThenLeftButtonHasNonMatchingColour() {

        Parameters mainTextParams = stroopGame.getNextRandomMainTextParameters();

        Parameters leftButtonParam = stroopGame.getNextRandomLeftButtonParameters(mainTextParams, false);

        assertNotEquals(mainTextParams.getColor(), leftButtonParam.getColor());
    }

    @Test
    public void givenWrongChoiceThenCorrectAnswerReutnsFalse() {
        Parameters mainTextParameters = stroopGame.getNextRandomMainTextParameters();

        Parameters usersAnswer = mainTextParameters.ofOppositeColour();

        assertFalse(stroopGame.isCorrectAnswer(mainTextParameters, usersAnswer));

    }

    @Test
    public void givenRightChoiceThenCorrectAnswerReutnsTrue() {
        Parameters mainTextParameters = stroopGame.getNextRandomMainTextParameters();

        Parameters usersAnswer = mainTextParameters.ofOppositText();

        assertTrue(stroopGame.isCorrectAnswer(mainTextParameters, usersAnswer));
    }

}