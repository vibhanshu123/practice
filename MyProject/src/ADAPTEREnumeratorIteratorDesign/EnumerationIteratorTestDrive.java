package ADAPTEREnumeratorIteratorDesign;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;

public class EnumerationIteratorTestDrive {
	
	public static void main(String [] args){
		
		ArrayList l=new ArrayList();
		l.add(1);
		l.add("sachin");
		Enumeration en=new IterationEnumerator(l.iterator());
		while(en.hasMoreElements()){
			System.out.println(en.nextElement());
		}
		
	}

}
