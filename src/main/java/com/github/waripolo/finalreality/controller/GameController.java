package com.github.waripolo.finalreality.controller;

import com.github.waripolo.finalreality.controller.phases.BattlePhase;
import com.github.waripolo.finalreality.model.character.*;
import com.github.waripolo.finalreality.model.character.player.IPlayerCharacter;
import com.github.waripolo.finalreality.model.character.player.classes.*;
import com.github.waripolo.finalreality.controller.handlers.CharacterHandler;
import com.github.waripolo.finalreality.controller.handlers.EnemyHandler;
import com.github.waripolo.finalreality.controller.handlers.TurnsHandler;
import com.github.waripolo.finalreality.controller.phases.InvalidTransitionException;
import com.github.waripolo.finalreality.controller.phases.Phase;
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
public class GameController {

    private IPlayerCharacter newCharacter;
    private ICharacter newEnemy;
    private IWeapon newWeapon;
    BlockingQueue<ICharacter> turns = new LinkedBlockingQueue<>();
    private final List<IPlayerCharacter> playerCharacters= new ArrayList<>();
    private final List<ICharacter> enemyList = new ArrayList<>();
    private final List<IWeapon> inventory = new ArrayList<>();

    private final List<ICharacter> deadList = new ArrayList<>();
    private final List<IPlayerCharacter> deadCharacterList = new ArrayList<>();

    private final CharacterHandler characterHandler = new CharacterHandler(this);
    private final EnemyHandler enemyHandler = new EnemyHandler(this);
    private final TurnsHandler turnsHandler = new TurnsHandler(this);

    int characterCounter = 0;
    int enemyCounter = 0;
    int deadCharacter = 0;
    int deadEnemies = 0;
    private Phase phase;

    private ICharacter characterInTurn;

    private boolean endGame = false;
    private boolean win = false;
    private boolean lose = false;

    /**
     * Creates a new controller
     */
    public GameController() {
     setPhase(new BattlePhase());//WaitPhase
    }

    /**
     * Adds a character to the queue
     *
     * @param character
     *     the character who is going to be added
     */
    public void addToQueue(ICharacter character) {
        if (!deadList.contains(character)) {
            character.waitTurn();
        }
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
    public void turnFinished() {

    }

    /**
     * Removes a character from the list of characters that the player has
     *
     * @param character
     *     the character who is going to be removed
     */
    public void eraseCharacter(IPlayerCharacter character) {
        deadList.add((ICharacter) character);
        turns.remove(character);
        deadCharacter +=1;
    }

    /**
     * Removes an enemy from the list of enemies
     *
     * @param enemy
     *     the enemy who is going to be removed
     */
    public void eraseEnemy(ICharacter enemy) {
        deadList.add(enemy);
        turns.remove(enemy);
        deadEnemies +=1;
    }

    /**
     * Checks if the player has won or lose the game
     */
    public boolean gameChecker () {
        if (deadCharacter == /*characterCounter*/ 10) {
            this.endGame = true;
            this.lose = true;
        }
        if (deadEnemies == enemyCounter) {
            this.endGame = true;
            this.win = true;
        }
        return endGame;
    }

    /**
     * Indicates that the player has won the game
     */
    public boolean hasWon() {
        return win;
    }

    /**
     * Indicates that the player has lose the game
     */
    public boolean hasLose() { //era void que cambiaba el estado de lose
        return lose;
    }

    //Item 1

    /**
     * Creates a new character of class Black Mage and adds it to the player's list
     *
     * @param name
     *     the name of the new character
     */
    public void createBlackMage(String name) {
        newCharacter = new BlackMage(name, 100, 50, turns);
        playerCharacters.add(newCharacter);
        newCharacter.addCharacterHandler(characterHandler);
        newCharacter.addCharacterTurnHandler(turnsHandler);
        characterCounter +=1;
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
        characterCounter +=1;
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
        characterCounter +=1;
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
        characterCounter +=1;
    }

    /**
     * Creates a new character of class White Mage and adds it to the player's list
     *
     * @param name
     *     the name of the new character
     */
    public void createWhiteMage(String name) {
        newCharacter = new WhiteMage(name, 100, 50, turns);
        playerCharacters.add(newCharacter);
        newCharacter.addCharacterHandler(characterHandler);
        newCharacter.addCharacterTurnHandler(turnsHandler);
        characterCounter +=1;
    }


    /**
     * Creates a new enemy and adds it to the enemy's list
     *
     * @param name
     *     the name of the new enemy
     * @param weight
     */
    public void createEnemy(String name, int weight) {
        newEnemy = new Enemy(name, 100, 50, 30 /*150*/, weight, turns);
        enemyList.add(newEnemy);
        newEnemy.addCharacterHandler(enemyHandler);
        newEnemy.addCharacterTurnHandler(turnsHandler);
        enemyCounter +=1;
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
     * Returns the name of a character
     */
    public String getCharacterName(IPlayerCharacter character) {
        return character.getName();
    }

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
     * Returns the name of an enemy
     */
    public String getEnemyName(ICharacter enemy) {
        return enemy.getName();
    }

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

    // extras

    /**
     * Sets a phase of the game
     *
     * @param phase
     *     the phase that is being settled
     */
    public void setPhase(final Phase phase) {
        this.phase = phase;
        phase.setController(this);
    }

    /**
     * Returns the actual phase of the game
     */
    public Phase getPhase() {
        return this.phase;
    }

    /**
     * Changes the phase of the game to the Equip Weapon Phase
     */
    public void goToInventory() {
        try {
            phase.toEquipWeaponPhase();
        } catch (InvalidTransitionException e) {
            e.printStackTrace();
        }
    }

    /**
     * Changes the phase of the game to the Attack Enemy Phase
     */
    public void goToAttack() {
        try {
            phase.toAttackEnemyPhase();
        } catch (InvalidTransitionException e) {
            e.printStackTrace();
        }
    }

    /**
    public void goToBattleScreen() {
        try {
            phase.toBattlePhase();
        } catch (InvalidTransitionException e) {
            e.printStackTrace();
        }
    }*/

    /**
     * Tries to attack an enemy in the actual phase
     *
     * @param attacker
     *     the character who is going to attack
     * @param enemy
     *     the enemy who is going to be attacked
     */
    public void tryToAttackEnemy(IPlayerCharacter attacker, ICharacter enemy) {
        try {
            phase.attackEnemy(attacker, enemy);
        } catch (InvalidTransitionException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tries to equip a weapon in the actual phase
     *
     * @param character
     *     the character who is trying to equip a weapon
     * @param weapon
     *     the weapon that is going to be equipped
     */
    public void tryToEquipWeapon(IPlayerCharacter character, IWeapon weapon) {
        try {
            phase.equipWeapon(character, weapon);
        } catch (InvalidTransitionException e) {
            e.printStackTrace();
        }
    }

    /**
    public void toAttackEnemyPhase() {
        try {
            phase.toAttackEnemyPhase();
        } catch (InvalidTransitionException e) {
            e.printStackTrace();
        }
    }

    public void toEquipWeaponPhase() {
        try {
            phase.toEquipWeaponPhase();
        } catch (InvalidTransitionException e) {
            e.printStackTrace();
        }
    }*/

    /**
     * Sets the initial conditions of the game, by equipping weapons to
     * every character, and then adds them to the queue
     */
    public void setGame() {
        equipWeapon(playerCharacters.get(0), inventory.get(4));
        equipWeapon(playerCharacters.get(1), inventory.get(2));
        equipWeapon(playerCharacters.get(2), inventory.get(8));
        equipWeapon(playerCharacters.get(3), inventory.get(5));
        equipWeapon(playerCharacters.get(4), inventory.get(6));
        waitTurnAll();
    }



    /**
     * Makes that every character and enemy wait for their turn
     */
    private void waitTurnAll(){
        for(IPlayerCharacter character: playerCharacters){
            addToQueue((ICharacter) character);
        }
        for(ICharacter enemy: enemyList){
            addToQueue(enemy);
        }
    }

    /**
     * Settle the character who is playing at the moment
     */
    public void beginTurn(){
        characterInTurn = turnInitiated();
    }

    /**
     * Returns the character who is playing at the moment
     */
    public ICharacter getCharacterInTurn(){
        return characterInTurn;
    }

    /**
     * Returns the name of a character, who could be of any type
     *
     * @param character
     *     character which name is going to be returned
     */
    public String getCharacterName(ICharacter character){
        return character.getName();
    }

    /**
     * Returns a string with information of a character. This info is about its name, life,
     * defense and if it is alive or not
     */
    public String getCharacterInfo(int indexPlayerCharacter){
        String name = getCharacterName((ICharacter) playerCharacters.get(indexPlayerCharacter));
        String life = Integer.toString(getCharacterLife(playerCharacters.get(indexPlayerCharacter)));
        String defense = Integer.toString(getCharacterDefense(playerCharacters.get(indexPlayerCharacter)));
        String isAlive = getCharacterLife(playerCharacters.get(indexPlayerCharacter)) > 0 ? "Alive" : "Dead";

        return name + "\n" + "life: " + life + "\n" + "defense: " + defense + "\n" + isAlive;
    }

    /**
     * Returns a string with information of an enemy. This info is about its name, life,
     * defense and if it is alive or not
     */
    public String getEnemyInfo(int indexEnemy) {
        String name = getCharacterName(enemyList.get(indexEnemy));
        String life = Integer.toString(getEnemyLife(enemyList.get(indexEnemy)));
        String defense = Integer.toString(getEnemyDefense(enemyList.get(indexEnemy)));
        String isAlive = getEnemyLife(enemyList.get(indexEnemy)) > 0 ? "Alive" : "Dead";

        return name + "\n" + "life: " + life + "\n" + "defense: " + defense + "\n" + isAlive;
    }

    /**
     * Returns a string with information of a weapon. This info is about its name,
     * attack and weight
     */
    public String getWeaponInfo(IWeapon weapon){
        String name = getWeaponName(weapon);
        String attack = Integer.toString(getWeaponAttack(weapon));
        String weight = Integer.toString(getWeaponWeight(weapon));

        return name + "\t" + attack +"\t" + weight;
    }

    /**
     * Returns the list of dead characters
     */
    public List<ICharacter> getDeadList() {
        return deadList;
    }
}