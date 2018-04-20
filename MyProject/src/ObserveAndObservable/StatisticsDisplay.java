package ObserveAndObservable;

import java.util.*;

public class StatisticsDisplay implements Observer, DisplayElement {
	private float maxTemp = 0.0f;
	private float minTemp = 200;
	private float tempSum= 0.0f;
	private int numReadings;
	private Observable observable;

	public StatisticsDisplay(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}


	public void display() {
		System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings)
			+ "/" + maxTemp + "/" + minTemp);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if(o instanceof WeatherData){
			WeatherData data=(WeatherData)o;
			tempSum+=data.getTemperature();
			numReadings++;
			if(data.getTemperature()>maxTemp){
				maxTemp=data.getTemperature();
			}
			if(data.getTemperature()<minTemp){
				minTemp=data.getTemperature();
			}
			display();
		}
	}
}
