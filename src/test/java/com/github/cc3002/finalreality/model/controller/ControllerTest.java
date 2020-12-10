package com.github.cc3002.finalreality.model.controller;

import com.github.waripolo.finalreality.model.character.Enemy;
import com.github.waripolo.finalreality.model.character.ICharacter;
import com.github.waripolo.finalreality.model.character.player.IPlayerCharacter;
import com.github.waripolo.finalreality.model.character.player.classes.*;
import com.github.waripolo.finalreality.model.controller.Controller;
import com.github.waripolo.finalreality.model.weapon.types.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests to check the {@code Controller} class.
 *
 * @author Nicolás Fernández
 * @see Controller
 */
public class ControllerTest {

    private Controller controller;
    private BlockingQueue<ICharacter> turns;

    final String BlackMageName = "TestBlackMage";
    final String EngineerName = "TestEngineer";
    final String KnightName = "TestKnight";
    final String ThiefName = "TestThief";
    final String WhiteMageName = "TestWhiteMage";
    final String EnemyName = "TestEnemy";

    final String AxeName = "TestAxe";
    final String BowName = "TestBow";
    final String KnifeName = "TestKnife";
    final String StaffName = "TestStaff";
    final String SwordName = "TestSword";

    IPlayerCharacter charPlaying;

    /**
     * Creates a new controller, a new queue of turns, characters of all classes,
     * an enemy and weapons of all classes
     */
    @BeforeEach
    void setUp() {
        controller = new Controller();
        turns = new LinkedBlockingQueue<>();

        controller.createBlackMage(BlackMageName);
        controller.createEngineer(EngineerName);
        controller.createKnight(KnightName);
        controller.createThief(ThiefName);
        controller.createWhiteMage(WhiteMageName);
        controller.createEnemy(EnemyName);

        controller.createAxe(AxeName, 10, 15);
        controller.createBow(BowName, 10, 15);
        controller.createKnife(KnifeName, 10, 15);
        controller.createStaff(StaffName, 10, 15);
        controller.createSword(SwordName, 10, 15);
    }


    /**
     * Checks that the controller is creating the characters and enemies correctly
     */
    @Test
    void characterCreatorTest() {
        BlackMage blackMageTest = new BlackMage(BlackMageName, 100, 50, turns, 100);
        Engineer engineerTest = new Engineer(EngineerName, 100, 50, turns);
        Knight knightTest = new Knight(KnightName, 100, 50, turns);
        Thief thiefTest = new Thief(ThiefName, 100, 50, turns);
        WhiteMage whiteMageTest = new WhiteMage(WhiteMageName, 100, 50, turns, 100);
        Enemy enemyTest = new Enemy(EnemyName, 100, 50, 30, 20, turns);

        var list = controller.getCharacterList();
        var enemyList = controller.getEnemyList();

        assertEquals(blackMageTest, list.get(0));
        assertEquals(engineerTest, list.get(1));
        assertEquals(knightTest, list.get(2));
        assertEquals(thiefTest, list.get(3));
        assertEquals(whiteMageTest, list.get(4));
        assertEquals(enemyTest, enemyList.get(0));
    }

    /**
     * Checks that the controller is creating weapons correctly
     */
    @Test
    void weaponCreatorTest() {
        Axe axeTest = new Axe(AxeName, 10, 15);
        Bow bowTest = new Bow(BowName, 10, 15);
        Knife knifeTest = new Knife(KnifeName, 10, 15);
        Staff staffTest = new Staff(StaffName, 10, 15);
        Sword swordTest = new Sword(SwordName, 10, 15);

        var list = controller.getWeaponList();

        assertEquals(axeTest, list.get(0));
        assertEquals(bowTest, list.get(1));
        assertEquals(knifeTest, list.get(2));
        assertEquals(staffTest, list.get(3));
        assertEquals(swordTest, list.get(4));

        assertNotEquals(list.get(0), controller.getCharacterList().get(0));
    }

    /**
     * Checks the information of a character
     */
    @Test
    void characterDataTest() {
        Bow bowTest = new Bow(BowName, 10, 15);

        var engineer = controller.getCharacterList().get(1);
        var bow = controller.getWeaponList().get(1);

        controller.equipWeapon(engineer, bow);

        assertEquals(100, controller.getCharacterLife(engineer));
        assertEquals(10, controller.getCharacterAttack(engineer));
        assertEquals(50, controller.getCharacterDefense(engineer));
        assertEquals(bowTest, controller.getCharacterWeapon(engineer));
    }

    /**
     * Checks the information of an enemy
     */
    @Test
    void enemyDataTest() {
        var enemy = controller.getEnemyList().get(0);

        assertEquals(100, controller.getEnemyLife(enemy));
        assertEquals(30, controller.getEnemyAttack((Enemy) enemy));
        assertEquals(50, controller.getEnemyDefense(enemy));
    }

    /**
     * Checks the information of a weapon
     */
    @Test
    void weaponDataTest() {
        var axe = controller.getWeaponList().get(0);

        assertEquals(AxeName, controller.getWeaponName(axe));
        assertEquals(10, controller.getWeaponAttack(axe));
        assertEquals(15, controller.getWeaponWeight(axe));
    }

    /**
     * Checks that the weapon is being equipped by a character
     */
    @Test
    void equipWeaponTest() {
        Bow bowTest = new Bow(BowName, 10, 15);

        var engineer = controller.getCharacterList().get(1);
        var bow = controller.getWeaponList().get(1);

        assertNull(controller.getCharacterWeapon(engineer));

        controller.equipWeapon(engineer, bow);
        assertEquals(bowTest, controller.getCharacterWeapon(engineer));
    }

    /**
     * Checks that characters and enemies can attack each other
     */
    @Test
    void attackTest() {
        var engineer = controller.getCharacterList().get(1);
        var bow = controller.getWeaponList().get(1);
        var enemy = controller.getEnemyList().get(0);

        controller.equipWeapon(engineer, bow);

        assertEquals(50, controller.getEnemyDefense(enemy));
        assertEquals(50, controller.getCharacterDefense(engineer));

        controller.attackCharacter(enemy, engineer);
        controller.attackEnemy(engineer, enemy);

        assertEquals(40, controller.getEnemyDefense(enemy));
        assertEquals(20, controller.getCharacterDefense(engineer));
    }

    /**
     * Checks that the character is removed from the list when it's dead
     */
    @Test
    void deadTest() {
        controller.createBow("Hyper Bow", 150, 15);
        controller.createEnemy("OtherEnemy");

        Engineer engineer = new Engineer("TestEngineer", 100, 50, turns);
        Knight knight = new Knight("TestKnight", 100, 50, turns);

        Enemy enemy1 = new Enemy("TestEnemy", 100, 50, 30, 20, turns);
        Enemy enemy2 = new Enemy("OtherEnemy", 100, 50, 30, 20, turns);

        var charList = controller.getCharacterList();
        var enemyList = controller.getEnemyList();
        var hyperBow = controller.getWeaponList().get(5);

        assertEquals(engineer, charList.get(1));
        assertEquals(enemy1, enemyList.get(0));

        controller.equipWeapon(charList.get(1), hyperBow);
        controller.attackEnemy(charList.get(1), enemyList.get(0));

        assertEquals(enemy2, controller.getEnemyList().get(0));

        controller.attackCharacter(enemyList.get(0), charList.get(1));
        controller.attackCharacter(enemyList.get(0), charList.get(1));
        controller.attackCharacter(enemyList.get(0), charList.get(1));
        controller.attackCharacter(enemyList.get(0), charList.get(1));
        controller.attackCharacter(enemyList.get(0), charList.get(1));

        assertEquals(knight, charList.get(1));
    }

    /**
     * Checks that the turn is ended
     */
    @Test
    void turnTest() throws InterruptedException {
        var engineer = controller.getCharacterList().get(1);
        var bow = controller.getWeaponList().get(1);
        var enemy = controller.getEnemyList().get(0);

        controller.equipWeapon(engineer, bow);
        controller.addToQueue((ICharacter) engineer);
        Thread.sleep(3000);
        charPlaying = (IPlayerCharacter) controller.turnInitiated();
        charPlaying.attack(enemy);
    }

    /**
     * Checks the case when the player wins the game
     */
    @Test
    void gameWinTest() {
        var engineer = controller.getCharacterList().get(1);
        var bow = controller.getWeaponList().get(1);

        controller.equipWeapon(engineer, bow);

        while (!(controller.getEnemyList().isEmpty())) {
            controller.attackEnemy(engineer, controller.getEnemyList().get(0));
            controller.gameChecker();
        }
    }

    /**
     * Checks the case when the player lose the game
     */
    @Test
    void gameLoseTest() {
        var enemy = controller.getEnemyList().get(0);

        while (!(controller.getCharacterList().isEmpty())) {
            controller.attackCharacter(enemy, controller.getCharacterList().get(0));
            controller.gameChecker();
        }
    }
}
