package jcip.composingObjects;

import java.util.*;

import net.jcip.annotations.*;

/**
 * BetterVector
 * <p/>
 * Extending Vector to have a put-if-absent method
 *
 * @author Brian Goetz and Tim Peierls
 */
@ThreadSafe
public class BetterVector <E> extends Vector<E> {
    // When extending a serializable class, you should redefine serialVersionUID
    static final long serialVersionUID = -3963416950630760754L;

    public synchronized boolean putIfAbsent(E x) {
    	
    	Vector<String> vector = new Vector<String>();
    	Iterator<String> iter = vector.iterator();
    	while(iter.hasNext()){
    		String s = iter.next();
    	}
        boolean absent = !contains(x);
        if (absent)
            add(x);
        return absent;
    }
}
