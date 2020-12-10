package com.github.waripolo.finalreality.model.controller;

import java.beans.PropertyChangeListener;
import com.github.waripolo.finalreality.model.character.ICharacter;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Notifies when the turn is over
 */
public class TurnsHandler implements PropertyChangeListener, IHandler {

    private final Controller controller;

    public TurnsHandler(Controller c) {
        this.controller = c;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        controller.turnFinished((ICharacter) evt.getNewValue());
    }
}
