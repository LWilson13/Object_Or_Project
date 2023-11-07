import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class GameScene extends SceneTemplate{

    Button pauseButton = new Button("Pause");

    public GameScene(){
        layout = new AnchorPane();

        AnchorPane.setTopAnchor(pauseButton, 50.0);
        AnchorPane.setLeftAnchor(pauseButton, 50.0);
        layout.setStyle("-fx-background-color: black;");

        layout.getChildren().add(pauseButton);

        scene = new Scene(layout, sizeX, sizeY);
    }
}
