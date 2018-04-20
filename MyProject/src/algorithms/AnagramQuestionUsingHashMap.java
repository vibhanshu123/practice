/**
 * 
 */
package algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;


/**
 * @author Vibs
 *
 */
public class AnagramQuestionUsingHashMap {
	
	public static void main(String [] args){
		String [] stringArray={"cat","bat","hello","lelw","world","tab","act","well"};
	    sort(stringArray);
	}
	
	public static void sort(String [] strArray){
		HashMap<String, LinkedList<String>> stringMap = new HashMap<String, LinkedList<String>>();
		for(String s:strArray){
			char[] charArray= s.toCharArray();
			Arrays.sort(charArray);
			String sortedString = new String(charArray);
			if(stringMap.get(sortedString)!=null)
				stringMap.get(sortedString).addLast(s);
			else{
				LinkedList<String> list = new LinkedList<String>();
				list.add(s);
				stringMap.put(sortedString, list);
			}
		}
		Set<String> set = stringMap.keySet();
		for(String s:set){
		  LinkedList<String> list = stringMap.get(s);
		  for(String s1:list)
			  System.out.print(s1+",");
		}
	}

}
