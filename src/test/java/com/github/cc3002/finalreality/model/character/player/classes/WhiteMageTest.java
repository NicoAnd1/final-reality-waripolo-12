package com.github.cc3002.finalreality.model.character.player.classes;

import com.github.cc3002.finalreality.model.character.player.AbstractPlayerCharacterTest;
import com.github.waripolo.finalreality.model.character.Enemy;
import com.github.waripolo.finalreality.model.character.player.classes.Knight;
import com.github.waripolo.finalreality.model.character.player.classes.WhiteMage;
import com.github.waripolo.finalreality.model.weapon.types.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class WhiteMageTest extends AbstractPlayerCharacterTest {

    private static final String WHITE_MAGE_NAME = "Eiko";
    private WhiteMage eiko;
    private final Axe axe = new Axe("axe", 1, 10);
    private final Bow bow = new Bow("bow", 1, 10);
    private final Knife knife = new Knife("knife", 1, 10);
    private final Staff staff = new Staff("staff", 1, 10);
    private final Sword sword = new Sword("sword", 1, 10);

    /**
     * Setup method.
     * Creates a new character named Vivi with 10 speed and links it to a turn queue.
     */
    @BeforeEach
    void setUp() {
        super.basicSetUp();
        eiko = new WhiteMage(WHITE_MAGE_NAME, 100, 50, turns, 100);
    }

    @Test
    void waitTurnTest() {
        eiko.equip(staff);
        checkWaitTurn(eiko);
    }

    @Test
    void constructorTest() {
        checkConstruction(new WhiteMage(WHITE_MAGE_NAME, 100, 50, turns, 100),
                eiko,
                new WhiteMage("Different name", 100, 50, turns, 100),
                new Knight(WHITE_MAGE_NAME, 100, 50, turns));
    }

    @Test
    void equippedWeaponTest() {
        //checkEquippedWeapon(eiko, staff);

        eiko.equipAxe(axe);
        assertNull(eiko.getEquippedWeapon());

        eiko.equipBow(bow);
        assertNull(eiko.getEquippedWeapon());

        eiko.equipKnife(knife);
        assertNull(eiko.getEquippedWeapon());

        eiko.equipStaff(staff);
        assertEquals(staff, eiko.getEquippedWeapon());

        eiko.equipSword(sword);
        assertNull(eiko.getEquippedWeapon());
    }

    @Test
    void attackTest() {
        eiko.equipStaff(staff);
        Enemy enemy = new Enemy("enemy", 100, 50, 10, turns);
        eiko.attack(enemy);
        enemy.getLife();

        enemy.attack(eiko);
        eiko.getLife();

        Staff bigStaff = new Staff("big staff", 150, 20);
        eiko.equipStaff(bigStaff);
        eiko.attack(enemy);
        enemy.getLife();
    }
}