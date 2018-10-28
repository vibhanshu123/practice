package game;

import java.util.List;

import board.Board;

public class Game implements DiceListener{
	
	private List<Player> players ;
	private Board board;
	private Dice dice;
	private Player currentPlayer;
	
	public Game(List<Player> players, Board board, Dice dice) {
		this.players = players;
		this.board = board;
		this.dice = dice;
	}
	
	public void start() {
	  for(Player p:players) {
		  player.play();
	  }
		
	}
	
	public void addPlayer(Player player) {
		players.add(player);
	}
	
	public void removePlayer(Player player) {
		players.remove(player);
	}

	@Override
	public void onDiceRolled(int face) {
		// TODO Auto-generated method stub
		
	}
	
	

}
