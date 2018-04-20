import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 */

/**
 * @author Vibs
 *
 */
public class BrandOfCars {
	
	private String brandName ;
	
	private int countOfCars ;
	
    public BrandOfCars(String brandName, int countOfCars){
    	this.brandName = brandName;
    	this.countOfCars = countOfCars;
    }
	
	public String getBrandName() {
		return brandName;
	}



	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}



	public int getCountOfCars() {
		return countOfCars;
	}



	public void setCountOfCars(int countOfCars) {
		this.countOfCars = countOfCars;
	}



	public static void main(String [] args){
	//	Map map = new HashMap();
		
		BrandOfCars car1 = new BrandOfCars("HONDA",120);
		BrandOfCars car2 = new BrandOfCars("FORD",800);
		BrandOfCars car3 = new BrandOfCars("AUDI",500);
		BrandOfCars car4 = new BrandOfCars("MERC",1000);
		BrandOfCars car5 = new BrandOfCars("HYUNDAI",134);
		BrandOfCars car6 = new BrandOfCars("SEARCH", 567);
//		
//		map.put("HONDA", 120);
//		map.put("FORD", 800);
//		map.put("AUDI", 500);
//		map.put("MERC", 1000);
		ValueSort sort = new ValueSort();
		List<BrandOfCars> list = new ArrayList<BrandOfCars>();
		list.add(car1);
		list.add(car2);
		list.add(car3);
		list.add(car4);
		list.add(car5);
		
		Collections.sort(list, sort);
		System.out.println(Collections.binarySearch(list, car6,sort));
		for(BrandOfCars car:list){
			System.out.println("name"+car.getBrandName()+"----- number is="+car.getCountOfCars()+"\n");
		}
	}
	

}


