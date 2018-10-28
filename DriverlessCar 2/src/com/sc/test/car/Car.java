package com.sc.test.car;

import com.sc.test.car.exception.CrossingBoundaryException;
import com.sc.test.states.East;
import com.sc.test.states.North;
import com.sc.test.states.South;
import com.sc.test.states.State;
import com.sc.test.states.West;

public class Car implements State, ICar {

	private final Integer maxX;
	private final Integer maxY;
	private final State north;
	private final State south;
	private final State east;
	private final State west;

	private State currentState;

	private Position pos;

	public Car(int length, int breadth) {
		this.north = new North(this);
		this.south = new South(this);
		this.east = new East(this);
		this.west = new West(this);
		this.maxX = length;
		this.maxY = breadth;
	}

	private void setPos(Position pos) {
		this.pos = pos;
	}

	@Override
	public void place(int x, int y, String state) {
		System.out.println("Car directly placed X:"+x+" Y:"+y+" Direction:"+state);
		if ((x >= 1 && x <= maxX) && (y >= 1 && y <= maxY)) {
			Position pos = new Position(x, y);
			setPos(pos);
			switch (state) {
			case "NORTH":
				setCurrentState(north);
				break;
			case "SOUTH":
				setCurrentState(south);
				break;
			case "EAST":
				setCurrentState(east);
				break;
			case "WEST":
				setCurrentState(west);
				break;
			default:
				System.out.println("Something WRONG !please check");
			}
		} else {
			throw new CrossingBoundaryException(
					"The car is crossing boundary as current position of car is" + getPos().toString());
		}
	}

	@Override
	public void report() {
		System.out.println(this);
	}

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("Output : ");
		string.append(this.getPos().getX() + ",");
		string.append(this.getPos().getY() + ",");
		string.append(this.getCurrentState().toString());
		return string.toString();
	}

	@Override
	public Position getPos() {
		return pos;
	}

	@Override
	public void turnleft() {
		currentState.turnleft();

	}

	@Override
	public void turnright() {
		currentState.turnright();

	}

	@Override
	public void move() {
		currentState.move();

	}

	@Override
	public State getCurrentState() {
		return currentState;
	}

	@Override
	public void setCurrentState(State state) {
		this.currentState = state;
	}

	public State getNorth() {
		return north;
	}

	public State getSouth() {
		return south;
	}

	public State getEast() {
		return east;
	}

	public State getWest() {
		return west;
	}

	public Integer getMaxX() {
		return maxX;
	}

	public Integer getMaxY() {
		return maxY;
	}

}
