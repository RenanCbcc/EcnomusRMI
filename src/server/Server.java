package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

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
	public synchronized boolean registerClient(ClientInterface ci) {
		clients.add(ci);
		return true;
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
	public void sendMessage(String origin, int x, int y, char c, String message) throws RemoteException {
		int i = 0;
		while (i < clients.size()) {
			if (!clients.get(i).equals(this)) {
				clients.get(i++).receiveMessage(origin, x, y, c, message);
			}
		}
	}

	public static void main(String[] args) throws RemoteException, MalformedURLException {
		Naming.rebind("RMIServer", new Server());
		System.out.println("Listenig");
	}

}
