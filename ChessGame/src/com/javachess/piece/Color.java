package com.javachess.piece;

/**
 * 
 * @author Vibs
 *
 */
public enum Color {
	BLACK, WHITE;

	public Color opponent() {
		if (this == Color.BLACK)
			return Color.WHITE;
		else
			return Color.BLACK;
	}
}