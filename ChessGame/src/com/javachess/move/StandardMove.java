package com.javachess.move;

import com.javachess.board.Board;
import com.javachess.board.Square;
import com.javachess.piece.Piece;

/**
 * 
 * @author Vibs
 *
 */
public class StandardMove implements Move {
	protected Board board;
	protected Square srcSquare;
	protected Square dstSquare;

	public StandardMove(Square sourceSquare, Square targetSquare, Board board) {
		this.srcSquare = sourceSquare;
		this.board = board;
		this.dstSquare = targetSquare;
	}

	@Override
	public void execute() {
		Piece sourcePiece = board.at(srcSquare);
        board.removePieceAt(srcSquare);
		board.setPieceAt(dstSquare, sourcePiece);
	}


	@Override
	public Square getSource() {
		return srcSquare;
	}

	@Override
	public Square getDst() {
		return dstSquare;
	}


	@Override
	public boolean equals(Square source, Square target) {
		return getSource().equals(source) && getDst().equals(target);
	}
}