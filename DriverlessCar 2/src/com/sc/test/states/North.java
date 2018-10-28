package com.sc.test.states;

import com.sc.test.car.Car;
import com.sc.test.car.exception.CrossingBoundaryException;

public class North implements State {

	private Car car;

	public North(Car car) {
		this.car = car;
	}

	@Override
	public void turnleft() {
		car.setCurrentState(car.getWest());

	}

	@Override
	public void turnright() {
		car.setCurrentState(car.getEast());

	}

	@Override
	public void move() {
		int currentYPosition = car.getPos().getY();
		if (currentYPosition < car.getMaxY()) {
			car.getPos().setY(currentYPosition + 1);
		} else {
			throw new CrossingBoundaryException("Not Allowed : The car is crossing boundary as current position of car is "
					+ (currentYPosition+1) + " the maximum allowed position is " + car.getMaxY());
		}
	}

	@Override
	public String toString() {
		return "NORTH";

	}

}
