/**
 * 
 */
package algorithms;

/**
 * @author Vibs
 *
 */
public class KthSmallestElementInAnArray {
	
	public static int doPartition(int [] array,int left, int right){
		int mid = (left+right)/2;
		int pivot = array[mid];
		while(left<right){
			while(array[left]<pivot)
				left++;
			while(array[right]>pivot)
				right --;
			if(left<right){
				swap(array,left,right);
				left++;
				right --;
			}		
		}
		return left;
	}
	
	/**
	 * @param array
	 * @param left
	 * @param right
	 */
	private static void swap(int[] array, int left, int right) {
		int temp =array[left];
		array[left]=array[right];
		array[right]=temp;
		
	}

	public static int getTheSpecificPivotElement(int[] array, int left, int right,int k){
		int index = doPartition(array, left, right);
		if(k==index+1) {
			return array[index];
		}
		else if(index+1<k) {
			return getTheSpecificPivotElement(array, index+1,right , k);
		}
		else {
		return	getTheSpecificPivotElement(array, left, index, k);
		}
	}
	
	public static void main(String [] args){
		int[] array={12,6,8,5,56,78,102,12,1,44};
		System.out.println(getTheSpecificPivotElement(array, 0, array.length-1, 7));
	}

}
