package com.github.cc3002.finalreality.model.character.player.classes;

import com.github.cc3002.finalreality.model.character.player.AbstractPlayerCharacterTest;
import com.github.waripolo.finalreality.model.character.Enemy;
import com.github.waripolo.finalreality.model.character.player.classes.Engineer;
import com.github.waripolo.finalreality.model.character.player.classes.Knight;
import com.github.waripolo.finalreality.model.weapon.types.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class EngineerTest extends AbstractPlayerCharacterTest {

    private static final String ENGINEER_NAME = "Cid";
    private Engineer cid;
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
        cid = new Engineer(ENGINEER_NAME, 100, 50, turns);
    }

    @Test
    void waitTurnTest() {
        cid.equip(bow);
        checkWaitTurn(cid);
    }

    @Test
    void constructorTest() {
        checkConstruction(new Engineer(ENGINEER_NAME, 100, 50, turns),
                cid,
                new Engineer("Different name", 100, 50, turns),
                new Knight(ENGINEER_NAME, 100, 50, turns));
    }

    @Test
    void equippedWeaponTest() {
        //checkEquippedWeapon(cid, bow);

        cid.equipAxe(axe);
        assertEquals(axe, cid.getEquippedWeapon());

        cid.equipBow(bow);
        assertEquals(bow, cid.getEquippedWeapon());

        cid.equipKnife(knife);
        assertNull(cid.getEquippedWeapon());

        cid.equipStaff(staff);
        assertNull(cid.getEquippedWeapon());

        cid.equipSword(sword);
        assertNull(cid.getEquippedWeapon());
    }

    @Test
    void attackTest() {
        cid.equipBow(bow);
        Enemy enemy = new Enemy("enemy", 100, 50, 10, turns);
        cid.attack(enemy);
        enemy.getLife();

        enemy.attack(cid);
        cid.getLife();

        Bow bigBow = new Bow("big bow", 150, 20);
        cid.equipBow(bigBow);
        cid.attack(enemy);
        enemy.getLife();

    }
}