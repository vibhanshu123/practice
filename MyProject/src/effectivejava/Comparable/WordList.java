package effectivejava.Comparable;

import java.math.BigDecimal;
import java.util.*;

public class WordList {
    public static void main(String[] args) {
    	BigDecimal [] strArray = {new BigDecimal("1.0"),new BigDecimal("2.0"),new BigDecimal("1.00")};
        Set<BigDecimal> s = new TreeSet<BigDecimal>();
        Set<BigDecimal> s1 = new HashSet<BigDecimal>();
        Collections.addAll(s, strArray);
        Collections.addAll(s1, strArray);
        System.out.println(s);
        System.out.println(s1);
    }
}
