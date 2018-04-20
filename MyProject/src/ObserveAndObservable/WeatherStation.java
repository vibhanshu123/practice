package ObserveAndObservable;

public class WeatherStation {
	
	public static void main(String [] args){
		WeatherData data=new WeatherData();
		CurrentConditionsDisplay ccd=new CurrentConditionsDisplay(data);
		ForeCastDisplay fd=new ForeCastDisplay(data);
		StatisticsDisplay sd=new StatisticsDisplay(data);
		data.setMeasurements(80, 65, 30.4f);
		data.setMeasurements(82, 70, 29.2f);
		data.setMeasurements(78, 90, 29.2f);
	}

}
