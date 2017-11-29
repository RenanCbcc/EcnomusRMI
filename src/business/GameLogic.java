package business;

import java.rmi.RemoteException;

import auxiliary.Packet;
import components.Component;

public class GameLogic {

	public BoardBuilder boardBuilder;
	private int moves_sent = 0;
	private int responses_receiver = 0;

	private final int NUMBER_MOVES = 3;
	private final int NUMBER_RESPONSES = 3;

	final int START = 10;
	final int XY_SQUARE = 20;
	final int RESPONSE_XY = 30;
	final int WIN_GAME = 40;
	final int LOST_PLAY = 50;

	public GameLogic() throws RemoteException {

		boardBuilder = new BoardBuilder();

	}

	// Send to another player
	public boolean fire(int row, int column) throws RemoteException {
		boolean response = false;

		if (!(row > 15 || row < 0) && !(column > 15 || column < 0)) {
			if (moves_sent < NUMBER_MOVES && responses_receiver == 0) {
				if (!boardBuilder.getBoardSercondary()[row][column].isFill()) {
					response = true;
				} else {
					System.out.println("Move wasted");

				}

				moves_sent++;

			} else {
				System.out.println("It is not you turn");

			}

		} else {
			System.out.println("Out of range");

		}

		return response;
	}

	// Receive from another player
	public Packet manageCommand(int actionCommand, int x, int y) {
		Packet result = null;

		if (actionCommand == XY_SQUARE) {
			increaseResponsePlay();
			if (boardBuilder.getBoard().getValueSquare(x, y)) {

				Component component = boardBuilder.getBoard().getComponent(x, y);

				boardBuilder.getBoard().immersePiece(x, y, false);
				boardBuilder.getBoard().setSimbolSquare(x, y, 'X');

				if (boardBuilder.getBoard().verifyComponentsSubmerged()) {
					if (boardBuilder.getBoard().verifyComponentKill(component)) {

						result = new Packet(x, y, 'X', "You sank :" + component.getName());
					} else {
						result = new Packet(x, y, 'X', "You hit : " + component.getName());

					}
				} else {
					result = new Packet(x, y, ' ', "Game lost. Search a new opponent.");

				}

			} else {
				boardBuilder.getBoard().setSimbolSquare(x, y, ' ');
				result = new Packet(x, y, ' ', "Water");

			}

		}
		boardBuilder.printBoard();
		return result;
	}

	public void increaseResponsePlay() {
		responses_receiver++;
		if (responses_receiver == NUMBER_RESPONSES) {
			System.out.println("Your turn to play");
			moves_sent = 0;
			responses_receiver = 0;
		}
	}

}
