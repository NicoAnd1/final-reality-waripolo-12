package com.github.waripolo.finalreality.gui;

import com.github.waripolo.finalreality.controller.phases.Phase;
import com.github.waripolo.finalreality.model.character.Enemy;
import com.github.waripolo.finalreality.model.character.ICharacter;
import com.github.waripolo.finalreality.model.character.player.IPlayerCharacter;
import com.github.waripolo.finalreality.controller.GameController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Main entry point for the application.
 * <p>
 * <Complete here with the details of the implemented application>
 *
 * @author Ignacio Slater Muñoz.
 * @author Nicolás Fernández
 */
public class FinalReality extends Application {

  private VBox root;
  private HBox enemiesInfo, enemies, playersImages, playersInfo, info;

  private GameController controller;
  private List<Label> infoLabelsPlayer;
  private List<Label> infoLabelsEnemy;


  private TextField blackMageField, engineerField, knightField, thiefField, whiteMageField;

  private TextField axe1NameField, axe2NameField, axe1DamageField, axe2DamageField;
  private TextField bow1NameField, bow2NameField, bow1DamageField, bow2DamageField;
  private TextField knife1NameField, knife2NameField, knife1DamageField, knife2DamageField;
  private TextField staff1NameField, staff2NameField, staff1DamageField, staff2DamageField;
  private TextField sword1NameField, sword2NameField, sword1DamageField, sword2DamageField;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws FileNotFoundException {
    controller = new GameController();
    infoLabelsPlayer = new ArrayList<>();
    infoLabelsEnemy = new ArrayList<>();

    primaryStage.setTitle("Final reality");
    int width = 720;
    int height = 700;

    root = new VBox(40);
    root.setAlignment(Pos.CENTER);
    root.setBackground(new Background(new BackgroundFill(Color.DARKCYAN,
            CornerRadii.EMPTY,
            Insets.EMPTY)));
    root.setPadding(new Insets(40));


    Label title = new Label("Enter your character's names");
    title.setTextFill(Color.WHITE);
    HBox titleBox = new HBox(5);
    titleBox.setPadding(new Insets(1, 100,10,100));
    titleBox.getChildren().add(title);

    Label blackMageLabel = new Label("Black Mage's Name: ");
    blackMageField = new TextField("Name");
    HBox blackMageBox = new HBox(5);
    blackMageBox.setPadding(new Insets(1, 5 , 5, 50));
    blackMageBox.getChildren().addAll(blackMageLabel, blackMageField);

    Label engineerLabel = new Label("Engineer's Name: ");
    engineerField = new TextField("Name");
    HBox engineerBox = new HBox(5);
    engineerBox.setPadding(new Insets(1, 5 , 5, 50));
    engineerBox.getChildren().addAll(engineerLabel, engineerField);

    Label knightLabel = new Label("Knight's Name: ");
    knightField = new TextField("Name");
    HBox knightBox = new HBox(5);
    knightBox.setPadding(new Insets(1, 5 , 5, 50));
    knightBox.getChildren().addAll(knightLabel, knightField);

    Label thiefLabel = new Label("Thief's Name: ");
    thiefField = new TextField("Name");
    HBox thiefBox = new HBox(5);
    thiefBox.setPadding(new Insets(1, 5 , 5, 50));
    thiefBox.getChildren().addAll(thiefLabel, thiefField);

    Label whiteMageLabel = new Label("White Mage's Name: ");
    whiteMageField = new TextField("Name");
    HBox whiteMageBox = new HBox(5);
    whiteMageBox.setPadding(new Insets(1, 5 , 5, 50));
    whiteMageBox.getChildren().addAll(whiteMageLabel, whiteMageField);

    Button nextButton = new Button("Next...");
    nextButton.setOnAction(event -> weaponCreation());

    Scene scene = new Scene(root, width, height);
    primaryStage.setScene(scene);
    root.getChildren().addAll(titleBox, blackMageBox, engineerBox, knightBox, thiefBox,
            whiteMageBox, nextButton);
    primaryStage.show();
  }

  private void weaponCreation() {

    setGameCharacters();
    root.getChildren().clear();

    Label title2 = new Label("Enter your weapon's names");
    title2.setTextFill(Color.WHITE);
    HBox title2Box = new HBox(5);
    title2Box.setPadding(new Insets(1, 100,10,100));
    title2Box.getChildren().add(title2);

    //Axe's Box

    Label axe1NameLabel = new Label("First Axe's Name: ");
    Label axe1DamageLabel = new Label("First Axe's Damage: ");
    axe1NameField = new TextField("Name 1");
    axe1DamageField = new TextField("Damage 1");
    HBox axe1NameBox = new HBox(5);
    HBox axe1DamageBox = new HBox(5);
    axe1NameBox.getChildren().addAll(axe1NameLabel, axe1NameField);
    axe1DamageBox.getChildren().addAll(axe1DamageLabel, axe1DamageField);
    VBox axe1Box = new VBox(5);
    axe1Box.getChildren().addAll(axe1NameBox, axe1DamageBox);

    Label axe2NameLabel = new Label("Second Axe's Name: ");
    Label axe2DamageLabel = new Label("Second Axe's Damage: ");
    axe2NameField = new TextField("Name 2");
    axe2DamageField = new TextField("Damage 2");
    HBox axe2NameBox = new HBox(5);
    HBox axe2DamageBox = new HBox(5);
    axe2NameBox.getChildren().addAll(axe2NameLabel, axe2NameField);
    axe2DamageBox.getChildren().addAll(axe2DamageLabel, axe2DamageField);
    VBox axe2Box = new VBox(5);
    axe2Box.getChildren().addAll(axe2NameBox, axe2DamageBox);

    HBox bigAxeBox = new HBox(5);
    bigAxeBox.getChildren().addAll(axe1Box, axe2Box);

    //Bow's Box

    Label bow1NameLabel = new Label("First Bow's Name: ");
    Label bow1DamageLabel = new Label("First Bow's Damage: ");
    bow1NameField = new TextField("Name 1");
    bow1DamageField = new TextField("Damage 1");
    HBox bow1NameBox = new HBox(5);
    HBox bow1DamageBox = new HBox(5);
    bow1NameBox.getChildren().addAll(bow1NameLabel, bow1NameField);
    bow1DamageBox.getChildren().addAll(bow1DamageLabel, bow1DamageField);
    VBox bow1Box = new VBox(5);
    bow1Box.getChildren().addAll(bow1NameBox, bow1DamageBox);

    Label bow2NameLabel = new Label("Second Bow's Name: ");
    Label bow2DamageLabel = new Label("Second Bow's Damage: ");
    bow2NameField = new TextField("Name 2");
    bow2DamageField = new TextField("Damage 2");
    HBox bow2NameBox = new HBox(5);
    HBox bow2DamageBox = new HBox(5);
    bow2NameBox.getChildren().addAll(bow2NameLabel, bow2NameField);
    bow2DamageBox.getChildren().addAll(bow2DamageLabel, bow2DamageField);
    VBox bow2Box = new VBox(5);
    bow2Box.getChildren().addAll(bow2NameBox, bow2DamageBox);

    HBox bigBowBox = new HBox(5);
    bigBowBox.getChildren().addAll(bow1Box, bow2Box);

    //Knife's Box

    Label knife1NameLabel = new Label("First Knife's Name: ");
    Label knife1DamageLabel = new Label("First Knife's Damage: ");
    knife1NameField = new TextField("Name 1");
    knife1DamageField = new TextField("Damage 1");
    HBox knife1NameBox = new HBox(5);
    HBox knife1DamageBox = new HBox(5);
    knife1NameBox.getChildren().addAll(knife1NameLabel, knife1NameField);
    knife1DamageBox.getChildren().addAll(knife1DamageLabel, knife1DamageField);
    VBox knife1Box = new VBox(5);
    knife1Box.getChildren().addAll(knife1NameBox, knife1DamageBox);

    Label knife2NameLabel = new Label("Second Knife's Name: ");
    Label knife2DamageLabel = new Label("Second Knife's Damage: ");
    knife2NameField = new TextField("Name 2");
    knife2DamageField = new TextField("Damage 2");
    HBox knife2NameBox = new HBox(5);
    HBox knife2DamageBox = new HBox(5);
    knife2NameBox.getChildren().addAll(knife2NameLabel, knife2NameField);
    knife2DamageBox.getChildren().addAll(knife2DamageLabel, knife2DamageField);
    VBox knife2Box = new VBox(5);
    knife2Box.getChildren().addAll(knife2NameBox, knife2DamageBox);

    HBox bigKnifeBox = new HBox(5);
    bigKnifeBox.getChildren().addAll(knife1Box, knife2Box);

    //Staff's Box

    Label staff1NameLabel = new Label("First Staff's Name: ");
    Label staff1DamageLabel = new Label("First Staff's Damage: ");
    staff1NameField = new TextField("Name 1");
    staff1DamageField = new TextField("Damage 1");
    HBox staff1NameBox = new HBox(5);
    HBox staff1DamageBox = new HBox(5);
    staff1NameBox.getChildren().addAll(staff1NameLabel, staff1NameField);
    staff1DamageBox.getChildren().addAll(staff1DamageLabel, staff1DamageField);
    VBox staff1Box = new VBox(5);
    staff1Box.getChildren().addAll(staff1NameBox, staff1DamageBox);

    Label staff2NameLabel = new Label("Second Staff's Name: ");
    Label staff2DamageLabel = new Label("Second Staff's Damage: ");
    staff2NameField = new TextField("Name 2");
    staff2DamageField = new TextField("Damage 2");
    HBox staff2NameBox = new HBox(5);
    HBox staff2DamageBox = new HBox(5);
    staff2NameBox.getChildren().addAll(staff2NameLabel, staff2NameField);
    staff2DamageBox.getChildren().addAll(staff2DamageLabel, staff2DamageField);
    VBox staff2Box = new VBox(5);
    staff2Box.getChildren().addAll(staff2NameBox, staff2DamageBox);

    HBox bigStaffBox = new HBox(5);
    bigStaffBox.getChildren().addAll(staff1Box, staff2Box);

    //Sword's Box

    Label sword1NameLabel = new Label("First Sword's Name: ");
    Label sword1DamageLabel = new Label("First Sword's Damage: ");
    sword1NameField = new TextField("Name 1");
    sword1DamageField = new TextField("Damage 1");
    HBox sword1NameBox = new HBox(5);
    HBox sword1DamageBox = new HBox(5);
    sword1NameBox.getChildren().addAll(sword1NameLabel, sword1NameField);
    sword1DamageBox.getChildren().addAll(sword1DamageLabel, sword1DamageField);
    VBox sword1Box = new VBox(5);
    sword1Box.getChildren().addAll(sword1NameBox, sword1DamageBox);

    Label sword2NameLabel = new Label("Second Sword's Name: ");
    Label sword2DamageLabel = new Label("Second Sword's Damage: ");
    sword2NameField = new TextField("Name 2");
    sword2DamageField = new TextField("Damage 2");
    HBox sword2NameBox = new HBox(5);
    HBox sword2DamageBox = new HBox(5);
    sword2NameBox.getChildren().addAll(sword2NameLabel, sword2NameField);
    sword2DamageBox.getChildren().addAll(sword2DamageLabel, sword2DamageField);
    VBox sword2Box = new VBox(5);
    sword2Box.getChildren().addAll(sword2NameBox, sword2DamageBox);

    HBox bigSwordBox = new HBox(5);
    bigSwordBox.getChildren().addAll(sword1Box, sword2Box);


    Button nextButton2 = new Button("Next...");
    nextButton2.setOnAction(event -> configuringView());

    root.getChildren().addAll(title2Box, bigAxeBox, bigBowBox, bigKnifeBox, bigStaffBox,
            bigSwordBox, nextButton2);
  }

  private void configuringView() {
    setGameWeapons();
    controller.setGame();

    root.getChildren().clear();

    Label info = new Label("Configuring the game");
    Button next = new Button("Okey");
    info.setTextFill(Color.WHITE);

    next.setOnAction(event -> {
      try {
        charactersView();
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
    });

    root.getChildren().addAll(info, next);
  }

  private void charactersView() throws FileNotFoundException {

    root.getChildren().clear();

    enemiesInfo = new HBox(5);
    enemies = new HBox(20);
    playersImages = new HBox(5);
    playersInfo = new HBox(5);
    info = new HBox(5);

    root.getChildren().addAll(enemiesInfo, enemies, playersImages,
            playersInfo, info);

    setEnemiesInfo();
    setEnemies();
    setPlayersImages();
    setPlayersInfo();
    newTurn();
  }

  private void setGameCharacters() {
    Random random = new Random();

    String blackMageName = blackMageField.getText();
    String engineerName = engineerField.getText();
    String knightName = knightField.getText();
    String thiefName = thiefField.getText();
    String whiteMageName = whiteMageField.getText();

    controller.createBlackMage(blackMageName);
    controller.createEngineer(engineerName);
    controller.createKnight(knightName);
    controller.createThief(thiefName);
    controller.createWhiteMage(whiteMageName);

    for(int i=0; i<5; i++){
      var j = i+1;
      controller.createEnemy("Enemy " + j, random.nextInt(30)+5);
    }
  }

  private void setGameWeapons() {
    String axe1Name = axe1NameField.getText();
    int axe1Damage = Integer.parseInt(axe1DamageField.getText());
    String axe2Name = axe2NameField.getText();
    int axe2Damage = Integer.parseInt(axe2DamageField.getText());

    String bow1Name = bow1NameField.getText();
    int bow1Damage = Integer.parseInt(bow1DamageField.getText());
    String bow2Name = bow2NameField.getText();
    int bow2Damage = Integer.parseInt(bow2DamageField.getText());

    String knife1Name = knife1NameField.getText();
    int knife1Damage = Integer.parseInt(knife1DamageField.getText());
    String knife2Name = knife2NameField.getText();
    int knife2Damage = Integer.parseInt(knife2DamageField.getText());

    String staff1Name = staff1NameField.getText();
    int staff1Damage = Integer.parseInt(staff1DamageField.getText());
    String staff2Name = staff2NameField.getText();
    int staff2Damage = Integer.parseInt(staff2DamageField.getText());

    String sword1Name = sword1NameField.getText();
    int sword1Damage = Integer.parseInt(sword1DamageField.getText());
    String sword2Name = sword2NameField.getText();
    int sword2Damage = Integer.parseInt(sword2DamageField.getText());

    Random random = new Random();

    controller.createAxe(axe1Name, axe1Damage, random.nextInt(30)+5);
    controller.createAxe(axe2Name, axe2Damage, random.nextInt(30)+5);

    controller.createBow(bow1Name, bow1Damage, random.nextInt(30)+5);
    controller.createBow(axe2Name, bow2Damage, random.nextInt(30)+5);

    controller.createKnife(knife1Name, knife1Damage, random.nextInt(30)+5);
    controller.createKnife(knife2Name, knife2Damage, random.nextInt(30)+5);

    controller.createStaff(staff1Name, staff1Damage, random.nextInt(30)+5);
    controller.createStaff(staff2Name, staff2Damage, random.nextInt(30)+5);

    controller.createSword(sword1Name, sword1Damage, random.nextInt(30)+5);
    controller.createSword(sword2Name, sword2Damage, random.nextInt(30)+5);
  }

  private void setEnemies() throws FileNotFoundException {
    for(int i=0; i<controller.getEnemyList().size(); i++) {
      int indexEnemy = i;
      ImageView imageEnemy = new ImageView(new Image(new FileInputStream
              ("src/main/resources/DarkGeneral.gif")));
      Button enemyButton = new Button();

      enemyButton.setOnAction(event -> controller.tryToAttackEnemy((IPlayerCharacter)
              controller.getCharacterInTurn(), controller.getEnemyList().get(indexEnemy)));

      enemyButton.setGraphic(imageEnemy);

      enemies.getChildren().add(enemyButton);
    }
  }

  private void setEnemiesInfo() {
    for(int i= 0; i<controller.getEnemyList().size(); i++){
      Label info = new Label(controller.getEnemyInfo(i));
      info.setTextFill(Color.WHITE);
      info.setPrefWidth(300);
      infoLabelsEnemy.add(info);

      enemiesInfo.getChildren().add(info);
    }
  }

  private void setPlayersImages() throws FileNotFoundException {
    ImageView imageKnight = new ImageView(new Image(new FileInputStream
            ("src/main/resources/Knight.gif")));
    ImageView imageWhiteMage = new ImageView(new Image(new FileInputStream
            ("src/main/resources/WhiteMage.gif")));
    ImageView imageThief = new ImageView(new Image(new FileInputStream
            ("src/main/resources/Thief.gif")));
    ImageView imageEngineer = new ImageView(new Image(new FileInputStream
            ("src/main/resources/Engineer.gif")));
    ImageView imageBlackMage = new ImageView(new Image(new FileInputStream
            ("src/main/resources/BlackMage.gif")));

    var knight = new HBox();
    knight.setAlignment(Pos.CENTER);
    knight.setPrefWidth(90);
    knight.getChildren().add(imageKnight);

    var whiteMage= new HBox();
    whiteMage.setAlignment(Pos.CENTER);
    whiteMage.setPrefWidth(90);
    whiteMage.getChildren().add(imageWhiteMage);

    var thief = new HBox();
    thief.setAlignment(Pos.CENTER);
    thief.setPrefWidth(90);
    thief.getChildren().add(imageThief);

    var engineer = new HBox();
    engineer.setAlignment(Pos.CENTER);
    engineer.setPrefWidth(90);
    engineer.getChildren().add(imageEngineer);

    var blackMage = new HBox();
    blackMage.setAlignment(Pos.CENTER);
    blackMage.setPrefWidth(90);
    blackMage.getChildren().add(imageBlackMage);

    playersImages.getChildren().addAll(blackMage, engineer, knight, thief, whiteMage);
  }

  private void setPlayersInfo(){
    for(int i= 0; i<controller.getCharacterList().size(); i++){
      Label info = new Label(controller.getCharacterInfo(i));
      info.setTextFill(Color.WHITE);
      info.setPrefWidth(90);
      infoLabelsPlayer.add(info);

      playersInfo.getChildren().add(info);
    }
  }

  private void setInventory() {

    controller.goToInventory();

    info.getChildren().clear();
    VBox weapons1 = new VBox(1);
    VBox weapons2 = new VBox(1);
    VBox weaponInfo = new VBox(1);

    Label equipWeaponInfo = new Label("The actual weapon of " +
            controller.getCharacterInTurn().getName() + " is");
    Label equippedWeapon = new Label(controller.getWeaponInfo(controller.getCharacterWeapon
            ((IPlayerCharacter) controller.getCharacterInTurn())));
    equipWeaponInfo.setTextFill(Color.WHITE);
    equippedWeapon.setTextFill(Color.WHITE);
    weaponInfo.getChildren().addAll(equipWeaponInfo, equippedWeapon);

    for(int i=0; i<controller.getWeaponList().size()/2; i++){
      Button buttonWeapon = new Button(controller.getWeaponInfo(controller.
              getWeaponList().get(i)));
      int finalI = i;

      buttonWeapon.setOnAction(event -> controller.tryToEquipWeapon((IPlayerCharacter)
              controller.getCharacterInTurn(), controller.getWeaponList().get(finalI)));

      weapons1.getChildren().add(buttonWeapon);
    }

    for(int i=controller.getWeaponList().size()/2; i<controller.getWeaponList().size(); i++){
      Button buttonWeapon = new Button(controller.getWeaponInfo(controller.
              getWeaponList().get(i)));
      int finalI = i;

      buttonWeapon.setOnAction(event -> controller.tryToEquipWeapon((IPlayerCharacter)
              controller.getCharacterInTurn(), controller.getWeaponList().get(finalI)));
      weapons2.getChildren().add(buttonWeapon);
    }

    Button backButton = new Button("Back");
    backButton.setOnAction(event -> turnUser());

    info.getChildren().addAll(weaponInfo, weapons1, weapons2, backButton);
  }

  private void setAttackEnemy() {
    controller.goToAttack();

    info.getChildren().clear();

    Button readyButton = new Button("Ready");
    readyButton.setOnAction(event -> refreshInfoEnemy());

    controller.addToQueue(controller.getCharacterInTurn());

    info.getChildren().add(readyButton);
  }

  private void setAttackCharacter() {
    info.getChildren().clear();

    Random random = new Random();

    int j = random.nextInt(5);

    while (controller.getDeadList().contains(controller.getCharacterList().get(j))) {
      j = random.nextInt(5);
    }

    controller.attackCharacter(controller.getCharacterInTurn(), controller.
            getCharacterList().get(j));
    refreshInfoPlayer(j);


    Label textToShow = new Label(controller.getCharacterInTurn().getName() + " has done " + Integer.toString(controller.getEnemyAttack((Enemy) controller.getCharacterInTurn())) + " of damage");
    Button okButton = new Button("Okey");
    okButton.setOnAction(event -> newTurn());
    controller.addToQueue(controller.getCharacterInTurn());

    info.getChildren().addAll(textToShow, okButton);
  }

  private void refreshInfoPlayer(int indexPlayer){
    infoLabelsPlayer.get(indexPlayer).setText(controller.getCharacterInfo(indexPlayer));
  }

  private void refreshInfoEnemy(){

    info.getChildren().clear();
    enemiesInfo.getChildren().clear();
    setEnemiesInfo();

    for(int i=0; i<controller.getEnemyList().size(); i++) {
      int indexEnemy = i;
      if (! controller.getEnemyList().get(indexEnemy).isAlive()) {
        enemyDead(indexEnemy);
      }
    }

    Label textToShow = new Label(controller.getCharacterInTurn().getName() +
            " has done " + Integer.toString(controller.getCharacterWeapon((IPlayerCharacter)
            controller.getCharacterInTurn()).getAttack()) + " of damage");

    Button okButton = new Button("Okey");
    okButton.setOnAction(event -> newTurn());
    info.getChildren().addAll(textToShow, okButton);

  }


  private void enemyDead(int indexEnemy){
    enemies.getChildren().get(indexEnemy).setDisable(true);
  }

  private void turnUser(){

    info.getChildren().clear();
    VBox box = new VBox(20);
    info.getChildren().add(box);
    Label nameCharacter = new Label("Turn of " + controller.getCharacterInTurn().getName());
    nameCharacter.setTextFill(Color.WHITE);
    Button attack = new Button("Attack enemy");
    Button inventory = new Button("Equip new weapon");

    attack.setOnAction(event -> setAttackEnemy());
    inventory.setOnAction(event -> setInventory());

    box.getChildren().addAll(nameCharacter, attack, inventory);

  }

  private void turnCPU() {

    info.getChildren().clear();

    Label infoLabel = new Label(controller.getCharacterInTurn().getName() + " is attacking");
    infoLabel.setTextFill(Color.WHITE);

    Button nextButton = new Button("Next...");
    nextButton.setOnAction(event -> setAttackCharacter());

    info.getChildren().addAll(infoLabel, nextButton);
  }

  private void newTurn() {

    info.getChildren().clear();

    controller.beginTurn();
    Label infoLabel = new Label("Refreshing");
    infoLabel.setTextFill(Color.WHITE);

    Button nextButton = new Button("Next...");

    if (controller.getCharacterInTurn().isEnemy()) {
      nextButton.setOnAction(event -> turnCPU());
    }

    if (! controller.getCharacterInTurn().isEnemy()) {
      nextButton.setOnAction(event -> turnUser());
    }

    if (controller.gameChecker()) {
      if (controller.hasLose()) {
        nextButton.setOnAction(event -> loser());
      }
      if (controller.hasWon()) {
        nextButton.setOnAction(event -> winner());
      }
    }

    info.getChildren().addAll(infoLabel, nextButton);

  }

  private void loser() {
    info.getChildren().clear();
    Label message = new Label("You have lose \n Saad :c");


    info.getChildren().addAll(message);
  }

  private void winner() {
    info.getChildren().clear();
    Label message = new Label("You have won \n Congrats c:");

    info.getChildren().addAll(message);
  }
}

