import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SceneTemplate {

    Scene scene;
    AnchorPane layout;
    static int sizeX = 800;
    static int sizeY = 800;
    Image backgroundStars = new Image("src/Stars.png");
    ImageView background = new ImageView(backgroundStars);


    public SceneTemplate(){

        background.setPreserveRatio(true);
        background.setFitWidth(sizeX);

        layout = new AnchorPane();
        layout.getChildren().add(background);
        layout.setStyle("-fx-background-color: black;");
    }



}

