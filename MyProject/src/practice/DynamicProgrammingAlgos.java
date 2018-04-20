package practice;

public class DynamicProgrammingAlgos {
	
	public static void main(String[] args){
    char X[] = "ABCBDAB".toCharArray();
    char Y[] = "BDCABA".toCharArray();
    int m = X.length ;
    int n = Y.length ;
    Integer c[][]=new Integer[m+1][n+1];
    System.out.println(longestCommonSubSequenceProblemBruteForce(X, Y, m, n));
//    for(int i=0;i<m;i++)
//    	for(int j=0;j<n;j++)
//          c[i][j]=0;
    System.out.println(longestCommomSubSequenceUsingMemoization(c,X,Y,m,n));
	}
	
	public static int longestCommonSubSequenceProblemBruteForce(char[] x, char[] y, int m, int n){
		if(m==0 || n==0) return 0;
		if (x[m-1]==y[n-1]) return 1+longestCommonSubSequenceProblemBruteForce(x, y, m-1, n-1);
		else 
			return Math.max(longestCommonSubSequenceProblemBruteForce(x, y, m-1, n), 
					longestCommonSubSequenceProblemBruteForce(x, y, m, n-1));
	}
   
	
	
	public static int longestCommomSubSequenceUsingMemoization(Integer[][] c,char[] x, char[] y, int m, int n){
		if(c[m][n]==null){
		   if(m==0 || n==0) c[m][n] =0;	
		  if (x[m-1]==y[n-1]) c[m][n]=1+longestCommomSubSequenceUsingMemoization(c,x, y, m-1, n-1);
			else 
				 c[m][n]=Math.max(longestCommomSubSequenceUsingMemoization(c,x, y, m-1, n), 
						longestCommomSubSequenceUsingMemoization(c,x, y, m, n-1));
	  }
	return c[m][n];	  
	}
	
	public static void LCSDynamicProgramming(){
		
	}
}
 