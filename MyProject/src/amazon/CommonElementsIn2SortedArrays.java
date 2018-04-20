/**
 * 
 */
package amazon;

/**
 * @author Vibs
 *
 */
public class CommonElementsIn2SortedArrays {
	
	public static void algorithm(int [] array1,int [] array2){
		int length = 0;
		if(array1.length<array2.length) length = array2.length;
		else length = array1.length ;
		int j=0;
		for(int i=0;i<length;){
			if(array1[i]==array2[j]){
				System.out.println("the duplicate elemet is "+array1[i]);
				i++;
				j++;
			}else{
				if(array1[i]<array2[j])
					i++;
				else
					j++;
			}
		}
	}
	
	public static void main(String [] args){
	     int a1 []={1,2,3,4,5,6,7,8,9,10,12,34};
	     int a2 []={2,6,9,10,12,34};
	     algorithm(a1, a2);
	}

}
