import java.util.Comparator;
import java.util.HashMap;

public class ValueSort implements Comparator<BrandOfCars>{
	 
	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(BrandOfCars o1, BrandOfCars o2) {
		Integer value1 = null;
		Integer value2 = null;
//		while (o1.keySet().iterator().hasNext()){
//			String key1=(o1.keySet().iterator()).next();
//			value1=o1.get(key1);
//		}
//		while (o2.keySet().iterator().hasNext()){
//			String key2=(o2.keySet().iterator()).next();
//			value2=o2.get(key2);
//		}
		value1 = (Integer)o1.getCountOfCars();
		value2=(Integer)o2.getCountOfCars();
		return(value2.compareTo(value1));	
	}
	
}
