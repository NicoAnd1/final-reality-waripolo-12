package com.github.waripolo.finalreality.controller.handlers;
import com.github.waripolo.finalreality.model.character.player.IPlayerCharacter;
import com.github.waripolo.finalreality.controller.GameController;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Notifies when a character is dead and remove it from its list
 */
public class CharacterHandler implements PropertyChangeListener, IHandler {

    private final GameController gameController;

    public CharacterHandler(GameController c) {
        this.gameController = c;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        gameController.eraseCharacter((IPlayerCharacter) evt.getNewValue());
    }
}
