package com.github.waripolo.finalreality.model.weapon.types;

import com.github.waripolo.finalreality.model.weapon.AbstractWeapon;

/**
 * A class that holds the information of an Axe type weapon.
 *
 * @author Nicolás Fernández.
 */
public class Axe extends AbstractWeapon {

    /**
     * Creates a new Axe.
    */
    public Axe (final String name, final int attack, final int weight) {
        super(name, attack, weight);
    }
}
