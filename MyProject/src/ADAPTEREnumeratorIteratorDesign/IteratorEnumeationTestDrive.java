package ADAPTEREnumeratorIteratorDesign;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class IteratorEnumeationTestDrive {
	
	public static void main(String [] args){
		
		Vector v =new Vector();
		v.add(2);
		v.add("vibhanshu");
		
		Iterator iter=new EnumerationIterator(v.elements());
		
		while(iter.hasNext()){
			System.out.println(iter.next());
			
		}
		
		
	}

}
