import javafx.animation.TranslateTransition;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class Meteor {

    private static int maxRad = 100;
    private static int minRad = 30;
    private static int maxSpawnPosY = 100;
    static Random rand = new Random();
    static TranslateTransition movement;
    Label scoreDisplay;
    int score = 0;

    public Meteor(Label scoreDisplay){
        this.scoreDisplay = scoreDisplay;
    }


public ImageView Spawn(AnchorPane layout, ArrayList meteors){

        int pauseButtonIndex = layout.getChildren().indexOf((layout.lookup("#pauseButton")));

        int xSpawn = rand.nextInt(SceneTemplate.sizeX - 25);
        int ySpawn = -1 * rand.nextInt(maxSpawnPosY) - 150;
        int rotationAngle = rand.nextInt(360);
        int radius = minRad + rand.nextInt(maxRad - minRad);
        Image meteorImage = new Image("src/Asteroid big.png");
        ImageView meteor = new ImageView(meteorImage);

        meteor.setX(xSpawn);
        meteor.setY(ySpawn);
        meteor.setRotate(rotationAngle);

        meteor.setFitWidth(radius * 2);
        meteor.setFitHeight(radius * 2);

        meteors.add(meteor);

        movement = new TranslateTransition();
        movement.setNode(meteor);
        movement.setDuration(Duration.seconds(3));
        movement.setToY(SceneTemplate.sizeY + 300);
        movement.setOnFinished(e->{
            layout.getChildren().remove(meteor);
            meteors.remove(meteor);
            score++;
            scoreDisplay.setText("Score: " + score);
        });

        if(xSpawn < SceneTemplate.sizeY/2)
        {
            movement.setToX(rand.nextInt(60));
        }
        else
        {
            movement.setToX(-120 + rand.nextInt(60));
        }
        movement.play();
        layout.getChildren().add(pauseButtonIndex, meteor);
        return (meteor);
}

}
