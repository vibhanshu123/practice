package linkedlist;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArryaysQuestions {
	
	
	/**
	 * If all elements are distinct,then a sub array has contiguous elements if and only if 
	 * the difference between maximum and minimum elements in sub array is equal to 
	 * the difference between last and first indexes of sub array
	 * @param array
	 */
	public static int lengthOfLargestSubarrayWithContiguousElements(int [] array) {
		 int max_len = 1;  // Initialize result
	        for (int i = 0; i < array.length - 1; i++) {
	            int mn = array[i], mx = array[i];
	           
	            for (int j = i + 1; j < array.length; j++) 
	            {
	                mn = min(mn, array[j]);
	                mx = max(mx, array[j]);
	 
	                if ((mx - mn) == j - i)
	                    max_len = max(max_len, mx - mn + 1);
	            }
	        }
	        return max_len;  // Return result
		
	}

	 public static int min(int x, int y) {
	        return (x < y) ? x : y;
	    }
	 
	  public static int max(int x, int y)  {
	        return (x > y) ? x : y;
	    }
	  /**
	   * A magic number is defined as a number which can be expressed as a power of 
	   * 5 or sum of unique powers of 5.
	   * First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5), ….
	   * @param n
	   * @return
	   */
	  	static int nthMagicNo(int n){
	  	     int pow = 1, answer = 0;
	  	     while (n != 0)
	  	     {
	  	       pow = pow*5;
	  	  
	  	       // If last bit of n is set
	  	       if ((n & 1) == 1)
	  	         answer += pow;
	  	  
	  	      n=n/2; 
	  	     }
	  	     return answer;
	  	  }
	  	
	   
	  	public static Map<String,Long> getListOfMostOccoringWords(String text){
	  		Stream<String> stream = Stream.of(text.toLowerCase().split("\\W+")).parallel();  
	  		Map<String,Long> wordFreq= stream.collect(Collectors.groupingBy(String::toString,Collectors.counting()));
	  	    return wordFreq;
	  	}
	  	
	  	public static List<String> getTopKOccurences(Map<String,Long> wordfreqMap) {
	  		
	  		
	  		return null;
	  		
	  	}
	  	
	  	
	    public static void main(String[] args)  {
	        int arr[] = {1, 56, 58, 57, 90, 92, 94, 93, 91, 45};
	        System.out.println("Length of the longest contiguous subarray is "
	                + lengthOfLargestSubarrayWithContiguousElements(arr));
	        System.out.println("nth magic" +
	        	    " number is " + nthMagicNo(5));
	    }


}
