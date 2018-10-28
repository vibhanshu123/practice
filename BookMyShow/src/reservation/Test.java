package reservation;

import java.util.List;

public class Test {
	
	public static void main(String [] args) {
		Venue venue = new Venue(2, 10);
		Thread t1 = new Thread(()->{
			List<Seat> seats = venue.getAvailableSeats();
			System.out.println("Lets try booking 3 seats seat 1 seat 2 seat 3");
			Seat[] seatArr = new Seat[3];
			for(int i=0;i<3;i++) {
				seatArr[i]=seats.get(i);
			}
			
			try {
				while(!venue.bookSeats(seatArr)) {
					seats = venue.getAvailableSeats();
					System.out.println("Lets try booking 3 seats seat 1 seat 2 seat 3 another time");
					//Seat[] seatArr = new Seat[3];
					for(int i=0;i<3;i++) {
						seatArr[i]=seats.get(i);
					}	
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		Thread t2 = new Thread(()->{
			List<Seat> seats = venue.getAvailableSeats();
			System.out.println("Lets try booking 3 seats seat 1 seat 2 seat 3");
			Seat[] seatArr = new Seat[3];
			for(int i=0;i<3;i++) {
				seatArr[i]=seats.get(i+2);
			}
			
			try {
				while(!venue.bookSeats(seatArr)) {
					seats = venue.getAvailableSeats();
					System.out.println("Lets try booking 3 seats seat 1 seat 2 seat 3");
					//Seat[] seatArr = new Seat[3];
					for(int i=0;i<3;i++) {
						seatArr[i]=seats.get(i);
					}	
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		
		Thread t3 = new Thread(()->{
			List<Seat> seats = venue.getAvailableSeats();
			System.out.println("Lets try booking 3 seats seat 1 seat 2 seat 3");
			Seat[] seatArr = new Seat[3];
			for(int i=0;i<3;i++) {
				seatArr[i]=seats.get(i+10);
			}
			
			try {
				while(!venue.bookSeats(seatArr)) {
					seats = venue.getAvailableSeats();
					System.out.println("Lets try booking 3 seats seat 1 seat 2 seat 3");
					//Seat[] seatArr = new Seat[3];
					for(int i=0;i<3;i++) {
						seatArr[i]=seats.get(i);
					}	
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		t1.start();
		t2.start();
		t3.start();
	}

}
