import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GameScene extends SceneTemplate{
    PauseMenu pauseMenu;
    GameLogic gameLogic;
    Button pauseButton = new Button("Pause");
    Label scoreDisplay;
    public int score;

    public GameScene(Stage stage, StartMenu startMenu){

        pauseMenu = new PauseMenu(stage, this);

        pauseButton.setOnAction(e-> stage.setScene(pauseMenu.scene));
        pauseButton.setId("pauseButton");

        scoreDisplay = new Label("Score: ");
        scoreDisplay.setTextFill(Color.WHITE);
        scoreDisplay.setFont(new Font("Ariel", 24));


        AnchorPane.setTopAnchor(scoreDisplay, 50.0);
        AnchorPane.setRightAnchor(scoreDisplay, 50.0);
        AnchorPane.setTopAnchor(pauseButton, 50.0);
        AnchorPane.setLeftAnchor(pauseButton, 50.0);
        layout.setStyle("-fx-background-color: black;");

        layout.getChildren().addAll(pauseButton, scoreDisplay);






        gameLogic = new GameLogic(layout, stage, startMenu, scoreDisplay);
        scene = new Scene(layout, sizeX, sizeY);
    }
    public void deleteLogic() {
        gameLogic.deleteSpawner();
        gameLogic = null;
    }
}
