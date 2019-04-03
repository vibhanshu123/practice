package com.zest.parkinglot.command;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zest.parkinglot.Car;
import com.zest.parkinglot.ParkingLot;
import com.zest.parkinglot.Vehicle;

public class InputCode {
	
	private static Logger logger = LoggerFactory.getLogger(InputCode.class.getName());

	public static void main(String[] args) {
		ParkingLot parkingLot = null;
		CommandToParkingLot commandToParkingLot = null;
		Vehicle vehicle = null;
		CommandInvoker commander = new CommandInvoker();

		File file = new File("/Users/vibhanshu/Desktop/workspace/robot/src/robot/inputFile.txt");
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String buffer = null;
			while ((buffer = br.readLine()) != null) {
				String[] command = buffer.split(" ");
				if (command[0].equalsIgnoreCase("create_parking_lot")) {
					parkingLot = new ParkingLot(1, Integer.parseInt(command[1]));
				} else if (command[0].equalsIgnoreCase("park")) {
					vehicle = new Car(command[1], command[2]);
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

}
