package business;

import java.awt.Color;
import java.util.Vector;

public class BoardBuilder {

	private Square[][] squareSecondary;
	private Vector<Vector<Square>> OpponentSquare;
	private Board board;

	public BoardBuilder() {
		board = new Board();
		squareSecondary = new Square[15][15];
		OpponentSquare = new Vector<Vector<Square>>();
		createCleanBoard();

	}
	
	public void setColorSquare(final int x, final int y, final char c){
		squareSecondary[x][y].setFill(true);
		squareSecondary[x][y].setSquareSimbol(c);
	}
	

	private void createCleanBoard() {
		for (int row = 0; row < squareSecondary.length; row++) {
			Vector<Square> temp = new Vector<Square>();
			for (int column = 0; column < squareSecondary[row].length; column++) {
				squareSecondary[row][column] = new Square(row, column, '#', false, true);
				temp.add(squareSecondary[row][column]);
			}
			OpponentSquare.add(temp);
		}

	}
	public void reseatBoard(){
		for (int row = 0; row < squareSecondary.length; row++) {
			for (int column = 0; column < squareSecondary[row].length; column++) {
				squareSecondary[row][column].setSquareSimbol('#');
				squareSecondary[row][column].setFill(false);
			}
		}
	}
	

	public Board getBoard() {
		return board;
	}

	public Square[][] getBoardSercondary() {
		return squareSecondary;
	}
	
	
	
	

	public void printBoard() {

		for (int i = 0; i < board.getPlayerBoard().size(); i++) {
			System.out.print("---");
		}
		System.out.println(" ");
		for (int i = 0; i < board.getPlayerBoard().size(); i++) {
			for (int j = 0; j < board.getPlayerBoard().get(i).size(); j++) {
				System.out.print("| " + board.getPlayerBoard().get(i).get(j).getSquareSimbol());
				//System.out.print("| " + squareSecondary[i][j].getSquareSimbol());
			}
			System.out.println("| ");
		}
		for (int i = 0; i < board.getPlayerBoard().size(); i++) {
			System.out.print("---");
		}
///////////////////////////////////////////////////////////////////////////////////////
		System.out.println("");
		for (int i = 0; i < board.getPlayerBoard().size(); i++) {
			System.out.print("---");
		}
		System.out.println(" ");
		for (int i = 0; i < board.getPlayerBoard().size(); i++) {
			for (int j = 0; j < board.getPlayerBoard().get(i).size(); j++) {
				System.out.print("| " + squareSecondary[i][j].getSquareSimbol());
			}
			System.out.println("| ");
		}
		for (int i = 0; i < board.getPlayerBoard().size(); i++) {
			System.out.print("---");
		}

		System.out.println(" ");

	}
}
