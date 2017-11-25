package auxiliary;

import java.rmi.RemoteException;

public class Packet implements java.io.Serializable{
	
	private static final long serialVersionUID = -1211352851988713019L;
	int x, y;
	String name, message;

	public Packet(String sender, int x, int y) throws RemoteException{
		super();
		this.name = sender;
		this.x = x;
		this.y = y;

	}

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
