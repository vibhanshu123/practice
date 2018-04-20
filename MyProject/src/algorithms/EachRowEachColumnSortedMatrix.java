/**
 * 
 */
package algorithms;

/**
 * @author Vibs
 *
 */
public class EachRowEachColumnSortedMatrix {
	
	public static void main(String [] args){
		int [][] matrix={{1,2,3},{4,5,6},{7,8,9}};
		System.out.println(findKeyInASortedMatrix(matrix, 5));
		
		
	  	
	}
	public static boolean findKeyInASortedMatrix(int [][] matrix, int key){
	int numRows = matrix.length-1;
	int numColumns = matrix[0].length-1;
	int i=0;
	while(numColumns>=0 &&i<=numRows){
		 if(matrix[i][numColumns]>key)
			numColumns--;
	       else if(key>matrix[i][numColumns])
	    	  i++;
	      else
	    	return true;
	}
	return false;
	}
}