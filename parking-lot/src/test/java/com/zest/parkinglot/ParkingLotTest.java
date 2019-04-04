package com.zest.parkinglot;

import static org.junit.Assert.assertEquals;


import org.junit.BeforeClass;
import org.junit.Test;

public class ParkingLotTest {
	
	private static ParkingLot lot = null;
	
	@BeforeClass
	public static void createParkingLot() {
		lot = new ParkingLot(1, 7);
	}
	
	@Test
	public void testParkVehicle() {
		Vehicle v = new Car("KA-01-HH-1234"," White");
		int slot=lot.parkVehicle(v);
		assertEquals(2, slot);
	}

	@Test
	public void testLeaveVehicle() {
		Vehicle v1 = new Car("KA-01-HH-1234"," White");
		Vehicle v2 = new Car("KA-01-HH-7777", "Red");
		lot.parkVehicle(v1);
		lot.parkVehicle(v2);
		lot.leaveVehicle(2);
		assertEquals(0,lot.report().get(0).getSlotNumber());
		
	}

	@Test
	public void testReport() {
		assertEquals(2,lot.report().size());
	}

	@Test
	public void testGetVehicleNumberForColours() {
		Vehicle v1 = new Car("KA-01-HH-3141","Blue");
		lot.parkVehicle(v1);
		assertEquals("KA-01-HH-3141",lot.getVehicleNumberForColours("Blue"));
	}

	@Test
	public void testGetSlotNumberForColour() {
		assertEquals(1,Integer.parseInt(lot.getSlotNumberForColour("Blue")));
	}

	@Test
	public void testGetSlotNumberForVehicleNumber() {
		assertEquals(1,lot.getSlotNumberForVehicleNumber("KA-01-HH-3141"));
	}

}
