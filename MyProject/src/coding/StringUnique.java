/**
 * 
 */
package coding;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Vibs
 *
 */
public class StringUnique {
	
	public static void main(String[] args){
		String abc = "abcdef";
		boolean a= isUnique(abc);
		System.out.println("unique---->"+a);
	}

	/**
	 * @param abc
	 * @return
	 */
	private static boolean isUnique(String abc) {
		char [] charArray=abc.toCharArray();
		Set<String> set = new HashSet<String>();
		for(char c:charArray){
		if(!set.add(""+c)){
			return false;
		 }
		}
		return true;
	}

}
