package Tetris;

import javafx.scene.paint.Color;

/*
 * This class is in charge of creating a board which utilizes a 2D array of squares. 
 * the getRectangle method allows the elements of the array to be accessed in the game class as well as the piece class.
 */
public class Board {
	private Square[][] _rects;
	
	
	public Board(){
		_rects = new Square[14][26];
		for (int i = 0; i < 14 ; i++){
			for (int j = 0; j < 26 ; j++){
			Square rect = new Square();
			rect.setColor(Color.GRAY);
			rect.setXLocation(i);
			rect.setYLocation(j);
				_rects[i][j] = rect;
			}
		}
		for (int i =2; i < 12 ; i++){
			for (int j = 2; j < 24 ; j++){
			_rects[i][j].setColor(Color.BLACK);
			}
		}	
	}
	
	
	public Square[][] getRectangles(){
		return _rects;
	}
	
}
