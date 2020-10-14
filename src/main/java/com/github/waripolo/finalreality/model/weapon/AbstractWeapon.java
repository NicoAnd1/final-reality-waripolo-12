package com.github.waripolo.finalreality.model.weapon;

import java.util.Objects;

/**
 * An abstract class that holds the common behaviour of the weapons in the game.
 *
 * @author Nicolás Fernández.
 */
public abstract class AbstractWeapon implements IWeapon {

    protected final String name;
    protected final int attack;
    protected final int weight;

    /**
     *Creates a new weapon.
     *
     * @param name
     *     the weapon's name.
     * @param attack
     *     the weapon's damage.
     * @param weight
     *     the weapon's weight.
     */
    protected AbstractWeapon (String name, int attack, int weight) {
        this.name = name;
        this.attack = attack;
        this.weight = weight;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public int getAttack(){
        return attack;
    }

    @Override
    public int getWeight(){
        return weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAttack(), getWeight());
    }

    @Override
    public boolean equals(Object o) {
        return this.hashCode() == o.hashCode();
    }
}
