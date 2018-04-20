/**
 * 
 */
package amazon;

import java.util.ArrayList;

/**
 * @author Vibs
 *
 */
public class PermutationsOfString {
	
	public static ArrayList<String> getPerms(String string){
		if(string == null) return null;
		ArrayList<String> permutations = new ArrayList<String>();
		if(string.length()==0){
			permutations.add("");
			return permutations;
		}
		
		String first = string.substring(0,1);
		String remainder = string.substring(1);
		ArrayList<String> words = getPerms(remainder);
		for(String word: words){
			for(int j=0;j<=word.length();j++){
				String abc =insertCharAt(first,word,j);
				permutations.add(abc);
			}
		}
		return permutations;
	}
	
	/**
	 * @param first
	 * @param word
	 * @param j
	 * @return
	 */
	private static String insertCharAt(String first, String word, int j) {
		String start = word.substring(0,j);
		String end = word.substring(j);
		return start+first+end;
	}


	
	public static void main(String [] args){
		ArrayList<String> list = getPerms("abc");
		for(String s:list)
			System.out.print(s+",");
	}
	
	
	
	
	

}	
		
     

