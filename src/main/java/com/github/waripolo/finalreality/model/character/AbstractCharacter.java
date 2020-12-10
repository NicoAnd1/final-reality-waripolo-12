package com.github.waripolo.finalreality.model.character;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledExecutorService;

import com.github.waripolo.finalreality.model.character.player.IPlayerCharacter;
import com.github.waripolo.finalreality.model.controller.CharacterHandler;
import com.github.waripolo.finalreality.model.controller.IHandler;
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

  protected final PropertyChangeSupport deadCharacterEvent =
          new PropertyChangeSupport(this);
  protected final PropertyChangeSupport endCharactersTurnEvent =
          new PropertyChangeSupport(this);

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
    endCharactersTurnEvent.firePropertyChange("turn ended", null, this);
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
   * Returns true if the character is alive and false if it's not
   */
  public boolean isAlive() {
    return alive;
  }

  /**
   * Sets the new life of the character
   */
  public void setLife(int newLife) {
    this.life = newLife;
    if (newLife == 0) {
      deadCharacterEvent.firePropertyChange("dead character", null, this);
    }
  }

  /**
   * Returns the defense of the character
   */
  public int getDefense() {
    return defense;
  }

  /**
   * Sets the new defense of the character
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

    if (damage >= this.defense) {
      this.setDefense(0);
      this.setLife(this.getLife() - damaged);
    }

    if (damaged < 0) {
      this.setDefense(this.defense - damage);
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
    attackedBy(enemy.getAttack());
  }


  /**
   * Adds the character to the listener that notify when the character is alive
   */
  public void addCharacterHandler(IHandler handler) {
    deadCharacterEvent.addPropertyChangeListener(handler);
  }

  /**
   * Adds the character to the listener that notify that the turn is over
   */
  public void addCharacterTurnHandler(IHandler handler) {
    endCharactersTurnEvent.addPropertyChangeListener(handler);
  }
}