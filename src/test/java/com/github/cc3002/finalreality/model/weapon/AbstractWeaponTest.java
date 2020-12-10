package com.github.cc3002.finalreality.model.weapon;

import com.github.waripolo.finalreality.model.weapon.IWeapon;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Abstract class containing the common tests for all the types of weapons
 *
 * @author Ignacio Slater Muñoz.
 * @author Nicolás Fernández.
 * @see IWeapon
 */
public abstract class AbstractWeaponTest {

    protected void checkConstruction(final IWeapon expectedWeapon,
        final IWeapon testEqualWeapon,
        final IWeapon testNotEqualWeapon) {
      assertEquals(expectedWeapon, testEqualWeapon);
      assertEquals(expectedWeapon.hashCode(), testEqualWeapon.hashCode());
      assertNotEquals(testNotEqualWeapon, testEqualWeapon);
      assertNotEquals(testNotEqualWeapon.hashCode(), testEqualWeapon.hashCode());
    }
}
