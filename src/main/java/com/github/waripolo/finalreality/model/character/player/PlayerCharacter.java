package com.github.waripolo.finalreality.model.character.player;

import com.github.waripolo.finalreality.model.character.AbstractCharacter;
import com.github.waripolo.finalreality.model.character.ICharacter;
import com.github.waripolo.finalreality.model.weapon.*;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single character of the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Nicolás Fernández.
 */
public class PlayerCharacter extends AbstractCharacter {

  protected ScheduledExecutorService scheduledExecutor;
  private IWeapon equippedWeapon;

  /**
   * Creates a new character.
   */
  public PlayerCharacter(@NotNull String name,
      @NotNull BlockingQueue<ICharacter> turnsQueue,
      final CharacterClass characterClass) {
    super(turnsQueue, name, characterClass);
  }

  @Override
  public int hashCode() {
    return Objects.hash(getCharacterClass());
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof PlayerCharacter)) {
      return false;
    }
    final PlayerCharacter that = (PlayerCharacter) o;
    return getCharacterClass() == that.getCharacterClass()
        && getName().equals(that.getName());
  }

  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    scheduledExecutor.schedule(this::addToQueue, equippedWeapon.getWeight() / 10, TimeUnit.SECONDS);
  }

/**
 * Equips a weapon to the character.
 */
  public void equip(IWeapon weapon) {
    this.equippedWeapon = weapon;
  }

/**
 * Return this character's equipped weapon.
 */
  public IWeapon getEquippedWeapon() {
    return equippedWeapon;
  }
}
