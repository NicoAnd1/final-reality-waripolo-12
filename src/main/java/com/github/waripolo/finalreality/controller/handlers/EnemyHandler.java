package com.github.waripolo.finalreality.controller.handlers;
import com.github.waripolo.finalreality.model.character.ICharacter;
import com.github.waripolo.finalreality.controller.GameController;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Notifies when an enemy is dead and remove it from its list
 */
public class EnemyHandler implements PropertyChangeListener, IHandler {

    private final GameController gameController;

    public EnemyHandler(GameController c) {
        this.gameController = c;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        gameController.eraseEnemy((ICharacter) evt.getNewValue());
    }
}
