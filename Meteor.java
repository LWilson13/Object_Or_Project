import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.util.Random;

public class Meteor {

    private static int maxRad = 50;
    private static int minRad = 30;
    private static int maxSpawnPosY = 50;
    static Random rand = new Random();
    static TranslateTransition movement;

public Circle SpawnWave(){

        int xSpawn = rand.nextInt(ScreenSize.getX());
        int ySpawn = -1 * rand.nextInt(maxSpawnPosY) - 50;
        int radius = minRad + rand.nextInt(maxRad - minRad);
        Circle meteor = new Circle(xSpawn, ySpawn,radius, Color.RED);

        movement = new TranslateTransition();
        movement.setNode(meteor);
        movement.setDuration(Duration.seconds(3));
        movement.setToY(ScreenSize.getY() + 300);

        if(xSpawn < ScreenSize.getX()/2)
        {
            movement.setToX(rand.nextInt(60));
        }
        else
        {
            movement.setToX(-120 + rand.nextInt(60));
        }
        movement.play();
        return(meteor);

}

}
