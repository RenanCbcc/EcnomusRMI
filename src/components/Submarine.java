package components;

public class Submarine extends Component{
	
	public Submarine(){
		super();
		initializePieces();
	}
	
	public Submarine(int row, int column){
		super(row, column);
		initializePieces();
	}
	
	@Override
	public String getName() {
		return "Submarine";
	}
	
	@Override
	public void updatePositonPieces() {
		pieces[0].setCoordinatePosition(position.getRow(), position.getColumn());
	}

	@Override
	public void initializePieces() {
		pieces = new Piece[]{new Piece(position.getRow(), position.getColumn())};
	}

}