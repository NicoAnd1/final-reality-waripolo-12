package com.github.cc3002.finalreality.model.character;

import com.github.waripolo.finalreality.model.character.Enemy;
import com.github.waripolo.finalreality.model.character.player.classes.Thief;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    testEnemy = new Enemy(ENEMY_NAME, 100, 50, 20,10, turns);
  }

  /**
   * Checks that the enemy waits the appropriate amount of time for it's turn.
   */
  @Test
  void waitTurnTest() {
    checkWaitTurn(testEnemy);
  }

  /**
   * Checks that the class's constructor and equals method works properly.
   */
  @Test
  void constructorTest() {
    checkConstruction(new Enemy(ENEMY_NAME, 100, 50, 20,10, turns),
        testEnemy,
        new Enemy(ENEMY_NAME, 100, 50, 20,11, turns),
        new Thief(ENEMY_NAME, 100, 50, turns));
  }

  /**
   * Checks that the enemy attacks a character
   */
  @Test
  void attackTest() {
    Thief thief = new Thief("thief", 100, 50, turns);
    testEnemy.attack(thief);
    assertEquals(30, thief.getDefense());
  }

  /**
   * Checks that the enemy is alive
   */
  @Test
  void aliveTest() {
    checkIsAlive(testEnemy);
  }
}