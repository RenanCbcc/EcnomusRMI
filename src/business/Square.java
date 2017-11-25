package business;

public class Square{
	
	private int row;
	private int column;
	private boolean fill;
	private boolean show;
	private char squareSimbol;
	
	public Square(int row, int column, char squareSimbol, boolean fill, boolean show){
		this.row = row;
		this.column = column;
		this.squareSimbol = squareSimbol;
		this.fill = fill;
		this.show = show;
	}
	
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public char getSquareSimbol() {
		return squareSimbol;
	}

	public void setSquareSimbol(char squareSimbol) {
		this.squareSimbol = squareSimbol;
	}
	
	public boolean isFill() {
		return fill;
	}

	public void setFill(boolean fill) {
		this.fill = fill;
	}

	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}

	
}