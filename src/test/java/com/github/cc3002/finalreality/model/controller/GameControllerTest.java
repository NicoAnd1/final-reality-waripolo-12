package com.github.cc3002.finalreality.model.controller;

import com.github.waripolo.finalreality.controller.phases.InvalidTransitionException;
import com.github.waripolo.finalreality.controller.phases.Phase;
import com.github.waripolo.finalreality.model.character.Enemy;
import com.github.waripolo.finalreality.model.character.ICharacter;
import com.github.waripolo.finalreality.model.character.player.IPlayerCharacter;
import com.github.waripolo.finalreality.model.character.player.classes.*;
import com.github.waripolo.finalreality.controller.GameController;
import com.github.waripolo.finalreality.model.weapon.types.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Executable;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests to check the {@code Controller} class.
 *
 * @author Nicolás Fernández
 * @see GameController
 */
public class GameControllerTest {

    private GameController gameController;
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
    //private Object InvalidTransitionException;

    /**
     * Creates a new controller, a new queue of turns, characters of all classes,
     * an enemy and weapons of all classes
     */
    @BeforeEach
    void setUp() {
        gameController = new GameController();
        turns = new LinkedBlockingQueue<>();

        gameController.createBlackMage(BlackMageName);
        gameController.createEngineer(EngineerName);
        gameController.createKnight(KnightName);
        gameController.createThief(ThiefName);
        gameController.createWhiteMage(WhiteMageName);
        gameController.createEnemy(EnemyName, 20);

        gameController.createAxe(AxeName, 10, 15);
        gameController.createAxe("BigAxe", 30, 30);
        gameController.createBow(BowName, 10, 15);
        gameController.createBow("BigBow", 30, 30);
        gameController.createKnife(KnifeName, 10, 15);
        gameController.createKnife("BigKnife", 30, 30);
        gameController.createStaff(StaffName, 10, 15);
        gameController.createStaff("BigStaff", 30, 30);
        gameController.createSword(SwordName, 10, 15);
        gameController.createSword("BigSword", 30, 30);
    }


    /**
     * Checks that the controller is creating the characters and enemies correctly
     */
    @Test
    void characterCreatorTest() {
        BlackMage blackMageTest = new BlackMage(BlackMageName, 100, 50, turns);
        Engineer engineerTest = new Engineer(EngineerName, 100, 50, turns);
        Knight knightTest = new Knight(KnightName, 100, 50, turns);
        Thief thiefTest = new Thief(ThiefName, 100, 50, turns);
        WhiteMage whiteMageTest = new WhiteMage(WhiteMageName, 100, 50, turns);
        Enemy enemyTest = new Enemy(EnemyName, 100, 50, 30, 20, turns);

        var list = gameController.getCharacterList();
        var enemyList = gameController.getEnemyList();

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

        var list = gameController.getWeaponList();

        assertEquals(axeTest, list.get(0));
        assertEquals(bowTest, list.get(2));
        assertEquals(knifeTest, list.get(4));
        assertEquals(staffTest, list.get(6));
        assertEquals(swordTest, list.get(8));

        assertNotEquals(list.get(0), gameController.getCharacterList().get(0));
    }

    /**
     * Checks the information of a character
     */
    @Test
    void characterDataTest() {
        Bow bowTest = new Bow(BowName, 10, 15);

        var engineer = gameController.getCharacterList().get(1);
        var bow = gameController.getWeaponList().get(2);

        gameController.equipWeapon(engineer, bow);

        assertEquals("TestEngineer", gameController.getCharacterName(engineer));
        assertEquals(100, gameController.getCharacterLife(engineer));
        assertEquals(10, gameController.getCharacterAttack(engineer));
        assertEquals(50, gameController.getCharacterDefense(engineer));
        assertEquals(bowTest, gameController.getCharacterWeapon(engineer));
    }

    /**
     * Checks the information of an enemy
     */
    @Test
    void enemyDataTest() {
        var enemy = gameController.getEnemyList().get(0);

        assertEquals("TestEnemy", gameController.getEnemyName(enemy));
        assertEquals(100, gameController.getEnemyLife(enemy));
        assertEquals(30, gameController.getEnemyAttack((Enemy) enemy));
        assertEquals(50, gameController.getEnemyDefense(enemy));
    }

    /**
     * Checks the information of a weapon
     */
    @Test
    void weaponDataTest() {
        var axe = gameController.getWeaponList().get(0);

        assertEquals(AxeName, gameController.getWeaponName(axe));
        assertEquals(10, gameController.getWeaponAttack(axe));
        assertEquals(15, gameController.getWeaponWeight(axe));
    }

    /**
     * Checks that the weapon is being equipped by a character
     */
    @Test
    void equipWeaponTest() {
        Bow bowTest = new Bow(BowName, 10, 15);

        var engineer = gameController.getCharacterList().get(1);
        var bow = gameController.getWeaponList().get(2);

        assertNull(gameController.getCharacterWeapon(engineer));

        gameController.equipWeapon(engineer, bow);
        assertEquals(bowTest, gameController.getCharacterWeapon(engineer));
    }

    /**
     * Checks that characters and enemies can attack each other
     */
    @Test
    void attackTest() {
        var engineer = gameController.getCharacterList().get(1);
        var bow = gameController.getWeaponList().get(2);
        var enemy = gameController.getEnemyList().get(0);

        gameController.equipWeapon(engineer, bow);

        assertEquals(50, gameController.getEnemyDefense(enemy));
        assertEquals(50, gameController.getCharacterDefense(engineer));

        gameController.attackCharacter(enemy, engineer);
        gameController.attackEnemy(engineer, enemy);

        assertEquals(40, gameController.getEnemyDefense(enemy));
        assertEquals(20, gameController.getCharacterDefense(engineer));
    }

    /**
     * Checks that the character is removed from the list when it's dead
     */
    @Test
    void deadTest() {
        gameController.createBow("Hyper Bow", 150, 15);
        gameController.createEnemy("OtherEnemy", 30);

        Engineer engineer = new Engineer("TestEngineer", 100, 50, turns);
        //Knight knight = new Knight("TestKnight", 100, 50, turns);

        Enemy enemy1 = new Enemy("TestEnemy", 100, 50, 30, 20, turns);
        Enemy enemy2 = new Enemy("OtherEnemy", 100, 50, 30, 20, turns);

        var charList = gameController.getCharacterList();
        var enemyList = gameController.getEnemyList();
        var hyperBow = gameController.getWeaponList().get(10);

        assertEquals(engineer, charList.get(1));
        assertEquals(enemy1, enemyList.get(0));

        gameController.equipWeapon(charList.get(1), hyperBow);
        gameController.attackEnemy(charList.get(1), enemyList.get(0));

        assertEquals(enemy2, gameController.getEnemyList().get(0));

        gameController.attackCharacter(enemyList.get(0), charList.get(1));
        gameController.attackCharacter(enemyList.get(0), charList.get(1));
        gameController.attackCharacter(enemyList.get(0), charList.get(1));
        gameController.attackCharacter(enemyList.get(0), charList.get(1));
        gameController.attackCharacter(enemyList.get(0), charList.get(1));

        //assertEquals(knight, charList.get(1));
        assertTrue(gameController.getDeadList().contains(charList.get(1)));
    }

    /**
     * Checks that the turn is ended
     */
    @Test
    void turnTest() throws InterruptedException {
        var engineer = gameController.getCharacterList().get(1);
        var bow = gameController.getWeaponList().get(2);
        var enemy = gameController.getEnemyList().get(0);

        gameController.equipWeapon(engineer, bow);
        gameController.addToQueue((ICharacter) engineer);
        Thread.sleep(3000);
        charPlaying = (IPlayerCharacter) gameController.turnInitiated();
        charPlaying.attack(enemy);
    }

    /**
     * Checks the case when the player wins the game
     */
    @Test
    void gameWinTest() {
        var engineer = gameController.getCharacterList().get(1);
        var bow = gameController.getWeaponList().get(2);

        gameController.equipWeapon(engineer, bow);

        while (!gameController.hasWon()) {
            gameController.attackEnemy(engineer, gameController.getEnemyList().get(0));
            gameController.gameChecker();
        }
    }

    /**
     * Checks the case when the player lose the game
     */
    @Test
    void gameLoseTest() {
        var enemy = gameController.getEnemyList().get(0);

        while (!gameController.hasLose()) {
            gameController.attackCharacter(enemy, gameController.getCharacterList().get(0));
            gameController.gameChecker();
        }
    }

    /**
     * Checks if phase's transitions work as how it should do
     */
    @Test
    void phasesTest() {

        var engineer = gameController.getCharacterList().get(1);
        var bow = gameController.getWeaponList().get(1);
        var axe = gameController.getWeaponList().get(0);
        gameController.equipWeapon(engineer, bow);

        assertTrue(gameController.getPhase().isBattlePhase());

        gameController.goToAttack();
        assertFalse(gameController.getPhase().isBattlePhase());
        assertTrue(gameController.getPhase().isAttackEnemyPhase());
        assertFalse(gameController.getPhase().isEquipPhase());
        gameController.tryToAttackEnemy(engineer, gameController.getEnemyList().get(0));

        assertTrue(gameController.getPhase().isBattlePhase());
        assertFalse(gameController.getPhase().isAttackEnemyPhase());
        assertFalse(gameController.getPhase().isEquipPhase());

        gameController.goToInventory();
        assertFalse(gameController.getPhase().isBattlePhase());
        assertFalse(gameController.getPhase().isAttackEnemyPhase());
        assertTrue(gameController.getPhase().isEquipPhase());
        gameController.tryToEquipWeapon(engineer, axe);

        assertTrue(gameController.getPhase().isBattlePhase());
    }

    /**
     * Checks if the game is setting correctly
     */
    @Test
    void setGameTest() {
        gameController.setGame();

        Bow bowTest = new Bow(BowName, 10, 15);
        Knife knifeTest = new Knife(KnifeName, 10, 15);
        Knife knife2Test = new Knife("BigKnife", 30, 30);
        Staff staffTest = new Staff(StaffName, 10, 15);
        Sword swordTest = new Sword(SwordName, 10, 15);

        var blackMage = gameController.getCharacterList().get(0);
        var engineer = gameController.getCharacterList().get(1);
        var knight = gameController.getCharacterList().get(2);
        var thief = gameController.getCharacterList().get(3);
        var whiteMage = gameController.getCharacterList().get(4);

        assertEquals(knifeTest, gameController.getCharacterWeapon(blackMage));
        assertEquals(bowTest, gameController.getCharacterWeapon(engineer));
        assertEquals(swordTest, gameController.getCharacterWeapon(knight));
        assertEquals(knife2Test, gameController.getCharacterWeapon(thief));
        assertEquals(staffTest, gameController.getCharacterWeapon(whiteMage));


    }

    /**
     * Checks if the turn is initiated correctly
     *
     * @throws InterruptedException
     */
    @Test
    void beginTurnTest() throws InterruptedException {
        var engineer = gameController.getCharacterList().get(1);
        var bow = gameController.getWeaponList().get(2);
        gameController.equipWeapon(engineer, bow);

        gameController.addToQueue((ICharacter) engineer);
        Thread.sleep(3000);
        gameController.beginTurn();

        assertEquals(engineer, gameController.getCharacterInTurn());
    }

    /**
     * Checks if the information is correct
     */
    @Test
    void getInfoTest() {
        var bow = gameController.getWeaponList().get(2);

        var characterText = EngineerName + "\n" + "life: " + "100" + "\n" + "defense: " +
                "50" + "\n" + "Alive";
        var enemyText = EnemyName + "\n" + "life: " + "100" + "\n" + "defense: " +
                "50" + "\n" + "Alive";
        var weaponText = BowName + "\t" + "10" +"\t" + "15";

        assertEquals(gameController.getCharacterInfo(1), characterText);
        assertEquals(gameController.getEnemyInfo(0), enemyText);
        assertEquals(gameController.getWeaponInfo(bow), weaponText);
    }

    /**@Test
    void exceptionTesting() {
        Executable closureContainingCodeToTest = () -> {throw new IllegalArgumentException("a message")};

        assertThrows(IllegalArgumentException.class, closureContainingCodeToTest, "a message");
    }*

    @Test
    void exceptionTesting() {
        Throwable exception = assertThrows(InvalidTransitionException.class, () -> {
            throw new InvalidTransitionException("Can´t change to the battle phase");
        });
        assertEquals("Can´t change to the battle phase", exception.getMessage());
    }*/
}
