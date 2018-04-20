/**
 * 
 */
package practice;

/**
 * @author Vibs
 *
 */
public class RecursionProblems {
	
	public static void main(String [] args){
		int [] factorialArray=getFactorialAtAllLevels(12);
		System.out.println("factorial "+getFactorialAtAllLevels(12).toString());
		for(int a:factorialArray)
			System.out.print(","+a);
		System.out.println("factorial for 10 is"+iterativeFactorial(10));
		int[] sortedArray = {1,4,6,8,90,123,126,567,890,2345};
		System.out.println("123 is present"+doRecursiveBinarySearch(sortedArray, 7, 0, sortedArray.length-1));
		System.out.println("iterative binary search for "+doIterativeBinarySearch(sortedArray, 131313, 0, sortedArray.length-1));
		permute("abc");
		
		
	}
	
	public static int iterativeFactorial(int n){
		int result =1;
		for(int i=n;i>0;i--)
			result*=i;
		return result;
	}
	
	public static int[] getFactorialAtAllLevels(int n){
		int[] fatorialLevels = new int[n==0?1:n];
		getFactorialLevels(n,0,fatorialLevels);
		return fatorialLevels;
			
	}

	/**
	 * @param n
	 * @param i
	 * @param fatorialLevels
	 */
	private static int getFactorialLevels(int n, int level, int[] fatorialLevels) {
		if(n>1){
			fatorialLevels[level]=n*getFactorialLevels(n-1,level+1,fatorialLevels);
			return fatorialLevels[level];
		}else{
			fatorialLevels[level]=1;
			return 1;
		}
		
	}
	
	public static int doRecursiveBinarySearch(int [] sortedArray, int key, int start, int end){
		if(start<=end){
		int mid = (start+end)/2;		
			if(sortedArray[mid]==key)
				return mid;
			else if(key<sortedArray[mid])
				return doRecursiveBinarySearch(sortedArray, key, start, mid-1);
			else 
				return doRecursiveBinarySearch(sortedArray, key, mid+1, end);
		}else
			return -1;
	}
	
	
	public static int doIterativeBinarySearch(int [] sortedArray, int key, int start, int end){
		while(start<=end){
		int mid = (start+end)/2;		
			if(sortedArray[mid]==key)
				return mid;
			else if(key<sortedArray[mid])
				end = mid -1;
			else 
				start= mid +1;
		}
		return -1;
	}

	
   public static void permute(String str){
	 
	   int length = str.length();
	   boolean[] used = new boolean[length];
	   StringBuffer out = new StringBuffer();
	   char[] in = str.toCharArray();
	   dopermute(in,out,used,length,0);
   }


private static void dopermute(char[] in, StringBuffer out, boolean[] used,
		int length, int level) {
	if(level==length){
		System.out.println(out.toString());
		return;
	}
	for(int i=0;i<length;++i){
		if(used[i]) continue;
		out.append(in[i]);
		used[i]= true;
		dopermute(in, out, used, length, level);
		used[i]= false;
		out.setLength(out.length()-1);
	}
	
  }
}
