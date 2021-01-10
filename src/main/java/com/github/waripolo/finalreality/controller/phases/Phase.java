package com.github.waripolo.finalreality.controller.phases;

import com.github.waripolo.finalreality.controller.GameController;
import com.github.waripolo.finalreality.model.character.ICharacter;
import com.github.waripolo.finalreality.model.character.player.IPlayerCharacter;
import com.github.waripolo.finalreality.model.weapon.IWeapon;

public class Phase {

    private GameController controller;

    protected boolean canAttackEnemy = false;
    protected boolean canEquipWeapon = false;

    protected boolean isBattle = false;
    protected boolean isAttack = false;
    protected boolean isEquipWeapon = false;

    public void setController(GameController controller) {
        this.controller = controller;
    }

    protected void changePhase(Phase phase) {
        controller.setPhase(phase);
    }

    //Section of phase's changes

    public void toBattlePhase() throws InvalidTransitionException {
        throw new InvalidTransitionException("Can´t change to the battle phase");
    }

    public void toAttackEnemyPhase() throws InvalidTransitionException {
        throw new InvalidTransitionException("Can't change to the attack enemy phase");
    }

    public void toEquipWeaponPhase() throws InvalidTransitionException {
        throw new InvalidTransitionException("Can't change to equip weapon phase");
    }



    //Métodos de las Fases
    public void attackEnemy(IPlayerCharacter attackerCharacter, ICharacter attackedEnemy) throws InvalidTransitionException {
        if(!canAttackEnemy) {
            throw new InvalidTransitionException("Can't attack an enemy in this stage");
        }
        controller.attackEnemy(attackerCharacter, attackedEnemy);
    }

    public void equipWeapon(IPlayerCharacter character, IWeapon weapon) throws InvalidTransitionException{
        if(!canEquipWeapon) {
            throw new InvalidTransitionException("Can't equip a weapon in this stage");
        }
        controller.equipWeapon(character, weapon);
    }

    public boolean isBattlePhase() {
        return this.isBattle;
    }

    public boolean isAttackEnemyPhase() {
        return this.isAttack;
    }

    public boolean isEquipPhase() {
        return this.isEquipWeapon;
    }
}
