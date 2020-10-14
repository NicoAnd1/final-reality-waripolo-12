package com.github.waripolo.finalreality.model.character;

import com.github.waripolo.finalreality.model.character.player.CharacterClass;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import org.jetbrains.annotations.NotNull;

/**
 * An abstract class that holds the common behaviour of all the characters in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Nicolás Fernández.
 */
public abstract class AbstractCharacter implements ICharacter {

  protected final BlockingQueue<ICharacter> turnsQueue;
  protected final String name;
  private final CharacterClass characterClass;

  protected ScheduledExecutorService scheduledExecutor;

  /**
   * Creates a new Character.
   *
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   * @param name
   *     the queue with the characters waiting for their turn
   * @param characterClass
   *     the class of this character
   */
  protected AbstractCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue,
      @NotNull String name, CharacterClass characterClass) {
    this.turnsQueue = turnsQueue;
    this.name = name;
    this.characterClass = characterClass;
  }

  /**
   * Adds this character to the turns queue.
   */
  protected void addToQueue() {
    turnsQueue.add(this);
    scheduledExecutor.shutdown();
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public CharacterClass getCharacterClass() {
    return characterClass;
  }

}
