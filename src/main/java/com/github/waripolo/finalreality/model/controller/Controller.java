package com.github.waripolo.finalreality.model.controller;
import com.github.waripolo.finalreality.model.character.*;
import com.github.waripolo.finalreality.model.character.player.IPlayerCharacter;
import com.github.waripolo.finalreality.model.character.player.classes.*;
import com.github.waripolo.finalreality.model.weapon.IWeapon;
import com.github.waripolo.finalreality.model.weapon.types.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * A class that controls how the game works
 *
 * @author Nicolás Fernández
 */
public class Controller {

    private IPlayerCharacter newCharacter;
    private ICharacter newEnemy;
    private IWeapon newWeapon;
    BlockingQueue<ICharacter> turns = new LinkedBlockingQueue<>();
    private final List<IPlayerCharacter> playerCharacters= new ArrayList<>();
    private final List<ICharacter> enemyList = new ArrayList<>();
    private final List<IWeapon> inventory = new ArrayList<>();

    private final CharacterHandler characterHandler = new CharacterHandler(this);
    private final EnemyHandler enemyHandler = new EnemyHandler(this);
    private final TurnsHandler turnsHandler = new TurnsHandler(this);

    /**
     * Creates a new controller
     */
    public Controller() {
    }

    /**
     * Adds a character to the queue
     *
     * @param character
     *     the character who is going to be added
     */
    public void addToQueue(ICharacter character) {
        character.waitTurn();
    }

    /**
     * Initiates a new turn bringing the character who is playing the turn
     *
     * @return
     *     the character who is playing
     */
    public ICharacter turnInitiated() {
        return turns.poll();
    }

    /**
     * Ends a turn
     */
    public void turnFinished(ICharacter character) {
    }

    /**
     * Removes a character from the list of characters that the player has
     *
     * @param character
     *     the character who is going to be removed
     */
    public void eraseCharacter(IPlayerCharacter character) {
        playerCharacters.remove(character);
    }

    /**
     * Removes an enemy from the list of enemies
     *
     * @param enemy
     *     the enemy who is going to be removed
     */
    public void eraseEnemy(ICharacter enemy) {
        enemyList.remove(enemy);
    }

    //Item 1

    /**
     * Creates a new character of class Black Mage and adds it to the player's list
     *
     * @param name
     *     the name of the new character
     */
    public void createBlackMage(String name) {
        newCharacter = new BlackMage(name, 100, 50, turns, 100);
        playerCharacters.add(newCharacter);
        newCharacter.addCharacterHandler(characterHandler);
        newCharacter.addCharacterTurnHandler(turnsHandler);
    }

    /**
     * Creates a new character of class Engineer and adds it to the player's list
     *
     * @param name
     *     the name of the new character
     */
    public void createEngineer(String name) {
        newCharacter = new Engineer(name, 100, 50, turns);
        playerCharacters.add(newCharacter);
        newCharacter.addCharacterHandler(characterHandler);
        newCharacter.addCharacterTurnHandler(turnsHandler);
    }

    /**
     * Creates a new character of class Knight and adds it to the player's list
     *
     * @param name
     *     the name of the new character
     */
    public void createKnight(String name) {
        newCharacter = new Knight(name, 100, 50, turns);
        playerCharacters.add(newCharacter);
        newCharacter.addCharacterHandler(characterHandler);
        newCharacter.addCharacterTurnHandler(turnsHandler);
    }

    /**
     * Creates a new character of class Thief and adds it to the player's list
     *
     * @param name
     *     the name of the new character
     */
    public void createThief(String name) {
        newCharacter = new Thief(name, 100, 50, turns);
        playerCharacters.add(newCharacter);
        newCharacter.addCharacterHandler(characterHandler);
        newCharacter.addCharacterTurnHandler(turnsHandler);
    }

    /**
     * Creates a new character of class White Mage and adds it to the player's list
     *
     * @param name
     *     the name of the new character
     */
    public void createWhiteMage(String name) {
        newCharacter = new WhiteMage(name, 100, 50, turns, 100);
        playerCharacters.add(newCharacter);
        newCharacter.addCharacterHandler(characterHandler);
        newCharacter.addCharacterTurnHandler(turnsHandler);
    }


    /**
     * Creates a new enemy and adds it to the enemy's list
     *
     * @param name
     *     the name of the new enemy
     */
    public void createEnemy(String name) {
        newEnemy = new Enemy(name, 100, 50, 30, 20, turns);
        enemyList.add(newEnemy);
        newEnemy.addCharacterHandler(enemyHandler);
        newEnemy.addCharacterTurnHandler(turnsHandler);
    }


    /**
     * Returns the list of characters that the player has
     */
    public List<IPlayerCharacter> getCharacterList() {
        return playerCharacters;
    }

    /**
     * Returns the list of enemies
     */
    public List<ICharacter> getEnemyList() {
        return enemyList;
    }


    /**
     * Creates a new weapon of class Axe and adds it to the inventory of the player
     *
     * @param name
     *     the name of the new weapon
     * @param attack
     *     the attack of the new weapon
     * @param weight
     *     the weight of the new weapon
     */
    public void createAxe(String name, int attack, int weight) {
        newWeapon = new Axe(name, attack, weight);
        inventory.add(newWeapon);
    }

    /**
     * Creates a new weapon of class Bow and adds it to the inventory of the player
     *
     * @param name
     *     the name of the new weapon
     * @param attack
     *     the attack of the new weapon
     * @param weight
     *     the weight of the new weapon
     */
    public void createBow(String name, int attack, int weight) {
        newWeapon = new Bow(name, attack, weight);
        inventory.add(newWeapon);
    }

    /**
     * Creates a new weapon of class Knife and adds it to the inventory of the player
     *
     * @param name
     *     the name of the new weapon
     * @param attack
     *     the attack of the new weapon
     * @param weight
     *     the weight of the new weapon
     */
    public void createKnife(String name, int attack, int weight) {
        newWeapon = new Knife(name, attack, weight);
        inventory.add(newWeapon);
    }

    /**
     * Creates a new weapon of class Staff and adds it to the inventory of the player
     *
     * @param name
     *     the name of the new weapon
     * @param attack
     *     the attack of the new weapon
     * @param weight
     *     the weight of the new weapon
     */
    public void createStaff(String name, int attack, int weight) {
        newWeapon = new Staff(name, attack, weight);
        inventory.add(newWeapon);
    }

    /**
     * Creates a new weapon of class Sword and adds it to the inventory of the player
     *
     * @param name
     *     the name of the new weapon
     * @param attack
     *     the attack of the new weapon
     * @param weight
     *     the weight of the new weapon
     */
    public void createSword(String name, int attack, int weight) {
        newWeapon = new Sword(name, attack, weight);
        inventory.add(newWeapon);
    }

    /**
     * Returns the inventory of the player
     */
    public List<IWeapon> getWeaponList() {
        return inventory;
    }


    //Item 2

    /**
     * Returns the life that a player's character has
     */
    public int getCharacterLife(IPlayerCharacter character) {
        return character.getLife();
    }

    /**
     * Returns the damage that a player's character can make
     */
    public int getCharacterAttack(IPlayerCharacter character) {
        return character.getEquippedWeapon().getAttack();
    }

    /**
     * Returns the defense that a player's character has
     */
    public int getCharacterDefense(IPlayerCharacter character) {
        return character.getDefense();
    }

    /**
     * Returns the weapon that a player's character has equipped
     */
    public IWeapon getCharacterWeapon(IPlayerCharacter character) {
        return character.getEquippedWeapon();
    }


    //Item 3

    /**
     * Returns the life that an enemy has
     */
    public int getEnemyLife(ICharacter enemy) {
        return enemy.getLife();
    }

    /**
     * Returns the damage that an enemy can make
     */
    public int getEnemyAttack(Enemy enemy) {
        return enemy.getAttack();
    }

    /**
     * Returns the defense that an enemy has
     */
    public int getEnemyDefense(ICharacter enemy) {
        return enemy.getDefense();
    }


    //Item 4

    /**
     * Returns the name of a weapon
     */
    public String getWeaponName(IWeapon weapon) {
        return weapon.getName();
    }

    /**
     * Returns the damage of a weapon
     */
    public int getWeaponAttack(IWeapon weapon) {
        return weapon.getAttack();
    }

    /**
     * Returns the weight of a weapon
     */
    public int getWeaponWeight(IWeapon weapon) {
        return weapon.getWeight();
    }


    //Item 5

    /**
     * Equips a weapon to a player's character
     *
     * @param character
     *     the character who is going to equip the weapon
     * @param weapon
     *     the weapon that is going to be equipped
     */
    public void equipWeapon(IPlayerCharacter character, IWeapon weapon) {
        character.equip(weapon);
    }


    //Item 6

    /**
     * Attacks a player's character
     *
     * @param attackerCharacter
     *     the character who is attacking
     * @param attackedCharacter
     *     the character who is being attacked
     */
    public void attackCharacter(ICharacter attackerCharacter, IPlayerCharacter attackedCharacter) {
        attackerCharacter.attack(attackedCharacter);
    }

    /**
     * Attacks an enemy
     *
     * @param attackerCharacter
     *     the character who is attacking
     * @param attackedCharacter
     *     the character who is being attacked
     */
    public void attackEnemy(IPlayerCharacter attackerCharacter, ICharacter attackedCharacter) {
        attackerCharacter.attack(attackedCharacter);
    }
}