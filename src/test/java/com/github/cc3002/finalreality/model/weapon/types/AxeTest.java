package com.github.cc3002.finalreality.model.weapon.types;

import com.github.cc3002.finalreality.model.weapon.AbstractWeaponTest;
import com.github.waripolo.finalreality.model.character.Enemy;
import com.github.waripolo.finalreality.model.weapon.IWeapon;
import com.github.waripolo.finalreality.model.weapon.types.Axe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests to check the {@code Axe} class.
 *
 * @author Nicolás Fernández.
 * @see Axe
 */
public class AxeTest extends AbstractWeaponTest {

    private static final String AXE_NAME = "Test Axe";
    private static final int DAMAGE = 15;
    private static final int SPEED = 10;
    private IWeapon testAxe;

    @BeforeEach
    void setUp() {
        testAxe = new Axe(AXE_NAME, DAMAGE, SPEED);
    }

    @Test
    void constructorTest() {
        checkConstruction(new Axe(AXE_NAME, DAMAGE, SPEED),
                testAxe, new Axe("Bad Axe", DAMAGE, SPEED));
    }
}