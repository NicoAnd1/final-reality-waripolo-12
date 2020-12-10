package com.github.cc3002.finalreality.model.character.player.classes;

import com.github.cc3002.finalreality.model.character.player.AbstractPlayerCharacterTest;
import com.github.waripolo.finalreality.model.character.Enemy;
import com.github.waripolo.finalreality.model.character.player.classes.Knight;
import com.github.waripolo.finalreality.model.character.player.classes.Thief;
import com.github.waripolo.finalreality.model.weapon.types.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class KnightTest extends AbstractPlayerCharacterTest {

    private static final String ENGINEER_NAME = "Adelbert";
    private Knight adelbert;
    private final Axe axe = new Axe("axe", 1, 10);
    private final Bow bow = new Bow("bow", 1, 10);
    private final Knife knife = new Knife("knife", 1, 10);
    private final Staff staff = new Staff("staff", 1, 10);
    private final Sword sword = new Sword("sword", 1, 10);

    /**
     * Setup method.
     * Creates a new character named Adelbert with 10 speed and links it to a turn queue.
     */
    @BeforeEach
    void setUp() {
        super.basicSetUp();
        adelbert = new Knight(ENGINEER_NAME, 100, 50, turns);
    }

    @Test
    void waitTurnTest() {
        adelbert.equip(sword);
        checkWaitTurn(adelbert);
    }

    @Test
    void constructorTest() {
        checkConstruction(new Knight(ENGINEER_NAME, 100, 50, turns),
                adelbert,
                new Knight("Different name", 100, 50, turns),
                new Thief(ENGINEER_NAME, 100,50, turns));
    }

    @Test
    void equippedWeaponTest() {
        //checkEquippedWeapon(adelbert, sword);

        adelbert.equipAxe(axe);
        assertEquals(axe, adelbert.getEquippedWeapon());

        adelbert.equipBow(bow);
        assertNull(adelbert.getEquippedWeapon());

        adelbert.equipKnife(knife);
        assertEquals(knife, adelbert.getEquippedWeapon());

        adelbert.equipStaff(staff);
        assertNull(adelbert.getEquippedWeapon());

        adelbert.equipSword(sword);
        assertEquals(sword, adelbert.getEquippedWeapon());
    }

    @Test
    void attackTest() {
        adelbert.equipSword(sword);
        Enemy enemy = new Enemy("enemy", 100, 50, 10, turns);
        adelbert.attack(enemy);
        enemy.getLife();

        enemy.attack(adelbert);
        adelbert.getLife();

        Sword bigSword = new Sword("big sword", 150, 20);
        adelbert.equipSword(bigSword);
        adelbert.attack(enemy);
        enemy.getLife();
    }
}
