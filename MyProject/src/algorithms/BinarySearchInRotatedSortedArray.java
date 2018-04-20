/**
 * 
 */
package algorithms;

/**
 * @author Vibs
 *
 */
public class BinarySearchInRotatedSortedArray {
	
	public static int searchInARotatedArray(int[] array,int low, int high, int key){
      int mid = (low+high)/2;
      if(array[mid]==key) return mid;
      if(high<low) return -1;
      if(array[low]<array[mid]){
    	  if(key>=array[low]&&key<=array[mid])
    	    return searchInARotatedArray(array, low, mid-1, key);
    	  else
    		  return searchInARotatedArray(array, mid+1, high, key); 
      }else if(array[mid]<array[high]){
    	  if(key>=array[mid]&&key<=array[high])
    		 return  searchInARotatedArray(array, mid+1, high, key);
    	  else 
    		  return searchInARotatedArray(array, low, mid-1, key);
       }else if(array[low]==array[mid]){
    	 if(array[mid]!=array[high]) 
    		 return searchInARotatedArray(array, mid+1, high, key);
    	 else{
    		 int result = searchInARotatedArray(array, low, mid, key);
    		 if(result==-1) 
    			 return searchInARotatedArray(array, mid+1, high, key);
    		   else 
    		    return result;
    	 }
       }
      return -1;
	}
	
	public static void main(String[] args){
		int [] intArray= {15,16,19,20,25,1,3,4,5,7,10,14};
		System.out.println(searchInARotatedArray(intArray, 0,intArray.length-1,5));
		int []  otherArray ={1,4,5,6,7,8,23,45,45,45,44,21,14,12,10,9};
		System.out.println(findMaxFromTheArray(otherArray, 0, otherArray.length));
	}
	
	
	public static int findMaxFromTheArray(int[] array, int low, int high){	
		while(low<=high){
			int mid = (low+high)/2;
		if(array[mid]>=array[mid+1]&&array[mid]>=array[mid-1]) 
			return array[mid];
		else if(array[mid]>array[mid-1])
			low=mid+1;
		else 
			high = mid;
		}
		return -1;
	  }

}
