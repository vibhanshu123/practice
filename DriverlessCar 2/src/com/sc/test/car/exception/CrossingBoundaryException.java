package com.sc.test.car.exception;

public class CrossingBoundaryException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public CrossingBoundaryException(String message) {
		super(message);
	}

}
