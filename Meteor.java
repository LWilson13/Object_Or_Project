import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Meteor {

    Circle meteor;

public Meteor(int posX, int posY, int radius) {

    meteor = new Circle(posX, posY, radius, Color.BROWN);
    System.out.println("Meteor Created");
}

}
