/**
 * 
 */
package coding;

import java.util.HashMap;

/**
 * @author Vibs
 *
 */
public class LongestSubStringWithUniqueCharacters {
	
	public static void findMaxUniqueString(String s){ 
		HashMap<Character, Integer> charIdx =new HashMap<Character, Integer>();
	      int start = 0;
	      int maxStart = 0;
	      int maxLen = 0;
	      int initialStart = 0;
	      for(int i=0;i<s.length();i++){
	    	  if(!charIdx.containsKey(s.charAt(i))){
	    		  int lengthOfUniqueString = i - start + 1;
	    		  if(lengthOfUniqueString>maxLen){
	    			  maxLen = lengthOfUniqueString ;
	    			  maxStart = start ;
	    		  }
	    	  }else {
	    		 initialStart = charIdx.get(s.charAt(i))+1;
	    		 if(initialStart>=start)
	    			 start = initialStart ;
	    	  }
	    	  charIdx.put(s.charAt(i), i);
	      }
	      
	      for(int i =0;i<maxLen;i++){
	    	System.out.print(s.charAt(i+maxStart));  
	      }
		  }	
	
	public static void findMaxUniqueStringPractice(String s){ 
		HashMap<Character,Integer> stringMap = new HashMap<Character, Integer>();
		int maxLen =0 ;
		int start =0;
		int maxStart = 0 ;
		int initialStart = 0;
		for(int i=0;i<s.length();i++){
			if(!stringMap.containsKey(s.charAt(i))){
				int lengthOfString = i -start+1;
				if(lengthOfString>maxLen){
					maxLen = lengthOfString;
					maxStart = start ;
				}
			  }
			else{
				initialStart = stringMap.get(s.charAt(i))+1;
				if(initialStart>=start){
					start = initialStart ;
				}
			}
			stringMap.put(s.charAt(i), i);
		    }
		System.out.println("---");
		for(int i=0 ;i<maxLen;i++)
			System.out.print(s.charAt(i+maxStart));
		
		 }	
	
	
	public static void findMaxUniqueStringOld(String s){ 
		HashMap<Character, Integer> charIdx =new HashMap<Character, Integer>();
		int maxLen = 0;
		int maxStart = 0;
		int start = 0;	
		int initialStart = 0;
		for (int i = 0; i < s.length(); i++){	
		if (!charIdx.containsKey(s.charAt(i))){
		int lenghtOfUniqueString = i - start +1 ;
		if (maxLen < lenghtOfUniqueString){
		maxLen = lenghtOfUniqueString; 
		maxStart = start; 
		} 
		} 
		else{ 
			initialStart = charIdx.get(s.charAt(i)) + 1; 
			if(initialStart>=start)
			start = initialStart ;
			}
		charIdx.put(s.charAt(i), i);
		} 
		for (int i = 0; i < maxLen; i++){
		System.out.print(s.charAt(maxStart + i)); 
		}
		}	
		
		 
  

      public static void main(String [] args){
	   findMaxUniqueString("asderdfsetodingydeflep");
	   System.out.println("----");
	   findMaxUniqueStringOld("asderdfsetodingydeflep");
	   findMaxUniqueStringPractice("asderdfsetodingydeflep");
      }

}