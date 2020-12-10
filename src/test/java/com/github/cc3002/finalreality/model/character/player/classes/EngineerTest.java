package com.github.cc3002.finalreality.model.character.player.classes;

import com.github.cc3002.finalreality.model.character.player.AbstractPlayerCharacterTest;
import com.github.waripolo.finalreality.model.character.Enemy;
import com.github.waripolo.finalreality.model.character.player.IPlayerCharacter;
import com.github.waripolo.finalreality.model.character.player.classes.Engineer;
import com.github.waripolo.finalreality.model.character.player.classes.Knight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests to check the {@code Engineer} class.
 *
 * @author Nicolás Fernández.
 * @see Engineer
 */
public class EngineerTest extends AbstractPlayerCharacterTest {

    private static final String ENGINEER_NAME = "Cid";
    private Engineer cid;
    private Knight knight = new Knight("name", 100, 50, turns);

    /**
     * Setup method.
     * Creates a new character named Adelbert with 10 speed and links it to a turn queue.
     */
    @BeforeEach
    void setUp() {
        super.basicSetUp();
        cid = new Engineer(ENGINEER_NAME, 100, 50, turns);
    }

    /**
     * Checks that the character waits the appropriate amount of time for it's turn.
     */
    @Test
    void waitTurnTest() {
        cid.equip(bow);
        checkWaitTurn(cid);
    }

    /**
     * Checks the constructor
     */
    @Test
    void constructorTest() {
        checkConstruction(new Engineer(ENGINEER_NAME, 100, 50, turns),
                cid,
                new Engineer("Different name", 100, 50, turns),
                new Knight(ENGINEER_NAME, 100, 50, turns));
    }

    /**
     * Checks that the character can equip weapons
     */
    @Test
    void equippedWeaponTest() {
        cid.equip(axe);
        assertEquals(axe, cid.getEquippedWeapon());

        cid.equip(bow);
        assertEquals(bow, cid.getEquippedWeapon());

        cid.equip(knife);
        assertNotEquals(knife, cid.getEquippedWeapon());

        cid.equip(staff);
        assertNotEquals(staff, cid.getEquippedWeapon());

        cid.equip(sword);
        assertNotEquals(sword, cid.getEquippedWeapon());
    }

    /**
     * Checks that the character attacks an enemy
     */
    @Test
    void attackTest() {
        checkAttack(cid, bow);
        cid.attack((IPlayerCharacter) knight);
    }

    /**
     * Checks that the character is alive
     */
    @Test
    void aliveTest() {
        checkIsAlive(cid);
    }
}