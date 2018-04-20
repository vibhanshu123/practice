package ADAPTEREnumeratorIteratorDesign;

import java.util.Enumeration;
import java.util.Iterator;

import javax.naming.OperationNotSupportedException;

public class EnumerationIterator implements Iterator{

	Enumeration enumeration;
	
	public EnumerationIterator(Enumeration enumeration) {
		// TODO Auto-generated constructor stub
		this.enumeration=enumeration;
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return enumeration.hasMoreElements();
	}

	@Override
	public Object next() {
		// TODO Auto-generated method stub
		return enumeration.nextElement();
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
	  throw new UnsupportedOperationException();	
	}

}
