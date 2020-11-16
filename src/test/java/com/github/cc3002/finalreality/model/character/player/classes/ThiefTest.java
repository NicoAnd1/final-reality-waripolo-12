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

public class ThiefTest extends AbstractPlayerCharacterTest {

    private static final String THIEF_NAME = "Zidane";
    private Thief zidane;
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
        zidane = new Thief(THIEF_NAME, 100, 50, turns);
    }

    @Test
    void waitTurnTest() {
        zidane.equip(knife);
        checkWaitTurn(zidane);
    }

    @Test
    void constructorTest() {
        checkConstruction(new Thief(THIEF_NAME, 100, 50, turns),
                zidane,
                new Thief("Different name", 100, 50, turns),
                new Knight(THIEF_NAME, 100, 50, turns));
    }

    @Test
    void equippedWeaponTest() {
        //checkEquippedWeapon(zidane, knife);

        zidane.equipAxe(axe);
        assertNull(zidane.getEquippedWeapon());

        zidane.equipBow(bow);
        assertEquals(bow, zidane.getEquippedWeapon());

        zidane.equipKnife(knife);
        assertEquals(knife, zidane.getEquippedWeapon());

        zidane.equipStaff(staff);
        assertNull(zidane.getEquippedWeapon());

        zidane.equipSword(sword);
        assertEquals(sword, zidane.getEquippedWeapon());
    }

    @Test
    void attackTest() {
        zidane.equipKnife(knife);
        Enemy enemy = new Enemy("enemy", 100, 50, 10, turns);
        zidane.attack(enemy);
        enemy.getLife();

        enemy.attack(zidane);
        zidane.getLife();

        Knife bigKnife = new Knife("big knife", 150, 20);
        zidane.equipKnife(bigKnife);
        zidane.attack(enemy);
        enemy.getLife();
    }
}
