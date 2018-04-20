/**
 * 
 */
package interview;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author Vibs
 *
 */
public class Test {

	public static void main(String[] args) {
		//Class c1=Class.forName("Car");
		Map map = new HashMap();
		map.put("a", 1);
		map.put("b", 2);
		Set set = map.keySet();
		System.out.println("set is"+set);
		for(Iterator iter = set.iterator();iter.hasNext();){
		   String key =(String) iter.next();
		   System.out.println("key is"+key);
		   System.out.println("value is"+map.get(key));
		}
	}	
	
}
