/**
 * 
 */
package algorithms;

/**
 * @author Vibs
 *
 */
public class MergeBtoA {
	
	public static void main(String [] args){
		int[] arrayA ={1,8,10,17,22,0,0,0,0};
		int[] arrayB ={2,4,12,34};
		mergeBtoA(arrayA,arrayB,5,4);
		for(int a:arrayA)
			System.out.print(a+",");
	}

	/**
	 * @param arrayA
	 * @param arrayB
	 */
	private static void mergeBtoA(int[] arrayA, int[] arrayB,int lastA, int lastB) {
		int indexMerged = lastA+lastB-1;
		int indexA = lastA -1;
		int indexB = lastB -1;
		while(indexA>=0&&indexB>=0){
		if(arrayA[indexA]>arrayB[indexB]){
			arrayA[indexMerged]= arrayA[indexA];
			indexMerged --;
			indexA --;
		}else{
			arrayA[indexMerged]=arrayB[indexB];
			indexB--;
			indexMerged --;
		  }
		}
		
		while(indexB>=0){
			arrayA[indexMerged]=arrayB[indexB];
			indexB --;
			indexMerged --;
		}
	}
	
	

}
