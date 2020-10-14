package com.github.waripolo.finalreality.model.weapon.types;

import com.github.waripolo.finalreality.model.weapon.AbstractWeapon;

/**
 * A class that holds the information of a Knife type weapon.
 *
 * @author Nicolás Fernández.
 */
public class Knife extends AbstractWeapon {

    /**
     * Creates a new Knife.
     */
    public Knife (final String name, final int attack, final int weight) {
        super(name, attack, weight);
    }
}
