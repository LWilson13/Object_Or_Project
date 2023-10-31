import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;
import java.util.Random;

public class Meteor {

    private static int maxRad = 200;
    private static int minRad = 75;
    private static int maxSpawnPosY = 100;
    static Random rand = new Random();
    static TranslateTransition movement;

public ImageView SpawnWave(){

        int xSpawn = rand.nextInt(ScreenSize.getX());
        int ySpawn = -1 * rand.nextInt(maxSpawnPosY) - 150;
        int rotationAngle = rand.nextInt(360);
        int radius = minRad + rand.nextInt(maxRad - minRad);
        Image meteorImage = new Image("src/Asteroid_big.png");
        ImageView meteor = new ImageView(meteorImage);

        meteor.setX(xSpawn);
        meteor.setY(ySpawn);
        meteor.setRotate(rotationAngle);

        meteor.setFitWidth(radius * 2);
        meteor.setFitHeight(radius * 2);

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
