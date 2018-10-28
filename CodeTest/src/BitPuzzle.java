
public class BitPuzzle {
	
	public static void main(String [] args) {
		divide(4,0);
	}
	
	public static int divide(int a,int b) {
		int c =-1;
		try {
			c=a/b;
		}
		catch(Exception e) {
			System.err.print("Exception ");
		}
		finally {
			System.err.print("Finally ");
		}
		return c;
	}

	public static int maxDifference(int [] a) {
		int maxDiff =0;
		for(int i=1;i<a.length;i++) {
			for (int j=0;j<i;j++) {
				int diff= a[i]-a[j];
				if(diff>maxDiff) {
					maxDiff =diff;
				}
				
			}
		}
		
		return 0;
		
	}
	
	
}
