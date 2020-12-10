package com.github.cc3002.finalreality.model.character.player.classes;

import com.github.cc3002.finalreality.model.character.player.AbstractPlayerCharacterTest;
import com.github.waripolo.finalreality.model.character.Enemy;
import com.github.waripolo.finalreality.model.character.player.IPlayerCharacter;
import com.github.waripolo.finalreality.model.character.player.classes.BlackMage;
import com.github.waripolo.finalreality.model.character.player.classes.Knight;
import com.github.waripolo.finalreality.model.character.player.classes.WhiteMage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests to check the {@code WhiteMage} class.
 *
 * @author Nicolás Fernández.
 * @see WhiteMage
 */
public class WhiteMageTest extends AbstractPlayerCharacterTest {

    private static final String WHITE_MAGE_NAME = "Eiko";
    private WhiteMage eiko;
    private BlackMage blackMage = new BlackMage("name", 100, 50, turns, 100);

    /**
     * Setup method.
     * Creates a new character named Vivi with 10 speed and links it to a turn queue.
     */
    @BeforeEach
    void setUp() {
        super.basicSetUp();
        eiko = new WhiteMage(WHITE_MAGE_NAME, 100, 50, turns, 100);
    }

    /**
     * Checks that the character waits the appropriate amount of time for it's turn.
     */
    @Test
    void waitTurnTest() {
        eiko.equip(staff);
        checkWaitTurn(eiko);
    }

    /**
     * Checks the constructor
     */
    @Test
    void constructorTest() {
        checkConstruction(new WhiteMage(WHITE_MAGE_NAME, 100, 50, turns, 100),
                eiko,
                new WhiteMage("Different name", 100, 50, turns, 100),
                new Knight(WHITE_MAGE_NAME, 100, 50, turns));
    }

    /**
     * Checks that the character can equip weapons
     */
    @Test
    void equippedWeaponTest() {
        eiko.equip(staff);
        assertEquals(staff, eiko.getEquippedWeapon());

        eiko.equip(axe);
        assertNotEquals(axe, eiko.getEquippedWeapon());

        eiko.equip(bow);
        assertNotEquals(bow, eiko.getEquippedWeapon());

        eiko.equip(knife);
        assertNotEquals(knife, eiko.getEquippedWeapon());

        eiko.equip(sword);
        assertNotEquals(sword, eiko.getEquippedWeapon());
    }

    /**
     * Checks that the character attacks enemy
     */
    @Test
    void attackTest() {
        checkAttack(eiko, staff);
        eiko.attack((IPlayerCharacter) blackMage);
    }

    /**
     * Checks that the character is alive
     */
    @Test
    void aliveTest() {
        checkIsAlive(eiko);
    }
}