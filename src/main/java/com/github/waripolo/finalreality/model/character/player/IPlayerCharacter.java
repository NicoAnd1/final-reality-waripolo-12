package com.github.waripolo.finalreality.model.character.player;

import com.github.waripolo.finalreality.model.character.Enemy;
import com.github.waripolo.finalreality.model.character.ICharacter;
import com.github.waripolo.finalreality.controller.handlers.IHandler;
import com.github.waripolo.finalreality.model.weapon.IWeapon;

/**
 * This represents a character from the game controlled by the player
 *
 * @author Ignacio Slater Muñoz.
 * @author Nicolás Fernández.
 */
public interface IPlayerCharacter {

    /**
     * Attacks a character
     *
     * @param character
     *     character that is going to be attacked
     */
    void attack(ICharacter character);

    /**
     * This character is being attacked by an enemy
     *
     * @param enemy
     *     enemy that is attacking this character
     */
    void attackedByEnemy(Enemy enemy);

    /**
     * This character is being attacked by other character
     *
     * @param character
     *     character that is attacking this character
     */
    void attackedByCharacter(IPlayerCharacter character);

    /**
     * equips a weapon to the character
     */
    void equip(IWeapon weapon);

    /**
     * equips an axe to the character
     */
    void equipAxe(IWeapon axe);

    /**
     * equips a bow to the character
     */
    void equipBow(IWeapon bow);

    /**
     * equips a knife to the character
     */
    void equipKnife(IWeapon knife);

    /**
     * equips a staff to the character
     */
    void equipStaff(IWeapon staff);

    /**
     * equips a sword to the character
     */
    void equipSword(IWeapon sword);

    /**
     * Returns the equipped weapon for the character
     */
    IWeapon getEquippedWeapon();

    /**
     * Returns the life of the character
     */
    int getLife();

    /**
     * Returns the defense of the character
     */
    int getDefense();

    /**
     * Adds the character to the listener that notify when the character is alive
     */
    void addCharacterHandler(IHandler handler);

    /**
     * Adds the character to the listener that notify that the turn is over
     */
    void addCharacterTurnHandler(IHandler handler);

    /**
     * Returns the name of the character
     */
    String getName();

    //void addCharacterToQueue(IHandler handler);
}
