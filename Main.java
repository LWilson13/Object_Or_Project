import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Main extends Application {
    GameScene gameScene = new GameScene();
    PauseMenu pauseMenu = new PauseMenu();
    GameLogic gameLogic;
    Player player;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        StartMenu startMenu = new StartMenu();
        GameOverMenu gameOverMenu = new GameOverMenu();


        //Main menu button setup
        Button startButton = startMenu.startButton;
        Button startQuitGame = startMenu.quitButton;
        startButton.setOnAction(e -> {
            primaryStage.setScene(gameScene.scene);
            CreateTimer();
        });
        startQuitGame.setOnAction(e -> Platform.exit());


        //Game Scene button setup
        Button pauseButton = gameScene.pauseButton;
        pauseButton.setOnAction(e ->{
            primaryStage.setScene(pauseMenu.scene);
            gameLogic.Pause();
        });
        player = new Player(gameScene.layout);

        //Pause Menu Button Setup
        Button resumeButton = pauseMenu.resumeButton;
        Button quitButton = pauseMenu.quitButton;
        resumeButton.setOnAction(e-> {

            primaryStage.setScene(gameScene.scene);
            gameLogic.StartGameLoop();
        });
        quitButton.setOnAction(e-> Platform.exit());

        //Game over button setup
        Button restart = gameOverMenu.restartButton;
        Button gameOverQuit = gameOverMenu.quitButton;
        restart.setOnAction(e -> primaryStage.setScene(gameScene.scene));
        gameOverQuit.setOnAction(e-> Platform.exit());



        //Initial stage setup
        primaryStage.setTitle("Space Game");
        primaryStage.setScene(startMenu.scene);
        primaryStage.setResizable(false);
        primaryStage.show();


    }

    public void AddNode(Node meteor){
        gameScene.layout.getChildren().add(meteor);
    }

    public void CreateTimer(){
        gameLogic = new GameLogic(gameScene.layout);
    }
}



