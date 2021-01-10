package com.github.waripolo.finalreality.model.character.player;

import com.github.waripolo.finalreality.model.character.AbstractCharacter;
import com.github.waripolo.finalreality.model.character.ICharacter;
import com.github.waripolo.finalreality.controller.handlers.IHandler;
import com.github.waripolo.finalreality.model.weapon.IWeapon;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * An abstract class that holds the common behaviour of all the player's
 * characters in the game
 *
 * @author Ignacio Slater Muñoz.
 * @author Nicolás Fernández.
 */
public abstract class AbstractPlayerCharacter extends AbstractCharacter implements
    IPlayerCharacter {

    protected IWeapon equippedWeapon = null;

    /**
     * Creates a new Character.
     *
     * @param turnsQueue
     *     the queue with the characters waiting for their turn
     * @param name
     *     the name of the character
     * @param defense
     *     the defense of the character
     * @param life
     *     the life of the character
     */
    public AbstractPlayerCharacter(@NotNull String name,
      int life, int defense,
      @NotNull BlockingQueue<ICharacter> turnsQueue) {
      super(name, life, defense, turnsQueue);
      this.alive = true;
      this.isThisAnEnemy = false;
    }

    @Override
    public void waitTurn() {
        scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutor
                .schedule(this::addToQueue, equippedWeapon.getWeight() / 10, TimeUnit.SECONDS);
    }

    /**
     * Attacks a character of type IPlayerCharacter
     * @param character
     *     the character that is being attacked
     */
    public void attack(IPlayerCharacter character) {
        character.attackedByCharacter(this);
    }


    /**
     * Attacks a character of type ICharacter
     * @param character
     *     the character that is being attacked
     */
    public void attack(ICharacter character) {
        character.attackedByCharacter(this);
    }

    @Override
    public void equip(IWeapon weapon) {
        weapon.equippedBy(this);
    }

    /**
     * Equips a weapon to the character
     */
    public void equipp(IWeapon weapon) {
        this.equippedWeapon = weapon;
    }

    @Override
    public void equipAxe(IWeapon weapon) {
        equipp(weapon);
    }

    @Override
    public void equipBow(IWeapon weapon) {
        equipp(weapon);
    }

    @Override
    public void equipKnife(IWeapon weapon) {
        equipp(weapon);
    }

    @Override
    public void equipStaff(IWeapon weapon) {
        equipp(weapon);
    }

    @Override
    public void equipSword(IWeapon weapon) {
        equipp(weapon);
    }


    @Override
    public IWeapon getEquippedWeapon() {
        return equippedWeapon;
    }

    @Override
    public int hashCode() {
        return Objects.
                hash(super.hashCode(), AbstractPlayerCharacter.class, getEquippedWeapon());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AbstractPlayerCharacter)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final AbstractPlayerCharacter that = (AbstractPlayerCharacter) o;
        return Objects.equals(getEquippedWeapon(), that.getEquippedWeapon());
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