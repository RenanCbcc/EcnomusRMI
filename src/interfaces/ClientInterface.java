package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientInterface extends Remote {
	
	void fire(int x, int y)throws RemoteException;
	void receiveMessage(String message,int x, int y) throws RemoteException;
	void receiveMessage(String origin, int x, int y, char c, String message) throws RemoteException;
}
