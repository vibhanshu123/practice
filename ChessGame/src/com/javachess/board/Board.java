package com.javachess.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.javachess.piece.Color;
import com.javachess.piece.Piece;

/**
 * 
 * @author Vibs
 *
 */
public class Board {

	private final Map<Square, Piece> positions;

	public Board() {
		positions = new HashMap<Square, Piece>();
	}

	private Board(Map<Square, Piece> newBoard) {
		this.positions = newBoard;
	}

	public Board copy() {
		return new Board(new HashMap<Square, Piece>(positions));
	}

	public List<Square> allSquares() {
		return new ArrayList<Square>(positions.keySet());
	}

	public Piece at(Square square) {		
		return positions.get(square);
	}

	public void removePieceAt(Square square) {
		positions.remove(square);
	}

	public void setPieceAt(Square position, Piece piece) {
		if (position != null && piece != null)
			positions.put(position, piece);
	}

	public void movePiece(Square src, Square dst) {
		Piece piece = at(src);
		removePieceAt(src);
		setPieceAt(dst, piece);
	}

	public boolean isFree(Square square) {
		if (square == null)
			return false;
		return !positions.containsKey(square);
	}

	public boolean isColor(Square square, Color color) {
		Piece piece = at(square);
		if (piece != null)
			return piece.color().equals(color);

		return false;
	}
}