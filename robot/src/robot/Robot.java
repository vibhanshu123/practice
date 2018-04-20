package robot;

import states.East;
import states.North;
import states.South;
import states.State;
import states.West;

public class Robot implements State {

	public static final Integer maxX = 5;
	public static final Integer maxY = 5;
	public static final Integer minX = 0;
	public static final Integer minY = 0;

	private  State north;
	private  State south;
	private  State east;
	private  State west;
	private State currentState;
	
	private Position pos;
	
	public Robot() {
	     this.north = new North(this);
	     this.south = new South(this);
	     this.east =new East(this);
	     this.west = new West(this);
	}

	
	private void setPos(Position pos) {
		this.pos = pos;
	}

	public void place(int x, int y, String state) {
		System.out.println("Robot directly placed");
		if ((x >= 0 && x <= maxX) && (y >= 0 && y <= maxY)) {
			Position pos = new Position(x, y);
			setPos(pos);
			switch(state) {
			case "NORTH":setState(north);
			             break;
			case "SOUTH":setState(south);
                         break;
			case "EAST":setState(east);
                        break;
			case "WEST":setState(north);
                        break;
             default: System.out.println("Something WRONG !please check"); 
			}
		}
	}

	public void report() {
			System.out.println(this);
	}

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("Output : ");
		string.append(this.getPos().getX() + ",");
		string.append(this.getPos().getY() + ",");
		string.append(this.getState().toString());
		return string.toString();
	}

	public Position getPos() {
		return pos;
	}

	@Override
	public void turnleft() {
		currentState.turnleft();

	}

	@Override
	public void turnright() {
		currentState.turnright();

	}

	@Override
	public void move() {
		currentState.move();

	}

	public State getState() {
		return currentState;
	}

	public void setState(State state) {
		this.currentState = state;
	}

	public State getNorth() {
		return north;
	}

	public State getSouth() {
		return south;
	}

	public State getEast() {
		return east;
	}

	public State getWest() {
		return west;
	}
	
	

}
