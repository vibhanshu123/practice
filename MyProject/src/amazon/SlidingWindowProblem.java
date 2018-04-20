/**
 * 
 */
package amazon;

import java.util.LinkedList;

/**
 * @author Vibs
 *
 */
public class SlidingWindowProblem {

	private static void maxSlidingWindow(int A[], int n, int w, int B[]) {
		  LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i=0;i<w;i++){
			while(!list.isEmpty()&&A[i]>=list.getLast())
				list.removeLast();
		   list.addLast(A[i]);
		}
		for(int i=w;i<n;i++){
			B[i-w] = list.getFirst();
			while(!list.isEmpty()&&A[i]>=list.getLast())
				list.removeLast();
			list.addLast(A[i]);
		}
		B[n-w]=list.getFirst();
		for(int b:B)
			System.out.print(b+",");
	}

	

	public static void main(String [] args){ 
	int a[]={1,3,-1,-3,5,3,6,7}; 
	int b[]= new int[6];
	maxSlidingWindow(a,8,3,b);
	System.out.println("------");
	System.out.println(getMaxUsingSlidingWindow(a, 8, 3));
	System.out.println(getMinUsingSlidingWindow(a, 8, 3));
	}
	
	
	private static int getMaxUsingSlidingWindow(int A[], int n, int w) {
		  int max = 0;
		  LinkedList<Integer> list = new LinkedList<Integer>();
		  for (int i = 0; i < w; i++) {
		    while (!list.isEmpty() && A[i] >= A[list.getLast()])
		      list.removeLast();
		    list.addLast(i);
		  }
		  max = A[list.getFirst()];
		  for (int i = w; i < n; i++) {
		    while (!list.isEmpty() && A[i] >= A[list.getLast()])
		      list.removeLast();
		    list.addLast(i);
		    if(max<A[list.getFirst()]) max= A[list.getFirst()];
		  }
		 return max ;
		}
	
	
	private static int getMinUsingSlidingWindow(int A[], int n, int w) {
		  int min = 0;
		  LinkedList<Integer> list = new LinkedList<Integer>();
		  for (int i = 0; i < w; i++) {
		    while (!list.isEmpty() && A[i] <= A[list.getLast()])
		      list.removeLast();
		    list.addLast(i);
		  }
		  min = A[list.getFirst()];
		  for (int i = w; i < n; i++) {
		    while (!list.isEmpty() && A[i] <= A[list.getLast()])
		      list.removeLast();
		    list.addLast(i);
		    if(min>A[list.getFirst()]) min= A[list.getFirst()];
		  }
		 return min ;
		}

	}
