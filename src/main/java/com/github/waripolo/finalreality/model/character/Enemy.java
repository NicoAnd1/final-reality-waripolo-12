package com.github.waripolo.finalreality.model.character;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.github.waripolo.finalreality.model.character.player.IPlayerCharacter;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single enemy of the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Nicolás Fernández.
 */
public class Enemy extends AbstractCharacter {

  public final int weight;
  protected ScheduledExecutorService scheduledExecutor;

  /**
   * Creates a new enemy with a name, a weight and the queue with the characters ready to
   * play.
   *
   * @param name
   *     the name of the enemy.
   * @param weight
   *     the weight of the enemy, according to the weapon "equipped".
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   */
  public Enemy(@NotNull final String name,
      final int life, final int defense, final int weight,
      @NotNull final BlockingQueue<ICharacter> turnsQueue) {
    super(name, life, defense, turnsQueue);
    this.weight = weight;
    this.life = 100;
    this.defense = 50;
  }

  /**
   * Returns the weight of this enemy.
   */
  public int getWeight() {
    return weight;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Enemy)) {
      return false;
    }
    final Enemy enemy = (Enemy) o;
    return getWeight() == enemy.getWeight();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getWeight());
  }

  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    var enemy = this;
    scheduledExecutor.schedule(this::addToQueue, enemy.getWeight() / 10, TimeUnit.SECONDS);

  }

  @Override
  public void attack(ICharacter character) {
    character.attackedByEnemy(this);
  }
}
