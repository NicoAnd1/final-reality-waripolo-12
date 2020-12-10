package com.github.waripolo.finalreality.model.character.player;

import com.github.waripolo.finalreality.model.character.AbstractCharacter;
import com.github.waripolo.finalreality.model.character.ICharacter;
import com.github.waripolo.finalreality.model.weapon.IWeapon;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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
    }

    @Override
    public void waitTurn() {
        scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutor
                .schedule(this::addToQueue, equippedWeapon.getWeight() / 10, TimeUnit.SECONDS);
    }


    @Override
    public void equip(IWeapon weapon) {
        this.equippedWeapon = weapon;
    }

    @Override
    public void equipAxe(IWeapon weapon) {
        equip(weapon);
    }

    @Override
    public void equipBow(IWeapon weapon) {
        equip(weapon);
    }

    @Override
    public void equipKnife(IWeapon weapon) {
        equip(weapon);
    }

    @Override
    public void equipStaff(IWeapon weapon) {
        equip(weapon);
    }

    @Override
    public void equipSword(IWeapon weapon) {
        equip(weapon);
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
}