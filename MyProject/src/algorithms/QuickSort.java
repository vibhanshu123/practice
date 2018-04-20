/**
 * 
 */
package algorithms;

/**
 * @author Vibs
 *
 */
public class QuickSort {
	
	public static void quickSort(int[] array, int left, int right){
		int index = partition(array, left, right);
		if(left<index-1) quickSort(array, left, index-1);
		if(index<right) quickSort(array, index, right);
	}
	
	public static int partition (int [] array, int left, int right){
		int mid = (left+right)/2;
		int pivot = array[mid];
		while(left<=right){
			while(array[left]<pivot)
				left ++;
			while(array[right]>pivot)
				right --;
			if(left<=right){
				swap(array,left,right);
				left++;
				right--;
			}	
		}
		return left ;
	}


	private static void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right]= temp; 
	}
	
	public static void main(String [] args){
		int[] array={2,10,9,8,7,6};
		for(int i:array)
			System.out.print(i+",");
		System.out.println("---");
		quickSort(array, 0, array.length-1);
		for(int i:array)
			System.out.print(i+",");
		
	}
	

}
