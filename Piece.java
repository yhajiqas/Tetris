package Tetris;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
/*
 * this is where I made my 7 pieces. 
 * using switch, I assigned each of the pieces' location and color accordingly.
 * created methods moveDown, moveLeft, moveRight, and Rotate to perform the desired moves.
 * added getN#Location method in order for the location of each Node to be accessed by other classes.
 * added getNode#() method in order for each node to be accessed in the game class. 
 */


public class Piece {
	private Square _rect1;
	private Square _rect2;
	private Square _rect3;
	private Square _rect4;
	private Board _board;
	private Square[][] _rects;
	public int _num;

	public Piece (int num) {
		_board = new Board();
		_rects = _board.getRectangles();
		_rect1 = new Square();
		_rect2 = new Square();
		_rect3 = new Square();
		_rect4 = new Square();
		_num = num;
		this.setXLocation(6);
		this.setYLocation(3);
		this.setColor();
		
	}	
	public void setColor(){
		switch(_num){
		case 1:
			_rect1.setColor(Color.BLUE);
			_rect2.setColor(Color.BLUE);
			_rect3.setColor(Color.BLUE);
			_rect4.setColor(Color.BLUE);
			break;
		case 2:
			_rect1.setColor(Color.YELLOW);
			_rect2.setColor(Color.YELLOW);
			_rect3.setColor(Color.YELLOW);
			_rect4.setColor(Color.YELLOW);
			break;
		case 3:
			_rect1.setColor(Color.ORANGE);
			_rect2.setColor(Color.ORANGE);
			_rect3.setColor(Color.ORANGE);
			_rect4.setColor(Color.ORANGE);
			break;
		case 4:
			_rect1.setColor(Color.RED);
			_rect2.setColor(Color.RED);
			_rect3.setColor(Color.RED);
			_rect4.setColor(Color.RED);
			break;
		case 5:
			_rect1.setColor(Color.PINK);
			_rect2.setColor(Color.PINK);
			_rect3.setColor(Color.PINK);
			_rect4.setColor(Color.PINK);
			break;
		case 6:
			_rect1.setColor(Color.GREEN);
			_rect2.setColor(Color.GREEN);
			_rect3.setColor(Color.GREEN);
			_rect4.setColor(Color.GREEN);
			break;
		case 7:
			_rect1.setColor(Color.PURPLE);
			_rect2.setColor(Color.PURPLE);
			_rect3.setColor(Color.PURPLE);
			_rect4.setColor(Color.PURPLE);
			break;
		default:
			_rect1.setColor(Color.BLUE);
			_rect2.setColor(Color.BLUE);
			_rect3.setColor(Color.BLUE);
			_rect4.setColor(Color.BLUE);
			break;
		
		}
	}
	public Paint getColor(){
		 return _rect1.getColor();
	}
	public void setXLocation(double x){

		switch(_num){
		case 1:
			_rect1.setXLocation(x);
			_rect2.setXLocation(x +1);
			_rect3.setXLocation(x +2);
			_rect4.setXLocation(x +3);
			break;
		case 2:
			_rect1.setXLocation(x);
			_rect2.setXLocation(x +1);
			_rect3.setXLocation(x);
			_rect4.setXLocation(x +1);
			break;
		case 3: 
			_rect1.setXLocation(x);
			_rect2.setXLocation(x+1);
			_rect3.setXLocation(x+2);
			_rect4.setXLocation(x +1);
			break;
		case 4:
			_rect1.setXLocation(x);
			_rect2.setXLocation(x+1);
			_rect3.setXLocation(x+2);
			_rect4.setXLocation(x);
			break;
		case 5:
			_rect1.setXLocation(x);
			_rect2.setXLocation(x+1);
			_rect3.setXLocation(x+2);
			_rect4.setXLocation(x+2);
			
			break;
		case 6:
			_rect1.setXLocation(x);
			_rect2.setXLocation(x+1);
			_rect3.setXLocation(x+1);
			_rect4.setXLocation(x+2);
			break;
		case 7: 
			_rect1.setXLocation(x);
			_rect2.setXLocation(x-1);
			_rect3.setXLocation(x-1);
			_rect4.setXLocation(x-2);
			break;
		default:
			_rect1.setXLocation(x);
			_rect2.setXLocation(x +1);
			_rect3.setXLocation(x +2);
			_rect4.setXLocation(x +3);
		}
	}
	
	public void setYLocation(double y){
		switch(_num){
		case 1:
		   	_rect1.setYLocation(y-1);
			_rect2.setYLocation(y-1);
			_rect3.setYLocation(y-1);
			_rect4.setYLocation(y-1);
		break;
		case 2:
			_rect1.setYLocation(y);
			_rect2.setYLocation(y);
			_rect3.setYLocation(y-1);
			_rect4.setYLocation(y-1);
		break;
		case 3:
			_rect1.setYLocation(y);
			_rect2.setYLocation(y);
			_rect3.setYLocation(y);
			_rect4.setYLocation(y-1);	
			break;
		case 4:
			_rect1.setYLocation(y);
			_rect2.setYLocation(y);
			_rect3.setYLocation(y);
			_rect4.setYLocation(y-1);
			break;
		case 5:
			_rect1.setYLocation(y);
			_rect2.setYLocation(y);
			_rect3.setYLocation(y);
			_rect4.setYLocation(y-1);
			break;
		case 6:
			_rect1.setYLocation(y);
			_rect2.setYLocation(y);
			_rect3.setYLocation(y-1);
			_rect4.setYLocation(y-1);
			break;
		case 7:
			_rect1.setYLocation(y);
			_rect2.setYLocation(y);
			_rect3.setYLocation(y -1);
			_rect4.setYLocation(y -1);
			break;
		default:
			_rect1.setYLocation(y-1);
			_rect2.setYLocation(y-1);
			_rect3.setYLocation(y-1);
			_rect4.setYLocation(y-1);
		}
	}	
	
	public void rotate(){
		double newX1Loc = _rect2.getXLocation() - _rect2.getYLocation() + _rect1.getYLocation();
		double newY1Loc = _rect2.getYLocation() + _rect2.getXLocation() - _rect1.getXLocation();
		double newX3Loc = _rect2.getXLocation() - _rect2.getYLocation() + _rect3.getYLocation();
		double newY3Loc = _rect2.getYLocation() + _rect2.getXLocation() - _rect3.getXLocation();
		double newX4Loc = _rect2.getXLocation() - _rect2.getYLocation() + _rect4.getYLocation();
		double newY4Loc = _rect2.getYLocation() + _rect2.getXLocation() - _rect4.getXLocation();
		
		
		if (_rects[(int) newX1Loc][(int) newY1Loc].getColor() == Color.BLACK &&
			_rects[(int) newX3Loc][(int) newY3Loc].getColor() == Color.BLACK &&	
			_rects[(int) newX4Loc][(int) newY4Loc].getColor() == Color.BLACK){
			_rect1.setXLocation(newX1Loc);
			_rect1.setYLocation(newY1Loc);
			_rect3.setXLocation(newX3Loc);
			_rect3.setYLocation(newY3Loc);
			_rect4.setXLocation(newX4Loc);
			_rect4.setYLocation(newY4Loc);
		}
	}
	
	public void moveDown(){
		_rect1.setYLocation(_rect1.getYLocation()+1);
		_rect2.setYLocation(_rect2.getYLocation()+1);
		_rect3.setYLocation(_rect3.getYLocation()+1);
		_rect4.setYLocation(_rect4.getYLocation()+1);
		
	}
	
	public void moveRight(){
		_rect1.setXLocation(_rect1.getXLocation()+1);
		_rect2.setXLocation(_rect2.getXLocation()+1);
		_rect3.setXLocation(_rect3.getXLocation()+1);
		_rect4.setXLocation(_rect4.getXLocation()+1);
	}
	
	public void moveLeft(){
		_rect1.setXLocation(_rect1.getXLocation()-1);
		_rect2.setXLocation(_rect2.getXLocation()-1);
		_rect3.setXLocation(_rect3.getXLocation()-1);
		_rect4.setXLocation(_rect4.getXLocation()-1);
	}
	
	
	public int getN1XLoc(){
		return (int) _rect1.getXLocation();		
	}
	
	public int getN2XLoc(){
		return (int) _rect2.getXLocation();
 	}
	
	public int getN3XLoc(){
		return (int) _rect3.getXLocation();
	}
	
	public int getN4XLoc(){
		return (int) _rect4.getXLocation();
	}
	
	public int getN1YLoc(){
		return (int) _rect1.getYLocation();
	}
	
	public int getN2YLoc(){
		return (int) _rect2.getYLocation();
	}
	
	public int getN3YLoc(){
		return (int) _rect3.getYLocation();
	}
	
	public int getN4YLoc(){
		return (int) _rect4.getYLocation();
	}
	
	
	public Node getNode1(){
		return _rect1.getNode();
	}
	
	public Node getNode2(){
		return _rect2.getNode();
	}
	
	public Node getNode3(){
		return _rect3.getNode();
	}
	
	public Node getNode4(){
		return _rect4.getNode();
	}
}	






