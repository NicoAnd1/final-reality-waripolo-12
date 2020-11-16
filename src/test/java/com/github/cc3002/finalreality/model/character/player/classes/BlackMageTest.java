package com.github.cc3002.finalreality.model.character.player.classes;

import com.github.cc3002.finalreality.model.character.player.AbstractPlayerCharacterTest;
import com.github.waripolo.finalreality.model.character.Enemy;
import com.github.waripolo.finalreality.model.character.player.classes.BlackMage;
import com.github.waripolo.finalreality.model.character.player.classes.Knight;
import com.github.waripolo.finalreality.model.weapon.types.*;
import com.github.waripolo.finalreality.model.weapon.types.Sword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BlackMageTest extends AbstractPlayerCharacterTest {

    private static final String BLACK_MAGE_NAME = "Vivi";
    private BlackMage vivi;
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
        vivi = new BlackMage(BLACK_MAGE_NAME, 100, 50, turns, 100);
    }

    @Test
    void waitTurnTest() {
        vivi.equip(staff);
        checkWaitTurn(vivi);
    }

    @Test
    void constructorTest() {
        checkConstruction(new BlackMage(BLACK_MAGE_NAME, 100, 50, turns, 100),
                vivi,
                new BlackMage("Different name", 100, 50, turns, 100),
                new Knight(BLACK_MAGE_NAME, 100, 50, turns));
    }

    @Test
    void equippedWeaponTest() {
        //checkEquippedWeapon(vivi, staff);

        vivi.equipAxe(axe);
        assertNull(vivi.getEquippedWeapon());

        vivi.equipBow(bow);
        assertNull(vivi.getEquippedWeapon());

        vivi.equipKnife(knife);
        assertEquals(knife, vivi.getEquippedWeapon());

        vivi.equipStaff(staff);
        assertEquals(staff, vivi.getEquippedWeapon());

        vivi.equipSword(sword);
        assertNull(vivi.getEquippedWeapon());
    }

    @Test
    void attackTest() {
        vivi.equipStaff(staff);
        Enemy enemy = new Enemy("enemy", 100, 50, 10, turns);
        vivi.attack(enemy);
        enemy.getLife();

        enemy.attack(vivi);
        vivi.getLife();

        Staff bigStaff = new Staff("big staff", 150, 20);
        vivi.equipStaff(bigStaff);
        vivi.attack(enemy);
        enemy.getLife();
    }
}