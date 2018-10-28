package com.sc.test.car;

import com.sc.test.car.exception.CrossingBoundaryException;

public class CommandInvoker {

	public void storeAndExecute(CommandToCar command) {
		try {
			command.executeCommand();
		} catch (CrossingBoundaryException exception) {
			System.out.println(exception.getMessage());
		}
	}

}