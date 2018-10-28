package board;

import java.util.List;

import connector.Connector;
import game.Player;
import game.PlayerPlacement;
import game.PlayerPlacementListener;

public class Board implements PlayerPlacementListener{
	
	private Cell [][] cells;
	private PlayerPlacement playerPlacements;
	private int size;
	private int endPosition;
	private List<Connector> collectors;

	
	public Board(Cell[][] cells) {
		this.cells = cells;
		this.playerPlacements = new PlayerPlacement(this);
		this.size = cells.length;
		this.endPosition = this.size*this.size;
	}

	public void forward(Player currentPlayer,int diceFace) {
		Cell presentCell = playerPlacements.get(currentPlayer);
		Cell toPlace = getsDestinationCellFor(presentCell,diceFace);
		updateThePlacements(currentPlayer,toPlace);
	}


	private void updateThePlacements(Player currentPlayer, Cell toPlace) {
		playerPlacements.put(currentPlayer, toPlace);
		
	}

	private Cell getsDestinationCellFor(Cell presentCell, int diceFace) {
		int destinationPosition= presentCell.getPosition()+diceFace;
		return getCellAt(destinationPosition);
	}

	private Cell getCellAt(int position) {
		if (position > getFinishingPosition())
			position = getFinishingPosition();
		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				if (cells[row][column].getPosition() == position)
					return cells[row][column];
			}
		}
		return null;
	}
	
	private int getFinishingPosition() {
		return endPosition;
	}

	@Override
	public void placementsUpdated(Player player) {
		Cell currentCell = playerPlacements.get(player);
		Cell destinationCell = currentCell;

		for (Connector connectors : collectors) {
			if (connectors.hasConnectorAt(currentCell)) {
				destinationCell = connectors.get(currentCell);
				break;
			}
		}

		updateThePlacements(player, destinationCell);
	}
	
	private int getSize() {
		return size;
	}
	
	public boolean isFinished(Player player) {
		return playerPlacements.get(player).getPosition() == getFinishingPosition();
	}

	public PlayerPlacement getPlayerPlacements() {
		return playerPlacements;
	}
	
	public void setCollectionOfConnectors(
			List<Connector> collectionOfConnectors) {
		this.collectors = collectionOfConnectors;
	}
	
	
}
