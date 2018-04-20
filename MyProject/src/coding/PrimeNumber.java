/**
 * 
 */
package coding;

/**
 * @author Vibs
 *
 */
public class PrimeNumber {
	
	public static boolean isTheNumberPrime(Integer n){
		boolean isPrime = true;
		int sqrt =  (int) Math.sqrt(n);
		for(int i=2; i<=sqrt;i++){
			if(n%i ==0){
				isPrime = false;
				break;
			}			  
		}		
		return isPrime ;
		}
	
	public static void getListOfAllPrimesTillN(int max){
		for(int i=2;i<=max;i++){
			if(isTheNumberPrime(i)){
				System.out.println(i);
			}
		}
	}
	
	public static void main(String [] args){
      System.out.println(isTheNumberPrime(11));	
      System.out.println(isTheNumberPrime(23));
      System.out.println(isTheNumberPrime(49));
     // getListOfAllPrimesTillN(100);
      System.out.println("-----algorithm------");
      boolean [] flags = sieveOfEratosthenes(45);
      for(int i=0;i<flags.length;i++)
    	  if(flags[i]) System.out.println(i);
	}
	
	public static boolean[] sieveOfEratosthenes(int max){
		int numberOfFlags = max/2;;
		if(max%2 ==0)
	      numberOfFlags --;				
		boolean [] flags = new boolean[numberOfFlags];
		init(flags);
		int prime = 3;
		while(prime<=max){
		crossOff(prime, flags);
		prime=getNextPrime(prime,flags);
		if(prime>=flags.length){
			break;
		   }
		}
		return flags;
	}
	
	/**
	 * @param prime
	 */
	private static int getNextPrime(int prime , boolean [] flags) {
		int next = prime + 2;
		while(next <flags.length && !flags[next])
			next++;
		return next;
		
	}

	public static void crossOff(int prime,boolean [] flags){
		for(int i=prime*prime;i<flags.length;i+=prime){
			flags[i]=false;
		}
	}
	/**
	 * @param flags
	 */
	private static void init(boolean[] flags) {
		for(int i=0;i<flags.length;i++){
			flags[i]=true;
		}
		
	}

}
