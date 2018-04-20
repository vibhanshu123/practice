/**
 * 
 */
package coding;

/**
 * @author Vibs
 *
 */
public class MatrixProblems {
	
	public static void main(String [] args){
		int[][] matrix ={{1,2,3,4},
				         {2,0,8,9},
				         {11,12,13,0}};
		matrix = makeWholeRowAndColumnZero(matrix);
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				System.out.print(matrix[i][j]);
				}
			System.out.println("\n");
			}
		
	}
	
	public static int[][] makeWholeRowAndColumnZero(int[][] matrix){
		int numRows = matrix.length;
		int numColumns = matrix[0].length;
		boolean [] rows = new boolean[numRows];
		boolean [] columns = new boolean[numColumns];
		for(int i=0;i<numRows;i++){
			for(int j=0;j<numColumns;j++){
				if(matrix[i][j]==0){
					rows[i] = true ;
					columns [j] = true ;
				}
			}
		}
		
		for(int i=0;i<numRows;i++){
			for(int j=0;j<numColumns;j++){
				if(rows[i]||columns[j]){
					matrix[i][j] = 0;
				}
			}
		}
		return matrix ;
	}

}
