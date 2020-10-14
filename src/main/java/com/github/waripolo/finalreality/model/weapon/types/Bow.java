package com.github.waripolo.finalreality.model.weapon.types;

import com.github.waripolo.finalreality.model.weapon.AbstractWeapon;

/**
 * A class that holds the information of a Bow type weapon.
 *
 * @author Nicolás Fernández.
 */
public class Bow extends AbstractWeapon {

    /**
     * Creates a new Bow.
     */
    public Bow (final String name, final int attack, final int weight) {
        super(name, attack, weight);
    }
}
