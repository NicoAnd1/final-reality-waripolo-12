package com.github.waripolo.finalreality.controller.handlers;

import java.beans.PropertyChangeListener;
import com.github.waripolo.finalreality.model.character.ICharacter;
import com.github.waripolo.finalreality.controller.GameController;

import java.beans.PropertyChangeEvent;

/**
 * Notifies when the turn is over
 */
public class TurnsHandler implements PropertyChangeListener, IHandler {

    private final GameController gameController;

    public TurnsHandler(GameController c) {
        this.gameController = c;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        gameController.turnFinished(/*(ICharacter) evt.getNewValue()*/);
    }
}
