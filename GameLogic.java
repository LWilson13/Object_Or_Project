import javafx.application.Platform;
import javafx.scene.layout.AnchorPane;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class GameLogic {
    private Timer timer;
    Main main;

    public GameLogic(Main main) {
        timer = new Timer();
        startGameLoop();
        this.main = main;

    }

        public void startGameLoop() {
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    Platform.runLater(() -> {
                        ;
                        try {
                            main.MeteorSpawn();
                        } catch (Exception e) {
                            System.out.println("Error");
                        }

                    });

                }

            };

            timer.scheduleAtFixedRate(task, 1000, 1000);

        }

}
