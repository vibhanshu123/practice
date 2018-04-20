package com.javachess.converter;

import com.javachess.board.Square;

/**
 * 
 * @author Vibs
 *
 */
public interface NotationConverter {

	public Square getSrc(String notation);

	public Square getDst(String notation);
}