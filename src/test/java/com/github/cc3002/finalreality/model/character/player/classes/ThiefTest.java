package com.github.cc3002.finalreality.model.character.player.classes;

import com.github.cc3002.finalreality.model.character.player.AbstractPlayerCharacterTest;
import com.github.waripolo.finalreality.model.character.Enemy;
import com.github.waripolo.finalreality.model.character.player.IPlayerCharacter;
import com.github.waripolo.finalreality.model.character.player.classes.Knight;
import com.github.waripolo.finalreality.model.character.player.classes.Thief;
import com.github.waripolo.finalreality.model.character.player.classes.WhiteMage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests to check the {@code Thief} class.
 *
 * @author Nicolás Fernández.
 * @see Thief
 */
public class ThiefTest extends AbstractPlayerCharacterTest {

    private static final String THIEF_NAME = "Zidane";
    private Thief zidane;
    private WhiteMage whiteMage = new WhiteMage("name", 100, 50, turns);

    /**
     * Setup method.
     * Creates a new character named Vivi with 10 speed and links it to a turn queue.
     */
    @BeforeEach
    void setUp() {
        super.basicSetUp();
        zidane = new Thief(THIEF_NAME, 100, 50, turns);
    }

    /**
     * Checks that the character waits the appropriate amount of time for it's turn.
     */
    @Test
    void waitTurnTest() {
        zidane.equip(knife);
        checkWaitTurn(zidane);
    }

    /**
     * Checks the constructor
     */
    @Test
    void constructorTest() {
        checkConstruction(new Thief(THIEF_NAME, 100, 50, turns),
                zidane,
                new Thief("Different name", 100, 50, turns),
                new Knight(THIEF_NAME, 100, 50, turns));
    }

    /**
     * Checks that the character can equip weapons
     */
    @Test
    void equippedWeaponTest() {
        zidane.equip(bow);
        assertEquals(bow, zidane.getEquippedWeapon());

        zidane.equip(knife);
        assertEquals(knife, zidane.getEquippedWeapon());

        zidane.equip(sword);
        assertEquals(sword, zidane.getEquippedWeapon());

        zidane.equip(axe);
        assertNotEquals(axe, zidane.getEquippedWeapon());

        zidane.equip(staff);
        assertNotEquals(staff, zidane.getEquippedWeapon());
    }

    /**
     * Checks that the character attacks enemy
     */
    @Test
    void attackTest() {
        checkAttack(zidane, knife);
        zidane.attack((IPlayerCharacter) whiteMage);
    }

    /**
     * Checks that the character is alive
     */
    @Test
    void aliveTest() {
        checkIsAlive(zidane);
    }
}
