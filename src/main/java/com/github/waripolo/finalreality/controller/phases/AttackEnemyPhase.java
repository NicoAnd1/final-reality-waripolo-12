package com.github.waripolo.finalreality.controller.phases;

import com.github.waripolo.finalreality.model.character.ICharacter;
import com.github.waripolo.finalreality.model.character.player.IPlayerCharacter;

public class AttackEnemyPhase extends Phase {

    private boolean isAttack = true;

    public AttackEnemyPhase() {
        this.canAttackEnemy = true;
    }

    @Override
    public void toBattlePhase() throws InvalidTransitionException {
        changePhase(new BattlePhase());
    }

    @Override
    public void attackEnemy(IPlayerCharacter attacker, ICharacter attacked) throws InvalidTransitionException{
        super.attackEnemy(attacker, attacked);
        toBattlePhase();
    }

    @Override
    public boolean isAttackEnemyPhase() {
        return isAttack;
    }
}
