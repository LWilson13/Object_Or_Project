
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        StartMenu startMenu = new StartMenu(primaryStage);

        //Initial stage setup
        primaryStage.setTitle("Space Game");
        primaryStage.setScene(startMenu.scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}



