package OBSERVERPattern;

import java.util.ArrayList;

public class WeatherData implements Subject{
    
	private ArrayList<Observer> observers;
	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherData(){
		observers=new ArrayList<Observer>();
	}
	@Override
	public void notifyObservers() {
		
	   for(Observer ob: observers){
			ob.update(temperature, humidity, pressure);
		}
		
	}

	@Override
	 public void registerObserver(Observer o) {
	    observers.add(o);
		
	  }

	@Override
	  public void removeObserver(Observer o) {
	    int i=observers.indexOf(o);
	    if(i>=0){
		observers.remove(i);
	      }
	    }
     public void measurementsChanged(){
    	 notifyObservers();
     }
     
     public void setMeasurements(float temp,float humid,float pres){
    	 
    	 this.humidity=humid;
    	 this.temperature=temp;
    	 this.pressure=pres;
    	 measurementsChanged();
     }
}
