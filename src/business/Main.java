package business;

import java.rmi.RemoteException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws RemoteException {
		GameLogic game = new GameLogic();
		game.boardBuilder.printBoard();
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.print("X value:");
			int x = in.nextInt();
			System.out.print("Y value:");
			int y = in.nextInt();
			System.out.println(game.manageCommand(20, x, y));

		}

	}

}
