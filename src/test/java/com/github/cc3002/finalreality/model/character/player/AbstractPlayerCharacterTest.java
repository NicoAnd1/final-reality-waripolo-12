package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.AbstractCharacterTest;
import com.github.waripolo.finalreality.model.character.Enemy;
import com.github.waripolo.finalreality.model.character.ICharacter;
import com.github.waripolo.finalreality.model.character.player.IPlayerCharacter;
import com.github.waripolo.finalreality.model.weapon.IWeapon;
import com.github.waripolo.finalreality.model.weapon.types.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Abstract class containing the common tests for the types of player's characters.
 *
 * @author Ignacio Slater Muñoz.
 * @author Nicolás Fernández.
 * @see IPlayerCharacter
 */
public abstract class AbstractPlayerCharacterTest extends AbstractCharacterTest {

    protected final Axe axe = new Axe("axe", 1, 10);
    protected final Bow bow = new Bow("bow", 1, 10);
    protected final Knife knife = new Knife("knife", 1, 10);
    protected final Staff staff = new Staff("staff", 1, 10);
    protected final Sword sword = new Sword("sword", 1, 10);

    Enemy enemy = new Enemy("enemy", 100, 50, 20,10, turns);

    /**
     * Checks that a character attacks an enemy
     *
     * @param character
     *     character that is being tested
     * @param weapon
     *     weapon equipped by the character
     */
    protected void checkAttack(IPlayerCharacter character, IWeapon weapon) {
        character.equip(weapon);

        assertEquals(100, enemy.getLife());
        assertEquals(50, enemy.getDefense());

        character.attack(enemy);

        assertEquals(100, enemy.getLife());
        assertNotEquals(50, enemy.getDefense());
    }
}