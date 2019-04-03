package com.zest.parkinglot.command;

import java.util.ArrayList;
import java.util.List;

public class CommandInvoker {

	private final List<CommandToParkingLot> commands;

	public CommandInvoker() {
		this.commands = new ArrayList<CommandToParkingLot>();
	}

	public void storeAndExecute(CommandToParkingLot command) {
		commands.add(command);
		command.executeCommand();
	}

}
