/**
 * 
 */
package coding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * @author Vibs
 *
 */
public class Anything {
	
	public static void main(String [] args){
//		int [] array = {1,2,3,4,5};
//		array=rotate( array,2);
//		
//		for(int a: array)
//			System.out.println(a);	
		
		 int[] f = {1, 2, 3, 4, 5,6};
		    System.out.println(Arrays.toString(f));
		    rotatecOPY(f, 2);
		    System.out.println(Arrays.toString(f));
		    
		    String s= "asdf";
		    System.out.println(s.indexOf("x"));
		    System.out.println("answer is"+findMaxUniqueStringPractice("baaccb"));
		
	//	int[][] newArray ={{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}};
	//	searchForKey(9, newArray);
	}
	
	
	
	public static int[] rotateArrayNew(int y,int[] array){
		for(int i=0;i<array.length;i++){
			int incrementValue = (i+y)%array.length;
			int temp = array[incrementValue];
			array[incrementValue]=temp;		
		}
		return array;
	}
	

	public static int[] rotate(int[] a,int y) {
			  int tempNew = a[a.length-y];
			  int temp1=a[a.length-y+1];
		        for (int j = a.length-1; j>=y; j--) {
		            a[j] = a[j -y];
		        }	        
		        a[0] = tempNew;
		        a[1]= temp1;
	      return (a);
	      
	}
	


	public static void rotatecOPY(int[] arr, int dist){
	    int tmp, tmp2, gcd = GCD(arr.length, dist);
	    for(int off=0;off<gcd;off++){
	        tmp = arr[off];
	        for(int i=0,idx=off;i<arr.length/gcd;idx=(idx+dist)%arr.length,i++){
	            tmp2 = arr[(idx+dist)%arr.length];
	            arr[(idx+dist)%arr.length] = tmp;
	            tmp = tmp2;
	        }
	    }
	}

	public static int GCD(int a, int b) {
	   if (b==0) return a;
	   return GCD(b,a%b);
	}
    
	
	

	public static void  searchForKey(int key, int [][] array){
		int colNumns=array[0].length;
	    int rowNumns = array.length;
	    int rowNumber = 0;
	    int columnNumber = 0;
	  for(int i=0;i<rowNumns;i++){
		if((key>array[i][0]) && (key<array[i][colNumns-1]))
		  rowNumber = i ;
		}
	  for(int i=0;i<colNumns;i++){
		 if(key==array[rowNumber][i])
			columnNumber = i; 
	  }
	  
	  System.out.println("rowNumber"+rowNumber+1+"columnNumber"+columnNumber+1);
	}
	


	private static int count [] = new int[200];
	public static int doComputationOnSTring(String s){
	 if(s.length() ==0) return 0;	
	 if(s.length()==1||s.length()==2) return 1;
	 if(s.length()==3) {
		 if(s.indexOf("a")==-1||s.indexOf("b")==-1||s.indexOf("c")==-1) return 1;
	 }
	 return doComputationOnSTring(s.substring(0,s.length()-1))+ doComputationOnSTring(s.substring(1,s.length()));
		 
	}
	
	
	public static int findMaxUniqueStringPractice(String s){ 
		LinkedHashMap<Character,Integer> stringMap = new LinkedHashMap<Character, Integer>();
		Character firstKeyInsertPosition = 0;
		int contiguousLength = 0;
		int index =0;
		int result = (2*s.length())-1;
		int count = 0;
		for(int i=0;i<s.length();i++){
			if(!stringMap.containsKey(s.charAt(i))){
				stringMap.put(s.charAt(i), i);
				count++;
			  }
			if(count ==3){
				firstKeyInsertPosition = getPositionFromMap(stringMap);
				index = stringMap.get(firstKeyInsertPosition);
				contiguousLength = i - index ;
				
				if(contiguousLength!=3)
				result +=((contiguousLength*(contiguousLength+1))/2) - (2*contiguousLength) + 1;
				else if((i>2 &&!(s.charAt(i-1)!=s.charAt(i-2)&& s.charAt(i-2)!=s.charAt(i-3) && s.charAt(i-1)!= s.charAt(i-3))))
					result +=((contiguousLength*(contiguousLength+1))/2) - (2*contiguousLength) + 1;
				if(firstKeyInsertPosition!=s.charAt(i-1)){
					stringMap.remove(firstKeyInsertPosition);
					count --;
				}
				else {
					stringMap.remove(firstKeyInsertPosition);
					stringMap.remove(s.charAt(i));
					stringMap.put(firstKeyInsertPosition, i-1);
					stringMap.put(s.charAt(i), i);
				}
				
			}
			}
		firstKeyInsertPosition = getPositionFromMap(stringMap);
		index = stringMap.get(firstKeyInsertPosition);
		contiguousLength = (s.length()) - index ;
		result +=((contiguousLength*(contiguousLength+1))/2) - (2*contiguousLength) + 1;
		return (result%1000000007) ;
	}



	/**
	 * @param stringMap
	 * @return
	 */
	private static Character getPositionFromMap(
			LinkedHashMap<Character, Integer> stringMap) {
	   Set<Character> set = stringMap.keySet();
	   return set.iterator().next();
	
	}
	
	
	/**
	 * @param stringMap
	 * @return
	 */
	private static Character get2ndPositionFromMap(
			LinkedHashMap<Character, Integer> stringMap) {
	   Set<Character> set = stringMap.keySet();
	   int count =0;
	  for(Iterator iter= set.iterator();iter.hasNext();){
	   if(count ==2) return (Character)iter.next();
	   else
		   iter.next();
	  }
	  return 0;
	}
	
	
	
	
}
