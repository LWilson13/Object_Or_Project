import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
public class Main extends Application{

    Button button;
    public static void main(String[] args){
       launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Space Game");

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene mainScene = new Scene(layout,750, 250);
        primaryStage.setScene(mainScene);
        primaryStage.show();

    }

}
