package ObserveAndObservable;

import java.util.Observable;

public class WeatherData extends Observable {
	
	private float temperature;
	private float pressure;
	private float humidity;
	
	public WeatherData(){
		
	}
	
	public void measurementChanged(){
		setChanged();
		notifyObservers();
	}
	
	public void setMeasurements(float temp,float humidity,float pres){
		this.temperature=temp;
		this.humidity=humidity;
		this.pressure=pres;
		measurementChanged();
	}

	public float getTemperature() {
		return temperature;
	}

	public float getPressure() {
		return pressure;
	}

	public float getHumidity() {
		return humidity;
	}
	
	

}
