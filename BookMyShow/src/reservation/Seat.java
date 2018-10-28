package reservation;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Seat {
	
	private int seatid;
	private Status currentStatus;
	private int rowId;
	private final Lock lock ;
	
	
	public Seat(int seatid, int rowId) {
		super();
		this.seatid = seatid;
		this.rowId = rowId;
		this.currentStatus = Status.AVAILABLE;
		lock = new ReentrantLock();
	}
	public int getSeatid() {
		return seatid;
	}
	public void setSeatid(int seatid) {
		this.seatid = seatid;
	}
     
	public Status getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(Status currentStatus) {
		this.currentStatus = currentStatus;
	}
	
	public boolean isAvailable() {
		return currentStatus.equals(Status.AVAILABLE);
	}
	
	public int getRowId() {
		return rowId;
	}
	public void setRowId(int rowId) {
		this.rowId = rowId;
	}
	public Lock getLock() {
		return lock;
	}

}
