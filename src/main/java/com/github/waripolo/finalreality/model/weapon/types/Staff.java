package com.github.waripolo.finalreality.model.weapon.types;

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
}
