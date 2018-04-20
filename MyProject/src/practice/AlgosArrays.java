/**
 * 
 */
package practice;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Vibs
 *
 */
public class AlgosArrays {
	
	public static void main(String [] args){
		int[] intArray = {2,1,4,3,6,7};
		intArray = arrangeArrayWhereOddNumberAtEvenIndexAndEvenNumberOddIndex(intArray);
		iterateArray(intArray);
		System.out.println("-----");
		funCoding();
		doPowerOf2();
		findFirstNonRepeatedCharacterUsingHashMap("teeter");
		findFirstNonRepeatedCharacterUsingOnly2ObjectCreation("teeter");
		System.out.println(removeChars("Battle of the vowels:Hawaii vs Grozny", "aeiou"));
		findFirstNonRepeatedCharacterUsingArrays("teeter");
		System.out.println("reverse of Ram is a good Boy is"+reverseWords(" Ram is a good Boy is"));
		System.out.println("reverse of Ram is a good Boy is"+reverseWordsOtherWay(" Ram is a good Boy is"));
		reverseWordsWithoutUsingBufferArrar(" Ram is a good Boy is");
		System.out.println("convert string to int "+convertStringToInt("0"));
		System.out.println(convertStringToInt("1"));
		System.out.println("convert int to string"+convertIntToString(-123));
		System.out.println("convert int to string"+convertIntToString(0));
		System.out.println("convert int to string"+convertIntToString(-1));
		System.out.println("convert int to string"+convertIntToString(1));
		System.out.println("---replace Array with next greatest element");
		int [] integerArray= {1,43,23,48,34,27,1,34,4,8};
		replaceArrayWithNextGreatestElememntInTheArray(integerArray);
		System.out.println("--");
		System.out.println("--NEXT GREATER ELEMENT IN AN ARRAY WITHOUT USING STACKS----");
		int []integerArray1= {1,43,23,48,34,27,1,34,4,8};
		replaceArrayWithNextGreatertElememntInTheArrayWithoutUsingStacks(integerArray1);
		System.out.println("--");
		System.out.println("--NEXT GREATER ELEMENT IN AN ARRAY USING STACKS----");
		int []integerArray2= {1,43,23,48,34,27,1,34,4,8};
		replaceArrayWithNextGreatertElememntInTheArrayUsingStacks(integerArray2);
		System.out.println("---MEDIAN FOR 2 SORTED EQUAL ARRAYS----");
		int [] array1 ={1,4,5,9,23};
		int [] array2 ={3,4,7,89,245};
		System.out.println(medianFor2SortedEqualArrays(array1, array2));
		findNonUniqueCharactersUsingBitVectorTechnique("abcabc");
		
	}
	
	public static void reverseWordsWithoutUsingBufferArrar(String str){
		char[] strArray = str.toCharArray();
		char[] reverseArray = reverse(strArray,0,strArray.length-1);
		int start =0,end =0, length = strArray.length ;
		while(end<length){
			if(reverseArray[end]!=' '){
				start = end;
			   while(end<length&&reverseArray[end]!=' ')
				   end++;  
			   end--;
			  reverseArray= reverse(strArray, start, end);
			}
			end++;
		}
		System.out.println(new String(reverseArray));
		
	}
	
	
	
	
	public static char[] reverse(char[] strArray,int start, int end){
        char temp ;
		while(start<end){
          temp = strArray[start];
          strArray[start]=strArray[end];
          strArray[end]= temp;
          start ++;
          end --;
		}
		return strArray;
	}
	
	
	public static String reverseWords(String str){
		char[] strArray = str.toCharArray();
		int length = strArray.length;
		int index =0;
		char[] bufferArray = new char[length];
		for(int i=length-1;i>=0;i--){
			if(strArray[i]==' ') {
				int indexOfstring = i;
				indexOfstring++;
				while(indexOfstring<length&&strArray[indexOfstring]!=' ')
					bufferArray[index++]=strArray[indexOfstring++];
				bufferArray[index++]=' ';
			}
			
		}
		return new String(bufferArray);
	}
	
	public static String reverseWordsOtherWay(String str){
		char[] strArray = str.toCharArray();
		int length = strArray.length-1;
		int index =0, wordEnd =0, wordReadPos=0;
		char[] bufferArray = new char[length];
		while(length>0){
			if(strArray[length]==' ') {
				bufferArray[index++]=strArray[length--];
			}else{
				wordEnd = length;
				while(length>=0&&strArray[length]!=' ')
					length --;
				wordReadPos = length+1;
				while(wordReadPos<=wordEnd)
					bufferArray[index++]= strArray[wordReadPos++];				
			}
			
		}
		return new String(bufferArray);
	}
	
	public static void replaceArrayWithNextGreatestElememntInTheArray(int [] array){
		int lengthOfArray = array.length-1;
		int max =array[lengthOfArray];
		array[lengthOfArray]= -1;
		for(int i=lengthOfArray-1;i>=0;i--){
			if(array[i]>max){
				int temp=array[i];
				array[i]= max;
				max= temp;
			}
			else if(array[i]<=max) array[i] = max;
		}
		for(int a:array)
			System.out.print(a+",");
	}
	
	public static void replaceArrayWithNextGreatertElememntInTheArrayUsingStacks(int [] array){
		Stack<Integer> stack = new Stack<Integer>();
		int next =-1;
		int element = 0;
		int length = array.length;
		stack.push(array[0]);
		for(int i=1;i<length;i++){
	     next = array[i];	
		if(!stack.isEmpty()){
			element = stack.pop();
			while(element<= next) {
				System.out.println("next of "+element+"is "+next);		
				if(stack.isEmpty()) break;
				element = stack.pop();
			}
			if(element>next) 
				stack.push(element);			  
		  }
		stack.push(next);
		}

		while(!stack.isEmpty()){
			System.out.println("next of "+stack.pop()+"is -1");	
		
		}
	}
	
   public static void replaceArrayWithNextGreatertElememntInTheArrayWithoutUsingStacks(int [] array){
	   int length = array.length;
	   for(int i=0;i<length;i++){
		   for(int j=i+1;j<length;j++){  
			 if(array[i]<=array[j]){
				 array[i] = array[j];
				 break;
			 } else if(j==length-1) array[i] = -1;
		   }
	   }
	   for(int a:array)
			System.out.print(a+","); 
	}
	
	public static int medianFor2SortedEqualArrays(int [] a1, int[] a2){
		int length = a1.length;
		int count = 0, i=0, j=0;
		int m1 =-1, m2=-1;
		while(count<=length){
			m1 = m2;
			if(i==length-1){			
			m2 = a2[0];
			break;
			}
			else if(j==length-1){
			 m2 = a1[0];
			 break;
			}
			if(a1[i]<a2[j]){
			 m2 = a1[i];
			 i++;
			}else{
			 m1 = a2[j];
			 j++;
			}
			count ++;
		}
	  return (m1+m2)/2;	
	}
	
	
	public static void medianFor2SortedUnEqualArrays(){
		
	}
	
	public static void findPivotElementForArotatedSortedArray(int [] array){
		
		
	}
	
	
	
	public static void maximumCircularSubArraySum(){
		
	}
	
	public static void returnArrayOfProductOfAllPostionsExceptTheIndexIusingDivison(){
		
	}
	
    public static void returnArrayOfProductOfAllPostionsExceptTheIndexIWithoutusingDivison(){
		
	}
    
    public static void findNonUniqueCharactersUsingBitVectorTechnique(String str){
    	int checker = 0;
    	for(int i=0;i<str.length();i++){
    		int val = str.charAt(i) -'a';
    		if((checker & (1<<val))>0){
    			System.out.print(str.charAt(i));
    		}
    		checker |= (1<<val);
    	}
    }
	
	public static void findFirstNonRepeatedCharacterUsingHashMap(String str){
		char[] charArray = str.toCharArray();
		Map<Character,Integer> abcMap = new HashMap<Character,Integer>();
		for(char c:charArray){
			Integer i = abcMap.get(c);
			if(i==null) abcMap.put(c, 1);
			else abcMap.put(c, i+1);	
		}
	    for(char c:charArray){
	    	if(abcMap.get(c).equals(1)) {
	    		System.out.println("The character is "+c);
	    		break;
	    	}   
	    }
	}
	
	
	public static void findFirstNonRepeatedCharacterUsingArrays(String str){
		char[] charArray = str.toCharArray();
		int [] boolArray = new int[128];
		for(int i=0;i<charArray.length;i++){
			boolArray[charArray[i]] ++;
		}
	    for(char c:charArray){
	    	if(boolArray[c]==1) {
	    		System.out.println("The character is "+c);
	    		break;
	    	}   
	    }
	}
	
	public static int convertStringToInt(String str){
		int length = str.length();
		int start = 0;
		int num =0;
		boolean isNegative = false;
		char[] charArray = str.toCharArray();
		if(charArray[0]=='-'){
			isNegative = true;
			start =1;
		}
		while(start<length){
			num *= 10;
			num+= charArray[start++] -'0';
		}
		if(isNegative) num*=-1;
		return num;
	}
	
	public static String convertIntToString(int num){		
		boolean isNegative = false;
		char[] tempArray=new char[10];
		if(num<0){
			isNegative = true;
			num*=-1;
		}
		int i=0;
		do{
		  tempArray[i++]=(char)((num%10) + '0');	
		  num = num/10;				
		}while(num!=0);		
		StringBuilder str = new StringBuilder();
		if(isNegative) str.append("-");
		while(i>0)
			str.append(tempArray[--i]);
		return str.toString();
	}
	
	
	public static String removeChars(String str, String remove){
		char[] removeArray = remove.toCharArray();
		char [] originalStrArray = str.toCharArray();
		boolean [] flags = new boolean[128];
		for(int i=0;i<removeArray.length;i++)
			flags[removeArray[i]] = true;
		int source =0;
		int destination =0;
		while(source<str.length()){
			if(!flags[originalStrArray[source]]) 
				originalStrArray[destination++]=originalStrArray[source];
			source ++;
				
		}
		return new String(originalStrArray,0,destination);
	}
	
	public static void findFirstNonRepeatedCharacterUsingOnly2ObjectCreation(String str){
		char [] charArray = str.toCharArray();
		Map<Character,Object> strMap = new HashMap<Character,Object>();
		Object seenOnce = new Object();
		Object seenTwice = new Object();
		for(char c:charArray){
			Object o = strMap.get(c);
			if(o == null) strMap.put(c, seenOnce);
			else if(o==seenOnce) strMap.put(c, seenTwice);				
		}
		for(char c:charArray){
	    	if(strMap.get(c)==seenOnce) {
	    		System.out.println("The character is "+c);
	    		break;
	    	}   	
		}
	}
	
	public static void funCoding(){
		for(int i=1;i<=100;i++){
			if(i%15 ==0) System.out.print("FizzBuzz"+",");
			else if(i%5 ==0) System.out.print("Buzz"+",");
			else if(i%3 ==0) System.out.print("Fizz"+",");
			else System.out.print(i+",");
		}
	}
	
	
        public static void doPowerOf2() {
                BigInteger i = new BigInteger("2");
                for (int x = 1; x < 1000 ; x ++) {
                i = i.add(i);
                }
                String s = i.toString();
                int sum = 0;
                
                for (byte c:s.getBytes()) {
                        sum += c-'0';
                }
                System.out.println(sum);
        }
 
	
	/**
	 * @param intArray
	 */
	private static void iterateArray(int[] intArray) {
		for(int i:intArray)
		System.out.print(i+",");
	}

	public static int[] arrangeArrayWhereOddNumberAtEvenIndexAndEvenNumberOddIndex(int [] intArray){
		int p=0;
		int q=1;
		int temp =0;
		int n = intArray.length-1;
		while(p<n&&q<n){
			while(intArray[p]%2 ==1) 
				p=p+2;
			while(intArray[q]%2==0)
				q=q+2;
			temp = intArray[p];
			intArray[p]= intArray[q];
			intArray[q] = temp;
		}
		return intArray;	
	}
	
	public static void prepareAllPossibleSetsFromAGivenArray(int[] intArray){
		
	}

}
