package com.sc.test.car;

import com.sc.test.states.State;

public interface ICar {
	
	public Position getPos() ;
	public void place(int x, int y, String state) ;
	public State getCurrentState() ;
	public void setCurrentState(State state) ;
	public void report() ;


}
