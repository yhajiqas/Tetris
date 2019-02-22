package Tetris;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

/** @author <yhajiqas>
  *this is the main class. which sets up the stage and shows the graphical elements of game. 
  *all the other classes contain their own comments. 
  */

public class App extends Application {

    @Override
	public void start(Stage stage) {
    PaneOrganizer organizer = new PaneOrganizer();
    Scene scene = new Scene(organizer.getRoot(),420,780);
    stage.setTitle("Tetris!");
    stage.setScene(scene);
    stage.show();
	}
	
	public static void main(String[] argv) {

		launch(argv);
	}
}