package com.github.cc3002.finalreality.model.weapon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.github.waripolo.finalreality.model.weapon.IWeapon;
import com.github.waripolo.finalreality.model.weapon.WeaponType.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WeaponTest {

  private static final String AXE_NAME = "Test Axe";
  private static final String STAFF_NAME = "Test Staff";
  private static final String SWORD_NAME = "Test Sword";
  private static final String BOW_NAME = "Test Bow";
  private static final String KNIFE_NAME = "Test Knife";
  private static final int DAMAGE = 15;
  private static final int SPEED = 10;

  private IWeapon testAxe;
  private IWeapon testStaff;
  private IWeapon testSword;
  private IWeapon testBow;
  private IWeapon testKnife;

  @BeforeEach
  void setUp() {
    testAxe = new Axe(AXE_NAME, DAMAGE, SPEED);
    testStaff = new Staff(STAFF_NAME, DAMAGE, SPEED);
    testSword = new Sword(SWORD_NAME, DAMAGE, SPEED);
    testBow = new Bow(BOW_NAME, DAMAGE, SPEED);
    testKnife = new Knife(KNIFE_NAME, DAMAGE, SPEED);
  }

  @Test
  void constructorTest() {
    var expectedAxe = new Axe(AXE_NAME, DAMAGE, SPEED);
    var expectedStaff = new Staff(STAFF_NAME, DAMAGE, SPEED);
    var expectedSword = new Sword(SWORD_NAME, DAMAGE, SPEED);
    var expectedBow = new Bow(BOW_NAME, DAMAGE, SPEED);
    var expectedKnife = new Knife(KNIFE_NAME, DAMAGE, SPEED);
    var notExpectedAxe = new Axe("Bad Axe", 3, 5);
    var notExpectedStaff = new Staff("Bad Staff", 3, 5);
    var notExpectedSword = new Sword("Bad Sword", 3, 5);
    var notExpectedBow = new Bow("Bad Bow", 3, 5);
    var notExpectedKnife = new Knife("Bad Knife", 3, 5);

    assertEquals(expectedAxe, testAxe);
    assertEquals(expectedAxe.hashCode(), testAxe.hashCode());
    assertEquals(expectedStaff, testStaff);
    assertEquals(expectedStaff.hashCode(), testStaff.hashCode());
    assertEquals(expectedSword, testSword);
    assertEquals(expectedSword.hashCode(), testSword.hashCode());
    assertEquals(expectedBow, testBow);
    assertEquals(expectedBow.hashCode(), testBow.hashCode());
    assertEquals(expectedKnife, testKnife);
    assertEquals(expectedKnife.hashCode(), testKnife.hashCode());
    assertNotEquals(notExpectedAxe, testAxe);
    assertNotEquals(notExpectedAxe.hashCode(), testAxe.hashCode());
    assertNotEquals(notExpectedStaff, testStaff);
    assertNotEquals(notExpectedStaff.hashCode(), testStaff.hashCode());
    assertNotEquals(notExpectedSword, testSword);
    assertNotEquals(notExpectedSword.hashCode(), testSword.hashCode());
    assertNotEquals(notExpectedBow, testBow);
    assertNotEquals(notExpectedBow.hashCode(), testBow.hashCode());
    assertNotEquals(notExpectedKnife, testKnife);
    assertNotEquals(notExpectedKnife.hashCode(), testKnife.hashCode());
  }
}