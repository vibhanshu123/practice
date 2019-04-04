package com.zest.parkinglot.command;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zest.parkinglot.Car;
import com.zest.parkinglot.ParkingLot;
import com.zest.parkinglot.Vehicle;

public class InputCode {

	private static Logger logger = LoggerFactory.getLogger(InputCode.class.getName());
	private ParkingLot parkingLot = null;
	private CommandInvoker commander = new CommandInvoker();

	public static void main(String[] args) {
		InputCode inputCode = new InputCode();
		if (args.length >0) {
			File file = new File(args[0]);
			inputCode.runAllCommandsFromFile(file);
		}else {
			logger.info("This is Interactive Shell Mode");
			logger.info("Make sure that your first command is create_parking_lot <Number of Slots>");
			logger.info("Or Please enter exit to exit from shell");
			inputCode.runAllCommandsFromInteractiveShell();
		}
	}
	
	private void runAllCommandsFromInteractiveShell() {
		while (true) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String s = null;
			try {
				s = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
				logger.error("Exception Occured",e);
			}
			String[] command = s.split(" ");
			if (command[0].equalsIgnoreCase("create_parking_lot")) {
				parkingLot = new ParkingLot(1, Integer.parseInt(command[1]));
				continue;
			}
			CommandToParkingLot commandToParkingLot = getCommandObjectFromInputString
					(command, parkingLot);
			if (command[0].equals("exit")) break;
			if (parkingLot == null) {
				logger.error("Parking Lot has not been initialzed Properly");
				continue;
			}
			if (commandToParkingLot == null) {
				logger.error("Not Valid Command");
				continue;
			}
			commander.storeAndExecute(commandToParkingLot);
		}
	}

	private void runAllCommandsFromFile(File file) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String buffer = null;
			while ((buffer = br.readLine()) != null) {
				String[] command = buffer.split(" ");
				if (command[0].equalsIgnoreCase("create_parking_lot")) {
					parkingLot = new ParkingLot(1, Integer.parseInt(command[1]));
					continue;
				}
				CommandToParkingLot commandToParkingLot = getCommandObjectFromInputString
						(command, parkingLot);
				if (parkingLot == null) {
					logger.error("Parking Lot has not been initialzed Properly");
					continue;
				}
				if (commandToParkingLot == null) {
					logger.error("Not Valid Command");
					continue;
				}
				commander.storeAndExecute(commandToParkingLot);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public CommandToParkingLot getCommandObjectFromInputString(String [] command, ParkingLot parkingLot) {
		CommandToParkingLot commandToParkingLot = null;
	     if (command[0].equalsIgnoreCase("park")) {
			Vehicle vehicle = new Car(command[1], command[2]);
			commandToParkingLot = new Park(parkingLot, vehicle);
		} else if (command[0].equalsIgnoreCase("leave")) {
			commandToParkingLot = new Leave(parkingLot, Integer.parseInt(command[1]));
		} else if (command[0].equalsIgnoreCase("status")) {
			commandToParkingLot = new Status(parkingLot);
		} else if (command[0].equalsIgnoreCase("registration_numbers_for_cars_with_colour")) {
			commandToParkingLot = new VehicleNumberForColour(parkingLot, command[1]);
		} else if (command[0].equalsIgnoreCase("slot_numbers_for_cars_with_colour")) {
			commandToParkingLot = new SlotNumberForColour(parkingLot, command[1]);
		} else if (command[0].equalsIgnoreCase("slot_number_for_registration_number")) {
			commandToParkingLot = new SlotNumberForVehicleNumber(parkingLot, command[1]);
		}
		return commandToParkingLot;
	}

}
