/**
 * 
 */
package coding;

/**
 * @author Vibs
 *
 */
public class SpecialBinarySearch {
	
	public static int findMaxPoint(int [] array){
		int left=0;
		int right=array.length-1;
		int mid =0;
		while (left<=right){
		  mid=(left+right)/2;
		    if (array[mid]>array[mid+1]&&array[mid-1]<array[mid]){
		      return mid;
		    }
		    else if (array[mid]<array[mid+1])
		       left=mid+1;
		    else
			   right = mid;
		    }
		return mid;
	}
	
	public static int writeAMethodToDoCoding(int [] array){
		int l = 0;
		int h = array.length - 1;
		while (array[l] > array[h]) {
		       int  mid = (l + h)/2;
		        if (array[mid] > array[h]) {
		                l = mid + 1 ;
		        } else {
		                h = mid ;
		        }
		}
		return l;
	}
     
	
	public static int orderBinarySearch(int [] array, int low, int high, int key, boolean order){
		while(low<high){
			int mid = (low+high)/2;
		 if(key==array[mid])
			 return mid;
		 if(order){
			if (key<array[mid])
				high = mid;
			else 
				low = mid +1 ;
		     }
		 else {
			 if(key>array[mid])
				 high = mid;
			 else
				 low = mid + 1;
		    }
		}
		return -1;
	}
	
	public static void main(String [] args){
		int key = 7;
		int [] array = {50,5,20,30,40};
       // int max = findMaxPoint(array);
        int min = writeAMethodToDoCoding(array);
      //  System.out.println("MAX POSTION IS"+max);
        System.out.println("min is"+min);
      //  int c = orderBinarySearch(array, 0, max, key, true);
       // if(c==-1) c=orderBinarySearch(array, max, array.length-1, key, false);
        //if(c==-1) {
        	//if(array[array.length-1]==key)System.out.println("the key is present at index "+(array.length-1));
        //	else System.out.println("key not present");        		
       // }else System.out.println("the key is present at index "+c);
	}
}
