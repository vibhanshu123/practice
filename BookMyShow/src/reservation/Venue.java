package reservation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Venue {
	
	private int totalAvailable;
    private List<Seat> seats = new ArrayList<Seat>();
    //private Seat[] seats = new Seat[totalAvailable];
    
    public Venue(int rows,int seatsPerRow) {
    	constructVenue(rows, seatsPerRow);
    	this.totalAvailable = rows*seatsPerRow;
	}

	private void constructVenue(int rows, int seatsPerRow) {
		for(int i = 1; i <= rows; i++) {
            for(int j = 1; j <= seatsPerRow; j++) {
                seats.add(new Seat(j,i));
            }
        }
		
	}
    		
	 public int getTotalAvailable() {
	        return totalAvailable;
	    }

	public List<Seat> getAvailableSeats() {
		return seats.parallelStream().filter(s -> s.isAvailable()).collect(Collectors.toList());
	}
	

    public void incrementTotalAvailable(int numSeats) { this.totalAvailable = this.getTotalAvailable() + numSeats; }

    public void decrementTotalAvailable(int numSeats) { this.totalAvailable = this.getTotalAvailable() - numSeats; }
    
	public boolean holdSeats(Seat[] seats) throws InterruptedException {
		int count = 0;
		try {
			for (Seat seat : seats) {
				boolean isLockPresent = seat.getLock().tryLock();
				if (!isLockPresent || !seat.isAvailable()) {
					return false;
				}
				count++;
			}
			Stream.of(seats).forEach(s -> s.setCurrentStatus(Status.HELD));
		} finally {
			Stream.of(Arrays.copyOfRange(seats, 0, count)).forEach(s -> s.getLock().unlock());
		}
		return true;
	}
     
     public boolean bookSeats(Seat[] seats) throws InterruptedException {
    	  if(holdSeats(seats)) {
    		  System.out.println("start the timer");
    		  System.out.println("start booking the seats");
    		  System.out.println("Booked the seats");
    		  return true;
    	  }else {
    		  
    		  System.out.println("something is wrong please book the seat again");
    		  return false;
    	  }
     }

}
