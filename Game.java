package Tetris;

import javafx.animation.Animation;
import javafx.animation.Animation.Status;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
/* This is the game class which contains the following methods:
 * setupTimeline: set's up the timeline and starts the animation.
 * Pause: pauses the game and prints the label "paused".
 * generate falling piece: a piece factory that creates random pieces.
 * removePiece: removes the piece when the piece lands on the board and is painted on the board.
 * isLegal methods: boolean methods that check to see if the desired move is legal by looking at the adjacent cells.
 * isFull: checks to see if the line is painted.
 * paintLine: paints the upper row on the current row.
 * clearLine: clears the row if the row is painted in its entirety.
 * gameOver: stops the timeline and prints the label "gameOver!"
 * TimeHandler: a private inner class that takes care of the game by using the methods mentioned above.
 * KeyHandler: registers the keys with their respective moves.
 */
public class Game {
	private Pane _gamePane;
	private Board _board;
	private Square[][] _rects;
	private Piece _current;
	private Label _label;
	private Timeline _timeline;
		
	public Game(Pane gamePane){
		_board = new Board();
		_rects = _board.getRectangles();
		_label = new Label();
		_label.setTextFill(Color.ALICEBLUE);
		_gamePane = gamePane;
		for (int i = 0; i < 14; i++){
			for(int j = 0 ; j < 26; j++){
				_gamePane.getChildren().addAll(_rects[i][j].getNode());
				
			}
		}
		_gamePane.getChildren().add(_label);
		this.generateFallingPiece();
		this.setupTimeline();
		KeyHandler myKeyHandler = new KeyHandler();
		_gamePane.addEventHandler(KeyEvent.KEY_PRESSED, myKeyHandler);
		_gamePane.setFocusTraversable(true);
	}
	
	
	public void setupTimeline(){
		KeyFrame keyframe = new KeyFrame(Duration.seconds(.8), new TimeHandler());
		_timeline = new Timeline(keyframe);
		_timeline.setCycleCount(Animation.INDEFINITE);
		_timeline.play();
		
	}
	
	public void pause(){
		if (_timeline.getStatus() == Status.PAUSED){
			_timeline.play();
			_label.setText(null);
		}else{
			_timeline.pause();
			_label.setText("Paused");
		}
	}
	
	public void generateFallingPiece(){
		int rand = (int) (Math.random()*7);	

			switch(rand){
			case 0:
				
				_current = new Piece(1);
				_gamePane.getChildren().addAll(_current.getNode1(),_current.getNode2(),_current.getNode3(),_current.getNode4());
				break;
			case 1:
				_current = new Piece(2);
				_gamePane.getChildren().addAll(_current.getNode1(),_current.getNode2(),_current.getNode3(),_current.getNode4());
				break;
			case 2: 
				_current = new Piece(3);
				_gamePane.getChildren().addAll(_current.getNode1(),_current.getNode2(),_current.getNode3(),_current.getNode4());
				break;
			case 3:
				_current = new Piece(4);
				_gamePane.getChildren().addAll(_current.getNode1(),_current.getNode2(),_current.getNode3(),_current.getNode4());
				break;
			case 4:
				_current = new Piece(5);
				_gamePane.getChildren().addAll(_current.getNode1(),_current.getNode2(),_current.getNode3(),_current.getNode4());
				break;
			case 5:
				_current = new Piece(6);
				_gamePane.getChildren().addAll(_current.getNode1(),_current.getNode2(),_current.getNode3(),_current.getNode4());
					break;
			case 6: 
				_current = new Piece(7);
				_gamePane.getChildren().addAll(_current.getNode1(),_current.getNode2(),_current.getNode3(),_current.getNode4());
				break;
			default:
				_current = new Piece(1);
				_gamePane.getChildren().addAll(_current.getNode1(),_current.getNode2(),_current.getNode3(),_current.getNode4());
			}
	}
	
	public void removePiece(){
		_gamePane.getChildren().removeAll(_current.getNode1(),_current.getNode2(),_current.getNode3(),_current.getNode4());
				
	}
	
	public boolean isLeftLegal(){
		if(_rects[_current.getN1XLoc()-1][_current.getN1YLoc()].getColor() == Color.BLACK &&
				_rects[_current.getN2XLoc()-1][_current.getN2YLoc()].getColor() == Color.BLACK &&
				_rects[_current.getN3XLoc()-1][_current.getN3YLoc()].getColor() == Color.BLACK &&
				_rects[_current.getN4XLoc()-1][_current.getN4YLoc()].getColor() == Color.BLACK){
			return true;
		}
		return false;
	}
	
	public boolean isRightLegal(){
		if(_rects[_current.getN1XLoc()+1][_current.getN1YLoc()].getColor() == Color.BLACK &&
				_rects[_current.getN2XLoc()+1][_current.getN2YLoc()].getColor() == Color.BLACK &&
				_rects[_current.getN3XLoc()+1][_current.getN3YLoc()].getColor() == Color.BLACK &&
				_rects[_current.getN4XLoc()+1][_current.getN4YLoc()].getColor() == Color.BLACK){
			return true;
		}
		return false;
	}
	
	public boolean isDownLegal(){
		if(_rects[_current.getN1XLoc()][_current.getN1YLoc()+1].getColor() == Color.BLACK && 
			_rects[_current.getN2XLoc()][_current.getN2YLoc()+1].getColor() == Color.BLACK &&
			_rects[_current.getN3XLoc()][_current.getN3YLoc()+1].getColor() == Color.BLACK &&
			_rects[_current.getN4XLoc()][_current.getN4YLoc()+1].getColor() == Color.BLACK){
			return true;
		}
		return false;
	}
	
	public boolean isFull(int j){
		for(int i=2; i<12;i++){
			if (_rects[i][j].getColor() == Color.BLACK){
				return false;
			}
		}
		return true;
	}
	
	public void paintLine(int j){
		for (int k=j;k>2;k--){
			for (int i = 2; i<12; i++){
				_rects[i][k].setColor((Color) _rects[i][k-1].getColor());
			}	
		}
		
	}
	
	public void clearLine(){
		for (int j =3; j<24; j++){
			if(this.isFull(j)){
				this.paintLine(j);
			}
		} 
	}
	
	public void gameOver(){
		for(int i = 2; i <12;i++){
			if (_rects[i][2].getColor() != Color.BLACK && this.isLeftLegal()==false && this.isRightLegal()==false){
				_label.setText("GameOver!");	
				_timeline.stop();
			}
		}
		
	}
	
	private class TimeHandler implements EventHandler <ActionEvent>{
		
		public void handle(ActionEvent e){		
		
				if (Game.this.isDownLegal()){
					_current.moveDown();
					Game.this.clearLine();
				}
				else{
					_rects[_current.getN1XLoc()][_current.getN1YLoc()].setColor ((Color) _current.getColor());  
					_rects[_current.getN2XLoc()][_current.getN2YLoc()].setColor ((Color) _current.getColor());  
					_rects[_current.getN3XLoc()][_current.getN3YLoc()].setColor((Color) _current.getColor());  
					_rects[_current.getN4XLoc()][_current.getN4YLoc()].setColor((Color) _current.getColor()); 
					
					Game.this.removePiece();
					Game.this.clearLine();
					Game.this.gameOver();
					Game.this.generateFallingPiece();
				}		
			}
		}	
		
	private class KeyHandler implements EventHandler<KeyEvent>{
		@Override
		public void handle(KeyEvent e){
			KeyCode KeyPressed = e.getCode();
			if (KeyPressed == KeyCode.RIGHT && Game.this.isRightLegal()){
				_current.moveRight();;
			}
			if(KeyPressed == KeyCode.LEFT && Game.this.isLeftLegal()){
				_current.moveLeft();;
			} 
			if(KeyPressed == KeyCode.DOWN && Game.this.isDownLegal()){
							_current.moveDown();
			}
			if(KeyPressed == KeyCode.UP && Game.this.isDownLegal() && Game.this.isLeftLegal() && Game.this.isRightLegal()){
				_current.rotate();
			}
			while (KeyPressed == KeyCode.SPACE && Game.this.isDownLegal()){
				_current.moveDown();
			}	
			if (KeyPressed == KeyCode.P ){
				 Game.this.pause();
				
			}
			e.consume();
		}
	}
}