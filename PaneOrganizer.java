package Tetris;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/*
 * this class simply organizes the gamePane and buttons.
 * gives a getRoot method so that it would be called in the App class.
 * uses clickHandler to register the buttons.
 */

public class PaneOrganizer {
	private BorderPane _root;
	private Game _game;
	private VBox _buttonPane;
	
	
	public PaneOrganizer(){
		_root = new BorderPane();
		_root.setStyle("-fx-background-color: blue;");
		_root.setPrefSize(420,780);
		Pane gamePane = new Pane();
		_game = new Game(gamePane);
		_root.setCenter(gamePane);
		this.setupButton();
		
		
	}
	public void setupButton(){
		_buttonPane = new VBox();
		Button btn = new Button("Quit");
		_buttonPane.getChildren().add(btn);
		_root.setBottom(_buttonPane);
		btn.setOnAction(new ClickHandler());		
	}
	
	public Pane getRoot(){
		return _root;
	}

	private class ClickHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event){
		System.exit(0);
		}
	}
}