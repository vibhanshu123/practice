package com.javachess.game;

import static com.javachess.evaluator.BoardEvaluator.legalMoves;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.javachess.board.Board;
import com.javachess.board.Square;
import com.javachess.converter.NotationConverter;
import com.javachess.move.Move;
import com.javachess.piece.Color;
import com.javachess.player.Player;
import com.javachess.state.GameState;

/**
 * 
 * @author Vibs
 *
 */
public class Game {
	private GameState state;
	private final Board board;
	private final NotationConverter converter;
	private final Map<Color, Player> players;

	public Game(Player player1, Player player2, NotationConverter converter,Board board) {
		this.board = board;
		this.converter = converter;
		this.state = new GameState();
		players = new HashMap<Color, Player>();
		players.put(Color.WHITE, player1);
		players.put(Color.BLACK, player2);
	}

	public void start() {
		Color  currentPlayer = null;
		int winner = 0;
		while (!state.isEnded()) {
			currentPlayer=state.currentPlayerColor();
			String notation = players.get(currentPlayer).takeMove(currentPlayer);
			Square srcSquare = converter.getSrc(notation);
			Square dstSquare = converter.getDst(notation);
			List<Move> legalMoves = legalMoves(state.currentPlayerColor(), board);
			boolean madeMove = false;
			for (Move move : legalMoves) {
				if (move.equals(srcSquare, dstSquare)){
					executeMove(move);
					System.out.println("SUCCESSFUL MOVE");
					System.out.println("START CELL :"+srcSquare);
					System.out.println("END CELL   :"+dstSquare);
					madeMove = true;
				}
			}
			if(!madeMove){
			  System.out.println("The move made by you is not legal...Please make a valid move");
			  System.out.println("Will again have to again make a valid move(Knight should move like Knight and not king):");
			  System.out.println("Please RETRY");
			}
		}
		System.out.println();
		
		winner = currentPlayer.equals(Color.WHITE)?1:2;
		System.out.println("WHAT A MOVE ...YOU HAVE WON YOURSELF A FORTUNE :)...GAME OVER ..");
		System.out.println("WINNER IS PLAYER NUMBER "+winner);
		
	}

	private void executeMove(Move move) {
		move.execute();
		state.notifyMove(move, board);
	}
}