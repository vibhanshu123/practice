package game;

import java.util.HashMap;

import board.Cell;

public class PlayerPlacement extends HashMap<Player, Cell> {

	private static final long serialVersionUID = 1L;
	private PlayerPlacementListener playerPlacementListener;
	private Cell startCell = new Cell(0, -1, -1);

	public PlayerPlacement(PlayerPlacementListener placementListener) {
		this.playerPlacementListener = placementListener;
	}
	
	@Override
	public Cell put(Player player,Cell cell) {
		Cell placedCell = super.put(player, cell);
		if(placedCell!=null&&!get(player).equals(placedCell)) {
			notifyPlayerPlacements(player);
		}
		return placedCell;
	}
	
	@Override
	public Cell get(Object player) {
		return super.get(player)==null?startCell:super.get(player);
		
	}
	
	private void notifyPlayerPlacements(Player player) {
		playerPlacementListener.placementsUpdated(player);
	}
}
