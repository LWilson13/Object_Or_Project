import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GameScene extends SceneTemplate{
    PauseMenu pauseMenu;
    GameLogic gameLogic;
    Button pauseButton = new Button("Pause");

    public GameScene(Stage stage){

        pauseMenu = new PauseMenu(stage, this);

        pauseButton.setOnAction(e-> stage.setScene(pauseMenu.scene));
        pauseButton.setId("pauseButton");

        AnchorPane.setTopAnchor(pauseButton, 50.0);
        AnchorPane.setLeftAnchor(pauseButton, 50.0);
        layout.setStyle("-fx-background-color: black;");

        layout.getChildren().add(pauseButton);






        gameLogic = new GameLogic(layout, stage);
        scene = new Scene(layout, sizeX, sizeY);
    }
}
