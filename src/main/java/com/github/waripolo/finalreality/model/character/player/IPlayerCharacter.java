package com.github.waripolo.finalreality.model.character.player;

import com.github.waripolo.finalreality.model.weapon.IWeapon;

public interface IPlayerCharacter {

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

}
