package com.github.waripolo.finalreality.controller.phases;

import com.github.waripolo.finalreality.model.character.ICharacter;
import com.github.waripolo.finalreality.model.character.player.IPlayerCharacter;
import com.github.waripolo.finalreality.model.weapon.IWeapon;

public class EquipWeaponPhase extends Phase {

    private boolean isEquipWeapon = true;

    public EquipWeaponPhase() {
        this.canEquipWeapon = true;
    }

    @Override
    public void toBattlePhase() throws InvalidTransitionException {
        changePhase(new BattlePhase());
    }

    @Override
    public void equipWeapon(IPlayerCharacter character, IWeapon weapon) throws InvalidTransitionException{
        super.equipWeapon(character, weapon);
        toBattlePhase();
    }

    @Override
    public boolean isEquipPhase() {
        return isEquipWeapon;
    }
}
