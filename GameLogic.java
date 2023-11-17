import javafx.application.Platform;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GameLogic {
    private Timer spawnTimer;
    private TimerTask spawn;
    private Timer collisionTimer;
    private TimerTask collisionCheck;
    ArrayList<ImageView> meteors = new ArrayList<>();
    Meteor spawner = new Meteor();
    AnchorPane gameObjects;
    Random rand = new Random();
    Player player;
    GameOverMenu gameOver = new GameOverMenu();
    Stage stage;

    public GameLogic(AnchorPane layout, Stage stage) {
        spawnTimer = new Timer();
        collisionTimer = new Timer();
        StartGameLoop();
        gameObjects = layout;
        player = new Player(layout);
        this.stage = stage;
    }

    public void StartGameLoop() {
        spawn = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(()->{
                    for (int i = 1 + rand.nextInt(3); i > 0; i--) {
                        spawner.Spawn(gameObjects, meteors);
                    }
                });
            }
        };

        spawnTimer.scheduleAtFixedRate(spawn, 2000, 2000);

        collisionCheck = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(()->{
                    for (ImageView img : meteors) {
                        if(img.getBoundsInParent().intersects(player.spaceship.getBoundsInParent())) {
                            System.out.println("collided");
                            stage.setScene(gameOver.scene);
                        }
                    }
                });
            }
        };

        collisionTimer.scheduleAtFixedRate(collisionCheck, 100, 100);


    }


    public void Pause(){
        spawn.cancel();
        for (ImageView meteor : meteors){
            System.out.println(meteor);
        }
    }


}
