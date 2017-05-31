package com.stroopgame;

import com.stroopgame.ui.element.LeftButton;
import com.stroopgame.ui.element.MainText;
import com.stroopgame.ui.element.RightButton;

public class GameObjects {

    private final LeftButton leftButton;
    private final RightButton rightButton;
    private final MainText mainText;

    public GameObjects( LeftButton leftButton, RightButton rightButton, MainText mainText ) {
        this.leftButton = leftButton;
        this.rightButton = rightButton;
        this.mainText = mainText;
    }

    public LeftButton getLeftButton( ) {
        return leftButton;
    }

    public RightButton getRightButton( ) {
        return rightButton;
    }

    public MainText getMainText( ) {
        return mainText;
    }
}
