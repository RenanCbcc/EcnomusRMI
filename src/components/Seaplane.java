package components;

public class Seaplane extends Component{

	public Seaplane(){
		super();
		initializePieces();
	}
	
	public Seaplane(int row, int column){
		super(row, column);
		initializePieces();
	}
	
	@Override
	public String getName() {
		return "Seaplane";
	}
	
	@Override
	public void initializePieces() {
		pieces = new Piece[]{new Piece(position.getRow(), position.getColumn() + 1),
				 new Piece(position.getRow() + 1, position.getColumn()),
				 new Piece(position.getRow() + 1, position.getColumn() + 2)};
	}

	@Override
	public void updatePositonPieces() {
		pieces[0].setCoordinatePosition(position.getRow(), position.getColumn() + 1);
		pieces[1].setCoordinatePosition(position.getRow() + 1, position.getColumn());
		pieces[2].setCoordinatePosition(position.getRow() + 1, position.getColumn() + 2);
	}

}