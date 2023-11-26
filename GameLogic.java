import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
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
    Meteor spawner;
    AnchorPane gameObjects;
    Random rand = new Random();
    Player player;
    Stage stage;
    StartMenu startMenu;
    Label scoreDisplay;

    public GameLogic(AnchorPane layout, Stage stage, StartMenu startMenu, Label scoreDisplay) {
        spawnTimer = new Timer();
        collisionTimer = new Timer();
        StartGameLoop();
        this.scoreDisplay = scoreDisplay;
        gameObjects = layout;
        player = new Player(layout);
        this.stage = stage;
        this.startMenu = startMenu;
        spawner = new Meteor(this.scoreDisplay);

    }

    public void StartGameLoop() {
        spawn = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(()->{

                    if(spawner!= null) {
                        for (int i = 1 + rand.nextInt(3); i > 0; i--) {
                            spawner.Spawn(gameObjects, meteors);
                        }
                    }
                });
            }
        };

        spawnTimer.scheduleAtFixedRate(spawn, 2000, 2000);

        collisionCheck = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(()->{

                    if(player != null) {
                        for (ImageView img : meteors) {
                            if (img.getBoundsInParent().intersects(player.spaceship.getBoundsInParent())) {
                                startMenu.deleteGameScene(stage);
                            }
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

public void deleteSpawner(){
        collisionTimer = null;
        spawnTimer = null;
        spawner = null;
        player = null;
}
}
