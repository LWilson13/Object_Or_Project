import javafx.application.Platform;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GameLogic {
    private Timer spawnTimer;
    private Timer collisionTimer;
    private TimerTask spawn;
    ArrayList<ImageView> meteors = new ArrayList<>();
    Meteor spawner = new Meteor();
    AnchorPane layout;
    Random rand = new Random();

    public GameLogic(AnchorPane layout) {
        spawnTimer = new Timer();
        collisionTimer = new Timer();
        StartGameLoop();
        this.layout = layout;
    }

    public void StartGameLoop() {
        spawn = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(()->{
                    for (int i = 1 + rand.nextInt(3); i > 0; i--) {
                        spawner.Spawn(layout, meteors);
                    }
                });
            }
        };

        spawnTimer.scheduleAtFixedRate(spawn, 1000, 1000);
    }

    public void Pause(){
        spawn.cancel();
        for (ImageView meteor : meteors){
            System.out.println(meteor);
        }
    }


}
