package client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import auxiliary.Packet;
import business.GameLogic;
import interfaces.ClientInterface;
import interfaces.ServerInterface;

public class Client extends UnicastRemoteObject implements ClientInterface, Runnable {
	int XY_SQUARE = 20;
	private static final long serialVersionUID = 1L;
	private ServerInterface chatserver;
	private String name = null;
	private GameLogic game;

	protected Client(String name, ServerInterface server) throws RemoteException {
		super();
		this.game = new GameLogic();
		this.name = name;
		chatserver = server;
		chatserver.registerClient(this);
	}

	String getName() {
		return name;
	}

	@Override
	public void receiveMessage(Packet message) {
		if (!message.getName().equals(name))
			System.out.println(message);

	}

	@Override
	public void run() {
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.print("X value:");
			int x = in.nextInt();
			System.out.print("Y value:");
			int y = in.nextInt();

			try {
				if (game.fire(x, y)) {
					chatserver.sendMessage(getName(), x, y);
				}

			} catch (RemoteException e) {
				System.out.println("Error " + e.getMessage());
			}
		}
	}

	@Override
	public void receiveMessage(String origin, int x, int y) throws RemoteException {
		if (!origin.equals(name)) {
			System.out.println();
			String result = game.manageCommand(XY_SQUARE, x, y);
			System.out.println("Author: " + origin + " coordenates: " + "[" + x + "]" + "," + "[" + y + "]");
			// Send the response back
			chatserver.sendMessage(getName(), result);
		}

	}

	@Override
	public void receiveMessage(String origin, String message) throws RemoteException {
		if (!origin.equals(name)) {
			System.out.println();
			System.out.println("origin: " + origin + " message: " + message);

		}

	}

}
