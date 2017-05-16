package com.stroopgame;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
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
    public void givenRightButtonTextShouldMatchColourOfMainTextThenGameParameterObjectContainsRightButtonWithCorrectText() {

        boolean shouldRightButtonMatchMainColour = true;
        Parameters mainText = new Parameters(Parameters.Text.BLUE, Parameters.Colour.RED);

        GameParameterObjects gameParameterObjects = stroopGame.generateNextGameState(mainText, shouldRightButtonMatchMainColour);

        assertTrue(gameParameterObjects.getRightButton().getText() == Parameters.Text.RED);
        assertTrue(gameParameterObjects.getLeftButton().getText() == Parameters.Text.BLUE);
    }

    @Test
    public void givenRightButtonTextShouldNotMatchColourOfMainTextThenGameParameterObjectContainsRightButtonWithCorrectText() {

        boolean shouldRightButtonMatchMainColour = false;
        Parameters mainText = new Parameters(Parameters.Text.BLUE, Parameters.Colour.RED);

        GameParameterObjects gameParameterObjects = stroopGame.generateNextGameState(mainText, shouldRightButtonMatchMainColour);

        assertTrue(gameParameterObjects.getLeftButton().getText() == Parameters.Text.RED);
        assertTrue(gameParameterObjects.getRightButton().getText() == Parameters.Text.BLUE);
    }

    @Test
    public void givenUserSelectedCorrectlyThenIsCorrectAnswerReturnsTrue() {

        Parameters mainText = new Parameters(Parameters.Text.BLUE, Parameters.Colour.RED);
        Parameters usersAnswer = new Parameters(Parameters.Text.RED, Parameters.Colour.BLUE);

        assertTrue(stroopGame.isCorrectAnswer(mainText, usersAnswer));

        mainText = new Parameters(Parameters.Text.BLUE, Parameters.Colour.BLUE);
        usersAnswer = new Parameters(Parameters.Text.BLUE, Parameters.Colour.BLUE);

        assertTrue(stroopGame.isCorrectAnswer(mainText, usersAnswer));

    }

    @Test
    public void givenUserSelectedIncorrectlyThenIsCorrectAnswerReturnsTrue() {

        Parameters mainText = new Parameters(Parameters.Text.BLUE, Parameters.Colour.RED);
        Parameters usersAnswer = new Parameters(Parameters.Text.BLUE, Parameters.Colour.BLUE);

        assertFalse(stroopGame.isCorrectAnswer(mainText, usersAnswer));
    }


}