package linkedlist;

import java.util.ArrayList;
import java.util.List;

public class MinMaxStock {
 
	public static class Interval{
		private  int max;
		private  int min;
		public int getMax() {
			return max;
		}
		public void setMax(int max) {
			this.max = max;
		}
		public int getMin() {
			return min;
		}
		public void setMin(int min) {
			this.min = min;
		}
	}
	
public static List<Interval> getIntervalList(int [] price){
	int n= price.length;
	List<Interval> list = new ArrayList<Interval>();
	int i=0;
	while(i<n) {
		
	  while(i<n-1 && price[i+1]<price[i]) {
		  i++;
	  }
	  Interval interval = new Interval();
	  interval.setMin(price[i++]);
	  
	  while(i<n && price[i]>price[i-1]) {
		  i++;
	  }
	  interval.setMax(price[i-1]);
	  list.add(interval);
	}
	return list;
}
	
	public static void main(String[] args) {
		
	  int [] price= {20,10,5,30,56,5,67,456,789,323,45,51,23,67,890};
	  for(Interval interval:getIntervalList(price)) {
		  System.out.println("Max"+interval.getMax()+", Min:"+interval.getMin());
	  }
	
		  
	  }
	  
	
	
}
	
	

