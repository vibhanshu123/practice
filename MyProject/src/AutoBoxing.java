import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;


public class AutoBoxing {
	
	public static void main(String[] args){
		List abc=new ArrayList();
		String s="hi";
		abc.add(s+s);
		abc.add(s);
		abc.add("c");
		abc.add("b");
		abc.add("a");
		//abc.remove("hi");
		Collections.sort(abc);
		System.out.println(abc);
		
	}

}
