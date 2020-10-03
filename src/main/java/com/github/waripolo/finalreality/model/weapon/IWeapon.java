package com.github.waripolo.finalreality.model.weapon;

/**
 * This represents a weapon from the game.
 * Depending on the character's class, a weapon can be or not be equipped by that character.
 *
 * @author Nicolás Fernández
 */
public interface IWeapon {

    /**
     * Returns its weapon's name.
     */

    String getName();

    /**
     * Returns its weapon's damage.
     */
    int getAttack();

    /**
     * Returns its weapon's weight.
     */
    int getWeight();
}
