package com.github.cc3002.finalreality.model.weapon.types;

import com.github.cc3002.finalreality.model.weapon.AbstractWeaponTest;
import com.github.waripolo.finalreality.model.character.Enemy;
import com.github.waripolo.finalreality.model.weapon.IWeapon;
import com.github.waripolo.finalreality.model.weapon.types.Staff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests to check the {@code Staff} class.
 *
 * @author Nicolás Fernández.
 * @see Staff
 */
public class StaffTest extends AbstractWeaponTest {

    private static final String STAFF_NAME = "Test Staff";
    private static final int DAMAGE = 15;
    private static final int SPEED = 10;
    private IWeapon testStaff;

    @BeforeEach
    void setUp() {
        testStaff = new Staff(STAFF_NAME, DAMAGE, SPEED);
    }

    @Test
    void constructorTest() {
        checkConstruction(new Staff(STAFF_NAME, DAMAGE, SPEED),
                testStaff, new Staff("Bad Staff", DAMAGE, SPEED));
    }
}