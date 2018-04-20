/**
 * 
 */
package amazon;

/**
 * @author Vibs
 *
 */
public class Fibonacci { 
	
	private static int fib [] = new int[200];
	public static int normalRecursiveFibonacci(int n){
		if(n==0) return 0;
		if(n==1) return 1;
	    return normalRecursiveFibonacci(n-1) + normalRecursiveFibonacci(n-2);
		
	}
	
	public static void main(String [] args){
		System.out.println(dynamicProgrammingFibonacci(70));
		System.out.println(normalRecursiveFibonacci(70));
		
	}
	
	public static int dynamicProgrammingFibonacci(int n){
	  if(n==0) return 0;
	  if(n==1) return 1;
	  if(fib[n]!=0) return fib[n];
	  fib[n]= dynamicProgrammingFibonacci(n-1)+dynamicProgrammingFibonacci(n-2);
	  return fib[n];
	    
	}

}
