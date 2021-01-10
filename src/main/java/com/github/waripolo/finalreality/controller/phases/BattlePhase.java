package com.github.waripolo.finalreality.controller.phases;

public class BattlePhase extends Phase {

    private boolean isBattle = true;

    @Override
    public void toAttackEnemyPhase() throws InvalidTransitionException {
        changePhase(new AttackEnemyPhase());
    }

    @Override
    public void toEquipWeaponPhase() throws InvalidTransitionException {
        changePhase(new EquipWeaponPhase());
    }

    @Override
    public void toBattlePhase() { }

    @Override
    public boolean isBattlePhase() {
        return isBattle;
    }
}
