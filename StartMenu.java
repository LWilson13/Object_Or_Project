import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class StartMenu extends SceneTemplate{

    Button startButton = new Button("Start");
    Button quitButton = new Button("Quit Game");

    public StartMenu(){

        AnchorPane.setLeftAnchor(startButton, (double)(sizeX / 2 - 20));
        AnchorPane.setTopAnchor(startButton, (double)(sizeY / 2));
        AnchorPane.setLeftAnchor(quitButton, (sizeX / 2 - 36.5));
        AnchorPane.setTopAnchor(quitButton, (double)(sizeY / 2 + 50));

        layout = new AnchorPane(startButton, quitButton);
        layout.setStyle("-fx-background-color: black;");

        scene = new Scene(layout, sizeX, sizeY);
    }
}
