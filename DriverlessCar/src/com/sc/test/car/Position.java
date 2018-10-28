package com.sc.test.car;

public class Position {
	
	private Integer X;
	private Integer Y;
	
	public Position(Integer x, Integer y) {
		this.X = x;
		this.Y = y;
	}

	public Integer getX() {
		return X;
	}

	public void setX(Integer x) {
		X = x;
	}

	public Integer getY() {
		return Y;
	}

	public void setY(Integer y) {
		Y = y;
	}

	@Override
	public String toString() {
		return "Position [X=" + X + ", Y=" + Y + "]";
	}
	

}
