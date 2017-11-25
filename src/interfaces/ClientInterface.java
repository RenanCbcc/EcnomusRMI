package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import auxiliary.Packet;

public interface ClientInterface extends Remote {
	
	void receiveMessage(Packet message) throws RemoteException;
	void receiveMessage(String message,int x, int y) throws RemoteException;
	void receiveMessage(String origin,String message) throws RemoteException;
}
