package com.github.cc3002.finalreality.model.character.player.classes;

import com.github.cc3002.finalreality.model.character.player.AbstractPlayerCharacterTest;
import com.github.waripolo.finalreality.model.character.Enemy;
import com.github.waripolo.finalreality.model.character.player.IPlayerCharacter;
import com.github.waripolo.finalreality.model.character.player.classes.BlackMage;
import com.github.waripolo.finalreality.model.character.player.classes.Engineer;
import com.github.waripolo.finalreality.model.character.player.classes.Knight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests to check the {@code BlackMage} class.
 *
 * @author Nicolás Fernández.
 * @see BlackMage
 */
public class BlackMageTest extends AbstractPlayerCharacterTest {

    private static final String BLACK_MAGE_NAME = "Vivi";
    private BlackMage vivi;
    private Engineer engineer = new Engineer("name", 100, 50, turns);


    /**
     * Setup method.
     * Creates a new character named Vivi with 10 speed and links it to a turn queue.
     */
    @BeforeEach
    void setUp() {
        super.basicSetUp();
        vivi = new BlackMage(BLACK_MAGE_NAME, 100, 50, turns, 100);
    }

    /**
     * Checks that the character waits the appropriate amount of time for it's turn.
     */
    @Test
    void waitTurnTest() {
        vivi.equip(staff);
        checkWaitTurn(vivi);
    }

    /**
     * Checks the constructor
     */
    @Test
    void constructorTest() {
        checkConstruction(new BlackMage(BLACK_MAGE_NAME, 100, 50, turns, 100),
                vivi,
                new BlackMage("Different name", 100, 50, turns, 100),
                new Knight(BLACK_MAGE_NAME, 100, 50, turns));
    }

    /**
     * Checks that the character can equip weapons
     */
    @Test
    void equippedWeaponTest() {
        vivi.equip(staff);
        assertEquals(staff, vivi.getEquippedWeapon());

        vivi.equip(knife);
        assertEquals(knife, vivi.getEquippedWeapon());

        vivi.equip(axe);
        assertNotEquals(axe, vivi.getEquippedWeapon());

        vivi.equip(bow);
        assertNotEquals(bow, vivi.getEquippedWeapon());

        vivi.equip(sword);
        assertNotEquals(sword, vivi.getEquippedWeapon());
    }

    /**
     * Checks that the character attacks an enemy, and another character
     */
    @Test
    void attackTest() {
        checkAttack(vivi, staff);
        vivi.attack((IPlayerCharacter) engineer);
    }

    /**
     * Checks that the character is alive
     */
    @Test
    void aliveTest() {
        checkIsAlive(vivi);
    }
}