package com.github.waripolo.finalreality.model.weapon.types;

import com.github.waripolo.finalreality.model.character.player.IPlayerCharacter;
import com.github.waripolo.finalreality.model.weapon.AbstractWeapon;

/**
 * A class that holds the information of a Staff type weapon.
 *
 * @author Nicolás Fernández.
 */
public class Staff extends AbstractWeapon {

    /**
     * Creates a new Staff.
     */
    public Staff (final String name, final int attack, final int weight) {
        super(name, attack, weight);
    }

    /**
     * Equips a staff to a character
     *
     * @param character
     *     character that is equipping this weapon
     */
    public void equippedBy(IPlayerCharacter character) {
        character.equipStaff(this);
    }
}
