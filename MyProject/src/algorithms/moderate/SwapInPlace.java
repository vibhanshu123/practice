/**
 * 
 */
package algorithms.moderate;

/**
 * @author Vibs
 *
 */
public class SwapInPlace {
	
	public static void doSwap(int a, int b){
		a=a^b;
		b=a^b;
		a=a^b;
	}
	
	public static void main(String [] args){
		int a =10;int b=20;
		doSwap(a, b);
		a=a^b;
		b=a^b;
		a=a^b;
		System.out.println("a is "+a);
		System.out.println("b is "+b);
	}

}
