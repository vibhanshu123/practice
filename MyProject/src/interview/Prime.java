package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class Prime {
	
	public static void main(String[] args){
		
		List<Integer> primeArray=new ArrayList<Integer>();
		int count=0;
		int n=100;
		for (int i=2;i<=n;i++){
			int j=(int) Math.sqrt(i);
			//System.out.println(j);
			boolean isPrime= true;
			for(int s=2;s<=j;s++){
				if(i%s==0){
					isPrime=false;
					break;
				}	
			}
			if(isPrime==true){
				primeArray.add(i);
			}
		  }
		
		System.out.println(count);
	System.out.println(primeArray);
	System.out.println(primeArray.size());
	}	
 }
