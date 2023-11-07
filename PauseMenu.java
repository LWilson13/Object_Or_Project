import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class PauseMenu extends SceneTemplate {

    Button resumeButton = new Button("Resume");
    Button quitButton = new Button("Quit Game");

    public PauseMenu() {


        AnchorPane.setLeftAnchor(resumeButton, (double) (sizeX / 2 - 27));
        AnchorPane.setTopAnchor(resumeButton, (double) (sizeY / 2));
        AnchorPane.setLeftAnchor(quitButton, (sizeX / 2 - 36.5));
        AnchorPane.setTopAnchor(quitButton, (double) (sizeY / 2 + 50));

        layout = new AnchorPane(resumeButton, quitButton);
        layout.setStyle("-fx-background-color: black;");

        scene = new Scene(layout, sizeX, sizeY);
    }
}
