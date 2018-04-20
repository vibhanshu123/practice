import java.util.Arrays;
import java.util.List;

import javax.swing.plaf.SliderUI;


public class ArraysToList {
	
	public static void main(String [] args){
	
	String [] sa={"one","two","three","four"};
	
    List myList=Arrays.asList(sa);
	System.out.println("size "+myList.size());
	System.out.println("idx2 "+myList.get(2));
	
	myList.set(3,"six");
	sa[1]="five";
	for(String s:sa)
		System.out.println(s+" ");
	
	System.out.println(myList);
   
	
	}
}
