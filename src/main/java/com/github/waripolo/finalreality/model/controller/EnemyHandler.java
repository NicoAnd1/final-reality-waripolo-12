package com.github.waripolo.finalreality.model.controller;
import com.github.waripolo.finalreality.model.character.ICharacter;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Notifies when an enemy is dead and remove it from its list
 */
public class EnemyHandler implements PropertyChangeListener, IHandler {

    private final Controller controller;

    public EnemyHandler(Controller c) {
        this.controller = c;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        controller.eraseEnemy((ICharacter) evt.getNewValue());
    }
}
