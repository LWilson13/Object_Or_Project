import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PauseMenu extends SceneTemplate {

    Button resumeButton = new Button("");
    Button quitButton = new Button();
    Image exitImage = new Image("src/EXIT.png");
    ImageView exit = new ImageView(exitImage);
    Image resumeImage = new Image("src/Resume.png");
    ImageView resume = new ImageView(resumeImage);



    public PauseMenu(Stage stage, GameScene gameScene) {

        resumeButton.setOnAction(e-> stage.setScene(gameScene.scene));
        quitButton.setOnAction(e-> Platform.exit());

        exit.setFitWidth(48);
        exit.setFitHeight(18);
        resume.setFitWidth(64);
        resume.setFitHeight(22);

        quitButton.setGraphic(exit);
        resumeButton.setGraphic(resume);

        AnchorPane.setLeftAnchor(resumeButton, (double) (sizeX / 2 - 40));
        AnchorPane.setTopAnchor(resumeButton, (double) (sizeY / 2));
        AnchorPane.setLeftAnchor(quitButton, (sizeX / 2 - 32.5));
        AnchorPane.setTopAnchor(quitButton, (double) (sizeY / 2 + 40));

        layout.getChildren().addAll(resumeButton, quitButton);
        layout.setStyle("-fx-background-color: black;");

        scene = new Scene(layout, sizeX, sizeY);
    }
}
