package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import auxiliary.Packet;
import interfaces.ClientInterface;
import interfaces.ServerInterface;

public class Server extends UnicastRemoteObject implements ServerInterface {

	private static final long serialVersionUID = 1L;
	private ArrayList<ClientInterface> clients;

	protected Server() throws RemoteException {
		super();
		clients = new ArrayList<ClientInterface>();
	}

	@Override
	public synchronized void registerClient(ClientInterface cc) {
		clients.add(cc);

	}

	@Override
	public synchronized void sendMessage(Packet message) throws RemoteException {

		int i = 0;
		while (i < clients.size()) {
			if (!clients.get(i).equals(this)) {
				clients.get(i++).receiveMessage(message);
			}
		}

	}

	@Override
	public synchronized void sendMessage(String message, int x, int y) throws RemoteException {

		int i = 0;
		while (i < clients.size()) {
			if (!clients.get(i).equals(this)) {
				clients.get(i++).receiveMessage(message, x, y);
			}
		}

	}

	@Override
	public void sendMessage(String origin, String message) throws RemoteException {
		int i = 0;
		while (i < clients.size()) {
			if (!clients.get(i).equals(this)) {
				clients.get(i++).receiveMessage(origin,message);
			}
		}
	}


}
