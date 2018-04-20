package test;

public class TestCode {

	public static void main(String[] args) {
	long starttime=System.currentTimeMillis();	
    System.out.println(count(50));
     long endtime=System.currentTimeMillis();
     System.out.println("Time taken"+(endtime-starttime));
     System.out.println(counntwaysDP(100,new long[100]));
     long endTime1=System.currentTimeMillis();
     System.out.println("Time taken"+(endTime1-endtime));
     
	}
	
	public static int count(int n) {
		 if (n==0) {
			return 1;
		}else if (n==1) {
			return 1;
	    }else if (n==2) {
		    return 2;
	    }else{
		  return count(n-1)+count(n-2)+count(n-3);
		}
	}
	
	public static long counntwaysDP(int n,long[] map) {
		if (n==0) {
			return 1;
		}else if (n==1) {
			return 1;
	    }else if (n==2) {
		    return 2;
	    } else if(map[n-1]>2) {
			return map[n-1];
	    }else{
		  map[(n-1)]=counntwaysDP(n-1,map)+counntwaysDP(n-2,map)+counntwaysDP(n-3,map);
		  return map[n-1];
		}
		
	}
}
