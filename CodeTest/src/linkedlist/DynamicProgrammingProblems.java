package linkedlist;

public class DynamicProgrammingProblems {

	/* A Naive recursive implementation of LCS problem in java*/
	public static  int longestCommonSubsequence(char[] X, char[] Y, int m, int n )  {
	    if (m == 0 || n == 0)
	      return 0;
	    if (X[m-1] == Y[n-1])
	      return 1 + longestCommonSubsequence(X, Y, m-1, n-1);
	    else
	      return max(longestCommonSubsequence(X, Y, m, n-1), longestCommonSubsequence(X, Y, m-1, n));
	  }
	
	
	  private static int max(int x, int y) {
		return x>y?x:y;
	}
	  
	  public static int lcsUsingMemoization(char[] X, char[] Y) {
       
		  int L[][]=new int[X.length+1][Y.length+1];
		  for(int i=0;i<L.length;i++) {
			  for(int j=0;j<L[0].length;j++) {
				  if(i==0||j==0) {
					  L[i][j]=0;
				  }else if(X[i-1]==Y[j-1]) {
					  L[i][j]=1+L[i-1][j-1];
				  }else {
					  L[i][j]=max(L[i-1][j],L[i][j-1]);
				  }
			  }
		  }
		  return L[X.length][Y.length];
	  }
	  
	public static void main(String[] args){
	    String s1 = "AGGTAB";
	    String s2 = "GXTXAYB";
	 
	    char[] X=s1.toCharArray();
	    char[] Y=s2.toCharArray();
	    int m = X.length;
	    int n = Y.length;
	 
	    System.out.println("Length of LCS is" + " " +longestCommonSubsequence(X, Y, m, n));
	    System.out.println("Length of LCS using memoization is" + " " +lcsUsingMemoization(X, Y));
	  }
	 
}
