/**
 * 
 */
package amazon;

/**
 * @author Vibs
 */

public class ChildCountSteps {
	private static int count [] = new int[200];
	public static int countSteps(int n){
		if (n<0) return 0;
		else if(n==0) return 1;
		else return countSteps(n-1)+countSteps(n-2)+countSteps(n-3);
	}
	
	public static int countStepsUsingDP(int n){
		if(n<0) return 0;
		else if(n==0) return 1;
		else if(count[n]!=0) return count[n];
		count[n]= countStepsUsingDP(n-1)+countStepsUsingDP(n-2)+countStepsUsingDP(n-3);
		return count[n];
		
		
	}
	
	public static void main(String [] args){
		System.out.println(countStepsUsingDP(35));
		System.out.println(countSteps(35));
	}
	

}
