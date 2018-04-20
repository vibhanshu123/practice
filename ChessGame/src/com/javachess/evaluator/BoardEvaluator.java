package com.javachess.evaluator;

import java.util.ArrayList;
import java.util.List;

import com.javachess.board.Board;
import com.javachess.board.Square;
import com.javachess.move.Move;
import com.javachess.piece.Color;
import com.javachess.piece.Piece;

/**
 * 
 * @author Vibs
 *
 */
public class BoardEvaluator {

	public static List<Move> legalMoves(Color color, Board board) {
		List<Move> legalMoves = new ArrayList<Move>();

		for (Square square : board.allSquares()) {
			Piece piece = board.at(square);

			if (piece.isColor(color))
				legalMoves.addAll(piece.availableMoves(square, board));
		}

		return legalMoves;
	}
}