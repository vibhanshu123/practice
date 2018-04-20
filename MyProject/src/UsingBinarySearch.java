import java.util.Arrays;
import java.util.Comparator;


public class UsingBinarySearch {
	
	public static void main(String[] args){
		
		String [] sa={"one","two","three","four"};
//		StringBuffer a=new StringBuffer("xknxkjasn");
//		System.out.println(a.reverse());
		
		Arrays.sort(sa);
		for(String s:sa)
			System.out.println(s+" ");
		System.out.println("searching something"+Arrays.binarySearch(sa,"four"));
       
		Reverse rs= new Reverse();
		Arrays.sort(sa,rs);
		for(String x:sa)
			System.out.println(x+" ");
		
		System.out.println(Arrays.binarySearch(sa,"four"));
		System.out.println(Arrays.binarySearch(sa,"four",rs));
		
		
	}

}


class Reverse implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return o2.compareTo(o1);
	}
	
}


