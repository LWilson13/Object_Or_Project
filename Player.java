import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

import java.awt.*;

public class Player {
    private static final double SPACESHIP_SPEED = 15.0;
    private double spaceshipX = 300;
    private double spaceshipY = 600;
    private Polygon spaceship;

    public Player(AnchorPane layout){

        spaceship = createSpaceship();
        layout.getChildren().add(spaceship);



        layout.setOnKeyPressed(event -> {
            switch(event.getCode()){
                case W:
                    moveSpaceship(0, -SPACESHIP_SPEED);
                    break;
                case A:
                    moveSpaceship(-SPACESHIP_SPEED, 0);
                    break;
                case S:
                    moveSpaceship(0, SPACESHIP_SPEED);
                    break;
                case D:
                    moveSpaceship(SPACESHIP_SPEED, 0);
                    break;
            }
        });
    }
    private void moveSpaceship(double dx, double dy) {
        spaceshipX += dx;
        spaceshipY += dy;

        // Limit the spaceship's movement within the window boundaries
        spaceshipX = Math.min(SceneTemplate.sizeX - 10, Math.max(10, spaceshipX));
        spaceshipY = Math.min(SceneTemplate.sizeY - 15, Math.max(SceneTemplate.sizeY / 3, spaceshipY));

        AnchorPane layout = (AnchorPane) spaceship.getParent();
        layout.getChildren().remove(spaceship);

        Polygon newSpaceship = createSpaceship();
        layout.getChildren().add(newSpaceship);
    }

    private Polygon createSpaceship(){
    spaceship = new Polygon(
                0, -20,
                        -10, 10,
                        10, 10
    );

        spaceship.setFill(Color.LIGHTGRAY);
        spaceship.setTranslateX(spaceshipX);
        spaceship.setTranslateY(spaceshipY);
        return spaceship;
}

}
