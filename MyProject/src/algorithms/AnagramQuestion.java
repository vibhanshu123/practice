/**
 * 
 */
package algorithms;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Vibs
 *
 */
public class AnagramQuestion implements Comparator<String>{

	public String sortChars(String s1){
		char[] charArray = s1.toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
	}
	@Override
	public int compare(String s1, String s2) {
		return sortChars(s1).compareTo(sortChars(s2));
	}
	
	public static void main(String [] args){
		String [] stringArray={"cat","bat","hello","world","tab","act"};
		Arrays.sort(stringArray,new AnagramQuestion());
		for(String s:stringArray)
			System.out.print(s+",");
	}

}
