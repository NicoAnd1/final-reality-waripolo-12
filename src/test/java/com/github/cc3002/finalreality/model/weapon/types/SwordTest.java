package com.github.cc3002.finalreality.model.weapon.types;

import com.github.cc3002.finalreality.model.weapon.AbstractWeaponTest;
import com.github.waripolo.finalreality.model.weapon.IWeapon;
import com.github.waripolo.finalreality.model.weapon.types.Sword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SwordTest extends AbstractWeaponTest {

    private static final String SWORD_NAME = "Test Sword";
    private static final int DAMAGE = 15;
    private static final int SPEED = 10;
    private IWeapon testSword;

    @BeforeEach
    void setUp() {
        testSword = new Sword(SWORD_NAME, DAMAGE, SPEED);
    }

    @Test
    void constructorTest() {
        checkConstruction(new Sword(SWORD_NAME, DAMAGE, SPEED),
                testSword, new Sword("Bad Sword", DAMAGE, SPEED));
    }
}