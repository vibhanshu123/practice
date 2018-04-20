/**
 * 
 */
package coding;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Vibs
 *
 */
public class StringPermutationCheck {
	
	public static void main(String[] args){
		String abc = "abcdef";
		String fgh="bcdefa";
		boolean a= isPermutaion(abc,fgh);
		System.out.println("permutation---->"+a);
	}

	/**
	 * @param abc
	 * @return
	 */
	private static boolean isPermutaion(String s1, String s2) {
		if(s1.length()!=s2.length()){
			return false;
		}
		char [] charArrays1=s1.toCharArray();
		Arrays.sort(charArrays1);
		char[] charArrays2 = s2.toCharArray();
		Arrays.sort(charArrays2);
		String string1= new String(charArrays1);
		System.out.println(string1);
		String string2= new String(charArrays2);
		System.out.println(string2);
		if(string1.equals(string2)){
			System.out.println("should be true");
			return true;
		}
		return false;
	}

}
