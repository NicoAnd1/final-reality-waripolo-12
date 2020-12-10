package com.github.waripolo.finalreality.model.character.player.classes;

import com.github.waripolo.finalreality.model.character.ICharacter;
import com.github.waripolo.finalreality.model.character.player.AbstractPlayerCharacter;
import com.github.waripolo.finalreality.model.weapon.IWeapon;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public class WhiteMage extends AbstractPlayerCharacter {

    private int mana;

    /**
     * Creates a new Character.
     *
     * @param turnsQueue the queue with the characters waiting for their turn
     * @param name       the name of the character
     */
    public WhiteMage(@NotNull final String name,
                     int life, int defense,
                     @NotNull final BlockingQueue<ICharacter> turnsQueue, int mana) {
        super(name, life, defense, turnsQueue);
        this.mana = mana;
    }


    @Override
    public void equipAxe(IWeapon weapon) {
    }

    @Override
    public void equipBow(IWeapon weapon) {
    }

    @Override
    public void equipKnife(IWeapon weapon) {
    }

    @Override
    public void equipStaff(IWeapon weapon) {
        super.equipStaff(weapon);
    }

    @Override
    public void equipSword(IWeapon weapon) {
    }


    @Override
    public boolean equals(final Object o) {
        return o instanceof WhiteMage && super.equals(o);
    }

    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(), WhiteMage.class);
    }
}
