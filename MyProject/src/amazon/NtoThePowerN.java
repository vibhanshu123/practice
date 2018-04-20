/**
 * 
 */
package amazon;

/**
 * @author Vibs
 *
 */
public class NtoThePowerN {
	
	public static boolean isPowerOfN(int n, int k){
		int temp = k;
		for(int i=0;i<n;i++){
			if(temp%n !=0) return false ;
			temp = temp/n;
		}
		if(temp ==1) return true ;
		return false ;
	}
	
	public static void main(String [] args){
		System.out.println(isPowerOfN(4, 256));
	  }
	
}
