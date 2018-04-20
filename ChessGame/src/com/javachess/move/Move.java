package com.javachess.move;

import com.javachess.board.Square;

/**
 * 
 * @author Vibs
 *
 */
public interface Move {
	public void execute();
	public Square getSource();
	public Square getDst();
	public boolean equals(Square src, Square dst);
}