import java.util.ArrayList;
import java.util.List;


public class RentalGeneric<T> {
  private List<T> rentalPool;
  
  private int maxnum;
  public RentalGeneric(int max,List<T> rentList){
	  
	  this.maxnum =max;
	  this.rentalPool=rentList;
  }
  
  public T getRental(){
	return rentalPool.get(0);
	  
  }
  
  public void returnRental(T returnedThing){
	  rentalPool.add(returnedThing);
  }
  
  
  
	

}

class TestRental{
	
	public static void main(String[] args){
		Car c1=new Car();
		Car c2= new Car();
		List<Car> carList=new ArrayList<Car>();
		carList.add(c1);
		carList.add(c2);
		RentalGeneric<Car> carRental=new RentalGeneric<Car>(2, carList);
		
		Car carTorent=carRental.getRental();
		carRental.returnRental(carTorent);
		carList.add(new Car());
	}
	
}

 class NumberHolder <T>{
	 T anum;
 }
