package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.AbstractCharacterTest;
import com.github.waripolo.finalreality.model.character.player.IPlayerCharacter;
import com.github.waripolo.finalreality.model.weapon.IWeapon;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractPlayerCharacterTest extends AbstractCharacterTest {
    protected void checkEquippedWeapon(IPlayerCharacter character, IWeapon goodWeapon) {
        assertNull(character.getEquippedWeapon());
        character.equip(goodWeapon);
        assertEquals(goodWeapon, character.getEquippedWeapon());
        //character.equip(badWeapon);
        //assertNotEquals(badWeapon, character.getEquippedWeapon());
    }
}