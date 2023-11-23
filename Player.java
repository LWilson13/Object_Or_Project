import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Player {
    private static final double SPACESHIP_SPEED = 15.0;
    private double spaceshipX = 360;
    private double spaceshipY = 600;
    private Image spaceshipImage = new Image("src/Star Fighter asset 1.png");
    public ImageView spaceship;
    public Player(AnchorPane layout){

        spaceship = createSpaceship();
        int pauseButtonIndex = layout.getChildren().indexOf((layout.lookup("#pauseButton")));
        layout.getChildren().add(pauseButtonIndex, spaceship);



        layout.setOnKeyPressed(event -> {

            if(event.getCode() == KeyCode.W)
            {
                moveSpaceship(0, -SPACESHIP_SPEED);
            }
            else if (event.getCode() == KeyCode.S)
            {
                moveSpaceship(0, SPACESHIP_SPEED);
            }
            if(event.getCode() == KeyCode.A)
            {
                moveSpaceship(-SPACESHIP_SPEED, 0);
            }
            else if (event.getCode() == KeyCode.D)
            {
                moveSpaceship(SPACESHIP_SPEED, 0);
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

        ImageView newSpaceship = createSpaceship();
        layout.getChildren().add(newSpaceship);
    }

    private ImageView createSpaceship(){
    spaceship = new ImageView(spaceshipImage);

        spaceship.setTranslateX(spaceshipX);
        spaceship.setTranslateY(spaceshipY);
        return spaceship;
}

}
