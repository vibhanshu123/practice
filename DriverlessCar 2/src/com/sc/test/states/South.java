package com.sc.test.states;

import com.sc.test.car.Car;
import com.sc.test.car.exception.CrossingBoundaryException;

public class South implements State {

	private Car car;

	public South(Car car) {
		this.car = car;
	}

	@Override
	public void turnleft() {
		car.setCurrentState(car.getEast());

	}

	@Override
	public void turnright() {
		car.setCurrentState(car.getWest());

	}

	@Override
	public void move() {
		int currentYPosition = car.getPos().getY();
		if (currentYPosition > 1) {
			car.getPos().setY(currentYPosition - 1);
		} else {
			throw new CrossingBoundaryException("Not Allowed : The car is crossing boundary as current position of car is "
					+ (currentYPosition-1) + " the minimum allowed position is 1");
		}
	}

	@Override
	public String toString() {
		return "SOUTH";

	}

}
