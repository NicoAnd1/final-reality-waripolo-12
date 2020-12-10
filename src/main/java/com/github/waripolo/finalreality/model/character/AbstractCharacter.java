package com.github.waripolo.finalreality.model.character;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledExecutorService;

import com.github.waripolo.finalreality.model.character.player.IPlayerCharacter;
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
  protected int life;
  protected int defense;
  protected boolean alive;
  protected ScheduledExecutorService scheduledExecutor;

  /**
   * Creates a new Character.
   *
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   * @param name
   *     the name of the character
   * @param life
   *     the life of the character
   * @param defense
   *     the defense of the character
   */
  protected AbstractCharacter(@NotNull String name,
      int life, int defense,
      @NotNull BlockingQueue<ICharacter> turnsQueue) {
    this.turnsQueue = turnsQueue;
    this.name = name;
    this.life = life;
    this.defense = defense;
    this.alive = true;
  }

  /**
   * Adds this character to the turns queue.
   */
  protected void addToQueue() {
    turnsQueue.add(this);
    scheduledExecutor.shutdown();
  }

  @Override
  public int hashCode() {
    return Objects.hash(AbstractCharacter.class, getName());
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AbstractCharacter)) {
      return false;
    }
    final AbstractCharacter that = (AbstractCharacter) o;
    return getName().equals(that.getName());
  }

  @Override
  public String getName() {
    return name;
  }

  /**
   * Returns the life of the character
   */
  public int getLife() {
    return life;
  }

  /**
   * Sets the new life of the character
   */
  public void setLife(int newLife) {
    this.life = newLife;
  }

  /**
   * Sets the new defense of the character
   * @param newDefense
   */
  public void setDefense(int newDefense) {
    this.defense = newDefense;
  }

  /**
   * Behaviour of the character when it is attacked
   */
  void attackedBy(int damage) {
    int damaged = damage - this.defense;

    if (damaged >= this.getLife()) {
      this.alive = false;
    }

    if (damaged < 0) {
      this.setDefense(this.defense - damage);
    }

    if (damage >= this.defense) {
      this.setDefense(0);
      this.setLife(this.getLife() - damaged);
    }
  }

  /**
   * Indicates that this character is been attacked by other character
   */
  public void attackedByCharacter(IPlayerCharacter character){
    attackedBy(character.getEquippedWeapon().getAttack());
  }

  /**
   * Indicates that this character is been attacked by an enemy
   */
  public void attackedByEnemy(Enemy enemy) {
    attackedBy(enemy.getWeight());
  }
}