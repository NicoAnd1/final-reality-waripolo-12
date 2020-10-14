package com.github.cc3002.finalreality.model.character;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.github.waripolo.finalreality.model.character.ICharacter;
import com.github.waripolo.finalreality.model.character.player.PlayerCharacter;
import com.github.waripolo.finalreality.model.weapon.IWeapon;
import com.github.waripolo.finalreality.model.weapon.types.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Abstract class containing the common tests for all the types of characters.
 *
 * @author Ignacio Slater Muñoz.
 * @author Nicolás Fernández.
 * @see ICharacter
 */
public abstract class AbstractCharacterTest {

  protected BlockingQueue<ICharacter> turns;
  protected List<PlayerCharacter> testPlayerCharacters;
  protected IWeapon testWeapon;

  /**
   * Try to equip a weapon to a character
   *
   * @param character
   *     character who will try to equip a weapon
   */
  protected void tryToEquip(PlayerCharacter character) {
    character.equip(testWeapon);
  }

  /**
   * Checks that the class's constructor and equals method works properly.
   *
   * @param expectedCharacter
   *     the character class that is expected.
   * @param testEqualCharacter
   *     the character to check the equal method.
   * @param sameClassDifferentCharacter
   *     a character of the same class that the expected, but with different parameters.
   * @param differentClassCharacter
   *     a different class character than the expected.
   */
  protected void checkConstruction(final ICharacter expectedCharacter,
      final ICharacter testEqualCharacter,
      final ICharacter sameClassDifferentCharacter,
      final ICharacter differentClassCharacter) {
    assertEquals(expectedCharacter, testEqualCharacter);
    assertNotEquals(sameClassDifferentCharacter, testEqualCharacter);
    assertNotEquals(testEqualCharacter, differentClassCharacter);
    assertEquals(expectedCharacter.hashCode(), testEqualCharacter.hashCode());
  }

  /**
   * Creates a turns queue, a test weapon of type Axe, and a list of characters.
   */
  protected void basicSetUp() {
    turns = new LinkedBlockingQueue<>();
    testWeapon = new Axe("Test", 15, 10);
    testPlayerCharacters = new ArrayList<>();
  }
}
