import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Main extends Application {

    Scene mainMenu;
    Scene mainGame;
    Random rand = new Random();
    AlertBox menuTemplate;
    public AnchorPane mainGameLayout;
    public Meteor spawner;

    TranslateTransition meteorMovement;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        spawner = new Meteor();
        menuTemplate = new AlertBox();

     /*   //Main Menu Setup
        Label mainMenuTitle = new Label("Space Game");
        Button startButton = new Button("Start Game");
        startButton.setOnAction(e -> primaryStage.setScene(mainGame));

        AnchorPane mainMenuLayout = new AnchorPane();
        AnchorPane.setTopAnchor(mainMenuTitle, 100.0);
        AnchorPane.setLeftAnchor(mainMenuTitle, 200.0);
        AnchorPane.setBottomAnchor(startButton, 250.0);
        AnchorPane.setLeftAnchor(startButton, 200.0);

        mainMenuLayout.getChildren().addAll(startButton, mainMenuTitle);
        mainMenu = new Scene(mainMenuLayout, 500,750);
    */

        //Main Game Setup
        Button pauseButton = new Button("Pause");
        pauseButton.setOnAction(e -> menuTemplate.display("Pause Menu", "Paused", "Resume", this));


        mainGameLayout = new AnchorPane();
        AnchorPane.setTopAnchor(pauseButton, 50.0);
        AnchorPane.setLeftAnchor(pauseButton, 50.0);
        mainGameLayout.getChildren().addAll(pauseButton);
        mainGameLayout.setStyle("-fx-background-color: black;");


        
        mainGame = new Scene(mainGameLayout,ScreenSize.getX(), ScreenSize.getY());


        primaryStage.setTitle("Space Game");
        primaryStage.setScene(mainGame);
        primaryStage.show();
        menuTemplate.display("Main Menu", "Space Game", "Start", this);

    }

    public void MeteorSpawn(){
        int numInWave = 1 + rand.nextInt(3);
        for(int i = 0; i <= numInWave; i++){
            Circle meteor = spawner.SpawnWave();
            mainGameLayout.getChildren().add(meteor);
        }
    }
    public void CreateTimer(){
        GameLogic gameLogic = new GameLogic(this);
    }
}



