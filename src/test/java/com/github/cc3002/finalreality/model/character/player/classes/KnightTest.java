package com.github.cc3002.finalreality.model.character.player.classes;

import com.github.cc3002.finalreality.model.character.player.AbstractPlayerCharacterTest;
import com.github.waripolo.finalreality.model.character.Enemy;
import com.github.waripolo.finalreality.model.character.player.IPlayerCharacter;
import com.github.waripolo.finalreality.model.character.player.classes.Knight;
import com.github.waripolo.finalreality.model.character.player.classes.Thief;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests to check the {@code Knight} class.
 *
 * @author Nicolás Fernández.
 * @see Knight
 */
public class KnightTest extends AbstractPlayerCharacterTest {

    private static final String ENGINEER_NAME = "Adelbert";
    private Knight adelbert;
    private Thief thief = new Thief("name", 100, 50, turns);

    /**
     * Setup method.
     * Creates a new character named Adelbert with 10 speed and links it to a turn queue.
     */
    @BeforeEach
    void setUp() {
        super.basicSetUp();
        adelbert = new Knight(ENGINEER_NAME, 100, 50, turns);
    }

    /**
     * Checks that the character waits the appropriate amount of time for it's turn.
     */
    @Test
    void waitTurnTest() {
        adelbert.equip(sword);
        checkWaitTurn(adelbert);
    }

    /**
     * Checks the constructor
     */
    @Test
    void constructorTest() {
        checkConstruction(new Knight(ENGINEER_NAME, 100, 50, turns),
                adelbert,
                new Knight("Different name", 100, 50, turns),
                new Thief(ENGINEER_NAME, 100,50, turns));
    }

    /**
     * Checks that the character can equip weapons
     */
    @Test
    void equippedWeaponTest() {
        adelbert.equip(axe);
        assertEquals(axe, adelbert.getEquippedWeapon());

        adelbert.equip(knife);
        assertEquals(knife, adelbert.getEquippedWeapon());

        adelbert.equip(sword);
        assertEquals(sword, adelbert.getEquippedWeapon());

        adelbert.equip(bow);
        assertNotEquals(bow, adelbert.getEquippedWeapon());

        adelbert.equip(staff);
        assertNotEquals(staff, adelbert.getEquippedWeapon());
    }

    /**
     * Checks that the character attacks enemy
     */
    @Test
    void attackTest() {
        checkAttack(adelbert, sword);
        adelbert.attack((IPlayerCharacter) thief);
    }

    /**
     * Checks that the character is alive
     */
    @Test
    void aliveTest() {
        checkIsAlive(adelbert);
    }
}
