import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import static java.awt.SystemColor.window;

public class AlertBox {
    Main main;
    public void display(String title, String message, String buttonText, Main main){
        Stage menu = new Stage();
        this.main = main;

        menu.setTitle(title);
        menu.setWidth(350);
        menu.setHeight(500);
        menu.initModality(Modality.APPLICATION_MODAL);

        Label menuText = new Label();
        menuText.setText(message);
        Button menuButton = new Button(buttonText);
        menuButton.setOnAction(e -> {
            menu.close();
            main.CreateTimer();

        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(menuText, menuButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        menu.setScene(scene);
        menu.showAndWait();
    }
}
