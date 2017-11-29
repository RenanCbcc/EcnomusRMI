package auxiliary;

public class Packet {
	
	int x, y;
	char c;
	String message;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public char getC() {
		return c;
	}
	public void setC(char c) {
		this.c = c;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Packet(int x, int y, char c, String message) {
		super();
		this.x = x;
		this.y = y;
		this.c = c;
		this.message = message;
	}

	
}
