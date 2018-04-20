/**
 * 
 */
package algorithms;

import com.sun.corba.se.spi.ior.MakeImmutable;

/**
 * @author Vibs
 *
 */
public class CoinsProblem {
	
	public static int makeChange(int n,int maxChange){
		int nextChange = 0;
		switch(maxChange){
		case 25 : nextChange = 10;
		          break;
		case 10 : nextChange = 5 ;
		          break;
		case 5 : nextChange = 1;
		         break;
		case 1: return 1;        
		
		}
		int ways = 0;
		for(int i=0;i*maxChange<=n;i++){
			ways += makeChange(n-i*maxChange, nextChange);
		}
		return ways ;
	}
	
	public static void main(String [] args){
		System.out.println(makeChange(25, 25));
	}

}
