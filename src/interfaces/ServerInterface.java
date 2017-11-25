package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import auxiliary.Packet;

public interface ServerInterface extends Remote{

	void registerClient(ClientInterface cc)throws RemoteException;
	void sendMessage(Packet message) throws RemoteException;
	void sendMessage(String message,int x, int y) throws RemoteException;
	void sendMessage(String origin,String message) throws RemoteException;
	
}
