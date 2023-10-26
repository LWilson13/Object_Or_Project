import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
public class Main extends Application implements EventHandler<ActionEvent>{

    Button button;
    public static void main(String[] args){
       launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Space Game");

        button =new Button();
        button.setText("Click");
        button.setOnAction(this);

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene mainScene = new Scene(layout,500, 750);
        primaryStage.setScene(mainScene);
        primaryStage.show();

    }
    @Override
    public void handle (ActionEvent event){
        if(event.getSource()== button){
            System.out.println("Test Worked");
        }
    }



}
