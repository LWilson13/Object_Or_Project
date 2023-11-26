import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class GameOverMenu extends SceneTemplate{

    Button restartButton = new Button("");
    Button quitButton = new Button("");
    Image gameOverIcon = new Image("src/GAME OVER.png");
    ImageView gameOver = new ImageView(gameOverIcon);
    Image exitImage = new Image("src/EXIT.png");
    ImageView exit = new ImageView(exitImage);
    Image restartImage = new Image("src/Restart.png");
    ImageView restart = new ImageView(restartImage);
    public GameOverMenu(Stage stage, StartMenu startMenu){

        gameOver.setPreserveRatio(true);
        gameOver.setFitWidth(sizeX);
        quitButton.setGraphic(exit);
        restartButton.setGraphic(restart);
        quitButton.setOnAction(e-> Platform.exit());
        restartButton.setOnAction(e-> stage.setScene(startMenu.scene));

        //AnchorPane.setLeftAnchor(gameOver, (double)(sizeX / 2));
        AnchorPane.setTopAnchor(gameOver, -400.0);
        AnchorPane.setLeftAnchor(restartButton, (double)(sizeX / 2 - 47));
        AnchorPane.setTopAnchor(restartButton, (double)(sizeY / 2));
        AnchorPane.setLeftAnchor(quitButton, (sizeX / 2 - 32.5));
        AnchorPane.setTopAnchor(quitButton, (double)(sizeY / 2 + 40));

        layout.getChildren().addAll(restartButton, quitButton, gameOver);

        scene = new Scene(layout, sizeX, sizeY);
    }
}
