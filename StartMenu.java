import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class StartMenu extends SceneTemplate{

    Button startButton = new Button();
    Button quitButton = new Button();
    GameScene gameScene;




    public StartMenu(Stage stage){


        Image logoImage = new Image("src/ASTEROID GRAVEYARD logo color.png");
        ImageView logo = new ImageView(logoImage);
        Image startImage = new Image("src/Start.png");
        ImageView start = new ImageView(startImage);
        Image exitImage = new Image("src/EXIT.png");
        ImageView exit = new ImageView(exitImage);


        logo.setFitWidth(600);
        logo.setFitHeight(1200);

        start.setFitWidth(60);
        start.setFitHeight(22);

        exit.setFitWidth(48);
        exit.setFitHeight(18);


        startButton.setGraphic(start);
        startButton.setOnAction(e->{
            gameScene = new GameScene(stage);
            stage.setScene(gameScene.scene);
        });

        quitButton.setGraphic(exit);
        quitButton.setOnAction(e-> Platform.exit());


        AnchorPane.setLeftAnchor(logo, (double)(sizeX / 2 - 300));
        AnchorPane.setTopAnchor(logo, (double)(sizeY / 80 - 200));
        AnchorPane.setLeftAnchor(startButton, (double)(sizeX / 2 - 36));
        AnchorPane.setTopAnchor(startButton, (double)(sizeY / 2));
        AnchorPane.setLeftAnchor(quitButton, (sizeX / 2 - 30.5));
        AnchorPane.setTopAnchor(quitButton, (double)(sizeY / 2 + 40));

        layout.getChildren().addAll(startButton, quitButton, logo);
        layout.setStyle("-fx-background-color: black;");

        scene = new Scene(layout, sizeX, sizeY);
    }
}
