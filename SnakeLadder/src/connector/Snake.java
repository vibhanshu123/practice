package connector;

import board.Cell;

public class Snake extends Connector{
	

	private static final long serialVersionUID = 1L;

	public boolean hasSnaKeAt(Cell cell) {
		return super.keySet().contains(cell);
	}

	@Override
	public Cell decideConnectingDirection(Cell lowerPositionedCell, Cell higherPositionedCell) {
			return putWithDirection(higherPositionedCell, lowerPositionedCell);
	}

}
