/**
 * 
 */
package amazon;

/**
 * @author Vibs
 *
 */
public interface CacheStrategy<K,T> {
	
	T get(K key);
	
	void put(K key ,T data);

}
