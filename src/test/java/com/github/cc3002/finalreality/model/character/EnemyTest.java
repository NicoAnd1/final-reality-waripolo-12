package com.github.cc3002.finalreality.model.character;

import com.github.waripolo.finalreality.model.character.Enemy;
//import com.github.waripolo.finalreality.model.character.player.CharacterClass;
//import com.github.waripolo.finalreality.model.character.player.PlayerCharacter;
import com.github.waripolo.finalreality.model.character.player.classes.Thief;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests to check the {@code Enemy} class.
 *
 * @author Nicolás Fernández.
 * @see Enemy
 */
class EnemyTest extends AbstractCharacterTest {

  private static final String ENEMY_NAME = "Goblin";
  protected Enemy testEnemy;

  /**
   * Creates a new enemy named Goblin with 10 weight and links it to the queue.
   */
  @BeforeEach
  void setUp() {
    basicSetUp();
    testEnemy = new Enemy(ENEMY_NAME, 100, 50, 10, turns);
  }

  /**
   * Checks that the enemy waits the appropriate amount of time for it's turn.
   *
  @Test
  void waitTurnTest() {
    Assertions.assertTrue(turns.isEmpty());
    //tryToEquip(testEnemies.get(0));
    testEnemy.waitTurn();
    try {
      // Thread.sleep is not accurate so this values may be changed to adjust the
      // acceptable error margin.
      // We're testing that the enemy waits approximately 1 second.
      Thread.sleep(900);
      Assertions.assertEquals(0, turns.size());
      Thread.sleep(200);
      Assertions.assertEquals(1, turns.size());
      Assertions.assertEquals(testEnemy, turns.peek());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }*/

  @Test
  void waitTurnTest() {
    checkWaitTurn(testEnemy);
  }

  /**
   * Checks that the class's constructor and equals method works properly.
   */
  @Test
  void constructorTest() {
    checkConstruction(new Enemy(ENEMY_NAME, 100, 50, 10, turns),
        testEnemy,
        new Enemy(ENEMY_NAME, 100, 50, 11, turns),
        new Thief(ENEMY_NAME, 100, 50, turns));
  }

  @Test
  void attackTest() {
    Enemy enemy = new Enemy("enemy", 100, 50, 10, turns);
    testEnemy.attack(enemy);
    enemy.getLife();
  }
}