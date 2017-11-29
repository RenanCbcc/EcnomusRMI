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
	private ServerInterface server;
	private String name = null;
	private GameLogic game;

	protected Client(String name, ServerInterface server) throws RemoteException {
		super();
		this.game = new GameLogic();
		this.name = name;
		this.server = server;
		server.registerClient(this);
	}

	String getName() {
		return name;
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
					fire(x, y);
				}

			} catch (RemoteException e) {
				in.close();
				System.out.println("Error " + e.getMessage());
			}
		}
	}

	@Override
	public void receiveMessage(String origin, int x, int y) throws RemoteException {
		if (!origin.equals(name)) {
			System.out.println();
			Packet result = game.manageCommand(XY_SQUARE, x, y);
			System.out.println("Author: " + origin + " , coordenates: " + "[" + x + "]" + "," + "[" + y + "]");
			// Send the response back
			server.sendMessage(getName(), result.getX(), result.getY(), result.getC(), result.getMessage());
		}

	}

	@Override
	public void receiveMessage(String origin, int x, int y, char c, String message) throws RemoteException {
		if (!origin.equals(name)) {
			System.out.println();
			game.boardBuilder.setsquareSecondarySimbol(x, y, c);
			game.boardBuilder.printBoard();
			System.out.println("origin: " + origin + " message: " + message);
			
		}

	}

	@Override
	public void fire(int x, int y) throws RemoteException {
		server.sendMessage(getName(), x, y);

	}

}
