package ObserveAndObservable;

import java.util.Observable;
import java.util.Observer;

public class ForeCastDisplay implements Observer,DisplayElement{

	Observable observable ;
	private float currentPresure=29.2f;
	private float lastPressure;
	public ForeCastDisplay(Observable observable){
		this.observable=observable;
		observable.addObserver(this);
		
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if(o instanceof WeatherData){
			WeatherData data=(WeatherData)o;
			lastPressure=currentPresure;
			currentPresure=data.getPressure();
			display();
		}
		
		
	}

	@Override
	public void display() {
		System.out.print("Forecast: ");
		if (currentPresure > lastPressure) {
			System.out.println("Improving weather on the way!");
		} else if (currentPresure == lastPressure) {
			System.out.println("More of the same");
		} else if (currentPresure < lastPressure) {
			System.out.println("Watch out for cooler, rainy weather");
		}
		
	}

}
