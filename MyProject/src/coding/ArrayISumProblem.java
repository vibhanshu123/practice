/**
 * 
 */
package coding;

/**
 * @author Vibs
 *
 */
public class ArrayISumProblem {
	
	
	public static void main(String [] args){
	    int[] intArray = {1,2,3,4,5,6,7,8,9,10,11};
		int i=0,n=intArray.length-1;
		while(i<n){
			if(8-intArray[n]==intArray[i]){
				System.out.println("numbers are "+intArray[n]+" and "+intArray[i]);
				n--;
				i++;
			}
			else{
				n--;
			}
			
		}
	}

}
