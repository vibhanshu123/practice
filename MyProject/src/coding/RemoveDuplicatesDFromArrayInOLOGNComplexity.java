/**
 * 
 */
package coding;

/**
 * @author Vibs
 *
 */
public class RemoveDuplicatesDFromArrayInOLOGNComplexity {
	
	public static int algorith(int array[]){
		int i, j;
        int length = array.length ;
		/* new length of modified array */
		int newLenght = 1;
		for( i=1;i<length;i++){
			for(j=0;j<newLenght;j++){
				if(array[i]==array[j])
				  break ;
			}
			
			if(j==newLenght)
				array[newLenght++]=array[i];
		}
		return newLenght;
        }
	
	public static int removeDuplicates(int [] array){
	  int newLength = 1;
	  int j =0;
	  for(int i=1;i<array.length;i++){
		  for(j=0;j<newLength;j++){
			  if(array[i]==array[j])
				break;  
			  }
		  if(j==newLength)
			  array[newLength++] = array[i];			  
	      }
	  return newLength ;
	}
	
	public static void main(String [] args){
		int [] array ={22,5,67,45,22,90,111,67,3,1,5,6,45,67};
		int length = removeDuplicates(array);
	    for(int i=0 ;i<length;i++){
	    	System.out.print(array[i]);
	    	System.out.print("--");
	    }
	}
	
}
