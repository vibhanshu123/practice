package OBSERVERPattern;

public class CurrentConditionsDisplay implements Observer,DisplayElement{

	private float temperature;
	private float humidity;
	private float pressure;
	private Subject weatherData;
	
	public CurrentConditionsDisplay(Subject data){
		this.weatherData=data;
		data.registerObserver(this);
	}
	
	@Override
	public void update(float temp, float humidity, float pressure) {
		// TODO Auto-generated method stub
		this.temperature=temp;
		this.humidity=humidity;
		this.pressure=pressure;
		display();
		
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
    System.out.println("current conditons: temperature="+temperature+"humidity="+humidity+"pressure="+pressure);		
	}

}
