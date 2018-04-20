package effectivejava;

// Using a recursive type bound to express mutual comparability - Pages 132-133

import java.util.*;

public class RecursiveTypeBound {
    // Returns the maximum value in a list - uses recursive type bound
    public static <T extends Comparable<T>> T max(List<T> list) {
        Iterator<T> i = list.iterator();
        T result = i.next();
        while (i.hasNext()) {
            T t = i.next();
            if (t.compareTo(result) > 0)
                result = t;
        }
        return result;
    }

    public static void main(String[] args) {
    	String [] strings = {"a","b","cdf"};
    	Integer [] intList = {1,7,8,56};
        List<String> argList = Arrays.asList(strings);
        List<Integer> abcList = Arrays.asList(intList);
        System.out.println(max(argList));
        System.out.println(max(abcList));
    }
}