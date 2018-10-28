package com.sc.test.car;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class InputCode {

	public static void main(String[] args) {
		Car car = new Car(4, 4);
		CommandToCar turnLeft = new Left(car);
		CommandToCar turnRight = new Right(car);
		CommandToCar move = new Move(car);
		CommandToCar report = new Report(car);
		CommandInvoker commander = new CommandInvoker();

		File file = new File("/Users/vibhanshu/Desktop/workspace/DriverlessCar/src/com/sc/test/car/inputFile.txt");
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String buffer = null;
			while ((buffer = br.readLine()) != null) {
				String[] command = buffer.split(" ");
				if (command[0].equalsIgnoreCase("MOVE")) {
					commander.storeAndExecute(move);
				} else if (command[0].equalsIgnoreCase("LEFT")) {
					commander.storeAndExecute(turnLeft);
				} else if (command[0].equalsIgnoreCase("REPORT")) {
					commander.storeAndExecute(report);
				} else if (command[0].equalsIgnoreCase("RIGHT")) {
					commander.storeAndExecute(turnRight);
				} else if (command[0].equalsIgnoreCase("PLACE")) {
					StringTokenizer data = new StringTokenizer(command[1], ",");
					String x = data.nextToken();
					String y = data.nextToken();
					String direction = data.nextToken();
					car.place(Integer.parseInt(x), Integer.parseInt(y), direction);
				}
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
