package com.javachess.generator;

import java.util.List;

import com.javachess.board.Board;
import com.javachess.board.Square;
import com.javachess.move.Move;
import com.javachess.move.StandardMove;
import com.javachess.piece.Color;

/**
 * 
 * @author Vibs
 *
 */
public class MoveGeneratorHelper {

	public static void addMoveIfEmptyOrOpponent(final Square src, final Square dst, final Color color,
			final List<Move> moves, final Board board) {
		if (src == null || dst == null)
			return;

		if (board.isFree(dst) || board.isColor(dst, color.opponent()))
			moves.add(new StandardMove(src, dst, board));
	}


}