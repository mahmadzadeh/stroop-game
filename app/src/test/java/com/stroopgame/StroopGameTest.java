package com.stroopgame;

import org.junit.Test;

import static com.stroopgame.StatefulGameObject.ColourState.BlueColour;
import static com.stroopgame.StatefulGameObject.ColourState.RedColour;
import static com.stroopgame.StatefulGameObject.TextState.BlueText;
import static com.stroopgame.StatefulGameObject.TextState.RedText;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class StroopGameTest {

    StroopGame stroopGame = new StroopGame();

    @Test
    public void givenStroopGameThenGetMainTextAndColorReturnsValue() {
        MainText parameters = stroopGame.getNextRandomMainText();

        assertNotNull(parameters);
    }

    @Test
    public void givenRightButtonTextShouldMatchColourOfMainTextThenGameParameterObjectContainsRightButtonWithCorrectText() {

        boolean shouldRightButtonMatchMainColour = true;
        MainText mainText = new MainText(BlueText, RedColour);

        GameObjects gameObjects = stroopGame.generateNextGameState(mainText, shouldRightButtonMatchMainColour);

        assertTrue(gameObjects.getRightButton().getTextState() == RedText);
        assertTrue(gameObjects.getLeftButton().getTextState() == BlueText);
    }

    @Test
    public void givenRightButtonTextShouldNotMatchColourOfMainTextThenGameParameterObjectContainsRightButtonWithCorrectText() {

        boolean shouldRightButtonMatchMainColour = false;
        MainText mainText = new MainText(BlueText, RedColour);

        GameObjects gameParameterObjects = stroopGame.generateNextGameState(mainText, shouldRightButtonMatchMainColour);

        assertTrue(gameParameterObjects.getLeftButton().getTextState() == RedText);
        assertTrue(gameParameterObjects.getRightButton().getTextState() == BlueText);
    }

    @Test
    public void givenUserSelectedCorrectlyThenIsCorrectAnswerReturnsTrue() {

        MainText mainText = new MainText(BlueText, RedColour);
        StatefulButton usersAnswer = new RightButton(RedText, BlueColour);

        assertTrue(stroopGame.evaluateAnswer(mainText, usersAnswer));

        mainText = new MainText(BlueText, BlueColour);
        usersAnswer = new RightButton(BlueText, BlueColour);

        assertTrue(stroopGame.evaluateAnswer(mainText, usersAnswer));

    }

    @Test
    public void givenUserSelectedIncorrectlyThenIsCorrectAnswerReturnsTrue() {

        MainText mainText = new MainText(BlueText, RedColour);

        StatefulButton usersAnswer = new RightButton(BlueText, BlueColour);

        assertFalse(stroopGame.evaluateAnswer(mainText, usersAnswer));
    }


}