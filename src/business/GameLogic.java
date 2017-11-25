package business;

import java.rmi.RemoteException;

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

		if (!(row > 15 || row < 0) && !(column > 15 || column < 0))
		{
			if(moves_sent < NUMBER_MOVES && responses_receiver == 0)
			{
				if (!boardBuilder.getBoardSercondary()[row][column].isFill()) {
						response = true;
				}else {
					System.out.println("Move wasted");
					response = false;
			}

			moves_sent++;
			
			}else{
				System.out.println("It isnot you turn");
					
			}

		} else {
			System.out.println("Out of range");
			response = false;

		}

		return response;
	}

	// Receive from another player
	public String manageCommand(int actionCommand, int x, int y) {
		String result = "Error manageCommand";

		if (actionCommand == XY_SQUARE) {
			increaseResponsePlay();
			if (boardBuilder.getBoard().getValueSquare(x, y)) {

				Component component = boardBuilder.getBoard().getComponent(x, y);

				boardBuilder.getBoard().immersePiece(x, y, false);
				boardBuilder.getBoard().setSimbolSquare(x, y, 'X');

				if (boardBuilder.getBoard().verifyComponentsSubmerged()) {
					if (boardBuilder.getBoard().verifyComponentKill(component)) {
						// std::cout << "You sank :" + component->getName() <<
						// std::endl;
						result = "You sank :" + component.getName();
					} else {
						// std::cout << "You hit :" + component->getName() <<
						// std::endl;
						result = "You hit : " + component.getName();
					}
				} else {
					// std::cout << "You lost the game. Search a new opponent."
					// << std::endl;
					result = "Game lost. Search a new opponent.";
				}

			} else {
				boardBuilder.getBoard().setSimbolSquare(x, y, ' ');
				result = "Water";
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
