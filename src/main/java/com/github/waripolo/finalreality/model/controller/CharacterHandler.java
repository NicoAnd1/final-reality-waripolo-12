package com.github.waripolo.finalreality.model.controller;
import com.github.waripolo.finalreality.model.character.player.IPlayerCharacter;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Notifies when a character is dead and remove it from its list
 */
public class CharacterHandler implements PropertyChangeListener, IHandler {

    private final Controller controller;

    public CharacterHandler(Controller c) {
        this.controller = c;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        controller.eraseCharacter((IPlayerCharacter) evt.getNewValue());
    }
}
