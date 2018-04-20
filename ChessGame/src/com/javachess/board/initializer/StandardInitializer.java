package com.javachess.board.initializer;

import com.javachess.board.Board;
import com.javachess.board.Square;
import com.javachess.piece.Piece;

public class StandardInitializer implements BoardInitializer {
	@Override
	public void init(Board board) {
	
		board.setPieceAt(Square.at(5, 6), Piece.WHITE_KNIGHT);		
		board.setPieceAt(Square.at(6, 5), Piece.BLACK_KNIGHT);
		
	
	}
}