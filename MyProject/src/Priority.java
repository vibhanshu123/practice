import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


class Priority {
	
	static class PQSort implements Comparator<Integer>{

		@Override
		public int compare(Integer one, Integer two) {
			// TODO Auto-generated method stub
			return two.compareTo(one) ;
		}
		
	}
	
	public static void main(String [] args){
		int [] ia={1,5,4,3,7,6,9,8};
		List abc=new ArrayList();
		abc.add("abc");
		System.out.println(abc);
		PriorityQueue<Integer> pa=new PriorityQueue<Integer>();
		for(int x:ia)
			pa.offer(x);
		for(int x:ia)
			System.out.println(pa.poll()+"  ");
		System.out.println("");
		System.out.println("sizeold"+pa.size());
		
		PQSort pqs=new PQSort();
		PriorityQueue<Integer> pa1=new PriorityQueue<Integer>(10,pqs);
		for(int x:ia)
			pa1.offer(x);
		System.out.println(ia[0]+ia[1]);
		
		for(int x:ia)
			System.out.println(pa1.peek()+" ");
		
		System.out.println("size"+pa1.size());
		System.out.println("peek"+pa1.peek());
		System.out.println("size"+pa1.size());
		System.out.println("poll"+pa1.poll());
		System.out.println("size"+pa1.size());
		
		for(int x:ia)
			System.out.println(pa1.poll()+" ");
		
	}	

}
