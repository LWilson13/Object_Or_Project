import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class PauseMenu extends SceneTemplate {

    Button resumeButton = new Button("Resume");
    Button quitButton = new Button();
    Image exitImage = new Image("src/EXIT.png");
    ImageView exit = new ImageView(exitImage);

    public PauseMenu() {

        exit.setFitWidth(48);
        exit.setFitHeight(18);

        quitButton.setGraphic(exit);

        AnchorPane.setLeftAnchor(resumeButton, (double) (sizeX / 2 - 27));
        AnchorPane.setTopAnchor(resumeButton, (double) (sizeY / 2));
        AnchorPane.setLeftAnchor(quitButton, (sizeX / 2 - 30.5));
        AnchorPane.setTopAnchor(quitButton, (double) (sizeY / 2 + 50));

        layout = new AnchorPane(resumeButton, quitButton);
        layout.setStyle("-fx-background-color: black;");

        scene = new Scene(layout, sizeX, sizeY);
    }
}
