package components;

public class Cruiser extends Component{

	public Cruiser(){
		super();
		initializePieces();
	}
	
	public Cruiser(int row, int column){
		super(row, column);
		initializePieces();
	}
	
	@Override
	public String getName() {
		return "Cruiser";
	}
	
	@Override
	public void initializePieces() {
		pieces = new Piece[]{new Piece(position.getRow(), position.getColumn()),
				 			 new Piece(position.getRow(), position.getColumn() + 1)};
	}

	@Override
	public void updatePositonPieces() {
		pieces[0].setCoordinatePosition(position.getRow(), position.getColumn());
		pieces[1].setCoordinatePosition(position.getRow(), position.getColumn() + 1);
	}

}