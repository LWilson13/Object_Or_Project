import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
public class Main extends Application{

    Scene mainMenu;
    Scene mainGame;
    public int meteorPosX = 150, meteorPosY = 400;
    public static void main(String[] args){
       launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {



        //Main Menu Setup
        Label mainMenuTitle = new Label("Space Game");
        Button startButton = new Button("Start Game");
        startButton.setOnAction(e -> primaryStage.setScene(mainGame));

        AnchorPane mainMenuLayout = new AnchorPane();
        AnchorPane.setTopAnchor(mainMenuTitle, 100.0);
        AnchorPane.setLeftAnchor(mainMenuTitle, 200.0);
        AnchorPane.setBottomAnchor(startButton, 250.0);
        AnchorPane.setLeftAnchor(startButton, 200.0);

        mainMenuLayout.getChildren().addAll(startButton, mainMenuTitle);
        mainMenu = new Scene(mainMenuLayout, 500,750);

        //Main Game Setup
        Button pauseButton = new Button("Pause");
        pauseButton.setOnAction(e -> primaryStage.setScene(mainMenu));

        StackPane mainGameLayout = new StackPane();
        mainGameLayout.getChildren().addAll(pauseButton);
        mainGame = new Scene(mainGameLayout, 500,750);



        primaryStage.setTitle("Space Game");
        primaryStage.setScene(mainMenu);
        primaryStage.show();

    }


}
