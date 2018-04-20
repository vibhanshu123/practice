/**
 * 
 */
package amazon;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Vibs
 *
 */
public class LRUCacheUsingLinkedHashMap<K,V> extends LinkedHashMap<K,V>{
 
	private static final long serialVersionUID = 1L;
   
	public int capacity ;	
   
 
   public LRUCacheUsingLinkedHashMap(int capacity) {
	   super(16, 0.75f, true);
	   this.capacity = capacity ;
    }
   
   protected boolean removeEldestEntry(Map.Entry<K, V> eldest){
	   return size() > capacity ;
   }
	
}
