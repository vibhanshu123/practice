package com.javachess.piece;

import java.util.List;

import com.javachess.board.Board;
import com.javachess.board.Square;
import com.javachess.move.Move;

/**
 * 
 * @author Vibs
 *
 */
public enum Piece {
	WHITE_KNIGHT(PieceType.KNIGHT, Color.WHITE),
	BLACK_KNIGHT(PieceType.KNIGHT, Color.BLACK);
	private PieceType type;
	private Color color;

	Piece(PieceType type, Color color) {
		this.type = type;
		this.color = color;
	}

	public Color color() {
		return color;
	}

	public boolean isColor(Color otherColor) {
		return color.equals(otherColor);
	}

	public boolean isType(PieceType otherType) {
		return type.equals(otherType);
	}

	public List<Move> availableMoves(Square position, Board board) {
		return type.generator.generateMoves(position, color, board);
	}
}