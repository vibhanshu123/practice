package connector;

import java.util.HashMap;

import board.Cell;

public abstract class Connector extends HashMap<Cell, Cell>{

	private static final long serialVersionUID = 1L;
	
	public boolean hasConnectorAt(Cell cell) {
		return super.keySet().contains(cell);
	}
	
	
	@Override
	public Cell put(Cell connectionPoint1, Cell connectionPoint2) {
		Cell lowerPositionedCell = connectionPoint1;
		Cell higherPositionedCell = connectionPoint2;
		if(lowerPositionedCell.getPosition()>higherPositionedCell.getPosition()) {
			lowerPositionedCell=connectionPoint2;
			higherPositionedCell=connectionPoint1;
		}
		return decideConnectingDirection(lowerPositionedCell,higherPositionedCell);
		
	}

	public abstract Cell decideConnectingDirection(Cell lowerPositionedCell, Cell higherPositionedCell) ;
	
	protected Cell putWithDirection(Cell connectionPoint1, Cell connectionPoint2) {
		return super.put(connectionPoint1, connectionPoint2);
	}

}
