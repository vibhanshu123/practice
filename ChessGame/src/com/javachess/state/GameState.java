package com.javachess.state;

import com.javachess.board.Board;
import com.javachess.board.Square;
import com.javachess.move.Move;
import com.javachess.piece.Color;
import com.javachess.piece.Piece;

public class GameState {

	private Color playerColor;
	private BoardState boardState;

	public GameState() {
		boardState = BoardState.STANDARD;
		playerColor = Color.WHITE;
	}

	private GameState(Color playerColor, BoardState state) {
		this.playerColor = playerColor;
		this.boardState = state;
	}

	public GameState copy() {
		return new GameState(playerColor, boardState);
	}

	public boolean isEnded() {
		return boardState == BoardState.BOTTOM_RIGHT;
	}

	public void notifyMove(Move move, Board board) {
		playerColor = playerColor.opponent();
		evalBoardState(board);
	}

	
	public Color currentPlayerColor() {
		return playerColor;
	}
	

	private void evalBoardState(Board board) {		
		if(isReachedBottomRight(playerColor, board))
			boardState =BoardState.BOTTOM_RIGHT;
		else
		boardState = BoardState.STANDARD;
	}

	
	private boolean isReachedBottomRight(Color playerColor2, Board board) {
		Square square =Square.at(7, 7);
		Piece piece =board.at(square);
		if(piece!=null)  return true;
		return false;
	}
}