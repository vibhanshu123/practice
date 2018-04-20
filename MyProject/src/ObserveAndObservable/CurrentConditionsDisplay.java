package ObserveAndObservable;

import java.util.Observable;
import java.util.Observer;



public class CurrentConditionsDisplay implements Observer,DisplayElement{

	Observable observable;
	private float temperature;
	private float humidity;
	@Override
	public void update(Observable obs, Object o) {
		// TODO Auto-generated method stub
		if(obs instanceof WeatherData){
			WeatherData weatherData=(WeatherData)obs;
			this.temperature=weatherData.getTemperature();
			this.humidity=weatherData.getHumidity();
			display();
		}
		
	}
	
	public CurrentConditionsDisplay(Observable observable){
		this.observable=observable;
		observable.addObserver(this);
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("current conditons: temperature="+temperature+"%f and humidity="+humidity);
		
	}

}
