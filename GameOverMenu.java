import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.awt.*;

public class GameOverMenu extends SceneTemplate{

    Button restartButton = new Button("Restart");
    Button quitButton = new Button("Quit Game");

    public GameOverMenu(){


        AnchorPane.setLeftAnchor(restartButton, (double)(sizeX / 2 - 27));
        AnchorPane.setTopAnchor(restartButton, (double)(sizeY / 2));
        AnchorPane.setLeftAnchor(quitButton, (sizeX / 2 - 36.5));
        AnchorPane.setTopAnchor(quitButton, (double)(sizeY / 2 + 50));

        layout = new AnchorPane(restartButton, quitButton);
        layout.setStyle("-fx-background-color: black;");

        scene = new Scene(layout, sizeX, sizeY);
    }
}
