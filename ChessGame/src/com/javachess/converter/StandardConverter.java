package com.javachess.converter;

import com.javachess.board.Square;

/**
 * 
 * @author Vibs
 *
 */
public class StandardConverter implements NotationConverter {

	@Override
	public Square getSrc(String notation) {
	    checkLength(notation);
		return toSquare(notation.substring(0, 2));
	}

	@Override
	public Square getDst(String notation) {
		checkLength(notation);
		return toSquare(notation.substring(2, 4));
	}

    
	private Square toSquare(String code) {
		checkLength(code);
		Square square = null;
		try {
			int row = Integer.parseInt(code.substring(0, 1));
			int column = Integer.parseInt(code.substring(1, 2));
			checkRow(row);
			checkRow(column);
			square = Square.at(row-1, column-1);
		} catch (Exception e) {
			throw new IllegalArgumentException("An error occured while converting " + code + " " + e.getMessage());
		}
		return square;
	}
	
	private void checkRow(int row) {
		if (row < 1 || row > 8)
			throw new IllegalArgumentException("Row value must be between 1 and 8");
	}

	private void checkLength(String code) {
		if (code.equals("")||code == null || code.length() <2)
			throw new IllegalArgumentException("Input length must be exactly 2characters for first time and 4 characters for rest");
	}
}