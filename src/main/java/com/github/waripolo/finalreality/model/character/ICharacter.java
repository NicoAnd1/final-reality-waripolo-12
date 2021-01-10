package com.github.waripolo.finalreality.model.character;

import com.github.waripolo.finalreality.model.character.player.IPlayerCharacter;
import com.github.waripolo.finalreality.controller.handlers.IHandler;

/**
 * This represents a character from the game.
 * A character can be controlled by the player or by the CPU (an enemy).
 *
 * @author Ignacio Slater Muñoz.
 * @author Nicolás Fernández.
 */
public interface ICharacter {

  /**
   * Sets a scheduled executor to make this character (thread) wait for {@code speed / 10}
   * seconds before adding the character to the queue.
   */
  void waitTurn();

  /**
   * Returns this character's name.
   */
  String getName();

  /**
   * Attacks a character.
   *
   * @param character
   *     character who is going to be attacked.
   */
  void attack(IPlayerCharacter character);

  /**
   * This is attacked by a character of the game.
   *
   * @param character
   *     character who is attacking this.
   */
  void attackedByCharacter(IPlayerCharacter character);

  /**
   * This is attacked by a enemy.
   *
   * @param enemy
   *     enemy who is attacking this.
   */
  void attackedByEnemy(Enemy enemy);

  /**
   * Returns the life of the character
   */
  int getLife();

  /**
   * Returns the defense of the character
   */
  int getDefense();

  /**
   * Returns true if the character is alive and false if it's not
   */
  boolean isAlive();

  boolean isEnemy();

  /**
   * Adds the character to the listener that notify when the character is alive
   */
  void addCharacterHandler(IHandler handler);

  /**
   * Adds the character to the listener that notify that the turn is over
   */
  void addCharacterTurnHandler(IHandler handler);

  //String getName();
}
