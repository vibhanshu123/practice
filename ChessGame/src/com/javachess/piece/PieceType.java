package com.javachess.piece;

import com.javachess.generator.KnightMoveGenerator;
import com.javachess.generator.MoveGenerator;

/**
 * 
 * @author Vibs
 *
 */
public enum PieceType {

    KNIGHT(new KnightMoveGenerator());

	MoveGenerator generator;

	private PieceType(MoveGenerator generator) {
		this.generator = generator;
	}
}