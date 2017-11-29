package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInterface extends Remote{

	boolean registerClient(ClientInterface ci)throws RemoteException;
	void sendMessage(String message,int x, int y) throws RemoteException;
	void sendMessage(String name, int x, int y, char c, String message) throws RemoteException;
	
}
