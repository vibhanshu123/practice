/**
 * 
 */
package coding;

/**
 * @author Vibs
 *
 */
public class SortedArrayQuestions {
	
	public static int findKthSmallestIn2SortedArrays(int array1 [], int array2 [], int k){
		
		int x=0,i = 0, j=0 , value = 0;
		for(x=0;x<k;x++){
			if(array1[i] < array2[j]){
				value = array1[i];
				i ++;				             
			} else {
				value = array2[j];
				j++;
			}
		}
		return value ;
	}
	
	public static int AtoThePowerB(int a, int b){
		if (b==1)
			return a ;
		if(b%2 ==0)
			return AtoThePowerB(a*a, b/2);
		else
			return a*AtoThePowerB(a*a, b/2);
	}
	
	public static void main(String [] args){
	   int [] array1 ={1,6,9,23,67,89,122};
	   int [] array2 ={2,4,10,33,45,78};
	   System.out.println(findKthSmallestIn2SortedArrays(array1, array2, 9));
	   System.out.println(AtoThePowerB(2,7));
	}

}
