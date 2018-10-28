package com.sc.test.states;

import com.sc.test.car.Car;
import com.sc.test.car.exception.CrossingBoundaryException;

public class East implements State {
	private Car car;

	public East(Car car) {
		this.car = car;
	}

	@Override
	public void turnleft() {
		car.setCurrentState(car.getNorth());

	}

	@Override
	public void turnright() {
		car.setCurrentState(car.getSouth());
	}

	@Override
	public void move() {
		int currentXPosition = car.getPos().getX();
		if (currentXPosition < car.getMaxX()) {
			car.getPos().setX(currentXPosition + 1);
		} else {
			throw new CrossingBoundaryException("Not Allowed : The car is crossing boundary as current position of car is "
					+ (currentXPosition+1) + " the maximum allowed position is " + car.getMaxX());
		}
	}

	@Override
	public String toString() {
		return "EAST";

	}

}
