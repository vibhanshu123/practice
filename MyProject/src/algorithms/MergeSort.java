/**
 * 
 */
package algorithms;

/**
 * @author Vibs
 *
 */
public class MergeSort {

	public static void mergeSort(int[] array,int low, int high){
		if(low<high){
			int mid = (low+high)/2;
			mergeSort(array, low, mid);
			mergeSort(array, mid+1, high);
			merge(array,low,high,mid);
		}
	}

	/**
	 * @param array
	 * @param low
	 * @param high
	 * @param mid
	 */
	private static void merge(int[] array, int low, int high, int mid) {
		int helperAarray []= new int[array.length];
		for(int i=low;i<=high;i++)
			helperAarray[i]= array[i];
		int current = low;
		int leftSide = low;
		int rightSide = mid+1;
		while(leftSide<=mid&&rightSide<=high){
			if(helperAarray[leftSide]<helperAarray[rightSide]){
			  array[current]=helperAarray[leftSide];
			  leftSide ++ ;
			}else {
				array[current]= helperAarray[rightSide];
				rightSide ++ ;				
			}
			current ++;	
		}
		int remaining = mid-leftSide;
		for(int i=0;i<=remaining;i++)
			array[current+i]=helperAarray[leftSide+i];
		
	}
	
	public static void main(String [] args){
		int[] array={2,10,9,8,7,6};
		for(int i:array)
			System.out.print(i+",");
		System.out.println("---");
		mergeSort(array, 0, array.length-1);
		for(int i:array)
			System.out.print(i+",");
		
	}
	
}
