package com.github.waripolo.finalreality.model.character.player.classes;

import com.github.waripolo.finalreality.model.character.Enemy;
import com.github.waripolo.finalreality.model.character.ICharacter;
import com.github.waripolo.finalreality.model.character.player.AbstractPlayerCharacter;
import com.github.waripolo.finalreality.model.character.player.IPlayerCharacter;
import com.github.waripolo.finalreality.model.weapon.IWeapon;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public class Knight extends AbstractPlayerCharacter {
    /**
     * Creates a new Character.
     *
     * @param turnsQueue the queue with the characters waiting for their turn
     * @param name       the name of the character
     */
    public Knight(@NotNull final String name,
        int life, int defense,
        @NotNull final BlockingQueue<ICharacter> turnsQueue) {
        super(name, life, defense, turnsQueue);
    }

    @Override
    public void equipAxe(IWeapon weapon) {
        super.equipAxe(weapon);
    }

    @Override
    public void equipBow(IWeapon weapon) {
        equippedWeapon = null;
    }

    @Override
    public void equipKnife(IWeapon weapon) {
        super.equipKnife(weapon);
    }

    @Override
    public void equipStaff(IWeapon weapon) {
        equippedWeapon = null;
    }

    @Override
    public void equipSword(IWeapon weapon) {
        super.equipSword(weapon);
    }


    @Override
    public void attack(ICharacter character) {
        character.attackedByCharacter(this);
    }

    @Override
    public boolean equals(final Object o) {
        return o instanceof Knight && super.equals(o);
    }

    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(), Knight.class);
    }
}
