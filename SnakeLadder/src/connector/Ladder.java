package connector;

import board.Cell;

public class Ladder extends Connector{

	private static final long serialVersionUID = 1L;


	public boolean hasLadderAt(Cell cell) {
		return super.keySet().contains(cell);
	}

	
	@Override
	public Cell decideConnectingDirection(Cell lowerPositionedCell, Cell higherPositionedCell) {
		return putWithDirection(lowerPositionedCell, higherPositionedCell);
	}

}
