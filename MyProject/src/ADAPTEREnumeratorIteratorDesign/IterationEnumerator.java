package ADAPTEREnumeratorIteratorDesign;

import java.util.Enumeration;
import java.util.Iterator;

public class IterationEnumerator implements Enumeration {

	Iterator iterator;
	
	public IterationEnumerator(Iterator iterator) {
		// TODO Auto-generated constructor stub
		this.iterator=iterator;
	}
	
	@Override
	public boolean hasMoreElements() {
		// TODO Auto-generated method stub
		return iterator.hasNext();
	}

	@Override
	public Object nextElement() {
		// TODO Auto-generated method stub
		return iterator.next();
	}
	
	

}
